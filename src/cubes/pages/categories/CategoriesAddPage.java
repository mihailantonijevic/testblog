package cubes.pages.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesAddPage {

	private String url;
	private WebDriver driver;

	private WebElement categoriesNameWe;
	private WebElement categoriesDescriptionWe;
	private WebElement buttonSaveWe;
	private WebElement buttonCancelWe;

	public CategoriesAddPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add";
		this.driver = driver;

		this.categoriesNameWe = driver.findElement(By.xpath("//input[@name ='name']"));
		this.categoriesDescriptionWe = driver.findElement(By.xpath("//textarea[@name ='description']"));
		this.buttonSaveWe = driver.findElement(By.xpath("//button[@class ='btn btn-primary']"));
		this.buttonCancelWe = driver.findElement(By.xpath("//a[@class ='btn btn-outline-secondary']"));

	}

	public void openPage() {
		this.driver.get(url);
	}

	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}

	public void clickOnSave() {
		buttonSaveWe.click();
	}

	public void clickOnCancel() {
		buttonCancelWe.click();
	}

	public void insertName(String name) {
		categoriesNameWe.clear();
		categoriesNameWe.sendKeys(name);
	}

	public String getName() {
		return categoriesNameWe.getAttribute("value");
	}

	public void insertDescription(String description) {
		categoriesDescriptionWe.clear();
		categoriesDescriptionWe.sendKeys(description);
	}

	public String getDescription() {
		return categoriesDescriptionWe.getAttribute("value");
	}

	public boolean isErrorDisplayedName(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}

	public boolean isErrorDisplayedDescription(String error) {
		WebElement errorWebElement = driver.findElement(By.id("description-error"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}

	public boolean isErrorDisplayedCharachtersNumber(String error) {
		WebElement errorWebElement = driver
				.findElement(By.xpath("//div[text()='The description must be at least 50 characters.']"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}

	public boolean isExistingNameErrorDisplayed(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[text()='The name has already been taken.']"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}

}
