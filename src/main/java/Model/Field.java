package Model;


public class Field {
    protected String fieldName;

    private String string;

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

    public Field(String fieldName, String string) {
        this.fieldName = fieldName;
        this.string = string;
    }

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }
}
