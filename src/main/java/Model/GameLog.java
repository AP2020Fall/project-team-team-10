package Model;

public class GameLog {
    public int count;
    public int winNum;
    public String gameID;
    public Score point;

    public GameLog(int count, int winNum, String gameID, Score point) {
        this.count = count;
        this.winNum = winNum;
        this.gameID = gameID;
        this.point = point;
    }

    public int getCount() {
        return count;
    }


}
