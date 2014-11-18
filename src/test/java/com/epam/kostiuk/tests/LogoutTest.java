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

@RunWith(ThucydidesRunner.class)
@Story(Application.LogoutTest.class)
public class LogoutTest {

    @Managed
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public GmailUserSteps gmailUser;

    @Test
    public void logOutCheck() {
        gmailUser.login(DataProvider.getValue("user.login"), DataProvider.getValue("user.password"));
        gmailUser.clickUserInfoButton();
        gmailUser.clickLogOut();
        gmailUser.openInboxPage();
        Assert.assertTrue(gmailUser.isLoginPageOpened());
    }

}
