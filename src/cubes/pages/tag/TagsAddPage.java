package cubes.pages.tag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagsAddPage {

	private String url;
	private WebDriver driver;

	private WebElement tagNameWebElement;
	private WebElement buttonSaveWebElement;
	private WebElement buttonCancelWebElement;

	public TagsAddPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add";
		this.driver = driver;

		this.tagNameWebElement = driver.findElement(By.xpath("//input[@name='name']"));
		this.buttonSaveWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
		this.buttonCancelWebElement = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));
	}

	public void openPage() {
		this.driver.get(url);
	}

	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}

	public void clickOnSave() {
		buttonSaveWebElement.click();
	}

	public void clickOnCancel() {
		buttonCancelWebElement.click();
	}

	public void insertName(String name) {
		tagNameWebElement.clear();
		tagNameWebElement.sendKeys(name);
	}

	public String getName() {
		// bilo je tagNameWebElement.getText() ne vazi za input polja
		// System.out.println(tagNameWebElement.getAttribute("value"));
		return tagNameWebElement.getAttribute("value");
	}

	public boolean isErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));

		return errorWebElement.getText().equalsIgnoreCase(error);
	}

	public boolean isDivErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));

		return errorWebElement.getText().equalsIgnoreCase(error);
	}
}
