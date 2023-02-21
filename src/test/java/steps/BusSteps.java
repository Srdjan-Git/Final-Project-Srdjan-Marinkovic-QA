package steps;

import excel.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.BusPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BusSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    Map<String, String> data;

    @Before
    public void setup() throws Exception {
        initialization(browser);
        reporterScreenshot("Start-Test_Bus", "Starting browser and starting the test Test_Bus", null);
    }

    @After
    public void tearDown() throws IOException {
        reporterScreenshot("End-Test-Test_Bus", "The end test Test_Bus", null);
        quitBrowser(quit);
    }

    @Given("I am on the polovni automobili home page for bus and I load data from {string} {string} for {string}")
    public void iAmOnThePolovniAutomobiliHomePageForBus(String file, String sheet, String row) throws IOException {
        driver.get("https://www.polovniautomobili.com/");
        data = new ExcelReader().getRowDataByID(file, sheet, row);
    }

    @When("I click on cookie button page bus")
    public void iClickOnCookieButtonPageBus() throws Exception {
        new BusPage(driver).clickCookie();
    }

    @And("I clicked on icon transport vehicles in menu")
    public void iClickedOnIconTransportVehiclesInMenu() throws Exception {
        new BusPage(driver).clickTransportVehicle();
    }

    @And("I clicked on icon bus in sub menu")
    public void iClickedOnIconBusInSubMenu() throws Exception {
        new BusPage(driver).clickTransportVehicleBus();
    }

    @And("I clicked on search button on bus page")
    public void iClickedOnSearchButtonOnBusPage() throws Exception {
        new BusPage(driver).clickSearchVehicle();
    }

    @And("I select desire bus brand")
    public void iSelectDesireBusBrand() throws Exception {
        new BusPage(driver).selectBrand(data.get("brand"));
    }

    @And("I enter desire bus price from")
    public void iEnterDesireBusPriceFrom() throws Exception {
        new BusPage(driver).enterPriceFrom(data.get("priceFrom"));
    }

    @And("I enter desire bus price to")
    public void iEnterDesireBusPriceTo() throws Exception {
        new BusPage(driver).enterPriceTo(data.get("priceTo"));
    }

    @And("I select desire bus year from")
    public void iSelectDesireBusYearFrom() throws Exception {
        new BusPage(driver).selectYearFrom(data.get("yearFrom"));
    }

    @And("I select desire bus year to")
    public void iSelectDesireBusYearTo() throws Exception {
        new BusPage(driver).selectYearTo(data.get("yearTo"));
    }

    @And("I select desire bus km from")
    public void iSelectDesireBusKmFrom() throws Exception {
        new BusPage(driver).selectKmFrom(data.get("kmFrom"));
    }

    @And("I select desire bus km to")
    public void iSelectDesireBusKmTo() throws Exception {
        new BusPage(driver).selectKmTo(data.get("kmTo"));
    }

    @And("I select desire bus fuel")
    public void iSelectDesireBusFuel() throws Exception {
        new BusPage(driver).selectFuel(data.get("fuel"));
    }

    @And("I select desire bus region")
    public void iSelectDesireBusRegion() throws Exception {
        new BusPage(driver).selectRegion(data.get("region"));
    }

    @And("I select bus seats from")
    public void iSelectBusSeatsFrom() throws Exception {
        new BusPage(driver).selectSeatsFrom(data.get("seatsFrom"));
    }

    @And("I select bus seats to")
    public void iSelectBusSeatsTo() throws Exception {
        new BusPage(driver).selectSeatsTo(data.get("seatsTo"));
    }

    @And("I click search button bus")
    public void iClickSearchButtonBus() throws Exception {
        new BusPage(driver).clickSearchVehicle();
    }

    @Then("I should by see result search bus")
    public void iShouldBySeeResultSearchBus() throws IOException {
        new BusPage(driver).assertResultSerachBus(data.get("messageSuccessfully"));
    }
}
