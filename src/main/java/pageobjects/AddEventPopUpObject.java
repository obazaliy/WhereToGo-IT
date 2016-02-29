package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddEventPopUpObject {

	public void setEventTitle(String titleName) {
		$(By.className("SinglePage__title ")).setValue(titleName);
	}

	public String getOwnerName() {
		return $(By.className("EventPage__owner__name ")).getText();
	}

	public void checkAddEventPageVisible() {
		$(".SinglePage__inputForm").shouldBe(visible);
	}

	public void choseEventCategory(String category) {
		$$(By.tagName("button")).filterBy(hasClass("multiselect")).get(0).click();
		$(".multiselect-container").shouldBe(visible);
		$(".multiselect-container").$$(By.tagName("label")).filterBy(text(category)).get(0).click();
	}

	public void selectCurrDateAsAStart() {
		selectDate();
	}

	public void selectCurrDateAsAnEnd() {
		selectDate();
	}

	private void selectDate() {
		$("#start").click();
		$("#ui-datepicker-div").shouldBe(visible);
		$(".ui-state-highlight").click();
		$(".ui-datepicker-close").click();
	}

	public void clickAddEvent() {
		$(".SinglePage__button--addEvent").click();
	}

	public void setDescription(String description) {
		$("#description").setValue(description);
	}


}
