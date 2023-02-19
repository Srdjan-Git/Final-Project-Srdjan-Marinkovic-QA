package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.AutomobilePage;
import tests.BaseTest;

import java.io.IOException;

public class AutomobileSteps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    @Before
    public void setup() throws Exception {
        initialization(browser);
        reporterScreenshot("Start-Test_Automobile", "Starting browser and starting the test Automobile", null);
    }

    @After
    public void tearDown() throws IOException {
        reporterScreenshot("End-Test-Automobile", "The end test Automobile", null);
        quitBrowser(quit);
    }

    @Given("I am on the polovni automobili home page")
    public void iAmOnThePolovniAutomobiliHomePage(){
        driver.get("https://www.polovniautomobili.com/");

    }

    @When("I click on cookie button")
    public void iClickOnCookieButton() throws Exception {
        new AutomobilePage(driver).clickCookie();
    }

    @And("I select desire automobile brand")
    public void iSelectDesireAutomobileBrand() throws Exception {
        new AutomobilePage(driver).selectBrand("Mercedes Benz");
    }

    @And("I select desire automobile model")
    public void iSelectDesireAutomobileModel() throws Exception {
        new AutomobilePage(driver).selectModel("C 220");
    }

    @And("I enter desire automobile price")
    public void iEnterDesireAutomobilePrice() throws Exception {
        new AutomobilePage(driver).enterPriceTo("10000");
    }

    @And("I select desire automobile year from")
    public void iSelectDesireAutomobileYearFrom() throws Exception {
        new AutomobilePage(driver).selectYearFrom("2007 god.");
    }

    @And("I select desire automobile year to")
    public void iSelectDesireAutomobileYearTo() throws Exception {
        new AutomobilePage(driver).selectYearTo("2015 god.");
    }

    @And("I select desire automobile chassis")
    public void iSelectDesireAutomobileChassis() throws Exception {
        new AutomobilePage(driver).selectChassis("Karavan");
    }

    @And("I select desire automobile fuel")
    public void iSelectDesireAutomobileFuel() throws Exception {
        new AutomobilePage(driver).selectFuel("Benzin");
    }

    @And("I select desire automobile region")
    public void iSelectDesireAutomobileRegion() throws Exception {
        new AutomobilePage(driver).selectRegion("Beograd");
    }

    @And("I select desire automobile old new vehicles")
    public void iSelectDesireAutomobileOldNewVehicles() throws Exception {
        new AutomobilePage(driver).selectOldNewVehicles("Samo polovna vozila");
    }

    @And("I check automobile waranty")
    public void iCheckAutomobileWaranty() throws Exception {
        new AutomobilePage(driver).checkWaranty();
    }

    @And("I click search button")
    public void iClickSearchButton() throws Exception {
        new AutomobilePage(driver).clickSearchVehicle();
    }

    @And("I click on survey button")
    public void iClickOnSurveyButton() throws Exception {
        new AutomobilePage(driver).clickSurvey();
    }

    @Then("I should by see result search")
    public void iShouldBySeeResultSearch() throws IOException {
        new AutomobilePage(driver).assertResultSerach("Trenutno nema rezultata koji odgovaraju tvom kriterijumu pretraživanja. Savetujemo ti da oglasiš kupovinu vozila kakvo tražiš, a mi ćemo te obavestiti kada se takvo vozilo pojavi na sajtu.");
    }

    @And("I uncheck waranty filter")
    public void iUncheckWarantyFilter() throws Exception {
        new AutomobilePage(driver).clickCloseFilterWaranty();
    }

    @And("I cancel chassis filter")
    public void iCancelChassisFilter() throws Exception {
        new AutomobilePage(driver).clickCloseFilterChassis();
    }

    @And("I cancel fuel filter")
    public void iCancelFuelFilter() throws Exception {
        new AutomobilePage(driver).clickCloseFilterFuel();
    }

    @And("I cancel price filter")
    public void iCancelPriceFilter() throws Exception {
        new AutomobilePage(driver).clickCloseFilterPriceTo();
    }

    @And("I cancel region filter")
    public void iCancelRegionFilter() throws Exception {
        new AutomobilePage(driver).clickCloseFilterRegion();
    }

    @And("I select again desire automobile chassis")
    public void iSelectAgainDesireAutomobileChassis() throws Exception {
        new AutomobilePage(driver).selectChassis("Limuzina");
    }

    @And("I click again to search button")
    public void iClickAgainToSearchButton() throws Exception {
        new AutomobilePage(driver).clickSearchVehicle();
    }

    @Then("I should by see new result search")
    public void iShouldBySeeNewResultSearch() throws IOException {
        new AutomobilePage(driver).assertResultSerachAfterCloseFilters("Prikazano");
    }
}
