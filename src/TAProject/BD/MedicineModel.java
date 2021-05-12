package TAProject.BD;

import TAProject.Entities.Disease;
import TAProject.Entities.Medicine;

import java.util.TreeMap;

public class MedicineModel implements Model<String , Medicine>{
    TreeMap<String, Medicine> medicineTreeMap;

    public MedicineModel() {
        medicineTreeMap = new TreeMap<>();
    }

    private static MedicineModel instance = new MedicineModel();

    public static MedicineModel getInstance() {
        return instance;
    }

    @Override
    public void add(String medicine, Medicine description) {
        medicineTreeMap.put(medicine , description);
    }

    @Override
    public void remove(String medicine) {
        medicineTreeMap.remove(medicine);
    }

    @Override
    public Medicine getModelElement(String medicine) {
        return medicineTreeMap.get(medicine);
    }

    @Override
    public TreeMap<String, Medicine> getModel() {
        return this.medicineTreeMap;
    }
}
