package TAProject;

import TAProject.BD.DiseaseModel;
import TAProject.BD.MedicineModel;
import TAProject.Methods.Reading;

public class Main {

    public static void main(String[] args) {

        Reading.readFile("TAProject/disease.txt");
        Reading.readFile("TAProject/disease.txt");
        //Denis lox ksta
        System.out.println(DiseaseModel.getInstance().getModel().toString());
        System.out.println(MedicineModel.getInstance().getModel().toString());
    }
}
