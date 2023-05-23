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
import scenarioSteps.DemoBlazeScenarioStep;

public class PlaceOrderSteps {
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@Steps
	private DemoBlazeScenarioStep demoSteps;

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
