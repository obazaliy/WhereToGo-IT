package tests;

import com.codeborne.selenide.WebDriverRunner;
import lib.Category;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.FiltersPanelPageObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

//TODO: remove it when random user will be used for each test
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilterByCategoryTest {
	private LoginPageObject loginPageObject = new LoginPageObject();

	@Test
	public void whenFilterIsSelectedEventsFromChosenCategoryAreShown() {
		HomePageObject pageObject = HomePageObject.openHomePage();
		FiltersPanelPageObject filtersPanelPageObject = new FiltersPanelPageObject();

		//TODO: remove it when random user will be used for each test
		loginPageObject.loginAs("root@gmail.com", "root");

		pageObject.getFiltersPanel()
				.selectFilter(Category.MOVIE)
				.validateAllEventsHaveCategory(Category.MOVIE);
	}


	@Test
	public void whenMultipleFilterAreSelectedEventsFromChosenCategoriesAreShown() {
		HomePageObject pageObject = HomePageObject.openHomePage();

		//TODO: remove it when random user will be used for each test
		loginPageObject.loginAs("root@gmail.com", "root");

		pageObject.getFiltersPanel()
				.selectFilter(Category.TRIP, Category.CONCERT)
				.validateAllEventsHaveCategory(Category.TRIP, Category.CONCERT);
	}

	@Test
	public void checkFilteringByCategory () {
		System.setProperty("webdriver.chrome.driver", "/home/oshvets/chromedriver");
		WebDriverRunner.setWebDriver(new ChromeDriver());
		HomePageObject.openHomePage();
		loginPageObject.loginAs("root@gmail.com" , "root");



	}

}
