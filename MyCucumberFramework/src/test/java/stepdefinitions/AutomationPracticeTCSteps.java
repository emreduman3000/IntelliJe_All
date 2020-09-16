package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AutomationPracticeHomePage;
import pages.AutomationPracticeRegisterPage;
import utilities.Driver;

public class AutomationPracticeTCSteps
{
    AutomationPracticeHomePage automationPracticeHomePage=new
            AutomationPracticeHomePage();
    AutomationPracticeRegisterPage automationPracticeRegisterPage=new
            AutomationPracticeRegisterPage();
    @Given("user web sayfasinda")
    public void user_web_sayfasinda() {
        Driver.getDriver().get("http://automationpractice.com/index.php");
    }
    @Given("user sign in linkine tiklar")
    public void user_sign_in_linkine_tiklar() {
        automationPracticeHomePage.signinButton.click();
    }


    @Given("user Create an account bolumune email adresi girer")
    public void user_Create_an_account_bolumune_email_adresi_girer() {
        automationPracticeHomePage.emailBox.sendKeys("sfd123123@gmail.com");
    }
    @Given("Create an Account butonuna basar")
    public void create_an_Account_butonuna_basar() {
        automationPracticeHomePage.createButton.click();
    }
    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        automationPracticeRegisterPage.firstname.sendKeys("ali");
        automationPracticeRegisterPage.lastname.sendKeys("turhan");
//automationPracticeRegisterPage.email.sendKeys("abc123123@gmail.com");
        automationPracticeRegisterPage.password.sendKeys("12345678");
        Select day = new Select(automationPracticeRegisterPage.day);
        day.selectByIndex(3);
        Select month = new Select(automationPracticeRegisterPage.month);
        month.selectByIndex(6);
        Select year = new Select(automationPracticeRegisterPage.year);

        year.selectByIndex(15);
        automationPracticeRegisterPage.company.sendKeys("tekno");
        automationPracticeRegisterPage.address1.sendKeys("hardstreet 121");
        automationPracticeRegisterPage.city.sendKeys("ny");
        Select state = new Select(automationPracticeRegisterPage.state);
        state.selectByIndex(4);
        automationPracticeRegisterPage.zipcode.sendKeys("12345");
        Select country = new Select(automationPracticeRegisterPage.country);
        country.selectByIndex(1);
        automationPracticeRegisterPage.addInformation.sendKeys("ajdfhjhjgfkjgfd");
        automationPracticeRegisterPage.homePhone.sendKeys("98798798");
        automationPracticeRegisterPage.mobilePhone.sendKeys("6875432513");
        automationPracticeRegisterPage.aliasAddress.sendKeys("my address");
    }
    @Given("user Register butonuna basar")
    public void user_Register_butonuna_basar() {
        automationPracticeRegisterPage.registerButton.click();
    }
    @Then("hesap olusturuldugunu dogrulayin")
    public void hesap_olusturuldugunu_dogrulayin() {
        Assert.assertTrue(automationPracticeRegisterPage.myAccount.isDisplayed());
    }


//@testcase2
    @Given("email kutusuna gecersiz email ve password yazar ve sign in butonuna tiklar")//this line represent feature file testcase reference
    public void email_kutusuna_gecersiz_email_ve_password_yazar_ve_sign_in_butonuna_tiklar()
    {
        automationPracticeHomePage.email.sendKeys("gecersiz@gmail.com");
        automationPracticeHomePage.password.sendKeys("111222");
        automationPracticeHomePage.signIn.click();
    }
    @Then("error mesajinin Authentication failed. oldugunu dogrulayin")
    public void error_mesajinin_Authentication_failed_oldugunu_dogrulayin() {
        Assert.assertTrue(automationPracticeHomePage.errorMesaj.isDisplayed());
    }



//@testcase3
    @Given("imleci Women linkinin uzerine ve daha sonra Tshirts'e tiklayin")
    public void imleci_Women_linkinin_uzerine_ve_daha_sonra_Tshirts_e_tiklayin() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(automationPracticeHomePage.womenLink).moveToElement(automationPracticeHomePage.tshirts).click().perform();
        Thread.sleep(2000);

    }
    @Given("sayfada gorunen ilk urunun textini alin")
    public void sayfada_gorunen_ilk_urunun_textini_alin() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String productName = automationPracticeHomePage.product.getText();
        System.out.println(productName);
    }

    @Given("sayfada ustte bulunan arama cubuguna ayni urun ismini girin ve search butonuna basin")
        public void sayfada_ustte_bulunan_arama_cubuguna_ayni_urun_ismini_girin_ve_search_butonuna_basin() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();

        automationPracticeHomePage.searchBox.sendKeys(automationPracticeHomePage.product.getText());
        Thread.sleep(2000);
        automationPracticeHomePage.search.click();
    }

    @Then("acilan sayfada cikan urunun T-Shirt sayfasinda goruntulenen urunle ayni oldugunu dogrulayin")
        public void acilan_sayfada_cikan_urunun_T_Shirt_sayfasinda_goruntulenen_urunle_ayni_oldugunu_dogrulayin() {
        Assert.assertTrue(automationPracticeHomePage.searchProduct.equals(automationPracticeHomePage.product));
        }






}


