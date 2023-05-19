package pageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.fluentlenium.core.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class MainPage extends PageObject {
	WebDriver driver;
	@FindBy(css = "li[class='nav-item active'] a[class='nav-link']")
	WebElement homeButton;

	@FindBy(css = "a[data-target='#exampleModal']")
	WebElement contactButton;
	@FindBy(id = "recipient-email")
	WebElement recipientMail;
	@FindBy(id = "recipient-name")
	WebElement recipientName;
	@FindBy(id = "message-text")
	WebElement messageText;
	@FindBy(xpath = "//button[contains(text(),'Send message')]")
	WebElement sendButton;

	WebElement closeButton;
	WebElement xButton;

	@FindBy(css = "a[data-target='#videoModal']")
	WebElement aboutUsButton;
	@FindBy(xpath = "(//h5[normalize-space()='About us'])[1]")
	WebElement aboutUsText;

	@FindBy(id = "cartur")
	WebElement cartButton;

	@FindBy(id = "login2")
	WebElement loginButton;
	@FindBy(id = "loginusername")
	WebElement loginUsername;
	@FindBy(id = "loginpassword")
	WebElement loginPassword;
	@FindBy(css = "button[onclick='logIn()']")
	WebElement loginSubmit;

	@FindBy(id = "signin2")
	WebElement signupButton;
	@FindBy(id = "sign-username")
	WebElement signUsername;
	@FindBy(id = "sign-password")
	WebElement signPassword;
	@FindBy(css = "button[onclick='register()']")
	WebElement signUpSubmit;

	@FindBy(xpath = "//a[contains(text(),'Phones')]")
	WebElement phoneButton;
	@FindBy(xpath = "//a[contains(text(),'Laptops')]")
	WebElement laptopsButton;
	@FindBy(xpath = "//a[contains(text(),'Monitors')]")
	WebElement monitorsButton;
	
	@FindBy(id = "next2")
	WebElement nextButton;
	
	@FindBy(id = ("logout2"))
	WebElement logOut;
	
	WebElement totalPrice;
	
	String welcomeStatus;
	
	WebElement element;
	List<WebElement> cartElements = new ArrayList<>();

	private WebElement productName;
	private WebElement productPrice;
	private WebElement productDiscription;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPrice(int a) {
		productPrice = find(By.cssSelector(
				"body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(" + a
						+ ") > div:nth-child(1) > div:nth-child(2) > h5:nth-child(2)"));
		return productPrice;
	}

	public WebElement getDiscription(int a) {
		productDiscription = find(By.xpath("(//p[@id='article'])[" + a + "]"));
		return productDiscription;
	}

	public WebElement getName(int a) {
		productName = find(By.cssSelector(
				"body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(" + a
						+ ") > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1) > a:nth-child(1)"));
		return productName;
	}

	public WebElement getCloseButton(int a) {
		closeButton = find(By.xpath("(//button[@type='button'][normalize-space()='Close'])[" + a + "]"));
		return closeButton;
	}
	
	public WebElement getXButton(int a) {
		xButton = find(By.xpath("(//span[@aria-hidden='true'][normalize-space()='×'])["+a+"]"));
		return xButton;
	}

	public WebElement getHomeButton() {
		return homeButton;
	}

	public WebElement getContactButton() {
		return contactButton;
	}

	public WebElement getAboutUsButton() {
		return aboutUsButton;
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginSubmit() {
		return loginSubmit;
	}

	public WebElement getSignupButton() {
		return signupButton;
	}

	public WebElement getSignUpSubmit() {
		return signUpSubmit;
	}

	public WebElement getPhoneButton() {
		return phoneButton;
	}

	public WebElement getLaptopsButton() {
		return laptopsButton;
	}

	public WebElement getMonitorsButton() {
		return monitorsButton;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public WebElement getAboutUsText() {
		return aboutUsText;
	}
	
	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getTotalPrice() {
		totalPrice = find(By.id("totalp"));
		return totalPrice;
	}

	public String getWelcomeStatus() {
		welcomeStatus = find(By.id("nameofuser")).getAttribute("style");
		return welcomeStatus;
	}

	public void logIn(String username, String password) {
		loginUsername.sendKeys(username);
		loginPassword.sendKeys(password);
		loginSubmit.click();
	}

	public void sendMessage(String email, String name, String message) {
		recipientMail.sendKeys(email);
		recipientName.sendKeys(name);
		messageText.sendKeys(message);
	}

	public void signUp(String username, String password) {
		signUsername.sendKeys(username);
		signPassword.sendKeys(password);
		signUpSubmit.click();
	}

	public String nameInDetailPage() {
		WebElement name = find(By.className("name"));
		return name.getText();
	}

	public String priceInDetailPage() {
		WebElement price = find(By.xpath("//h3[@class='price-container']"));
		return price.getText();
	}

	public String descriptionInDetailPage() {
		WebElement description = find(By.cssSelector("div[id='more-information'] p"));
		return description.getText();
	}

	public void addToCart() {
		WebElement add = find(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a"));
		add.click();
	}

	public String getAlertText() {

		return getAlert().getText();
	}

	public void alertAccept() {
		getAlert().accept();
	}
	
	public List<WebElement> cartList(){
		element = find(By.id("tbodyid"));
		cartElements = element.findElements(By.tagName("tr"));
		return cartElements;
	}
	
	public WebElement deletebutton(int a) {
		WebElement deleteButton = find(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr["+a+"]/td[4]/a"));
		return deleteButton;
	}
	
	public WebElement placeOrder() {
		WebElement placeOrder = find(By.xpath("/html/body/div[6]/div/div[2]/button"));
		return placeOrder;
	}
	
	public void inputSubmitPO(String name, String country, String city, String card, String month, String year) {
		find(By.id("name")).sendKeys(name);
		find(By.id("country")).sendKeys(country);
		find(By.id("city")).sendKeys(city);
		find(By.id("card")).sendKeys(card);
		find(By.id("month")).sendKeys(month);
		find(By.id("year")).sendKeys(year);
	}
	
	public void inputSubmitPO(String name, String card) throws InterruptedException {
		find(By.id("name")).sendKeys(name);
		Thread.sleep(1000);
		find(By.id("card")).sendKeys(card);		
	}
	
	public void submitPO() {
		find(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
	}

}
