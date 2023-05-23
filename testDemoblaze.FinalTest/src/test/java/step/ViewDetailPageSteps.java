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

public class ViewDetailPageSteps {
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@Steps
	private DemoBlazeScenarioStep demoSteps;

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
}
