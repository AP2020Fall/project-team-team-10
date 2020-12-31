package Model.Acount;

import Exception.*;
import Exception.AccountDoesNotExistException;
import Exception.FieldDoesNotExist;
import Model.Database;
import Model.Game;
import Model.Money;
import Model.Score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Account{
    public Score score;
    public Money money;
    private static ArrayList<Player> playerList=new ArrayList<>();
    public List<Account> friendsList=new ArrayList<Account>();
    private List<Account> requestList=new ArrayList<Account>();
    public List<String> favoriteGameList=new ArrayList<String>();




    /******************************** constructor **********************************************/

    public Player(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber, Score score, Money money, List<Account> friends) {
        super(name, familyName, userName, ID, password, email, phoneNumber);
        this.score = score;
        this.money = money;
        this.friendsList = friends;
    }

    public Player(Score score, Money money, List<Account> friends) {
        this.score = score;
        this.money = money;
        this.friendsList = friends;
    }

    public Player(String userName, Score score, Money money, List<Account> friends) {
        super(userName);
        this.score = score;
        this.money = money;
        this.friendsList = friends;
    }

    private Player() {
        super();
    }

    public Player(String username) {
         super(username);
    }

    /**************************** getter and setter *******************************/
    public Score getScore() {
        return score;
    }

    public Money getMoney() {
        return money;
    }

    public List<Account> getFriends() {
        return friendsList;
    }

    public List<Account> getFriendsList() {
        return friendsList;
    }

    public List<Account> getRequestList() {
        return requestList;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setFriendsList(List<Account> friendsList) {
        this.friendsList = friendsList;
    }

    public void setRequestList(List<Account> requestList) {
        this.requestList = requestList;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setFriends(ArrayList<Account> friends) {
        this.friendsList = friends;
    }

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public List<String> getFavoriteGameList() {
        return favoriteGameList;
    }

    public static void setPlayerList(ArrayList<Player> playerList) {
        Player.playerList = playerList;
    }

    public void setFriends(List<Account> friends) {
        this.friendsList = friends;
    }

    public void setFavoriteGameList(List<String> favoriteGameList) {
        this.favoriteGameList = favoriteGameList;
    }

    /**************************** method ******************************************************/
    public void addFriends(Player playerID){
        if ("playerID".equals(playerID))
        friendsList.add(playerID);
        Database.save(this);
    }
    public static void showUser(){
        playerList.sort(Comparator.comparing(o -> o.userName));
        for (Player player : playerList){
            System.out.print(player.userName);
        }
    }


    public static List<Player> getAllPlayer() {
        return list.stream()
                .filter(account -> account instanceof Player)
                .map(account -> (Player) account)
                .collect(Collectors.toList());
    }

    @Override
    public void editField(String field, String value) throws FieldDoesNotExist, NumberFormatException {
        if ("password".equals(field)) {
            setPassword(value);
        } else {
            switch (field) {
                case "firstName":
                    setFirstName(value);
                    break;
                case "familyName":
                    setFamilyName(value);
                    break;
                case "userName":
                    setUserName(value);
                    break;
                case "email":
                    setEmail(value);
                    break;
                case "phoneNumber":
                    setPhoneNumber(value);
            }

            Database.save(this);
        }
    }

    public void favoriteGame(String gameName) throws GameInvalidName {
        if (Game.isThereAnyGameWithThisName(gameName)){
            favoriteGameList.add(gameName);
        }else
            throw new GameInvalidName("input valid gameName");
    }


public void addFriend(Account accountId) throws AccountDoesNotExistException {
    if (Account.isThereAnyAccountWithThisAccountId(accountId)) {


    }

}





/*************************** pack *****************************************************/




}
