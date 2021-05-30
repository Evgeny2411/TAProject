package TAProject;

import TAProject.BD.DiseaseModel;
import TAProject.BD.MedicineModel;
import TAProject.Methods.Reading;
import TAProject.Methods.WhichDisease;

public class Main {

    public static void main(String[] args) {

        Reading.readFile("TAProject/disease.txt");
        Reading.readFile("TAProject/medicine.txt");

        String[] userSymptoms = {"воспаление лимфоузлов","сиплый голос","боль в горле","температура"};

//        System.out.println(DiseaseModel.getInstance().getModel().toString());
//        System.out.println(MedicineModel.getInstance().getModel().toString());
        WhichDisease whichDisease = new WhichDisease();
        whichDisease.setSymptoms(userSymptoms);
        whichDisease.whichDisease();
        //System.out.println(whichDisease.whichDisease().toString());
    }
}
