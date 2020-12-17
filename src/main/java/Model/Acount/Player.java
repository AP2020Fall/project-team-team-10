package Model.Acount;

import Exception.FieldDoesNotExist;
import Model.Database;
import Model.Money;
import Model.Score;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Account{
    public Score score;
    public Money money;
    private static ArrayList<Player> playerList=new ArrayList<>();
    public List<Player> friends=new ArrayList<Player>();

/******************************** constructor **********************************************/

    public Player(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber, Score score, LoginDay time, Money money, ArrayList<Player> friends, ArrayList<Friends> reqList) {
        super(name, familyName, userName, ID, password, email, phoneNumber);
        this.score = score;
        this.time = time;
        this.money = money;
        this.friends = friends;
        this.reqList = reqList;
    }

    private Player() {
        super();
    }

/**************************** getter and setter *******************************/
    public Score getScore() {
        return score;
    }

    public Money getMoney() {
        return money;
    }

    public List<Player> getFriends() {
        return friends;
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



/**************************** method ******************************************************/
    public void addFriends(Player playerID){
        if ("playerID".equals(playerID))
        friends.add(playerID);
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
    public void editField(@NotNull String field, String value) throws FieldDoesNotExist, NumberFormatException {

        switch (field) {
            case "password" -> setPassword(value);
            case "firstName" -> setFirstName(value);
            case "familyName" -> setFamilyName(value);
            case "userName" -> setUserName(value);
            case "email" -> setEmail(value);
            case "phoneNumber" -> setPhoneNumber(value);


        }

        Database.save(this);
    }
public void addFriend(Account accountId){

}
/*************************** pack *****************************************************/




}
