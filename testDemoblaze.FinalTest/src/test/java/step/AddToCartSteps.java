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

public class AddToCartSteps {
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@Steps
	private DemoBlazeScenarioStep demoSteps;

	@Given("click the product, add to cart, get alert message then click Home button")
	public void addProduct(DataTable order) throws InterruptedException {
		List<String> orderList = order.asList();
		for (int i = 0; i < orderList.size(); i++) {
			int a = Integer.parseInt(orderList.get(i));
			demoSteps.selectProduct(a);
			Thread.sleep(1000);
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

}
