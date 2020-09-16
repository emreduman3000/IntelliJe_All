package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import pages.FhcRegisterPage;
import pages.FhcTripLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class FhcTripRegistration
{
    FhcRegisterPage fhcRegisterPage= new FhcRegisterPage();
    FhcTripLoginPage fhcTripLoginPage=new FhcTripLoginPage();
    @Given("kullanici fhctrip sayfasindadir")
    public void kullanici_fhctrip_sayfasindadir() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fhc_login_url"));
    }

    @Given("kullanici {string} butonuna tiklar")
    public void kullanici_butonuna_tiklar(String string) {
        fhcTripLoginPage.createButton.click();
    }

    @Given("kullanici username girer")
    public void kullanici_username_girer() {
        fhcRegisterPage.username.sendKeys("mehmet");
    }
    @Given("kullanici password girer")
    public void kullanici_password_girer() {
        fhcRegisterPage.password.sendKeys("password1");
    }
    @Given("kullanici email girer")
    public void kullanici_email_girer() {
        fhcRegisterPage.mail.sendKeys("mmmkka@gmail.com");
    }
    @Given("kullanici fullname girer")
    public void kullanici_fullname_girer() {
        fhcRegisterPage.fullname.sendKeys("Memoli can");
    }
    @Given("kullanici phone girer")
    public void kullanici_phone_girer() {
        fhcRegisterPage.phone.sendKeys("15204106202");
    }
    @Given("kullanici SSN girer")
    public void kullanici_SSN_girer() {
        fhcRegisterPage.ssnumber.sendKeys("111 111 111 222");
    }
    @Given("kullanici Driven lisans girer")
    public void kullanici_Driven_lisans_girer() {
        fhcRegisterPage.drivingLicense.sendKeys("125 abc 11");
    }
    @Given("kullanici country dropdowndan secer")
    public void kullanici_country_dropdowndan_secer() {
        Select select =new Select(fhcRegisterPage.Country);
        select.selectByIndex(12);
    }
    @Given("kullanici state dropdowndan secer")
    public void kullanici_state_dropdowndan_secer() {
        Select select =new Select(fhcRegisterPage.Country);
        select.selectByIndex(7);
    }
    @Given("kullanici adress girer")
    public void kullanici_adress_girer() {
        fhcRegisterPage.address.sendKeys("königsbrunn");
    }
    @Given("kullanici working sector girer")
    public void kullanici_working_sector_girer() {
        fhcRegisterPage.sector.sendKeys("IT egitim");
    }
    @Given("kullanici birthday girer")
    public void kullanici_birthday_girer() {
        fhcRegisterPage.birthdate.sendKeys("11.11.2001");
    }
    @Then("kullanici save butonuna tiklar")
    public void kullanici_save_butonuna_tiklar() {
        fhcRegisterPage.saveButton.click();
    }
}