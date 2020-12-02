package Model.Acount;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public String name;
    public String familyName;
    public String userName;
    public String ID;
    public String password;
    public String email;
    public String phoneNumber;
    protected static List<Account> list = new ArrayList<>();

/*************** constructor **********/
    public Account(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber) {
        this.name = name;
        this.familyName = familyName;
        this.userName = userName;
        this.ID = ID;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public static void AddAccount(Account account){

    }

    public static List<Account> getList() {
        return list;
    }
/********************** getter and setter ************/
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

    /***************** edit and remove account*********************/

    public void changeFirstName(String name) {
    }

    public void changeLastName(String name) {
    }

    public void changeEmail(String Email) {
        this.email = Email;
    }
    public void removeAccount(Account account){

    }




}

