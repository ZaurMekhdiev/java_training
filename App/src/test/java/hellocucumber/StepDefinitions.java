package hellocucumber;


import com.microsoft.playwright.*;
import io.cucumber.java.en.*;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class StepDefinitions {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    // Create a new incognito browser context.
    BrowserContext context = browser.newContext();
    // Create a new page in a pristine context.
    Page page = context.newPage();
    // Create a new incognito browser context

    @Given("Open page {string}")
    public void openSite(String url) {
        page.navigate(url);
    }

    @Then("User type message in field {string} to search {string}")
    public void typeInSearchField(String fieldname, String message) {
        page.locator("textarea[aria-label=\"" + fieldname + "\"]").fill(message);
    }

    @Then("User click the button {string}")
    public void clickTheButton(String button) {
        var locators = page.locator("[value=\"" + button + "\"]").all();
        locators.get(1).click();

    }

    @And("User see in results page {string}")
    public void assertsResults(String result){
        assertThat(page.getByText(result).first()).isVisible();
        System.out.println('X');
    }
}
