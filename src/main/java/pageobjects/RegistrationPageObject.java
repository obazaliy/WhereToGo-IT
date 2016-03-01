package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by oshvets on 26.02.16.
 */
public class RegistrationPageObject {

    private void setEmail (String email) {$(By.className("UserPage__email__input")).setValue(email);}

    private void setPassword (String password) {$(By.className("UserPage__password__input")).setValue(password);}

    private void setFirstName (String firstName) {$(By.className("UserPage__name__first")).setValue(firstName);}

    private void setLastName (String lastName) {$(By.className("UserPage__name__last")).setValue(lastName);}

    private void openLoginForm() {
        $(".navbar-right").$(".dropdown-toggle").click();
    }

    private boolean validateLoginFormIsVisible() {
        return $(".dropdown-menu").isEnabled();
    }

    private void clickRegisterButton() {
        $$(By.tagName("button")).findBy(text("Register")).click();
    }

    private void clickCloseButton () { $$(By.tagName("span")).findBy(text("close")).click();}

    private void clickAddUserButton () { $$(By.tagName("button")).findBy(text("Add user")).click();}

    public void registerAs (String email, String password, String firstName, String lastName) {

        openLoginForm ();
        validateLoginFormIsVisible();
        clickRegisterButton();
        setEmail (email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        clickAddUserButton();

    }

}
