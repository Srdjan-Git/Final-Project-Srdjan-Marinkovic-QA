package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.AutomobilePage;
import pages.MotorcyclesPage;
import tests.BaseTest;

import java.io.IOException;

public class MotorcyclesSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    @Before
    public void setup() throws Exception {
        initialization(browser);
        reporterScreenshot("Start-Test_Motorcycles", "Starting browser and starting the test Test_Motorcycles", null);
    }

    @After
    public void tearDown() throws IOException {
        reporterScreenshot("End-Test-Test_Motorcycles", "The end test Test_Motorcycles", null);
        quitBrowser(quit);
    }

    @Given("I am on the polovni automobili home page for motorcycles")
    public void iAmOnThePolovniAutomobiliHomePageForMotorcycles(){
        driver.get("https://www.polovniautomobili.com/");

    }

    @When("I click on cookie button page motorcycles")
    public void iClickOnCookieButtonPageMotorcycles() throws Exception {
        new MotorcyclesPage(driver).clickCookie();
    }

    @And("I clicked on icon motorcycles in menu")
    public void iClickedOnIconMotorcyclesInMenu() throws Exception {
        new MotorcyclesPage(driver).clickVehicleMotorcycles();
    }

    @And("I select desire motorcycles brand")
    public void iSelectDesireMotorcyclesBrand() throws Exception {
        new MotorcyclesPage(driver).selectBrand("Honda");
    }

    @And("I enter desire motorcycles price")
    public void iEnterDesireMotorcyclesPrice() throws Exception {
        new MotorcyclesPage(driver).enterPriceTo("6000");
    }

    @And("I select desire motorcycles year from")
    public void iSelectDesireMotorcyclesYearFrom() throws Exception {
        new MotorcyclesPage(driver).selectYearFrom("1995 god.");
    }

    @And("I select desire motorcycles year to")
    public void iSelectDesireMotorcyclesYearTo() throws Exception {
        new MotorcyclesPage(driver).selectYearTo("2010 god.");
    }

    @And("I select desire motorcycles type")
    public void iSelectDesireMotorcyclesType() throws Exception {
        new MotorcyclesPage(driver).selectTypeMotorcycles("Chopper / Cruiser");
    }

    @And("I select desire motorcycles region")
    public void iSelectDesireMotorcyclesRegion() throws Exception {
        new MotorcyclesPage(driver).selectRegion("Beograd");
    }

    @And("I select another desire motorcycles type")
    public void iSelectAnotherDesireMotorcyclesType() throws Exception {
        new MotorcyclesPage(driver).selectTypeMotorcycles("Touring");
    }

    @And("I select another desire motorcycles region")
    public void iSelectAnotherDesireMotorcyclesRegion() throws Exception {
        new MotorcyclesPage(driver).selectRegion("Centralna Srbija");
    }

    @And("I check motorcycles credit")
    public void iCheckMotorcyclesCredit() throws Exception {
        new MotorcyclesPage(driver).checkCredit();
    }

    @And("I click search button motorcycles")
    public void iClickSearchButtonMotorcycles() throws Exception {
        new MotorcyclesPage(driver).clickSearchMotorcycles();
    }

    @Then("I should by see result search motorcycles")
    public void iShouldBySeeResultSearchMotorcycles() throws IOException {
        new MotorcyclesPage(driver).assertResultSerachMotorcycles("Prikazano");
    }

    @And("I  to sort by descending price")
    public void iToSortByDescendingPrice() throws Exception {
        new MotorcyclesPage(driver).selectSort("ceni silazno");
    }


}
