package Model.Data;

import Model.Tools.Packable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data <T extends Packable<T>>{
    private T instance;
    private List<Object> fields = new ArrayList<>();

    public List<Object> getFields() {
        return Collections.unmodifiableList(this.fields);
    }

    public T getInstance() throws AccountDoesNotExistException, LogHistoryDoesNotExistException {
        return instance.dpkg(this);
    }

    public Data<T> addField(Object field) {
        this.fields.add(field);
        return this;
    }

    public Data<T> setInstance(T instance) {
        this.instance = instance;
        return this;
    }
}
