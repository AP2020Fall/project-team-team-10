package Controller;

public class LoginController {

    private static LoginController loginController = new LoginController();
    public void login(String username, String password) throws PasswordException {
        if (checkFormat(username)){

        }

    }

    public static LoginController getInstance() {
        return loginController;
    }

    private static boolean checkFormat(String string) {
        return string.matches("([0-9a-zA-Z_])+");
    }
}
