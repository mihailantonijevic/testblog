package cubes.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.tag.TagsAddPage;
import cubes.pages.tag.TagsListPage;

public class TagTest {

	private static WebDriver driver;
	private String newTagName = "Tag name 123";
	private String updateTagName = "Tag name 12";

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

	// insert empty tag name and click save
	@Test
	public void tc01() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add page open problem!", tagsAddPage.isOnPage());

		tagsAddPage.insertName("");

		tagsAddPage.clickOnSave();

		assertTrue("Insert Tag error problem!", tagsAddPage.isErrorOnPage("This field is required."));
	}

	// insert empty tag name and click cancel
	@Test
	public void tc02() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add page open problem!", tagsAddPage.isOnPage());

		tagsAddPage.insertName("");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());
	}

	// insert Test tag name for tag name and click cancel
	@Test
	public void tc03() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add page open problem!", tagsAddPage.isOnPage());

		tagsAddPage.insertName("Test tag name");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());
	}

	// insert Test tag name 123 for tag name and click save
	@Test
	public void tc04() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add page open problem!", tagsAddPage.isOnPage());

		tagsAddPage.insertName(newTagName);

		tagsAddPage.clickOnSave();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(newTagName));
	}

	// insert existing Test tag name 123 for tag name and click save and check
	// result
	@Test
	public void tc05() {

		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add page open problem!", tagsAddPage.isOnPage());

		tagsAddPage.insertName(newTagName);

		tagsAddPage.clickOnSave();

		assertTrue("Problem with TagsAddPage isOpenPage", tagsAddPage.isOnPage());

		assertTrue("Missing div error massage", tagsAddPage.isDivErrorOnPage("The name has already been taken."));
	}

	// edit Test tag name 123, leave text click cancel
	@Test
	public void tc06() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnUpdateTag(newTagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element", newTagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(newTagName));

	}

	// edit Test tag name 123, clear text click cancel
	@Test
	public void tc07() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnUpdateTag(newTagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element", newTagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName("");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(newTagName));

	}

	// edit Test tag name 123, insert text click cancel
	@Test
	public void tc08() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnUpdateTag(newTagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element", newTagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName("Test tag name");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(newTagName));
	}

	// edit Test tag name 123, clear text click save
	@Test
	public void tc09() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnUpdateTag(newTagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element", newTagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName("");

		tagsAddPage.clickOnSave();

		assertTrue("Error massega missing!", tagsAddPage.isErrorOnPage("This field is required."));
	}

	// edit Test tag name 123, leave text click save
	@Test
	public void tc10() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnUpdateTag(newTagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element", newTagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.clickOnSave();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(newTagName));
	}

	// edit Test tag name 123, insert new tag name click save
	@Test
	public void tc11() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnUpdateTag(newTagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element", newTagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName(updateTagName);

		tagsAddPage.clickOnSave();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(updateTagName));
	}

	// delete tag ,click on cancel button
	@Test
	public void tc12() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnDeleteTag(updateTagName);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

		}

		tagsListPage.clickOnDeleteDialogCancelButton();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(updateTagName));

	}

	// delete tag ,click on close button
	@Test
	public void tc13() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnDeleteTag(updateTagName);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

		}

		tagsListPage.clickOnDeleteDialogCloseButton();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(updateTagName));

	}

	// delete tag,click on delete button
	@Test
	public void tc14() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnDeleteTag(updateTagName);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

		}

		tagsListPage.clickOnDeleteDialogDeliteButton();

		assertTrue("Tags list open page problem.", tagsListPage.isOnPage());

		assertTrue("Element nije izbrisan!", !tagsListPage.isTagNameElementOnPage(updateTagName));
	}

}
