package com.alfabank.qapp;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.alfabank.qapp.page.LoginPage.ERROR_TEXT;

import org.junit.Test;


public class LoginTest extends BaseTest {

    @Test
    public void validateTextOnLoginPage() {
        loginPage.getPageTitle().check(matches(isDisplayed()));
        loginPage.getPageTitle().check(matches(withText("Вход в Alfa-Test")));
    }

    @Test
    public void validateLoginWithValidCredentials() {
        loginPage.login("Login", "Password");
    }

    @Test
    public void validateShowPasswordIcon() {
        loginPage.fillInPassword("Password");
        loginPage.getPassword().check(matches(withText("********")));
        loginPage.clickShowPasswordIcon();
        loginPage.getPassword().check(matches(withText("Password")));
    }

    @Test
    public void validateLoginWithInvalidPassword() {
        loginPage.login("Login", "Password1");
        loginPage.getError().check(matches(isDisplayed()));
        loginPage.getError().check(matches(withText(ERROR_TEXT)));
    }

    @Test
    public void validateLoginWithoutPassword() {
        loginPage.fillInUserName("Login");
        loginPage.clickLogInButton();
        loginPage.getError().check(matches(isDisplayed()));
        loginPage.getError().check(matches(withText(ERROR_TEXT)));
    }

    @Test
    public void validateLoginWithoutUserName() {
        loginPage.fillInPassword("Password");
        loginPage.clickLogInButton();
        loginPage.getError().check(matches(isDisplayed()));
        loginPage.getError().check(matches(withText(ERROR_TEXT)));
    }
}
