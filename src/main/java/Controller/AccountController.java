package Controller;

import Model.Acount.Account;

public class AccountController {

    protected ControllerSection controllerSection=new ControllerSection();


    public void editField(String fieldName,String newField) throws FieldDoesNotExist {
        Account account = controllerSection.getAccount();
        account.editField(fieldName,newField);
    }





}
