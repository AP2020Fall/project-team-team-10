package Model;
import Exception.*;

public class Game {
    public GameLog gameLog;
    private long gameId;
    public Game gameName;


    public static boolean isThereAnyGameWithThisName(String name) throws GameInvalidName {
        if (name.equals("Dots")| name.equals("reversi")){
            return true;
        }else
            throw new GameInvalidName("input valid name game");

    }


}
