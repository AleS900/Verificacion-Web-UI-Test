package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CRUDModal;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;

import java.net.CacheRequest;

public class LoginTest extends BaseTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    CRUDModal crudModal = new CRUDModal();

    @Test
    public void verifyLoginTodoLy(){
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("santiavctf@gmail.com");
        loginModal.pwdTxtBox.setText("Santiago900");
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo hacer el login");
    }

}
