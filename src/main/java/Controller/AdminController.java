package Controller;

import Exception.AccountDoesNotExistException;
import Model.Acount.Account;
import Model.Game;

public class AdminController  {
/********************* field **************************************/
    private static AdminController adminController = new AdminController();
    protected ControllerSection controllerSection=new ControllerSection();


/*********************instance *************************************/

public static AdminController getInstance() {
    return adminController;
}


private AdminController(){

}
/*********************** method *********************************************/
    public void addSuggestion(Account accountId, Game gameID){
        controllerSection.getSuggestion().addSuggestion(accountId,gameID);
    }
    public void removeSuggestion(Account account,Game gameId){
        controllerSection.getSuggestion().removeSuggestion(account,gameId);
    }


    public Account viewAccount(String username) throws AccountDoesNotExistException {
        return Account.getAccountByUserName(username);
    }




}
