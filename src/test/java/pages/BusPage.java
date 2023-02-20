package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class BusPage extends BasePage{
    public BusPage(WebDriver driver) {
        super(driver);
    }

    //--- Button for cookie and a survey ---
    @FindBy(css = "a[class='paBlueButtonPrimary jsCloseGdprNotice js-accept-cookies']")
    WebElement cookies;
    @FindBy(css = "button[id='btn_poll_no']")
    WebElement survey;
    //--- Button for cookie a survey End---

    //--- Button menu vehicle ---
    @FindBy(css = "a[title='Transportna vozila']")
    WebElement choiceTransportVehicles;
    @FindBy(css = "a[title='Autobusi']")
    WebElement choiceTransportVehiclesBus;
    //--- Button menu vehicle End ---


    //--- Filters ---

    //Brands
    @FindBy(css = "p[title=' Marka']")
    WebElement brandsClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(1) > div > div > ul")
    WebElement brandsSelect;

    //Models
    @FindBy(css = "input[id ='modeltxt']")
    WebElement modelsBuses;

    //Price to
    @FindBy(css = "input[id='price_from']")
    WebElement priceFrom;
    @FindBy(css = "input[id='price_to']")
    WebElement priceTo;

    //Year from
    @FindBy(css = "p[title=' Godina od']")
    WebElement yearFromClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(4) > div > div:nth-child(1) > div > div > ul")
    WebElement yearFromSelect;

    //Year to
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(4) > div > div:nth-child(2) > div > p")
    WebElement yearToClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(4) > div > div:nth-child(2) > div > div > ul")
    WebElement yearToSelect;

    //KM From
    @FindBy(css = "p[title=' km od']")
    WebElement kmFromClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(5) > div > div:nth-child(1) > div > div > ul")
    WebElement kmFromSelect;

    //KM To
    @FindBy(css = "p[title=' km do']")
    WebElement kmToClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(5) > div > div:nth-child(2) > div > div > ul")
    WebElement kmToSelect;

    //Fules
    @FindBy(css = "p[title=' Vrsta goriva']")
    WebElement fuelsClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(6) > div > div > ul")
    WebElement fuelsSelect;

    //Regions
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(7) > div > p")
    WebElement regionsClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(7) > div > div > ul")
    WebElement regionsSelect;

    //Number of seats from
    @FindBy(css = "p[title=' Br. sedišta od']")
    WebElement numberSeatsFromClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(8) > div > div:nth-child(1) > div > div > ul")
    WebElement numberSeatsFromSelect;

    //Number of seats to
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(8) > div > div:nth-child(2) > div > p")
    WebElement numberSeatsToClick;
    @FindBy(css = "form > div.uk-grid > div.uk-width-medium-3-4.uk-width-1-1 > div > div:nth-child(8) > div > div:nth-child(2) > div > div > ul")
    WebElement numberSeatsToSelect;

    //CheckBox credit
    @FindBy(css = "input[id='credit']")
    WebElement creditMark;

    //CheckBox leasing
    @FindBy(css = "input[id='leasing']")
    WebElement leasingMark;
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

    @FindBy(css = "[data-field='price_to'] > i")
    WebElement closeFilterPriceTo;

    @FindBy(css = "[data-field='year_from'] > i")
    WebElement closeFilterYearFrom;

    @FindBy(css = "[data-field='year_to'] > i")
    WebElement closeFilterYearTo;

    @FindBy(css = "[data-field='showOldNew'] > i")
    WebElement closeFilterNewOld;
    //--- Close selected filter End---


    //--- Result search ---
    @FindBy(css = "div[class='uk-width-1-1 reversre-search uk-text-center']")
    WebElement searchFailed;
    @FindBy(css = "div[class='js-hide-on-filter'] > small")
    WebElement searchSuccessful;
    // --- Result search end ---

    //--- Sort ---
    @FindBy(css = "p[title=' Osnovno']")
    WebElement searchSortClick;
    @FindBy(css = "#search-results > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > label > div.uk-width-medium-2-3.uk-width-1-1 > div > div > ul")
    WebElement searchSortSelect;
    //--- Sort End---

    //--- Baner ---
    @FindBy(css = "#billboardojuhgfmkkjxwmmsnsigtwgpj > div > div._ado-responsiveFooterBillboard-hover > svg > polygon")
    WebElement baner;


    //--- Method ---
    public void clickCookie() throws Exception {
        click(cookies,"Clicked on cookie button");
    }

    public void clickTransportVehicle() throws Exception {
        click(choiceTransportVehicles,"Clicked on transport vehicle button");
    }

    public void clickTransportVehicleBus() throws Exception {
        click(choiceTransportVehiclesBus,"Clicked on transport vehicle bus button");
    }

    public void selectBrand(String brand) throws Exception {
        selectValue(brand, brandsClick, brandsSelect, "Selecting the desired buses brand");
    }

    public void enterPriceFrom(String price) throws Exception {
        sendValue(price, priceFrom, "Send price value on price from control");
    }

    public void enterPriceTo(String price) throws Exception {
        sendValue(price, priceTo, "Send price value on price to control");
    }

    public void selectYearFrom(String year) throws Exception {
        selectValue(year, yearFromClick, yearFromSelect, "Selecting the desired year from");
    }

    public void selectYearTo(String year) throws Exception {
        selectValue(year, yearToClick, yearToSelect, "Selecting the desired year to");
    }

    public void selectKmFrom(String km) throws Exception {
        selectValue(km, kmFromClick, kmFromSelect, "Selecting the desired km from");
    }

    public void selectKmTo(String km) throws Exception {
        selectValue(km, kmToClick, kmToSelect, "Selecting the desired km to");
    }

    public void selectFuel(String fuel) throws Exception {
        selectValue(fuel, fuelsClick, fuelsSelect, "Selecting the desired fuel");
    }

    public void selectRegion(String region) throws Exception {
        selectValue(region, regionsClick, regionsSelect, "Selecting the desired region");
    }

    public void selectSeatsFrom(String seats) throws Exception {
        selectValue(seats, numberSeatsFromClick, numberSeatsFromSelect, "Selecting the desired number seats from");
    }

    public void selectSeatsTo(String seats) throws Exception {
        selectValue(seats, numberSeatsToClick, numberSeatsToSelect, "Selecting the desired number seats to");
    }

    public void clickSearchVehicle() throws Exception {
        click(searchButton, "Clicked on the search button");
    }

    public void clickSurvey() throws Exception {
        click(survey, "Clicked on the survey button - not want");
    }

    public void assertResultSerachBus(String result) throws IOException {
        String getResult = searchSuccessful.getText();
        boolean isContains = getResult.contains(result);
        String boolResult = String.valueOf(isContains);
        assertEqual(boolResult, "true", "Checking the obtained and expected results - after close filters");
    }

    public void selectSort(String sort) throws Exception {
        selectValue(sort, searchSortClick, searchSortSelect, "Selecting the desired sort");
    }
}
