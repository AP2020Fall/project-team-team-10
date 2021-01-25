package Model;

import Exception.*;
import java.util.ArrayList;
import java.util.List;

public class FieldList implements Cloneable {
    private List<Field> fieldList;

    /**************************** getter and setter ********************/
    public List<Field> getFieldList() {
        return fieldList;
    }

    public FieldList setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }


    public FieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
    /***************************** add and remove *********************************/
    public FieldList addFiled(Field field) {
        fieldList.add(field);
        return this;
    }

    public Field getFieldByName(String name) throws FieldDoesNotExist {
        return fieldList.stream()
                .filter(field -> name.equals(field.getFieldName()))
                .findFirst()
                .orElseThrow(() -> new FieldDoesNotExist(
                        "Field with the name:" + name + " doesn't exist."
                ));
    }

    public boolean isFieldWithThisName(String name) {
        return fieldList.stream().anyMatch(field -> name.equals(field.getFieldName()));
    }
/************************************ other method ***********************************/
    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Field> fields = new ArrayList<>();
        for (Field field : fieldList) {
            fields.add((Field) field.clone());
        }
        return ((FieldList) super.clone()).setFieldList(fields);
    }

    @Override
    public String toString() {
        return "FieldList{" +
                "fieldList=" + fieldList +
                '}';
    }
}
