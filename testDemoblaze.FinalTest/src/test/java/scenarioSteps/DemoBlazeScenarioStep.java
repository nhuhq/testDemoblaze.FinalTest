package scenarioSteps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pageObject.MainPage;

public class DemoBlazeScenarioStep extends ScenarioSteps {
	MainPage mainPage = new MainPage(getDriver());

	@Step
	public void accessMainPage() {
		mainPage.open();
	}

	@Step
	public String getNameText(int a) {
		return mainPage.getName(a).getText();
	}

	@Step
	public String getPriceText(int a) {
		return mainPage.getPrice(a).getText();
	}

	@Step
	public String getDiscriptionText(int a) {
		return mainPage.getDiscription(a).getText();
	}

	@Step
	public WebElement getDiscription(int a) {
		return mainPage.getDiscription(a);
	}

	@Step
	public void inViewPort(WebElement e) {
		Coordinates coordinate = ((Locatable) e).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
	}

	@Step
	public void nextPage() {
		mainPage.getNextButton().click();
		;
	}

	@Step
	public void home() {
		mainPage.getHomeButton().click();
		;
	}

	@Step
	public void close(int a) {
		mainPage.getCloseButton(a).click();
	}

	@Step
	public void closeX(int a) {
		mainPage.getXButton(a).click();
	}

	@Step
	public void aboutUs() {
		mainPage.getAboutUsButton().click();
		;
	}

	@Step
	public void cart() {
		mainPage.getCartButton().click();
		;
	}

	@Step
	public void clickSignupButton() {
		mainPage.getSignupButton().click();
		;
	}

	@Step
	public void clickLoginButton() {
		mainPage.getLoginButton().click();
		;
	}

	@Step
	public void clickLogoutButton() {
		mainPage.getLogOut().click();
	}

	@Step
	public void login(String username, String password) {
		mainPage.logIn(username, password);
	}

	@Step
	public void signUp(String username, String password) {
		mainPage.signUp(username, password);

	}

	@Step
	public void clickContactButton() {
		mainPage.getContactButton().click();
		;
	}

	@Step
	public void sendMessage(String email, String name, String message) {
		mainPage.sendMessage(email, name, message);
	}

	@Step
	public void clickSend() {
		mainPage.getSendButton().click();
		;
	}

	@Step
	public void selectProduct(int a) {
		mainPage.getName(a).click();

	}

	@Step
	public String nameInDetailPage() {
		return mainPage.nameInDetailPage();
	}

	@Step
	public String priceInDetailPage() {
		return mainPage.priceInDetailPage();
	}

	@Step
	public String descriptionInDetailPage() {
		return mainPage.descriptionInDetailPage();
	}

	@Step
	public void addToCart() {
		mainPage.addToCart();
	}

	@Step
	public String getAlertText() {
		return mainPage.getAlertText();
	}

	@Step
	public void alertAccept() {
		mainPage.alertAccept();
	}

	@Step
	public WebElement getAboutUsTitle() {
		return mainPage.getAboutUsText();
	}

	@Step
	public String getWelcomeStatus() {
		return mainPage.getWelcomeStatus();
	}

	@Step
	public List<WebElement> cartList() {
		return mainPage.cartList();
	}

	@Step
	public List<String> cartNameText() {
		List<String> cartNameText = new ArrayList<>();
		for (int i = 0, j = 1; i < mainPage.cartList().size(); i++, j++) {
			cartNameText.add(mainPage.cartList().get(i)
					.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[" + j + "]/td[2]"))
					.getText());
		}
		return cartNameText;
	}

	@Step
	public List<String> cartPriceText() {
		List<String> cartPriceText = new ArrayList<>();
		for (int i = 0, j = 1; i < mainPage.cartList().size(); i++, j++) {
			cartPriceText.add(mainPage.cartList().get(i)
					.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[" + j + "]/td[3]"))
					.getText());
		}
		return cartPriceText;
	}

	@Step
	public void clickDelete(int a) {
		mainPage.deletebutton(a).click();
	}

	@Step
	public String getTotalPrice() {
		return mainPage.getTotalPrice().getText();
	}

	@Step
	public void placeOrder() {
		mainPage.placeOrder().click();
	}
	
	@Step
	public void inputSubmitPO(String name, String country, String city, String card, String month, String year) {
		mainPage.inputSubmitPO(name, country, city, card, month, year);
	}
	
	@Step
	public void inputSubmitPO(String name, String card) throws InterruptedException {
		mainPage.inputSubmitPO(name, card);
	}
	
	@Step
	public void submitPO() {
		mainPage.submitPO();
	}
			
}