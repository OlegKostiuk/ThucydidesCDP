package com.epam.kostiuk.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://accounts.google.com/ServiceLogin?service=mail")
public class LoginPage extends PageObject {

    @FindBy(id = "Email")
    private WebElementFacade loginBox;

    @FindBy(id = "Passwd")
    private WebElementFacade passwordBox;

    @FindBy(id = "signIn")
    private WebElementFacade loginButton;

    @FindBy(id = "errormsg_0_Passwd")
    private WebElementFacade wrongCredentialsMessage;

    public void enterLogin(String login) {
        loginBox.type(login);
    }

    public void enterPassword(String password) {
        passwordBox.type(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isWrongCredentialsMssgPresent() {
        return wrongCredentialsMessage.isPresent();
    }

    public boolean passwordFieldPresent() {
        return passwordBox.isDisplayed();
    }
}
