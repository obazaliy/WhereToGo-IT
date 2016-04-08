package tests;

import org.junit.Test;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.RegistrationPageObject;
import pageobjects.UserInfoPageObject;

/**
 * Created by oshvets on 01.03.16.
 */
public class RegistrationTest {

    private RegistrationPageObject registrationPageObject = new RegistrationPageObject();
    private LoginPageObject loginPageObject = new LoginPageObject();
    private HomePageObject homePageObject = new HomePageObject();
    private UserInfoPageObject userInfoPageObject = new UserInfoPageObject();

    @Test
    public void registerNewUser () {
        homePageObject.openHomePage();
        registrationPageObject.registerAs("jack@gmail.com", "1234", "Jack", "Johnson");
        loginPageObject.loginAs("jack@gmail.com", "1234");
        homePageObject.validateAddEventButtonEnabled();
        homePageObject.validateLogoutIsVisible();
        homePageObject.validateAndOpenUserInfo("Jack Johnson");
        userInfoPageObject.validateAllUserInfo("jack@gmail.com","Jack Johnson" );

    }




}
