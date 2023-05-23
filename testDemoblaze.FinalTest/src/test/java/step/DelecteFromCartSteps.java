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

public class DelecteFromCartSteps {
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@Steps
	private DemoBlazeScenarioStep demoSteps;

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
}
