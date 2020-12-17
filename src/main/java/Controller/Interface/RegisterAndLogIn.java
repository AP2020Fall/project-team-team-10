package Controller.Interface;
import Model.Acount.Account;

import java.util.function.Supplier;

public interface RegisterAndLogIn extends Supplier<RegisterAndLogIn.RegisterValidation> {
    static RegisterAndLogIn isFirstName(String name){
        return () -> name.matches("^([a-z A-Z]+)$")
                ?RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_FIRST_NAME;


    }
    static RegisterAndLogIn isLastName(String name){
        return () -> name.matches("^([a-z A-Z]+)$")
                ? RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_LAST_NAME;
    }
    static RegisterAndLogIn isPhoneNumber(String num){
        return () -> num.matches("^(\\d{11})$")
                ? RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_NUMB;

    }
    static RegisterAndLogIn isEmail(String email){
        return () -> email.matches("^(.+)@(gmail|yahoo|outlook)(.+)$")
                ? RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_EMAIL;

    }
    static RegisterAndLogIn isPassword(String pass){
        return () -> pass.matches("^(\\w+)$")
                ? RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_PASS;
    }
    static RegisterAndLogIn isCorrectPassword(String pass, Account account){
        return () -> pass.equals(account.getPassword())
                ?RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_PASS_INCORRECT;

    }
    static RegisterAndLogIn isUsername(String user){
        return () -> user.matches("^(\\w+)$") ?
                user.matches("^(\\w{6}\\w*)$") ?
                        RegisterValidation.IS_VALID : RegisterValidation.IS_NOT_A_VALID_USERNAME_TOO_SHORT
                : RegisterValidation.IS_NOT_A_VALID_USERNAME_CHAR;
    }

    public enum RegisterValidation {
        IS_NOT_A_VALID_EMAIL, IS_NOT_A_VALID_FIRST_NAME,
        IS_NOT_A_VALID_LAST_NAME, IS_NOT_A_VALID_NUMB,
         IS_NOT_A_VALID_USERNAME_CHAR,
        IS_NOT_A_VALID_USERNAME_TOO_SHORT, IS_NOT_A_VALID_PASS,
        IS_NOT_A_VALID_PASS_INCORRECT , IS_VALID
    }




}
