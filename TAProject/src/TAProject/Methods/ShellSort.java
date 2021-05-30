package TAProject.Methods;

import TAProject.Entities.Disease;
import TAProject.Entities.Medicine;

public class ShellSort implements Sort{
    @Override
    public Medicine[] sort(Disease disease) {
        Medicine[] medicine = disease.getMedicine();
        int n = medicine.length;

        for (int gap = n / 2; gap > 0; gap /= 2) { // set the initial step to half the length of the array
            for (int i = gap; i < n; i++) {
                Medicine keyValue = medicine[i];
                Double key = Double.parseDouble(medicine[i].getCost());

                int j = i;
                while (j >= gap && Double.parseDouble(medicine[j - gap].getCost()) < key) { // swap elements
                    medicine[j] = medicine[j - gap];
                    j -= gap;
                }
                medicine[j] = keyValue;
            }
        }
        return medicine;
    }
}
