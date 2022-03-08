package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CRUDModal;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;

public class CRUDTest extends BaseTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    CRUDModal crudModal = new CRUDModal();
    String email = "santiavctf@gmail.com";
    String password = "Santiago900";

    @Test
    public void verifyCRUDTodoLy()throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText(email);
        loginModal.pwdTxtBox.setText(password);
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR, no se pudo realizar el inicio de sesión.");

        // Create
        crudModal.addButton.click();
        crudModal.projectNameTxtBox.setText(crudModal.nameProj);
        crudModal.projectAddNameButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals(crudModal.nameProj,crudModal.projectVerifyNameControl.getTextControl(),"ERROR, no se pudo crear el proyecto.");
        Assertions.assertTrue(crudModal.projectVerifyNameExistControl.isControlDisplayed(),"ERROR, no se pudo crear el proyecto.");

        // Update
        crudModal.getNameProjectButton.click();
        crudModal.displayMenuButton.click();
        crudModal.displayEditButton.click();
        crudModal.clearNameProjectTxtBox.clearSetText(crudModal.newNameProj);
        crudModal.projectEditNameButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals(crudModal.newNameProj,crudModal.projectVerifyNewNameControl.getTextControl(),"ERROR, no se pudo actualizar el nombre del proyecto.");
        Assertions.assertTrue(crudModal.projectVerifyNewNameExistControl.isControlDisplayed(),"ERROR, no se pudo actualizar el nombre del proyecto.");

        // Delete
        crudModal.getNewNameProjectButton.click();
        crudModal.displayMenu2Button.click();
        crudModal.projectDeleteButton.click();
        Thread.sleep(2000);
        crudModal.alertControl.alertAccept();
        Thread.sleep(5000);
        Assertions.assertNotEquals(crudModal.projectVerifyNameControl.getTextControl(), crudModal.newNameProj, "ERROR, no se pudo eliminar el proyecto.");
    }
}
