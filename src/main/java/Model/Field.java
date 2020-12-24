package Model;


import java.util.ArrayList;
import java.util.List;

public class Field implements Cloneable{
    protected String fieldName;

    private String string;

    private List<Field> fieldList;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Field setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public Field(String fieldName, String string) {
        this.fieldName = fieldName;
        this.string = string;
    }

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public Field(){

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Field> fields = new ArrayList<>();
        for (Field field : fieldList) {
            fields.add((Field) field.clone());
        }
        return ((Field) super.clone()).setFieldList(fields);
    }
}
