package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AutomobilePage extends BasePage {
    public AutomobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //--- Button for cookie and a survey ---
    @FindBy(css = "a[class='paBlueButtonPrimary jsCloseGdprNotice js-accept-cookies']")
    WebElement cookies;
    @FindBy(css = "button[id='btn_poll_no']")
    WebElement survey;
    //--- Button for cookie a survey End---


    //--- Filters ---

    //Brands
    @FindBy(css = "p[title=' Sve marke']")
    WebElement brandsClick;
    @FindBy(css = "form > div > div:nth-child(1) > div > div > ul")
    WebElement brandsSelect;

    //Models
    @FindBy(css = "[title=' Svi modeli']")
    WebElement modelsClick;
    @FindBy(css = "form > div > div:nth-child(2) > div > div > ul")
    WebElement modelsSelect;

    //Price to
    @FindBy(css = "input[name='price_to']")
    WebElement priceTo;

    //Year from
    @FindBy(css = "p[title=' Godište od']")
    WebElement yearFromClick;
    @FindBy(css = "form > div > div:nth-child(4) > div > div:nth-child(1) > div > div > ul")
    WebElement yearFromSelect;

    //Year to
    @FindBy(css = "p[title=' do']")
    WebElement yearToClick;
    @FindBy(css = "form > div > div:nth-child(4) > div > div:nth-child(2) > div > div > ul")
    WebElement yearToSelect;

    //Chassis
    @FindBy(css = "p[title=' Karoserija']")
    WebElement chassisClick;
    @FindBy(xpath = "//label[text() = 'Limuzina']/..")
    WebElement chassisSelect;

    //Fuels
    @FindBy(css = "p[title=' Gorivo']")
    WebElement fuelsClick;
    @FindBy(css = "form > div > div:nth-child(6) > div > div > ul")
    WebElement fuelsSelect;

    //Regions
    @FindBy(css = "p[title=' Region']")
    WebElement regionsClick;
    @FindBy(css = "form > div > div:nth-child(7) > div > div > ul")
    WebElement regionsSelect;

    //Old new vehicles
    @FindBy(css = "p[title=' Polovna i nova vozila'] > span")
    WebElement oldNewVehiclesClick;
    @FindBy(xpath = "//label[text() = 'Polovna i nova vozila']/../..")
    WebElement oldNewVehiclesSelect;

    //CheckBox credit
    @FindBy(css = "input[id='credit']")
    WebElement creditMark;

    //CheckBox leasing
    @FindBy(css = "input[id='leasing']")
    WebElement leasingMark;

    //CheckBox warranty
    @FindBy(css = "input[id='warranty']")
    WebElement warrantyMark;
    //--- Filters End---


    //--- Button for search car ---
    @FindBy(css = "button[name='submit_1']")
    WebElement searchButton;
    //--- Button for search car End---


    //--- Close selected filter ---
    @FindBy(css = "[data-field='region'] > i")
    WebElement closeFilterRegion;

    @FindBy(css = "[data-field='brandModel'] > i")
    WebElement closeFilterBrandModel;

    @FindBy(css = "[data-field='chassis'] > i")
    WebElement closeFilterChassis;

    @FindBy(css = "[data-field='fuel'] > i")
    WebElement closeFilterFuel;

    @FindBy(css = "[data-field='leasing'] > i")
    WebElement closeFilterLeasing;

    @FindBy(css = "[data-field='credit'] > i")
    WebElement closeFilterCredit;

    @FindBy(css = "[data-field='warranty'] > i")
    WebElement closeFilterWarranty;

    @FindBy(css = "[data-field='price_to'] > i")
    WebElement closeFilterPriceTo;

    @FindBy(css = "[data-field='year_from'] > i")
    WebElement closeFilterYearFrom;

    @FindBy(css = "[data-field='year_to'] > i")
    WebElement closeFilterYearTo;
    //--- Close selected filter End---

    //--- Result search ---
    @FindBy(css = "div[class='uk-width-1-1 reversre-search uk-text-center']")
    WebElement searchFailed;
    @FindBy(css = "div[class='js-hide-on-filter'] > small")
    WebElement searchSuccessful;
    // --- Result search end ---


    //--- Method ---
    public void clickCookie() throws Exception {
        click(cookies,"Clicked on cookie button");
    }

    public void selectBrand(String brand) throws Exception {
        selectValue(brand, brandsClick, brandsSelect, "Selecting the desired brand");
    }

    public void selectModel(String model) throws Exception {
        selectValue(model, modelsClick, modelsSelect, "Selecting the desired model");
    }

    public void enterPriceTo(String price) throws Exception {
        sendValue(price, priceTo, "Send price value on price control");
    }

    public void selectYearFrom(String year) throws Exception {
        selectValue(year, yearFromClick, yearFromSelect, "Selecting the desired year from");
    }

    public void selectYearTo(String year) throws Exception {
        selectValue(year, yearToClick, yearToSelect, "Selecting the desired year to");
    }

    public void selectChassis(String chassisVehicle) throws Exception {
        selectValueWithChecked(chassisVehicle, chassisClick, chassisSelect, "Selecting the desired chassis");
    }

    public void selectFuel(String fuel) throws Exception {
        selectValue(fuel, fuelsClick, fuelsSelect, "Selecting the desired fuel");
    }

    public void selectRegion(String region) throws Exception {
        selectValue(region, regionsClick, regionsSelect, "Selecting the desired region");
    }

    public void selectOldNewVehicles(String oldNewVehiclesValue) throws Exception {
        selectValue(oldNewVehiclesValue, oldNewVehiclesClick, oldNewVehiclesSelect, "Selected on old i new vehicles");
    }

    public void checkWaranty() throws Exception {
        if (!warrantyMark.isSelected()){
            click(warrantyMark, "Clicked on waranty checkbox control");
        }
    }

    public void clickSearchVehicle() throws Exception {
        click(searchButton, "Clicked on the search button");
    }

    public void clickSurvey() throws Exception {
        click(survey, "Clicked on the survey button - not want");
    }

    public void assertResultSerach(String result) throws IOException {
        String getResult = searchFailed.getText();
        assertEqual(getResult, result, "Checking the obtained and expected results - with filters");
    }

    public void clickCloseFilterChassis() throws Exception {
        click(closeFilterChassis, "Clicked on close filter chassis");
    }

    public void clickCloseFilterWaranty() throws Exception {
        if (warrantyMark.isSelected()){
            click(closeFilterWarranty, "Clicked on close filter waranty");
        }
    }

    public void clickCloseFilterRegion() throws Exception {
        click(closeFilterRegion, "Clicked on close filter region");
    }

    public void clickCloseFilterFuel() throws Exception {
        click(closeFilterFuel, "Clicked on close filter fuel");
    }

    public void clickCloseFilterPriceTo() throws Exception {
        click(closeFilterPriceTo, "Clicked on close filter price to");
    }

    public void assertResultSerachAfterCloseFilters(String result) throws IOException {
        String getResult = searchSuccessful.getText();
        boolean isContains = getResult.contains(result);
        String boolResult = String.valueOf(isContains);
        assertEqual(boolResult, "true", "Checking the obtained and expected results - after close filters");
    }
}

