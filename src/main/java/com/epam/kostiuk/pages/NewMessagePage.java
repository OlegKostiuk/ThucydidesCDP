package com.epam.kostiuk.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewMessagePage extends PageObject {
    private static final String MESSAGE_IFRAME_XPATH = "//iframe[@tabindex='1']";
    private static final String DISCART_DRAFT_XPATH = ".//*[@class = 'og T-I-J3']";
    public static final String SAVE_BUTTON_XPATH = ".//img[@class='Ha']";

    @FindBy(xpath = DISCART_DRAFT_XPATH)
    private WebElementFacade discardDraft;

    @FindBy(xpath = MESSAGE_IFRAME_XPATH)
    private WebElementFacade messageBoxFrame;

    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElementFacade saveAndClose;

    @FindBy(xpath = ".//textarea[@class='vO']")
    private WebElementFacade sendTo;

    @FindBy(xpath = ".//*[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElementFacade send;

    public void typeMessage(String message) {
        getDriver().switchTo().frame(messageBoxFrame);
        WebElement editable = getDriver().switchTo().activeElement();
        editable.sendKeys(message);
        getDriver().switchTo().defaultContent();
    }

    public String getNewMailMessage() {
        getDriver().switchTo().frame(messageBoxFrame);
        WebElement editable = getDriver().switchTo().activeElement();
        String mailMessage = editable.getText();
        getDriver().switchTo().defaultContent();
        return mailMessage;
    }

    public void clickDiscardDraft() {
        discardDraft.click();
    }

    public void typeSendTo(String recipient) {
        sendTo.type(recipient);
    }

    public void clickSend() {
        send.click();
    }

    public void clickSaveAndClose() {
        saveAndClose.click();
    }

}
