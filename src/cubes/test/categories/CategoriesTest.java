package cubes.test.categories;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.categories.CategoriesAddPage;
import cubes.pages.categories.CategoriesListPage;

public class CategoriesTest {

	private static WebDriver driver;
	private String categoryName = "Name Aa39@!";
	private String newCategoryName = "Name Aa39@!11";
	private String categoryDescription = "North Sahara North Sahara North Sahara North Sahar";
	private String newCategoryDescription = "North Sahara South Sahara North Sahara North Sahar";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getDriver("chrome");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	// nije mi bila funkcionalna metoda da scrooluje do clicakbilnog elementa u TC
	// gde je to potebno tako da sam je sklonio

	// Leave empty name, description fields and click save
	@Test
	public void tc01() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription("");

		categoriesAddPage.clickOnSave();

		assertTrue("Insert name error problem!", categoriesAddPage.isErrorDisplayedName("This field is required."));
		assertTrue("Insert description error problem!",
				categoriesAddPage.isErrorDisplayedDescription("This field is required."));
	}

	// Leave empty name, description fields and click cancel
	@Test
	public void tc02() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription("");
		categoriesAddPage.clickOnCancel();

		assertTrue("Categories list open problem!", categoriesListpage.isOnPage());

	}

	// Insert name,description field empty click on save
	@Test
	public void tc03() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("Name Aa39@!");
		categoriesAddPage.insertDescription("");
		categoriesAddPage.clickOnSave();

		assertTrue("Insert description error problem!",
				categoriesAddPage.isErrorDisplayedDescription("This field is required."));

	}

	// Name field empty ,insert description field click on save
	@Test
	public void tc04() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription("North Sahara");
		categoriesAddPage.clickOnSave();

		assertTrue("Insert name error problem!", categoriesAddPage.isErrorDisplayedName("This field is required."));

	}

	// Insert name,description field empty click on cancel
	@Test
	public void tc05() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("Name Aa39@!");
		categoriesAddPage.insertDescription("");
		categoriesAddPage.clickOnCancel();

		assertTrue("Categories list open problem!", categoriesListpage.isOnPage());

	}

	// Name field empty ,insert description field click on cancel
	@Test
	public void tc06() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("Name Aa39@!");
		categoriesAddPage.insertDescription("");
		categoriesAddPage.clickOnCancel();

		assertTrue("Categories list open problem!", categoriesListpage.isOnPage());

	}

	// Insert name field ,insert description field click on save
	@Test
	public void tc07() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("Name Aa39@!");
		categoriesAddPage.insertDescription("North Sahara");
		categoriesAddPage.clickOnSave();

		assertTrue("Insert description error problem!",
				categoriesAddPage.isErrorDisplayedCharachtersNumber("The description must be at least 50 characters."));

	}

	// Insert name field ,insert description field click on cancel
	@Test
	public void tc08() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName("Name Aa39@!");
		categoriesAddPage.insertDescription("North Sahara");
		categoriesAddPage.clickOnCancel();

		assertTrue("Categories list open problem!", categoriesListpage.isOnPage());

	}

	// Insert add new Category name Name Aa39@! and click save
	@Test
	public void tc09() {
		CategoriesListPage categoriesListpage = new CategoriesListPage(driver);

		categoriesListpage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName(categoryName);
		categoriesAddPage.insertDescription(categoryDescription);
		categoriesAddPage.clickOnSave();

		assertTrue("New Category name missing!", categoriesListpage.isCategoryNameOnPage(categoryName));
		assertTrue("New Category description missing",
				categoriesListpage.isCategoryDescriptionOnPage(categoryDescription));

	}

	// Add existing Category name and click save
	@Test
	public void tc10() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnAddNewCategory();

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());

		categoriesAddPage.insertName(categoryName);
		categoriesAddPage.insertDescription(categoryDescription);
		categoriesAddPage.clickOnSave();

		assertTrue("Categories Add Page open problem!", categoriesAddPage.isOnPage());
		assertTrue("Missing existing name error massage",
				categoriesAddPage.isExistingNameErrorDisplayed("The name has already been taken."));
	}

	// Click on Update button, clear description ,click cancel
	@Test
	public void tc11() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong Name in web element!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));

		categoriesAddPage.insertName(categoryName);
		categoriesAddPage.insertDescription("");

		categoriesAddPage.clickOnCancel();

		assertTrue("Categories Add Page open problem!", categoriesListPage.isOnPage());
		assertTrue("Name missing!", categoriesListPage.isCategoryNameOnPage(categoryName));
	}

	// Click on Update button, clear name, click cancel
	@Test
	public void tc012() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong description in web element!",
				categoryDescription.equalsIgnoreCase(categoriesAddPage.getDescription()));

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription(categoryDescription);

		categoriesAddPage.clickOnCancel();

		assertTrue("Categories Add Page open problem!", categoriesListPage.isOnPage());
		assertTrue("Description missing", categoriesListPage.isCategoryDescriptionOnPage(categoryDescription));
	}

	// Click on Update button ,clear name ,clear description, click cancel
	@Test
	public void tc013() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong Name in web element!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
		assertTrue("Wrong description in web element!",
				categoryDescription.equalsIgnoreCase(categoriesAddPage.getDescription()));

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription("");

		categoriesAddPage.clickOnCancel();
		assertTrue("Categories Add Page open problem!", categoriesListPage.isOnPage());
		assertTrue("Description missing", categoriesListPage.isCategoryDescriptionOnPage(categoryDescription));
	}

	// Click on Update, clear description , click save
	@Test
	public void tc014() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong description in web element!",
				categoryDescription.equalsIgnoreCase(categoriesAddPage.getDescription()));

		categoriesAddPage.insertName(categoryName);
		categoriesAddPage.insertDescription("");

		categoriesAddPage.clickOnSave();

		assertTrue("Error message mising!", categoriesAddPage.isErrorDisplayedDescription("This field is required."));

	}

	// Click on Update,clear name,click save
	@Test
	public void tc015() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong Name in web element!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription(categoryDescription);

		categoriesAddPage.clickOnSave();
		assertTrue("Error message mising!", categoriesAddPage.isErrorDisplayedName("This field is required."));
	}

	// Click on Update,clear name ,clear description,click save
	@Test
	public void tc016() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong Name in web element!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));

		categoriesAddPage.insertName("");
		categoriesAddPage.insertDescription("");

		categoriesAddPage.clickOnSave();

		assertTrue("Error message mising!", categoriesAddPage.isErrorDisplayedName("This field is required."));
		assertTrue("Error message mising!", categoriesAddPage.isErrorDisplayedDescription("This field is required."));

	}

	// Manuelno ovo je TC 19
	// Click on Update,change name,leave description same,click save
	@Test
	public void tc017() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(categoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong Name in web element!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));

		categoriesAddPage.insertName(newCategoryName);
		categoriesAddPage.insertDescription(categoryDescription);

		categoriesAddPage.clickOnSave();

		assertTrue("Categories Add Page open problem!", categoriesListPage.isOnPage());
		assertTrue("Error with edit Name ", categoriesListPage.isCategoryNameOnPage(newCategoryName));
	}

	// Manuelno ovo je TC 20
	// Click on Update,leave updated name ,change description ,click save
	@Test
	public void tc018() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnEditPostCategories(newCategoryName);

		CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);

		assertTrue("Wrong Name in web element!", newCategoryName.equalsIgnoreCase(categoriesAddPage.getName()));

		categoriesAddPage.insertName(newCategoryName);
		categoriesAddPage.insertDescription(newCategoryDescription);

		categoriesAddPage.clickOnSave();

		assertTrue("Categories Add Page open problem!", categoriesListPage.isOnPage());
		assertTrue("Error with edit Name ", categoriesListPage.isCategoryNameOnPage(newCategoryName));

	}

	// Delete Category click on cancel
	@Test
	public void tc19() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnDeleteCategory(newCategoryName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		categoriesListPage.clickOnDeleteDialogueCancelButton();
		assertTrue("Chek if category exists ", categoriesListPage.isCategoryNameOnPage(newCategoryName));

	}

	// Delete Category click on close
	@Test
	public void tc20() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnDeleteCategory(newCategoryName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		categoriesListPage.clickOnDeleteDialogCloseButton();
		assertTrue("Chek if category exists ", categoriesListPage.isCategoryNameOnPage(newCategoryName));
	}

	// Delete Category ,click on delete button
	@Test
	public void tc21() {
		CategoriesListPage categoriesListPage = new CategoriesListPage(driver);

		categoriesListPage.clickOnDeleteCategory(newCategoryName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		categoriesListPage.clickOnDeleteDialogueDeleteButton();
		assertTrue("Chek if category exists ", !categoriesListPage.isCategoryNameOnPage(newCategoryName));

	}

}
