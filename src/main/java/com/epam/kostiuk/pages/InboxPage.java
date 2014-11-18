package com.epam.kostiuk.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://mail.google.com/mail/?ui=2&pli=1#inbox")
public class InboxPage extends PageObject {

    private static final String UNDO_BUTTON_XPATH = ".//*[@id='link_undo']";
    public static final String COMPOSE_XPATH = ".//*[@class='T-I J-J5-Ji T-I-KE L3']";
    public static final String USER_INFO_XPATH = ".//a[@class='gb_A gb_7 gb_f']";

    @FindBy(xpath = USER_INFO_XPATH)
    private WebElementFacade userInfo;

    @FindBy(xpath = COMPOSE_XPATH)
    private WebElementFacade composeButton;

    @FindBy(xpath = UNDO_BUTTON_XPATH)
    private WebElementFacade undoButton;

    @FindBy(id = "link_vsm")
    private WebElementFacade viewSendMessageButton;

    @FindBy(id = "gb_71")
    private WebElementFacade logOutButton;

    @FindBy(xpath = ".//td[@class='apU xY']/span")
    private List<WebElement> starMailList;

    public boolean isloggedIn(String login) {
       return userInfo.getAttribute("title").contains(login);
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public void clickUndoButton() {
        undoButton.click();
    }

    public void clickViewSendMessage() {
        viewSendMessageButton.click();
    }

    public void clickUserInfoButton() {
        userInfo.click();
    }

    public void clickLogOut() {
        logOutButton.click();
    }

    public void starMessage(int number) {
        starMailList.get(number).click();
    }

    public boolean isStared(int number) {
        return starMailList.get(number).getAttribute("aria-label").equals("Starred");
    }

    public int starListSize() {
        return starMailList.size();
    }
}
