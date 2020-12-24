package Controller;

import Exception.FieldDoesNotExist;
import Model.Acount.Account;

import java.util.List;

public class AccountController {

    protected ControllerSection controllerSection=new ControllerSection();
    protected List<Account> personalInfo;


    public void editField(String fieldName,String newField) throws FieldDoesNotExist {
        Account account = controllerSection.getAccount();
        account.editField(fieldName,newField);
    }


    public void viewPersonalInfo(){
        controllerSection.getAccount().toString();

    }





}
