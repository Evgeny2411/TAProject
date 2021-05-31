package Application.BD;

import Application.Entities.Disease;

import java.util.TreeMap;

public class DiseaseModel implements Model<String, Disease>{
    TreeMap<String, Disease> diseaseTreeMap;

    public DiseaseModel() {
       diseaseTreeMap = new TreeMap<>();
    }

    private static DiseaseModel instance = new DiseaseModel();

    public static DiseaseModel getInstance() {
        return instance;
    }

    @Override
    public void add(String disease, Disease description) {
        diseaseTreeMap.put(disease, description);
    }

    @Override
    public void remove(String disease) {
        diseaseTreeMap.remove(disease);
    }

    @Override
    public Disease getModelElement(String disease) {
        return diseaseTreeMap.get(disease);
    }

    @Override
    public TreeMap<String, Disease> getModel() {
        return this.diseaseTreeMap;
    }


}
