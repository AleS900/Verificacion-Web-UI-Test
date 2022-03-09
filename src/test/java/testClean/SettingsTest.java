package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SettingsModal;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SettingsTest extends BaseTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    SettingsModal settingsModal = new SettingsModal();
    String email = "santiavctf@gmail.com";
    String password = "Santiago900";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    String newUserName = "Santiago" + dtf.format(LocalDateTime.now());
    String attr =  "value";

    @Test
    public void verifyEditUserNameTodoLy() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText(email);
        loginModal.pwdTxtBox.setText(password);
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR, no se pudo realizar el inicio de sesión.");

        //Editar Nombre de la Cuenta
        settingsModal.settingsButton.click();
        Thread.sleep(2000);
        settingsModal.nameTextBox.clearSetText(newUserName);
        settingsModal.okButton.click();
        settingsModal.settingsButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(settingsModal.nameTextBox.getTextAttributeControl(attr), newUserName,"ERROR, no se modifico el nombre.");
    }
}
