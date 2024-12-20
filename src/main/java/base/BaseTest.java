package base;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.Constants;

public class BaseTest {
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTestLogger;
	public static WebDriver driver;
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public static Logger log;

	@BeforeSuite(alwaysRun = true)
	@Parameters("suiteName")
	public void extentReportInitializer(String suiteName) {
		extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-reports/" + suiteName + "_extentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("HostName", "RHEL8");
		extentReports.setSystemInfo("UserName", "root");
		extentSparkReporter.config().setDocumentTitle("DemoBlaze");
		extentSparkReporter.config().setReportName("DemoBlaze Automation Test Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setEncoding("utf-8");
		extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		log = LogManager.getLogger(BaseTest.class);
		log.info("Extent report initialized for the Suite:" + suiteName);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browserName", "headless"})
	public void driverInitializer(String browserName, Boolean headless) throws InterruptedException {
		if(headless)
		{
			setupHeadlessDriver(browserName);
		}
		else
		{
			setupDriver(browserName);
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(Constants.applicationURL);
		log.info("Launched the Application in " + browserName);
	}

	@AfterMethod(alwaysRun = true)
	public void captureReport(ITestResult results) {
		if (results.getStatus() == ITestResult.FAILURE) {
			extentTestLogger.log(Status.FAIL,
					MarkupHelper.createLabel(results.getName() + " - Test Case Failed", ExtentColor.RED));
			extentTestLogger.log(Status.FAIL,
					MarkupHelper.createLabel(results.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (results.getStatus() == ITestResult.SUCCESS) {
			extentTestLogger.log(Status.PASS,
					MarkupHelper.createLabel(results.getName() + " - Test Case Passed", ExtentColor.GREEN));
		} else if (results.getStatus() == ITestResult.SKIP) {
			extentTestLogger.log(Status.SKIP,
					MarkupHelper.createLabel(results.getName() + " - Test Case Skipped", ExtentColor.YELLOW));
		}
		driver.quit();
		log.info("Browser is Closed");
	}

	@AfterTest(alwaysRun = true)
	public void tear() {
		extentReports.flush();
		log.info("Separated Test Method report");
	}

	public void setupDriver(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
	}
	
	public void setupHeadlessDriver(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-debugging-port=9222");
			driver = new EdgeDriver(options);
		}
	}

}
