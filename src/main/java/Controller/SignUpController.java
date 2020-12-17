package Controller;

import Exception.*;
import Controller.Interface.RegisterAndLogIn;
import Model.Acount.Account;
import Model.Acount.Admin;
import Model.Acount.Player;

public class SignUpController {
/********************************field *******************************/
    public static SignUpController signUpController=new SignUpController();

/****************************** method *******************************/
 public Account creatTheAccount(String type,String username) throws UserNameInvalidException, UserNameTooShortException, TypeInvalid, MoreThanOneAdmin, ThisAccountAlreadyTakenException {
    RegisterAndLogIn.RegisterValidation registerValidation=RegisterAndLogIn.isUsername(username).get();
    switch (registerValidation){
        case IS_NOT_A_VALID_USERNAME_CHAR :
            throw new UserNameInvalidException("username is invalid");
        case IS_NOT_A_VALID_USERNAME_TOO_SHORT:
            throw new UserNameTooShortException("username is too short");

    }
    if (Account.isThereAnyInRegisteringWithThisUsername(username)){
        throw new ThisAccountAlreadyTakenException("this Account Already taken");
    }
    Account account;
    switch (type){
        case "Player":
            account=new Player(username);
            break;
        case "Admin":
            if (Admin.isThereAnyAdmin()) {
                throw new MoreThanOneAdmin("Only one admin can signin");
            }
            account=new Admin(username);
            break;
        default:
            throw new TypeInvalid("Type is invalid");

    }
    return account;
 }
public void creatPassword(Account account,String password) throws PasswordException {
    RegisterAndLogIn.RegisterValidation registerValidation=RegisterAndLogIn.isPassword(password).get();

    if (registerValidation == RegisterAndLogIn.RegisterValidation.IS_NOT_A_VALID_PASS){
        throw new PasswordException("your Password is invalid");
    }
    account.setPassword(password);
}
/*******************************instance ******************************/
private SignUpController(){

}
public static SignUpController getInstance(){
    return signUpController;
}

}
