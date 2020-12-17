package Controller;

import Model.Acount.Account;
import Model.Event;
import Model.Game;

public class ControllerSection {
    private static ControllerSection ControllerSection=new ControllerSection();


    private Account account;
    private Event currentEvent;
    private Game currentGame;


    public static ControllerSection getInstance() {
        return ControllerSection;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Event getCurrentEvent() {
        return currentEvent;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
