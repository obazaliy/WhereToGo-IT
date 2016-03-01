package tests;

import org.junit.Test;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.RegistrationPageObject;

/**
 * Created by oshvets on 01.03.16.
 */
public class RegistrationTest {

    private RegistrationPageObject registrationPageObject = new RegistrationPageObject();
    private LoginPageObject loginPageObject = new LoginPageObject();
    private HomePageObject homePageObject = new HomePageObject();

    @Test
    public void registerNewUser () {
        homePageObject.openHomePage();
        registrationPageObject.registerAs("abcde@gmail.com", "1234", "abcd", "txyz");
        loginPageObject.loginAs("abcde@gmail.com", "1234");
        homePageObject.validateAddEventButtonEnabled();
        homePageObject.validateLogoutIsVisible();
        homePageObject.validateUserInfo("abcd txyz");
    }

}
