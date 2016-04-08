package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lib.Category;
import org.openqa.selenium.By;

import java.util.List;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class HomePageObject {

	public static final String ADD_EVENT_BTN_SEL = ".navbar-right .btn-add-event";

	public static HomePageObject openHomePage() {
//		open("http://172.30.148.9:8080/WhereToGo/#");
		open("http://localhost:8888/WhereToGo/");
		assertEquals("The page title should equal Events", "Events!", title());
		return page(HomePageObject.class);
	}

	public void validateClearFiltersButtonVisible () {
		$(By.className("filters")).should(text("Clear filters")).shouldBe(visible);
	}

	public void validateAndOpenUserInfo(String userinfo) {
		$(By.className("userInfo")).shouldBe(text(userinfo)).click();

	}

	public void validateLogoutIsVisible() {
		$(By.className("logout")).shouldHave(text("Logout")).shouldBe(visible);

	}

	public boolean validateAddEventButtonDisabled() {
		getAddEventBtn().shouldBe(visible);
		return getAddEventBtn().getCssValue("cursor").equals("not-allowed");
	}

	public void validateAddEventButtonEnabled() {
		getAddEventBtn().shouldBe(enabled);
	}

	public void clickAddEventButton() {
		getAddEventBtn().click();
	}

	public void validateEventIsOnPage(String event) {
		getAllEvents()
				.filter(text(event))
				.shouldHaveSize(1);
	}

	private ElementsCollection getAllEvents() {
		return $$(".events-list > li").filterBy(visible);
	}

	public void validateAllEventsHaveCategory(Category category) {
		List<SelenideElement> eventsWithCategory = getEvents(category);

		getAllEvents().shouldHaveSize(eventsWithCategory.size());
	}

	public void validateAllEventsHaveCategory(Category... categories) {
		int eventsNumber = 0;
		for (Category category : categories) {
			eventsNumber += getEvents(category).size();
		}

		getAllEvents().shouldHaveSize(eventsNumber);
	}

	private List<SelenideElement> getEvents(Category category) {
		return $$(".events-list .event-description > li")
				.filterBy(visible)
				.filterBy(text(category.name()));
	}

	public FiltersPanelPageObject getFiltersPanel() {
		return page(FiltersPanelPageObject.class);
	}

	private SelenideElement getAddEventBtn() {
		return $(ADD_EVENT_BTN_SEL);
	}

	public void openEventPopUp (String eventName) {
				$$("li[class*=small_event]").findBy(text(eventName)).click();
	}
}
