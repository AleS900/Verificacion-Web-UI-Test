package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EditModal;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditTest extends BaseTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    EditModal editModal = new EditModal();
    String email = "santiavctf@gmail.com";
    String password = "Santiago900";
    DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
    String newUserName = "Santiago" + dt.format(LocalDateTime.now());
    String attr =  "value";

    @Test
    public void verifyEditUserNameTodoLy() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText(email);
        loginModal.pwdTxtBox.setText(password);
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR, no se pudo realizar el inicio de sesión.");

        //Editar Nombre de la Cuenta
        editModal.settingsButton.click();
        Thread.sleep(2000);
        editModal.nameTextBox.clearSetText(newUserName);
        editModal.okButton.click();
        editModal.settingsButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(editModal.nameTextBox.getTextAttributeControl(attr), newUserName,"ERROR, no se modifico el nombre.");
    }
}
