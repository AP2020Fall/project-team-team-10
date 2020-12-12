package Model;

import Model.Acount.Player;

import java.util.ArrayList;
import java.util.List;

public class Friends {
    public Player playerID;
    public List<Friends> friendsList =new ArrayList<>();

    public Friends(Player playerID) {
        this.playerID = playerID;
    }

    public Player getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Player playerID) {
        this.playerID = playerID;
    }
}
