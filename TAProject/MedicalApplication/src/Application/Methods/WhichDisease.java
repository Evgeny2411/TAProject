package Application.Methods;

import Application.BD.DiseaseModel;
import Application.Entities.Disease;

import java.util.*;

public class WhichDisease {
    private final ArrayList<String> usersSymptoms = new ArrayList<>();
    private final ArrayList<String[]> dbSymptoms = new ArrayList<>();
    private final ArrayList<String> names = new ArrayList<>();
    private final TreeMap<String, Disease> diseaseTreeMap = DiseaseModel.getInstance().getModel();

    private void setDbSymptoms() {
        ArrayList<Disease> a = new ArrayList<>(diseaseTreeMap.values());
        for (Disease disease : a) {
            names.add(disease.getName());
            dbSymptoms.add(disease.getSymptoms());
        }
    }

    private void setSymptoms(String[] symptoms) {
        usersSymptoms.clear();
        usersSymptoms.addAll(Arrays.asList(symptoms));
        setDbSymptoms();
    }

    public Disease whichDisease(String[] symptoms) {
        setSymptoms(symptoms);
        int tmp, max = 0, index = 0;
        double rate = 0, currRate;
        for(int i = 0; i < names.size(); i++){
            tmp = longestSubStringLength(dbSymptoms.get(i));
            if(tmp > max){
                index = i;
                max = tmp;
                rate = (double) tmp/dbSymptoms.get(i).length;
            }
            else if(tmp == max){
                currRate = (double) tmp/dbSymptoms.get(i).length;
                if(currRate > rate){
                    index = i;
                }
                if(tmp == dbSymptoms.get(i).length){
                    index = i;
                    break;
                }
            }
        }
        return diseaseTreeMap.get(names.get(index));
    }

    public int longestSubStringLength(String[] dbSymptoms) {
        String[] firstString = usersSymptoms.toArray(new String[0]);
        String[] secondString = dbSymptoms;
        ArrayList<String> sames = new ArrayList<>();
        for (int i = 0; i < firstString.length; i++) {
            for(int j = 0; j < secondString.length; j++){
                if(firstString[i].equals(secondString[j])){
                    sames.add(firstString[i]);
                }
            }
        }
        return sames.size();
    }
}
