package Application.Methods;


import Application.Entities.Disease;
import Application.Entities.Medicine;

public interface Sort {
    Medicine[] sort(Disease disease);
}
