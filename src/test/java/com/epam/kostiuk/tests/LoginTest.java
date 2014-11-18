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
@Story(Application.LoginTest.class)
public class LoginTest {

    @Managed
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public GmailUserSteps gmailUser;

    @Test
    public void loginTest() {
        gmailUser.login(DataProvider.getValue("user.login"), DataProvider.getValue("user.password"));
        Assert.assertTrue(gmailUser.isLoggedIn(DataProvider.getValue("user.login")));
    }

    @Test
    public void loginWrongCredentialsTest() {
        gmailUser.login(DataProvider.getValue("user.wrongLogin"), DataProvider.getValue("user.wrongPassword"));
        Assert.assertTrue(gmailUser.isWrongCredentialsMessagePresent());
    }
}
