package Model;

import Model.Acount.Player;

public class Friends {
    public Player playerID;

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
