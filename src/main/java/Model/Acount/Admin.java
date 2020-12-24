package Model.Acount;

import Model.Data.Data;
import Model.Database;
import Model.Game;


public class Admin extends Account{

/************************************* constructor *************************************************************/
   public Admin(String userName){
       super(userName);
   }
    private Admin(){
    }
/*************************************** method ***************************************************/
    public static boolean isThereAnyAdmin(){
        return list.stream().anyMatch(account -> account instanceof Admin);
    }

    public void removeAccount(Account account)  {
        list.remove(account);
        Database.remove(account);
    }
     public void addSuggestion(Account accountId,Game gameId){


     }
/**************************** pack ******************************************/
@Override
public Data<Account> pack() {
    return super.pack().setInstance(new Admin());
}

}
