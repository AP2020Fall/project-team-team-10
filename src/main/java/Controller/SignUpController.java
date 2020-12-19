package Controller;

import Controller.Interface.RegisterAndLogIn;
import Exception.*;
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
                throw new MoreThanOneAdmin("Only one admin can signIn");
            }
            account=new Admin(username);
            break;
        default:
            throw new TypeInvalid("Type is invalid");

    }
    Account.addToInRegisteringList(account);
    return account;
 }
public void creatPassword(Account account,String password) throws PasswordException {
    RegisterAndLogIn.RegisterValidation registerValidation=RegisterAndLogIn.isPassword(password).get();

    if (registerValidation == RegisterAndLogIn.RegisterValidation.IS_NOT_A_VALID_PASS){
        throw new PasswordException("your Password is invalid");
    }
    account.setPassword(password);
}

public void savePersonalInfo(Account account,String firstName,String familyName,String phoneNumber,String email) throws AccountDoesNotExistException ,FirstNameInvalidException,FamilyNameInvalidException,PhoneNumberInvalidException,InvalidEmail{
    RegisterAndLogIn.RegisterValidation registerValidation = RegisterAndLogIn.isFirstName(firstName)
            .and(RegisterAndLogIn.isLastName(familyName))
            .and(RegisterAndLogIn.isPhoneNumber(phoneNumber))
            .and(RegisterAndLogIn.isEmail(email)).get();
    switch (registerValidation){
        case IS_NOT_A_VALID_FIRST_NAME:
            throw new FirstNameInvalidException("your first name is invalid");
        case IS_NOT_A_VALID_LAST_NAME:
            throw new FamilyNameInvalidException("your family name is invalid");
        case IS_NOT_A_VALID_NUMB:
            throw new PhoneNumberInvalidException("your phone number is invalid");
        case IS_NOT_A_VALID_EMAIL:
            throw new InvalidEmail("your email is invalid");
    }

    account.setFamilyName(familyName);
    account.setFirstName(firstName);
    account.setEmail(email);
    account.setPhoneNumber(phoneNumber);

    if (account instanceof Player){
        Account.addAccount(account);
        Account.removeFromInRegistering(account);

    }
    if (account instanceof Admin){
        Account.addAccount(account);
        Account.removeFromInRegistering(account);
    }


}


/*******************************instance ******************************/
private SignUpController(){

}
public static SignUpController getInstance(){
    return signUpController;
}



}
