package Controller;

import Model.Acount.Account;
import Model.Acount.Player;
import Model.Event;
import Model.Game;
import Model.Suggestion;

public class ControllerSection {
    private static ControllerSection ControllerSection=new ControllerSection();


    private Account account;
    private Event currentEvent;
    private Game currentGame;
    private Suggestion suggestion;
    private Player player;


    public static ControllerSection getInstance() {
        return ControllerSection;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Player getPlayer() {
        return player;
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

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
