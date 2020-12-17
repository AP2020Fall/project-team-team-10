package Controller;

import Controller.Interface.RegisterAndLogIn;
import Model.Acount.Account;
import Model.Acount.Admin;
import Model.Acount.Player;

public class SignUpController {
/********************************field *******************************/
    public SignUpController signUpController=new SignUpController();

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

}
