package pages;

import control.*;
import org.openqa.selenium.By;

public class EditModal {
    public Button settingsButton = new Button(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]"));
    public TextBox nameTextBox = new TextBox(By.xpath("//input[@id=\"FullNameInput\"]"));
    public Button okButton = new Button(By.xpath("//span[@class=\"ui-button-text\" and contains(.,\"Ok\")]"));
}
