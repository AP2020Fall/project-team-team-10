package Model.Acount;

import Model.Friends;
import Model.LoginDay;
import Model.Money;
import Model.Score;

import java.util.ArrayList;

public class Player extends Account{
    public Score score;
    public LoginDay time;
    public Money money;
    public ArrayList<Friends> friends=new ArrayList<Friends>();
    public ArrayList<Friends> reqList=new  ArrayList<Friends>();


    public Player(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber, Score score, LoginDay time, Money money, ArrayList<Friends> friends, ArrayList<Friends> reqList) {
        super(name, familyName, userName, ID, password, email, phoneNumber);
        this.score = score;
        this.time = time;
        this.money = money;
        this.friends = friends;
        this.reqList = reqList;
    }

    public Score getScore() {
        return score;
    }

    public LoginDay getTime() {
        return time;
    }

    public Money getMoney() {
        return money;
    }

    public ArrayList<Friends> getFriends() {
        return friends;
    }

    public ArrayList<Friends> getReqList() {
        return reqList;
    }


    public void setScore(Score score) {
        this.score = score;
    }

    public void setTime(LoginDay time) {
        this.time = time;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setFriends(ArrayList<Friends> friends) {
        this.friends = friends;
    }

    public void setReqList(ArrayList<Friends> reqList) {
        this.reqList = reqList;
    }
}
