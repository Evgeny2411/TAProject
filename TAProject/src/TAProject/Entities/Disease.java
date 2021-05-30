package TAProject.Entities;

import java.util.Arrays;

public class Disease {
    private String name;
    private String doctor;
    private Medicine[] medicine;
    private String[] symptoms;

    public Disease(String name, String doctor, Medicine[] medicine, String[] symptoms) {
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
        return medicine;
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
