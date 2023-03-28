package cubes.pages.categories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesListPage {

	private String url;
	private WebDriver driver;
	private WebElement addNewCategoriesWe;

	public CategoriesListPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories";
		this.driver = driver;

		this.driver.get(url);
		this.driver.manage().window().maximize();
		this.addNewCategoriesWe = driver.findElement(By.xpath("//a[@class ='btn btn-success']"));
	}

	public void openPage() {
		driver.get(url);
	}

	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}

	public void clickOnAddNewCategory() {
		addNewCategoriesWe.click();
	}

	public boolean isCategoryNameOnPage(String categoryName) {
		// WebElement webElement = driver.findElement(By.xpath("//strong[text()='" +
		// categoryName + "']"));
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[text()='" + categoryName + "']"));
		return webElements.size() > 0;
	}

	public boolean isCategoryDescriptionOnPage(String categoryDescription) {
		WebElement webElement = driver
				.findElement(By.xpath("//td[contains(text(),'North Sahara North Sahara North Sahara North Sahar')]"));
		return webElement.getText().equalsIgnoreCase(categoryDescription);
	}

	public void clickOnEditPostCategories(String categoryName) {
		WebElement editWebElement = driver
				.findElement(By.xpath("//strong[text()='" + categoryName + "']//ancestor::tr/td[6]/div[1]/a[2]"));
		editWebElement.click();
	}

	public void clickOnDeleteCategory(String categoryName) {
		WebElement deleteWebElement = driver
				.findElement(By.xpath("//strong[text()='" + categoryName + "']//ancestor::tr/td[6]/div[1]/button[1]"));
		deleteWebElement.click();
	}

	public void clickOnDeleteDialogueCancelButton() {
		WebElement cancelWebElement = driver.findElement(By.xpath("//button[text() = 'Cancel']"));
		cancelWebElement.click();
	}

	public void clickOnDeleteDialogCloseButton() {
		WebElement closeWebElement = driver.findElement(By.xpath("//button[@class= 'close']"));
		closeWebElement.click();
	}

	public void clickOnDeleteDialogueDeleteButton() {
		WebElement deleteWebElement = driver.findElement(By.xpath("//button[text() = 'Delete']"));
		deleteWebElement.click();
	}

	public void clickOnViewButton(String categoryName) {
		WebElement clickOnViewWebelement = driver
				.findElement(By.xpath("//strong[text()='" + categoryName + "']//ancestor::tr/td[6]/div[1]/a[1]"));
		clickOnViewWebelement.click();

	}
}
