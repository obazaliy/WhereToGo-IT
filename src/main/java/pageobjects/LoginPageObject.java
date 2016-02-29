package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPageObject {

	private void setEmail(String email) {
		$("#userEmail")
				.shouldBe(visible)
				.setValue(email);
	}

	private void setPassword(String password) {
		$(By.id("userPassword")).setValue(password);
	}

	private void openLoginForm() {
		$(".navbar-right .dropdown-toggle").click();
		$(".dropdown").shouldHave(cssClass("open"));
	}

	private boolean validateLoginFormIsVisible() {
		return $(".dropdown-menu").isEnabled();
	}

	private void clickSignInButton() {
		$$(By.tagName("button")).findBy(text("Sign in")).click();
	}

	public void loginAs(String email, String password) {
		openLoginForm();
		validateLoginFormIsVisible();
		setEmail(email);
		setPassword(password);
		clickSignInButton();
	}

}
