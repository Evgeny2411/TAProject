package TAProject;

import TAProject.BD.DiseaseModel;
import TAProject.BD.MedicineModel;
import TAProject.Entities.Disease;
import TAProject.Entities.Medicine;
import TAProject.Methods.Reading;
import TAProject.Methods.QuickSort;
import TAProject.Methods.ShellSort;
import TAProject.Methods.Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Reading.readFile("TAProject/disease.txt");
        Reading.readFile("TAProject/disease.txt");
        System.out.println(DiseaseModel.getInstance().getModel().toString());
        System.out.println(MedicineModel.getInstance().getModel().toString());



    }
}
