package steps;

import excel.ExcelReader;
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
import java.util.Map;

public class AutomobileSteps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    Map<String, String> data;

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

    @Given("I am on the polovni automobili home page and I load data from {string} {string} for {string}")
    public void iAmOnThePolovniAutomobiliHomePageAndILoadDataFrom(String file, String sheet, String row) throws IOException {
        driver.get("https://www.polovniautomobili.com/");
        data = new ExcelReader().getRowDataByID(file, sheet, row);
    }

//    @Given("I am on the polovni automobili home page")
//    public void iAmOnThePolovniAutomobiliHomePage(){
//        driver.get("https://www.polovniautomobili.com/");
//
//    }

    @When("I click on cookie button")
    public void iClickOnCookieButton() throws Exception {
        new AutomobilePage(driver).clickCookie();
    }

    @And("I select desire automobile brand")
    public void iSelectDesireAutomobileBrand() throws Exception {
        new AutomobilePage(driver).selectBrand(data.get("brand"));
    }

    @And("I select desire automobile model")
    public void iSelectDesireAutomobileModel() throws Exception {
        new AutomobilePage(driver).selectModel(data.get("model"));
    }

    @And("I enter desire automobile price")
    public void iEnterDesireAutomobilePrice() throws Exception {
        new AutomobilePage(driver).enterPriceTo(data.get("price"));
    }

    @And("I select desire automobile year from")
    public void iSelectDesireAutomobileYearFrom() throws Exception {
        new AutomobilePage(driver).selectYearFrom(data.get("yearFrom"));
    }

    @And("I select desire automobile year to")
    public void iSelectDesireAutomobileYearTo() throws Exception {
        new AutomobilePage(driver).selectYearTo(data.get("yearTo"));
    }

    @And("I select desire automobile chassis")
    public void iSelectDesireAutomobileChassis() throws Exception {
        new AutomobilePage(driver).selectChassis(data.get("chassis"));
    }

    @And("I select desire automobile fuel")
    public void iSelectDesireAutomobileFuel() throws Exception {
        new AutomobilePage(driver).selectFuel(data.get("fuel"));
    }

    @And("I select desire automobile region")
    public void iSelectDesireAutomobileRegion() throws Exception {
        new AutomobilePage(driver).selectRegion(data.get("region"));
    }

    @And("I select desire automobile old new vehicles")
    public void iSelectDesireAutomobileOldNewVehicles() throws Exception {
        new AutomobilePage(driver).selectOldNewVehicles(data.get("oldNewVehicles"));
    }

    @And("I check automobile waranty")
    public void iCheckAutomobileWaranty() throws Exception {
        if (data.get("waranty").equals("Yes")){
            new AutomobilePage(driver).checkWaranty();
        }
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
        new AutomobilePage(driver).assertResultSerach(data.get("messageFailed"));
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
        new AutomobilePage(driver).selectChassis(data.get("chassisTwo"));
    }

    @And("I click again to search button")
    public void iClickAgainToSearchButton() throws Exception {
        new AutomobilePage(driver).clickSearchVehicle();
    }

    @Then("I should by see new result search")
    public void iShouldBySeeNewResultSearch() throws IOException {
        new AutomobilePage(driver).assertResultSerachAfterCloseFilters(data.get("messageSuccessfully"));
    }
}
