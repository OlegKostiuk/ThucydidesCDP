package com.epam.kostiuk.steps;

import com.epam.kostiuk.pages.EmailPage;
import com.epam.kostiuk.pages.InboxPage;
import com.epam.kostiuk.pages.LoginPage;
import com.epam.kostiuk.pages.NewMessagePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailUserSteps extends ScenarioSteps {

    private NewMessagePage newMessagePage;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private EmailPage emailPage;

    @Step
    public void openLoginPage() {
        loginPage.open();
    }

    @Step
    public void enterLogin(String login) {
        loginPage.enterLogin(login);
    }

    @Step
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Step
    public boolean isLoggedIn(String login) {
        return inboxPage.isloggedIn(login);
    }

    @Step
    public boolean isWrongCredentialsMessagePresent() {
        return loginPage.isWrongCredentialsMssgPresent();
    }

    @Step
    public void login(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickLogin();
    }

    @Step
    public void clickComposeButton() {
        inboxPage.clickComposeButton();
    }

    @Step
    public void typeRecipient(String recipient) {
        newMessagePage.typeSendTo(recipient);
    }

    @Step
    public void enterMessage(String message) {
        newMessagePage.typeMessage(message);
    }

    @Step
    public String getMessageText() {
        return newMessagePage.getNewMailMessage();
    }

    @Step
    public void clickSend() {
        newMessagePage.clickSend();
    }

    @Step
    public void clickDiscartDraft() {
        newMessagePage.clickDiscardDraft();
    }

    @Step
    public void clickUndo() {
        inboxPage.clickUndoButton();
    }

    @Step
    public void clickViewSendMessage() {
        inboxPage.clickViewSendMessage();
    }

    @Step
    public boolean checkEmailMessage(String text) {
        return emailPage.checkMessageText(text);
    }

    @Step
    public void clickUserInfoButton() {
        inboxPage.clickUserInfoButton();
    }

    @Step
    public void clickLogOut() {
        inboxPage.clickLogOut();
    }

    @Step
    public void openInboxPage() {
        inboxPage.open();
    }

    @Step
    public boolean isLoginPageOpened() {
        return loginPage.passwordFieldPresent();
    }

    @Step
    public void starMessage(int number) {
        inboxPage.starMessage(number);
    }

    @Step
    public int getStarListSize() {
        return inboxPage.starListSize();
    }

    @Step
    public boolean isStared(int number) {
        return inboxPage.isStared(number);
    }
}
