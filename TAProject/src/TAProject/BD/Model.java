package TAProject.BD;

import java.util.TreeMap;

public interface Model<E, T> {
    void add(E disease, T description);
    void remove(E disease);
    T getModelElement(E disease);
    TreeMap<E, T> getModel();
    Model instance = Model.getInstance();
    static Model getInstance() {
        return instance;
    }

}
