package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.runners.MethodSorters;
import pageobjects.EventPopUpObject;
import pageobjects.EditEventPageObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

import java.lang.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//TODO: remove it when random user will be used for each test
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddEventTest {

	private EventPopUpObject eventPopUpObject = new EventPopUpObject();
	private LoginPageObject loginPageObject = new LoginPageObject();
	private HomePageObject homePageObject = new HomePageObject();
	private EditEventPageObject editEventPageObject = new EditEventPageObject();

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
		homePageObject.validateAndOpenUserInfo("Root Root");
	}

	@Test
	public void newEventShouldBeCreatedIfFieldsAreFilledOutWithCorrectData() {
		final String eventName = "Some Cool Event!";

		homePageObject.openHomePage();
		//TODO: remove it when random user will be used for each test
		loginPageObject.loginAs("root@gmail.com", "root");
		homePageObject.clickAddEventButton();
		eventPopUpObject.checkAddEventPageVisible();
		eventPopUpObject.setEventTitle(eventName);
		eventPopUpObject.choseEventCategory("Pub");
		eventPopUpObject.selectCurrDateAsAStart();
		eventPopUpObject.selectCurrDateAsAnEnd();
		eventPopUpObject.setDescription("the best event ever");
		eventPopUpObject.setLocation("Lepse,Kiev");
		eventPopUpObject.setCost(100.00);
		eventPopUpObject.setCurrency("USD");
		eventPopUpObject.clickAddEvent();
		homePageObject.validateEventIsOnPage(eventName);
	}

	@Test
	public void editEvent () {
		Double eventCost = 100.00;

		homePageObject.openHomePage();
		loginPageObject.loginAs("root@gmail.com", "root");
		homePageObject.openEventPopUp("Concert....");
		editEventPageObject.clickEditEventButton();
		editEventPageObject.checkApplyChangesButtonVisible();
		eventPopUpObject.setEventTitle("Another New Event!");
		eventPopUpObject.setDescription("abcdefghij");
		eventPopUpObject.setCost(eventCost);
		editEventPageObject.clickApplyChangesButton();
		eventPopUpObject.checkEventPopupNotVisible();
		homePageObject.openEventPopUp("Another New Event!");
		String description = editEventPageObject.getDescription();
		String actualCost = editEventPageObject.getCost();
		assertEquals("Description is not correct","abcdefghij", description);
		assertEquals("Cost is not correct", eventCost.toString(), actualCost);


	}



}
