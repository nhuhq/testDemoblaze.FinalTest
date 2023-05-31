package step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;

public class StepDemoBlaze {
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@Steps
	private DemoBlazeScenarioStep demoSteps;

	@Given("access the website")
	public void accessDemoblaze() {
		demoSteps.accessMainPage();
	}

	@Then("The website displays product <order> information correct with {string},{string},{string}")
	public void checkInformation(int a, String name, String price, String description) {
		demoSteps.inViewPort(demoSteps.getDiscription(a));
		assertEquals(demoSteps.getNameText(a), name);
		assertEquals(demoSteps.getPriceText(a), price);
		assertEquals(demoSteps.getDiscriptionText(a), description);
	}

	@When("navigate to the next page")
	public void toNextPage() throws InterruptedException {
		Thread.sleep(2000);
		demoSteps.nextPage();
	}

	@Given("click the product {int}")
	public void toProductDetailPage(int a) throws InterruptedException {
		Thread.sleep(2000);
		demoSteps.selectProduct(a);
		Thread.sleep(2000);
	}

	@Then("The detail page displays product information correct with {string},{string},{string}")
	public void checkInDetailPage(String name, String price, String description) {
		assertEquals(demoSteps.nameInDetailPage(), name);
		assertEquals(demoSteps.priceInDetailPage(), price);
		assertEquals(demoSteps.descriptionInDetailPage(), description);
	}

	@And("click contact button")
	public void clickContactButton() {
		demoSteps.clickContactButton();
	}

	@Given("input {string}, {string}, {string} and send message")
	public void inputMessage(String email, String name, String message) throws InterruptedException {
		demoSteps.sendMessage(email, name, message);
		demoSteps.clickSend();
		Thread.sleep(2000);
	}

	@Then("confirm the message {string} from website")
	@Screenshots(disabled = false)
	public void confirmMessage(String message) throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(demoSteps.getAlertText(), message);
		demoSteps.alertAccept();
	}

	@Given("click Close button {int}")
	public void clickClose(int a) {
		demoSteps.close(a);
	}

	@Given("click X button {int}")
	public void clickX(int a) {
		demoSteps.closeX(a);
	}

	@Then("confirm the url is {string}")
	public void confirmURL(String url) throws InterruptedException {
		Thread.sleep(3000);
		assertEquals(demoSteps.getDriver().getCurrentUrl(), url);
	}

	@And("click About us button")
	public void clickAboutUs() {
		demoSteps.aboutUs();
	}

	@Then("confirm About us box is displayed")
	public void confirmAboutUsDisplay() {
		assertTrue(demoSteps.getAboutUsTitle().isDisplayed());
	}

	@And("click Sign up button")
	public void clickSignUpButton() {
		demoSteps.clickSignupButton();
	}

	@Given("input {string}, {string} to register")
	public void inputSignup(String username, String password) {
		demoSteps.signUp(username, password);
	}

	@And("click Log in button")
	public void clickLoginButton() {
		demoSteps.clickLoginButton();
	}

	@Given("input {string}, {string} to log in")
	public void inputLogin(String username, String password) throws InterruptedException {
		demoSteps.login(username, password);
		Thread.sleep(2000);
	}

	@Then("confirm that the user was logged in with welcome status is {string}")
	public void confirmLoggedin(String status) {
		assertEquals(demoSteps.getWelcomeStatus(), status);
	}

	@And("click Cart button")
	public void clickCart() throws InterruptedException {
		demoSteps.cart();
		Thread.sleep(5000);
	}

	@Then("confirm the url {string} is correct")
	public void confirmCartUrl(String url) {
		assertEquals(demoSteps.getDriver().getCurrentUrl(), url);
	}

	@Given("click the product, add to cart, get alert message then click Home button")
	public void addProduct(DataTable order) throws InterruptedException {
		List<String> orderList = order.asList();
		for (int i = 0; i < orderList.size(); i++) {
			int a = Integer.parseInt(orderList.get(i));
			demoSteps.selectProduct(a);
			Thread.sleep(1000);
//			((JavascriptExecutor) demoSteps.getDriver()).executeScript("window.alert = function(){}");
			demoSteps.addToCart();
			Thread.sleep(1500);
			assertEquals(demoSteps.getAlertText(), "Product added");
			demoSteps.alertAccept();
			demoSteps.home();
		}
	}

	@When("click Add-to-cart button")
	public void clickAddButton() {
		demoSteps.addToCart();
	}

	@Then("confirm that products are added to cart with correct name and price")
	public void confirmCartList(List<List<String>> nameList) {
		List<String> cartNameList = demoSteps.cartNameText();
		List<String> cartPriceList = demoSteps.cartPriceText();
		List<WebElement> cartList = demoSteps.cartList();
		assertEquals(cartNameList.size(), nameList.size());
		assertEquals(cartPriceList.size(), nameList.size());
		for (int i = 0; i < nameList.size(); i++) {
			demoSteps.inViewPort(cartList.get(i));
			assertTrue(cartNameList.contains(nameList.get(i).get(0)));

			for (int j = 0; j < cartNameList.size(); j++) {
				if (nameList.get(i).get(0).equals(cartNameList.get(j))) {
					assertTrue(cartPriceList.get(j).equals(nameList.get(i).get(1)));
				}
			}
		}
	}

	@And("confirm total price is {string}")
	public void confirmToTalPrice(String price) {
		assertEquals(demoSteps.getTotalPrice(), price);
	}

	@Then("confirm that product is added to cart with correct name {string} and price {string}")
	public void confirmProductAdded(String name, String price) {
		assertTrue(demoSteps.cartNameText().contains(name));
		assertTrue(demoSteps.cartPriceText().contains(price));

	}

	@And("click Log out button")
	public void clickLogout() {
		demoSteps.clickLogoutButton();
	}

	@Then("confirm that the user was logged out successfully with welcome status is {string}")
	public void confirmLoggedout(String status) {
		assertEquals(demoSteps.getWelcomeStatus(), status);
	}

	@When("remove products from cart")
	public void removeItems(List<String> list) throws InterruptedException {
		List<String> cartNameList = new ArrayList<>();
		Boolean boo = false;
		do {
			for (int i = 0; i < list.size(); i++) {
				cartNameList = demoSteps.cartNameText();
				for (int j = 0; j < cartNameList.size(); j++) {
					if (list.get(i).equals(cartNameList.get(j))) {
						demoSteps.clickDelete((j+1));
						Thread.sleep(3000);
						break;
						}
					}
				if ((cartNameList.contains(list.get(i)))==false) {
					boo = true;
					break;
				} 
			}
		} while (boo);
	}

	@Then("confirm that that product is not in cart anymore")
	public void confirmDeleted(List<String> list) {
		List<String> cartNameList = demoSteps.cartNameText();
		for (int i = 0; i < list.size(); i++) {
			assertFalse(cartNameList.contains(list.get(i)));
		}

	}
	
	@And("remove {string} from cart")
	public void removeOneItem(String name) throws InterruptedException {
		List<String> cartNameList = demoSteps.cartNameText();
		for (int i = 0; i < cartNameList.size(); i++) {
			if(cartNameList.get(i).equals(name)) {
				demoSteps.clickDelete(i+1);
				Thread.sleep(1000);
			}
		}
	}

	@Then("confirm that cart is empty")
	public void confirmEmptyCart() {
		
		assertTrue(demoSteps.cartList().isEmpty());
	}

	@And("Total price is null")
	public void confirmNullTotalPrice() {
		assertEquals(demoSteps.getTotalPrice(),"");
	}
	
	@When("click Place order button")
	public void clickPlaceOrder() {
		demoSteps.placeOrder();
	}
	
	@And("confirm total price before order")
	public void confirmTotalPO(String total) {
		assertEquals(demoSteps.getDriver().findElement(By.id("totalm")).getText(), total);
	}
	
	@And("input name, credit card to PO")
	public void inputSubmitPO(List<List<String>> list) throws InterruptedException {
		demoSteps.inputSubmitPO(list.get(0).get(0), list.get(0).get(1));
		
	}
	
	@And("submit order")
	public void submitPO() {
		demoSteps.submitPO();
	}
	
	@Then("confirm the order information correct with {string}, {string}, {string}, {string}")
	public void confirmPO(String message, String amount, String card, String name) {
		List<WebElement> list = demoSteps.getDriver().findElements(By.xpath("/html/body/div[10]/p"));
		List<String> txtL = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			txtL.add(list.get(i).getText());
		}
		System.out.println(txtL);
		assertEquals(demoSteps.getDriver().findElement(By.xpath("/html/body/div[10]/h2")).getText(), message);
		assertTrue(txtL.get(0).contains(amount));
		assertTrue(txtL.get(0).contains(card));
		assertTrue(txtL.get(0).contains(name));
	}
	
	@And("input {string}, {string}, {string}, {string}, {string}, {string} to PO")
	public void inputSubmitPO(String name, String country, String city, String card, String month, String year) {
		demoSteps.inputSubmitPO(name, country, city, card, month, year);
	}
	
}
