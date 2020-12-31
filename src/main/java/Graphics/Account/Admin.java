package Graphics.Account;

import Controller.ControllerSection;
import Graphics.Interface.SceneBuilder;
import javafx.fxml.Initializable;

public class Admin implements SceneBuilder, Initializable {
    private Model.Acount.Admin admin =(Model.Acount.Admin) ControllerSection.getInstance().getAccount();

}
