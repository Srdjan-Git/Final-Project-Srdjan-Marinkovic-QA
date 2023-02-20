package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MotorcyclesPage extends BasePage {

    public MotorcyclesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //--- Button for cookie and a survey ---
    @FindBy(css = "a[class='paBlueButtonPrimary jsCloseGdprNotice js-accept-cookies']")
    WebElement cookies;
    @FindBy(css = "button[id='btn_poll_no']")
    WebElement survey;
    //--- Button for cookie a survey End---

    //--- Button menu vehicle ---
    @FindBy(css = "a[title='Motori']")
    WebElement choiceVehicleMotorcycles;
    //--- Button menu vehicle End ---


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

    //Type
    @FindBy(css = "form > div > div:nth-child(5) > div > p")
    WebElement typeClick;
    @FindBy(css = "form > div > div:nth-child(5) > div > div > ul")
    WebElement typeSelect;

    //Regions
    @FindBy(css = "form > div > div:nth-child(6) > div > p")
    WebElement regionsClick;
    @FindBy(css = "form > div > div:nth-child(6) > div > div > ul")
    WebElement regionsSelect;

    //Old new motorcycles
    @FindBy(css = "p[title=' Polovne i nove motore'] > span")
    WebElement oldNewVehiclesClick;
    @FindBy(css = "form > div > div:nth-child(7) > div > div > ul")
    WebElement oldNewVehiclesSelect;

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

    public void clickVehicleMotorcycles() throws Exception {
        click(choiceVehicleMotorcycles,"Clicked on vehicle motorcycles button");
    }

    public void selectBrand(String brand) throws Exception {
        selectValue(brand, brandsClick, brandsSelect, "Selecting the desired motorcycles brand");
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

    public void selectTypeMotorcycles(String type) throws Exception {
        selectValue(type, typeClick, typeSelect, "Selecting the desired motorcycles type");
    }

    public void selectRegion(String region) throws Exception {
        selectValue(region, regionsClick, regionsSelect, "Selecting the desired region");
    }

    public void checkCredit() throws Exception {
        if (!creditMark.isSelected()){
            click(creditMark, "Clicked on credit checkbox control");
        }
    }

    public void clickSearchMotorcycles() throws Exception {
        click(searchButton, "Clicked on the search button");
    }

    public void clickSurvey() throws Exception {
        click(survey, "Clicked on the survey button - not want");
    }

    public void assertResultSerachMotorcycles(String result) throws IOException {
        String getResult = searchSuccessful.getText();
        boolean isContains = getResult.contains(result);
        String boolResult = String.valueOf(isContains);
        assertEqual(boolResult, "true", "Checking the obtained and expected results - after close filters");
    }

    public void selectSort(String sort) throws Exception {
        selectValue(sort, searchSortClick, searchSortSelect, "Selecting the desired sort");
    }

}
