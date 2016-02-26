package pageobjects;

import static com.codeborne.selenide.Condition.hasClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

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

	public void selectStartDate(String date) {
		$("#start").click();
		$("#ui-datepicker-div").shouldBe(visible);
		$(By.className("ui-datepicker-calendar")).$(By.xpath(String.format("//a[contains(text, '%s')]", date)));
		//$(".ui-datepicker-calendar").find(text("25")).click();
	}

	public void selectEndtDate(String date) {
		$("#end").click();
		$("#ui-datepicker-div").shouldBe(visible);
		$(By.className("ui-datepicker-calendar")).$(By.xpath(String.format("//a[contains(text, '%s')]", date)));
		//$(".ui-datepicker-calendar").find(text("25")).click();
	}

	public void clickAddEvent() {
		$$(By.tagName("button")).findBy(text("Done")).click();
	}

	public void setDescription(String description) {
		$("#description").setValue(description);
	}


}
