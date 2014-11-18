package com.epam.kostiuk.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;



public class EmailPage extends PageObject {

    @FindBy(xpath = ".//*[@class='a3s']/div[1]")
    private WebElementFacade message;

    public boolean checkMessageText(String text) {
        return message.containsText(text);
    }
}
