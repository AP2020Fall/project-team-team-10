package Model;

import Model.Acount.Player;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private long scoreId;
    private long userId;
    private static List<Score> list=new ArrayList<>();




    public static int increaseScore(int score){

    }

    public long getScoreId() {
        return scoreId;
    }

    public long getUserId() {
        return userId;
    }

    public static List<Score> getList() {
        return list;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public static void setList(List<Score> list) {
        Score.list = list;
    }
}
