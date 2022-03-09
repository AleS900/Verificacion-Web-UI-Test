package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LeftSection;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;

public class LeftTest extends BaseTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    LeftSection leftSection = new LeftSection();
    String email = "santiavctf@gmail.com";
    String password = "Santiago900";

    @Test
    public void verifyProjectTodoLy()throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText(email);
        loginModal.pwdTxtBox.setText(password);
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR, no se pudo realizar el inicio de sesión.");

        // Create
        leftSection.addButton.click();
        leftSection.projectNameTxtBox.setText(leftSection.nameProj);
        leftSection.projectAddNameButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals(leftSection.nameProj, leftSection.projectVerifyNameControl.getTextControl(),"ERROR, no se pudo crear el proyecto.");
        Assertions.assertTrue(leftSection.projectVerifyNameExistControl.isControlDisplayed(),"ERROR, no se pudo crear el proyecto.");

        // Update
        leftSection.getNameProjectButton.click();
        leftSection.displayMenuButton.click();
        leftSection.displayEditButton.click();
        leftSection.clearNameProjectTxtBox.clearSetText(leftSection.newNameProj);
        leftSection.projectEditNameButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals(leftSection.newNameProj, leftSection.projectVerifyNewNameControl.getTextControl(),"ERROR, no se pudo actualizar el nombre del proyecto.");
        Assertions.assertTrue(leftSection.projectVerifyNewNameExistControl.isControlDisplayed(),"ERROR, no se pudo actualizar el nombre del proyecto.");

        // Delete
        leftSection.getNewNameProjectButton.click();
        leftSection.displayMenuButton.click();
        leftSection.projectDeleteButton.click();
        Thread.sleep(2000);
        leftSection.alertControl.alertAccept();
        Thread.sleep(5000);
        Assertions.assertNotEquals(leftSection.projectVerifyNameControl.getTextControl(), leftSection.newNameProj, "ERROR, no se pudo eliminar el proyecto.");
    }
}
