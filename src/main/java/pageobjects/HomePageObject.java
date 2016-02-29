package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tests.AbstractTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class HomePageObject extends AbstractTest {

	public static final String ADD_EVENT_BTN_SEL = ".navbar-right .btn-add-event";

	public HomePageObject openHomePage() {
//		open("http://172.30.148.9:8080/WhereToGo/#");
		open("http://localhost:8080/WhereToGo/");
		assertEquals("The page title should equal Events", "Events!", title());
		return page(HomePageObject.class);
	}

	public void validateUserInfo(String userinfo) {
		$(By.className("userInfo")).shouldBe(text(userinfo));
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
		$$(".events-list > li a")
				.filter(text(event))
				.shouldHaveSize(1);
	}

	private SelenideElement getAddEventBtn() {
		return $(ADD_EVENT_BTN_SEL);
	}
	
}
