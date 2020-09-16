package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class AutomationPracticeHomePage {
    public AutomationPracticeHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='login']")
    public WebElement signinButton;
    @FindBy(id = "email_create")
    public WebElement emailBox;
    @FindBy(id = "SubmitCreate")
    public WebElement createButton;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "passwd")
    public WebElement password;
    @FindBy(xpath = "//i[@class='icon-lock left']")
    public WebElement signIn;
    @FindBy(xpath = "//*[.='Authentication failed.']")
    public WebElement errorMesaj;
    @FindBy(xpath = "//a[.='Women']")
    public WebElement womenLink;
    @FindBy(xpath = "//a[@title='T-shirts']")
    public WebElement tshirts;
    @FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
    public WebElement product;
    @FindBy(xpath = "//input[@id='search_query_top']")
    public WebElement searchBox;
    @FindBy(name = "submit_search")
    public WebElement search;
    @FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
    public WebElement searchProduct;
}