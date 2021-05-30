package TAProject;

import TAProject.BD.DiseaseModel;
import TAProject.BD.MedicineModel;
import TAProject.Entities.Disease;
import TAProject.Entities.Medicine;
import TAProject.Methods.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Reading.readFile("TAProject/disease.txt");
        Reading.readFile("TAProject/disease.txt");
        System.out.println(DiseaseModel.getInstance().getModel().toString());
        System.out.println(MedicineModel.getInstance().getModel().toString());

        String[] userSymptoms = new String[]{"воспаление лимфоузлов","сиплый голос","боль в горле","температура"};
        WhichDisease whichDisease = new WhichDisease();
        whichDisease.whichDisease(userSymptoms);



    }
}
