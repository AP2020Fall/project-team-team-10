package Controller;

import Model.Acount.Account;

public class ControllerSection {
    private static ControllerSection ControllerSection=new ControllerSection();


    private Account account;

    public static ControllerSection getInstance() {
        return ControllerSection;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
