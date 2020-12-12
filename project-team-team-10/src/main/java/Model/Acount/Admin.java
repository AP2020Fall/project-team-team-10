package Model.Acount;

public class Admin extends Account {

    public Admin(String name, String familyName, String userName, String ID, String password, String email, String phoneNumber) {
        super(name, familyName, userName, ID, password, email, phoneNumber);
    }

    public static boolean isThereAnyAdmin(){
        return list.stream().anyMatch(account -> account instanceof Admin);
    }

}
