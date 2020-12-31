package Model.Acount;

import Exception.*;
import Model.Data.Data;
import Model.Database;
import Model.Tools.Packable;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Packable<Account> {
/******************************* field **********************************/

    protected String firstName;
    protected String familyName;
    protected String userName;
    protected long id;
    protected String password;
    protected String email;
    protected String phoneNumber;
    protected static List<Account> list = new ArrayList<>();
    protected LocalDate loginDate;
    protected LocalDate currentDate;
    protected static List<Account> inRegistering = new ArrayList<>();

/*********************************** constructor **********************************************/
protected Account(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber) {
        this.firstName = name;
        this.familyName = familyName;
        this.userName = userName;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Account(String firstName, String familyName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Account() {

    }
    public Account(String userName){
    this.userName=userName;
    }


    /************************* getter and setter *****************************/
    public static List<Account> getList() {
        return list;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getUserName() {
        return userName;
    }

    public static List<Account> getInRegistering() {
        return inRegistering;
    }

    public static void setInRegistering(List<Account> inRegistering) {
        Account.inRegistering = inRegistering;
    }

    @Override
    public long getId() {
        return id;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
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
            switch (field){
                case "firstName":
                    setFirstName(value);
                    break;
                case "familyName" :
                    setFamilyName(value);
                    break;
                case "userName" :
                    setUserName(value);
                    break;
                case "email":
                    setEmail(value);
                    break;
                case "phoneNumber":
                    setPhoneNumber(value);
            }

        }
       Database.save(this);
    }

    public void removeAccount(Account account){
        list.removeIf(acc -> account.getId() == acc.getId() );
        Database.remove(account);

    }
    public static void addAccount(Account account){
        list.add(account);
        Database.save(account,true);
    }

    public static boolean isThereAnyInRegisteringWithThisUsername(String username) {
        return inRegistering.stream().anyMatch(account -> username.equals(account.getUserName()));
    }

    public static Account getAccountByUserName(String name) throws AccountDoesNotExistException {
        return list.stream()
                .filter(account -> name.equals(account.getUserName()))
                .findFirst()
                .orElseThrow(() -> new AccountDoesNotExistException(
                        "The username:" + name + " not exist in all account list."
                ));
    }


    public void finishRegistering(Account account) {
        Account.removeFromInRegistering(account);
    }

    public static void removeFromInRegistering(Account account) {
        inRegistering.remove(account);
    }

    public static void addToInRegisteringList(Account account) {
        inRegistering.add(account);
    }


    public static boolean isThereAnyAccountWithThisUsername(String username) {
        return list.stream().anyMatch(account -> username.equals(account.getUserName()));
    }

    public static boolean isThereAnyAccountWithThisAccountId(Account accountId){
        return list.stream().anyMatch((account -> accountId.getId()== account.getId()));
    }

/****************************************** pack *****************************************/
@Override
public Account dpkg(@NotNull Data<Account> data) throws LogHistoryDoesNotExistException {
    this.id = (long) data.getFields().get(0);
    this.userName = (String) data.getFields().get(1);
    this.password = (String) data.getFields().get(2);

    return this;
}

    @Override
    public Data<Account> pack() {
        return new Data<Account>()
                .addField(id)
                .addField(userName)
                .addField(password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loginDate=" + loginDate +
                ", currentDate=" + currentDate +
                '}';
    }
}

