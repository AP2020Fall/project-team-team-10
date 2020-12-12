package Model.Acount;

import Model.Friends;
import Model.Money;
import Model.Score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player extends Account{
    public Score score;
    public Money money;
    private static ArrayList<Player> playerList=new ArrayList<>();
    public List<Player> friends=new ArrayList<Player>();
    public ArrayList<Friends> reqList=new  ArrayList<Friends>();


    public Player(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber, Score score, LoginDay time, Money money, ArrayList<Player> friends, ArrayList<Friends> reqList) {
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

    public List<Player> getFriends() {
        return friends;
    }

    public ArrayList<Friends> getReqList() {
        return reqList;
    }


    public void setScore(Score score) {
        this.score = score;
    }


    public void setMoney(Money money) {
        this.money = money;
    }

    public void setFriends(ArrayList<Player> friends) {
        this.friends = friends;
    }

    public void setReqList(ArrayList<Friends> reqList) {
        this.reqList = reqList;
    }


    public void addFriends(Player playerID){
        if ("playerID".equals(playerID))
        friends.add(playerID);
    }
    public static void showUser(){
        playerList.sort(Comparator.comparing(o -> o.userName));
        for (Player player : playerList){
            System.out.print(player.userName);
        }
    }


}
