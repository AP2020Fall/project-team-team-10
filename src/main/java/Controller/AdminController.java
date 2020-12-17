package Controller;

import Model.Acount.Account;
import Model.Suggestion;
import Exception.*;
import java.util.List;

public class AdminController  {
/********************* field **************************************/
    private static AdminController adminController = new AdminController();


/*********************instance *************************************/

public static AdminController getInstance() {
    return adminController;
}


private AdminController(){

}
/*********************** method *********************************************/
    public List<Suggestion> suggestionList(){return Suggestion.getSuggestionList();}


    public Account viewAccount(String username) throws AccountDoesNotExistException {
        return Account.getAccountByUserName(username);
    }




}
