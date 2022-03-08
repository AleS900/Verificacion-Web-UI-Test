package pages;

import control.AlertControl;
import control.Button;
import control.Control;
import control.TextBox;
import org.openqa.selenium.By;

import java.util.Date;

public class CRUDModal {
    // Create
    public String nameProj="UPB"+new Date().getTime();
    public Button addButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox projectNameTxtBox = new TextBox(By.id("NewProjNameInput"));
    public Button projectAddNameButton = new Button(By.id("NewProjNameButton"));
    public Control projectVerifyNameControl = new Control(By.id("CurrentProjectTitle"));
    public Control projectVerifyNameExistControl = new Control(By.xpath("//li[last()]//td[text()='"+nameProj+"']"));

    //Update
    public Button getNameProjectButton = new Button(By.xpath("//li[last()]//td[text()='"+nameProj+"']"));
    public Button displayMenuButton = new Button(By.xpath("//div[@style='display: block;']/img"));
    public Button displayEditButton = new Button(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']"));
    public TextBox clearNameProjectTxtBox = new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public String newNameProj="upb"+new Date().getTime();
    public Button projectEditNameButton = new Button(By.xpath("//td/div/img[@id='ItemEditSubmit']"));
    public Control projectVerifyNewNameControl = new Control(By.id("CurrentProjectTitle"));
    public Control projectVerifyNewNameExistControl = new Control(By.xpath("//li[last()]//td[text()='"+newNameProj+"']"));

    //Delete
    public Button getNewNameProjectButton = new Button(By.xpath("//li[last()]//td[text()='"+newNameProj+"']"));
    public Button displayMenu2Button = new Button(By.xpath("//div[@style='display: block;']/img"));
    public Button projectDeleteButton = new Button(By.id("ProjShareMenuDel"));
    public AlertControl alertControl = new AlertControl();
}