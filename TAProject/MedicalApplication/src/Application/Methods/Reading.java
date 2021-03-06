package Application.Methods;

import Application.BD.DiseaseModel;
import Application.BD.MedicineModel;
import Application.Entities.Disease;
import Application.Entities.Medicine;

import java.io.*;

public class Reading {

    public static void readFile(String url){
        try {
            File file = new File(url);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null && !line.equals("")) {
                String[] bufferArray = line.split(";");
                if (bufferArray.length == 4){
                    String[] medicine = bufferArray[2].split(",");
                    String[] symptoms = bufferArray[3].split(",");
                    Disease disease = new Disease(bufferArray[0], bufferArray[1], medicine , symptoms );
                    DiseaseModel.getInstance().add(bufferArray[0], disease);
                    line = reader.readLine();
                }
                if (bufferArray.length == 3){
                    Medicine medicine = new Medicine(bufferArray[0], bufferArray[2] , bufferArray[1] );
                    MedicineModel.getInstance().add(bufferArray[1], medicine);
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
