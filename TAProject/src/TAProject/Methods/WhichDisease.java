package TAProject.Methods;

import TAProject.BD.DiseaseModel;
import TAProject.Entities.Disease;

import java.util.*;

public class WhichDisease {
    private ArrayList<String> usersSymptoms = new ArrayList<>();
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
        for(int i = 0; i < names.size(); i++){
            tmp = longestSubString(dbSymptoms.get(i));
            if(tmp > max){
                max = tmp;
                index = i;
            }
        }
        System.out.println(names.get(index));
        return diseaseTreeMap.get(names.get(index));
    }

    public int longestSubString(String[] dbSymptoms) {
        String[] firstString;
        String[] secondString;
        if (usersSymptoms.size() > dbSymptoms.length) {
            secondString = usersSymptoms.toArray(new String[0]);
            firstString = dbSymptoms;
        } else {
            secondString = dbSymptoms;
            firstString = usersSymptoms.toArray(new String[0]);
        }
        ArrayList<Stack<String>> sames = new ArrayList<>();
        int maxChainSize = 1;
        for (int i = 0; i < firstString.length - 1; i++) {
            Stack<String> buf = new Stack<>();
            int u = 0, y = 0;
            for (int j = i; j < firstString.length; j++) {
                for (; u <= secondString.length; u++) {
                    if (u == secondString.length) {
                        j++;
                        if (y == 0) {
                            break;
                        }
                        u = y;
                    }
                    if (firstString[y].equals(secondString[u])) {
                        buf.add(firstString[j]);
                        y = u;
                        break;
                    }
                }

                if (j < firstString.length - 1){ //&& firstString[j].length() > firstString[j + 1].length()) {
                    j++;
                }
            }
            if (maxChainSize == 1 && buf.size() > 0) {
                sames.add(buf);
                maxChainSize = buf.size();
            } else if (maxChainSize <= buf.size()) {
                sames.add(buf);
                maxChainSize = buf.size();
            }
        }
        return sames.size();
    }
}
