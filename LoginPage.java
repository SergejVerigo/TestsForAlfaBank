package com.alfabank.qapp.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import com.alfabank.qapp.R;

public class LoginPage {

    private final int pageTitle = R.id.tvTitle;
    private final int userNameField = R.id.etUsername;
    private final int passwordField = R.id.etPassword;
    private final int loginButton = R.id.btnConfirm;
    private final int errorText = R.id.tvError;

    public static final String ERROR_TEXT = "Введены неверные данные";

    public ViewInteraction getPageTitle() {
        return onView(withId(pageTitle));
    }

    public void fillInUserName(String userName) {
        onView(withId(userNameField)).perform(typeText(userName));
    }

    public void fillInPassword(String password) {
        onView(withId(passwordField)).perform(typeText(password));
    }

    public ViewInteraction getPassword() {
        return onView(withId(passwordField));
    }

    public void clickLogInButton() {
        onView(withId(loginButton)).perform(click());
    }

    public void login(String userName, String password) {
        fillInUserName(userName);
        fillInPassword(password);
        clickLogInButton();
    }

    public ViewInteraction getError() {
        return onView(withId(errorText));
    }

    public void clickShowPasswordIcon() {
        onView(withContentDescription("Show password")).perform(click());
    }
}

