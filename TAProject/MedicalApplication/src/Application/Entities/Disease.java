package Application.Entities;


import Application.BD.MedicineModel;

import java.util.Arrays;

public class Disease {
    private String name;
    private String doctor;
    private String[] medicine;
    private String[] symptoms;

    public Disease(String name, String doctor, String[] medicine, String[] symptoms) {
        this.name = name;
        this.doctor = doctor;
        this.symptoms = symptoms;
        this.medicine = medicine;
    }

    public String getName() {
        return name;
    }

    public String getDoctor() {
        return doctor;
    }

    public Medicine[] getMedicine() {
        Medicine[] result = new Medicine[medicine.length];
        MedicineModel model = MedicineModel.getInstance();
        int i = 0;
        for(String key : medicine){
            result[i] = model.getModel().get(key);
            i++;
        }
        return result;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "name='" + name + '\'' +
                ", doctor='" + doctor + '\'' +
                ", medicine=" + Arrays.toString(medicine) +
                ", symptoms=" + Arrays.toString(symptoms) +
                '}';
    }
}
