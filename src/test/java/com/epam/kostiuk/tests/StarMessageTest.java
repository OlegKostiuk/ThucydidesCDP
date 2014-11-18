package com.epam.kostiuk.tests;

import com.epam.kostiuk.requirements.Application;
import com.epam.kostiuk.steps.GmailUserSteps;
import com.epam.kostiuk.utils.DataProvider;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Random;

@RunWith(ThucydidesRunner.class)
@Story(Application.StarMessageTest.class)
public class StarMessageTest {

    @Managed
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public GmailUserSteps gmailUser;

    @Test
    public void checkStarMessage() {
        gmailUser.login(DataProvider.getValue("user.login"), DataProvider.getValue("user.password"));
        Random random = new Random();
        int starMessage = random.nextInt(gmailUser.getStarListSize());
        while (gmailUser.isStared(starMessage)) {
            starMessage = random.nextInt(gmailUser.getStarListSize());
        }
        gmailUser.starMessage(starMessage);
        gmailUser.openInboxPage();
        Assert.assertTrue(gmailUser.isStared(starMessage));
    }
}
