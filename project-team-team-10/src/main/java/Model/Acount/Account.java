package Model.Acount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    protected String name;
    protected String familyName;
    protected String userName;
    protected String ID;
    protected String password;
    protected String email;
    protected String phoneNumber;
    protected static List<Account> list = new ArrayList<>();
    protected LocalDate loginDate;
    protected LocalDate currentDate;

/*************** constructor **********/
protected Account(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber) {
        this.name = name;
        this.familyName = familyName;
        this.userName = userName;
        this.ID = ID;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static void AddAccount(Account account){
        list.add(account);
    }
    /********************** getter and setter ************/
    public static List<Account> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getUserName() {
        return userName;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public static void setList(List<Account> list) {
        Account.list = list;
    }

    public void setLoginDate(LocalDate loginDate) {
        this.loginDate = loginDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    /***************** edit and remove account*********************/

    public void editField(String field ,String value) throws FieldDoesNotExist {
        if ("password".equals(field)){
            setPassword(value);
        }else {

        }
    }

    public void removeAccount(final Account account){
        list.removeIf(acc -> account.getID().equals(acc.getID()) );

    }




}

