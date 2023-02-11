package model.interfaces;

public interface IMatter {
    void registerObserver (ICheck observer);
    void cutObserver (ICheck observer);
}
