package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobjects.AddEventPopUpObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

import java.lang.*;

import static org.junit.Assert.assertTrue;

//TODO: remove it when random user will be used for each test
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddEventTest {

	private AddEventPopUpObject addEventPopUpObject = new AddEventPopUpObject();
	private LoginPageObject loginPageObject = new LoginPageObject();
	private HomePageObject homePageObject = new HomePageObject();

	@Test
	public void addEventButtonShouldBeDisabledForUnauthorizedUser() {
		homePageObject.openHomePage();
		assertTrue(homePageObject.validateAddEventButtonDisabled());
	}

	@Test
	public void addEventButtonShouldBeEnabledForAuthorizedUser() {
		homePageObject.openHomePage();

		loginPageObject.loginAs("root@gmail.com", "root");

		homePageObject.validateAddEventButtonEnabled();
		homePageObject.validateLogoutIsVisible();
		homePageObject.validateUserInfo("Root Root");
	}

	@Test
	public void newEventShouldBeCreatedIfFieldsAreFilledOutWithCorrectData() {
		final String eventName = "Some Cool Event!";

		homePageObject.openHomePage();
		//TODO: remove it when random user will be used for each test
		//loginPageObject.loginAs("root@gmail.com", "root");
		homePageObject.clickAddEventButton();
		addEventPopUpObject.checkAddEventPageVisible();
		addEventPopUpObject.setEventTitle(eventName);
		addEventPopUpObject.choseEventCategory("Pub");
		addEventPopUpObject.selectCurrDateAsAStart();
		addEventPopUpObject.selectCurrDateAsAnEnd();
		addEventPopUpObject.setDescription("the best event ever");
		addEventPopUpObject.clickAddEvent();
		homePageObject.validateEventIsOnPage(eventName);
	}

}
