package TAProject.Entities;

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

    public String[] getMedicine() {
        return medicine;
    }

    public String[] getSymptoms() {
        return symptoms;
    }
}
