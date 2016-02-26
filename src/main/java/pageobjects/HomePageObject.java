package pageobjects;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

public class HomePageObject {

	public void openHomePage() {
		open("http://172.30.148.9:8080/WhereToGo/#");
		//open("http://localhost:8888/WhereToGo/");
		assertEquals("The page title should equal Events", "Events!", title());
	}

	public void validateUserInfo(String userinfo) {
		$(By.className("userInfo")).shouldBe(text(userinfo));
	}

	public void validateLogoutIsVisible() {
		$(By.className("logout")).should(text("Logout")).shouldBe(visible);

	}

	public boolean validateAddEventButtonDisabled() {
		$(By.className("navbar-right")).$(By.className("btn-add-event")).should(visible);
		return $(By.className("navbar-right")).$(By.className("btn-add-event")).getCssValue("cursor").equals("not-allowed");
	}

	public void validateAddEventButtonEnabled() {
		$(By.className("navbar-right")).$(By.className("btn-add-event")).should(enabled);
	}

	public void clickAddEventButton() {
		$(By.className("navbar-right")).$(By.className("btn-add-event")).click();
	}

}
