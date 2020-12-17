package Controller;

import Model.Acount.Account;
import Exception.*;
import java.util.List;

public class AccountController {

    protected ControllerSection controllerSection=new ControllerSection();
    protected List<Account> personalInfo;


    public void editField(String fieldName,String newField) throws FieldDoesNotExist {
        Account account = controllerSection.getAccount();
        account.editField(fieldName,newField);
    }


    public String viewPersonalInfo(){
       return controllerSection.getAccount()
        controllerSection.getAccount().getFamilyName()
        controllerSection.getAccount().getPhoneNumber()
        controllerSection.getAccount().getEmail()
        controllerSection.getAccount().getUserName()


    }





}
