package Graphics.Account;

import Controller.ControllerSection;
import Exception.FieldDoesNotExist;
import Graphics.Interface.SceneBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin implements SceneBuilder {
    private Model.Acount.Admin admin =(Model.Acount.Admin) ControllerSection.getInstance().getAccount();
    private File selectedImage;


    @FXML
    private ImageView manager_image;
    @FXML
    private TextField Email;
    @FXML
    private TextField UserName;
    @FXML
    private TextField Password;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField PhoneNum;

    @Override
    public Scene sceneBuilder() {

        try {
            return FXMLLoader.load(new File("src/main/resources/Graphics/Account/ManagerAccount.fxml").toURI().toURL());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            UserName.setText(admin.getUserName());
            Password.setText(admin.getPassword());
            LastName.setText(admin.getPersonalInfo().getList().getFieldByName("LastName").getString());
            FirstName.setText(admin.getPersonalInfo().getList().getFieldByName("FirstName").getString());
            PhoneNum.setText(admin.getPersonalInfo().getList().getFieldByName("PhoneNumber").getString());
            Email.setText(admin.getPersonalInfo().getList().getFieldByName("Email").getString());

            if (admin.getMediaId() != 0) {
                manager_image.setImage(Medias.getImage(Medias.getMediasById(admin.getMediaId()).getImageSrc()));
            }
        } catch (FieldDoesNotExist e) {
            e.printStackTrace();
        }
    }

    public void ChoosePhoto() {
        FileChooser fc = new FileChooser();
        fc.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("image", "*.jpg", "*.png"));
        selectedImage = fc.showOpenDialog(null);
        Image value = new Image(selectedImage.toURI().toString());
        manager_image.setImage(value);
    }


}
