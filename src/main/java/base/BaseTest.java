package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import org.testng.annotations.Parameters;
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
	public static WebDriverWait wait;

	@BeforeSuite
	public void extentReportInitializer() {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("HostName", "RHEL8");
		extentReports.setSystemInfo("UserName", "root");
		extentSparkReporter.config().setDocumentTitle("DemoBlaze");
		extentSparkReporter.config().setReportName("DemoBlaze Automation Test Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@BeforeMethod
	@Parameters("browserName")
	public void driverInitializer(String browserName, Method testMethod) throws InterruptedException {
		extentTestLogger = extentReports.createTest(testMethod.getName()+" "+browserName+" Browser");
		setupDriver(browserName);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(Constants.applicationURL);
	}

	@AfterMethod
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
	}

	@AfterTest
    public void tear()
    {
        extentReports.flush();
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
	
}
