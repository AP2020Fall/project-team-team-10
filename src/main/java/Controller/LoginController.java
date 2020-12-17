package Controller;


import Controller.Interface.RegisterAndLogIn;
import Model.Acount.Account;

public class LoginController {
    /************************* field***************************************************/

    private static ControllerSection controllerSection=new ControllerSection();
    private static LoginController loginController = new LoginController();
    /****************************** method************************************************/
    public Account login(String username,String password) throws PasswordException, UserNameInvalidException, UserNameTooShortException, AccountDoesNotExistException {
        RegisterAndLogIn.RegisterValidation checkUsername = RegisterAndLogIn
                .isUsername(username).get();

        switch (checkUsername) {
            case IS_NOT_A_VALID_USERNAME_TOO_SHORT:
                throw new UserNameTooShortException("Username is too short.");
            case IS_NOT_A_VALID_USERNAME_CHAR:
                throw new UserNameInvalidException("Username is invalid.");
        }

        Account account = Account.getAccountByUserName(username);

        RegisterAndLogIn.RegisterValidation checkPassword = RegisterAndLogIn.isCorrectPassword(password, account).get();

        if (checkPassword == RegisterAndLogIn.RegisterValidation.IS_NOT_A_VALID_PASS_INCORRECT) {
            throw new PasswordException("Password is incorrect.");
        }

        controllerSection.setAccount(account);

        return account;
    }




    private static boolean checkFormat(String string) {
        return string.matches("([0-9a-zA-Z_])+");
    }
 /*********************************instance ********************************/
 public static LoginController getInstance() {
     return loginController;
 }

      public LoginController(){

 }
}
