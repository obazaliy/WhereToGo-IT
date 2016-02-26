package tests;

import org.junit.Test;
import pageobjects.AddEventPopUpObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

public class FirstTest {

	private AddEventPopUpObject addEventPopUpObject = new AddEventPopUpObject();
	private LoginPageObject loginPageObject = new LoginPageObject();
	private HomePageObject homePageObject = new HomePageObject();

	@Test
	public void checkAddEventButtonForPublicUser() {
		homePageObject.openHomePage();
		homePageObject.validateAddEventButtonDisabled();
	}

	@Test
	public void checkAddEventButtonForRootUser() {
		homePageObject.openHomePage();
		homePageObject.validateAddEventButtonDisabled();

		loginPageObject.loginAs("root@gmail.com", "root");

		homePageObject.validateAddEventButtonEnabled();
		homePageObject.validateLogoutIsVisible();
		homePageObject.validateUserInfo("Root Root");
	}

	@Test
	public void createNewEvent() {
		homePageObject.openHomePage();
		loginPageObject.loginAs("root@gmail.com", "root");
		homePageObject.clickAddEventButton();
		addEventPopUpObject.checkAddEventPageVisible();
		addEventPopUpObject.setEventTitle("Some Cool Event!");
		addEventPopUpObject.choseEventCategory("Pub");
		addEventPopUpObject.selectStartDate("26");
		addEventPopUpObject.selectEndtDate("27");
		addEventPopUpObject.setDescription("the best event ever");
		addEventPopUpObject.clickAddEvent();
	}

}
