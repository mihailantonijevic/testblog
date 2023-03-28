package cubes.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyWebDriver {
//marko

	public static WebDriver getDriver(String browser) {

		WebDriver webDriver;

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/qa/Desktop/webdriver/geckodriver");
			webDriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp-640g1\\Desktop\\webdriver\\chromedriver.exe");
			webDriver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp-640g1\\Desktop\\webdriver\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return webDriver;

	}

}
