package pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

	private void setEmail(String email) {
		$(By.id("userEmail")).setValue(email);
	}

	private void setPassword(String password) {
		$(By.id("userPassword")).setValue(password);
	}

	private void openLoginForm() {
		$(".navbar-right").$(".dropdown-toggle").click();
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
