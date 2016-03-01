package pageobjects;

import com.codeborne.selenide.Condition;
import lib.Category;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Sergii on 01.03.2016.
 */
public class FiltersPanelPageObject {
	public static final String FILTER_SEL = ".nav-left input";


	public HomePageObject selectFilter(Category... categories) {
		for (Category category : categories) {
			$$(FILTER_SEL)
					.filterBy(Condition.value(category.name()))
					.shouldHaveSize(1) //check that we have only one category
					.first()
					.click();
		}
		return page(HomePageObject.class);
	}
}
