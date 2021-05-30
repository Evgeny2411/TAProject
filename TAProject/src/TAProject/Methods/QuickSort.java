package TAProject.Methods;

import TAProject.Entities.Disease;
import TAProject.Entities.Medicine;

public class QuickSort implements Sort {
    private void sorter(Medicine[] medicine, int low, int high) {
        if (medicine.length == 0)
            return;// terminate execution if array length is 0

        if (low >= high)
            return;// terminate execution if there is already nothing to share


        // select pivot element
        int middle = low + (high - low) / 2;
        Double opora = Double.parseDouble(medicine[middle].getCost());

        // split into subarrays which is larger and smaller than the pivot
        int i = low, j = high;
        while (i <= j) {
            while (Double.parseDouble(medicine[i].getCost()) > opora) {
                i++;
            }

            while (Double.parseDouble(medicine[j].getCost()) < opora) {
                j--;
            }

            if (i <= j) {// swap places
                Medicine temp = medicine[i];
                medicine[i] = medicine[j];
                medicine[j] = temp;
                i++;
                j--;
            }
        }

        // call recursion to sort left and right
        if (low < j)
            sorter(medicine, low, j);

        if (high > i)
            sorter(medicine, i, high);
    }

    @Override
    public Medicine[] sort(Disease disease) {
        Medicine[] medicine = disease.getMedicine();
        sorter(medicine, 0, medicine.length - 1);
        return medicine;
    }
}
