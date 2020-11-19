package Model;

import Model.Acount.Player;

public class Score {
    public Player player;
    public long score;

    public Score(Player player, long score) {
        this.player = player;
        Score = score;
    }


    public static int increaseScore(int score){

    }

    public Player getPlayer() {
        return player;
    }

    public long getScore() {
        return Score;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setScore(long score) {
        Score = score;
    }
}
