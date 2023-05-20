package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import resources.Base;
import utilities.ExtentReport;

public class Listeners extends Base implements ITestListener {

	WebDriver driver = null;
	ExtentReports extentReport = ExtentReport.getExtentReport();
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest> (); // Thread Safe is used to run the test in parallel and to get individual extent report  

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		
		extentTest = extentReport.createTest(testName+"execution started");
		extentTestThread.set(extentTest);
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		//extentTest.log(Status.PASS, testName+"Passed");
		
		extentTestThread.get().log(Status.PASS, testName+"Passed"); // Thread Safe Declaration to run the test in parallel
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
		
		//extentTest.fail(result.getThrowable());
		
		extentTestThread.get().fail(result.getThrowable()); // Thread Safe Declaration to run the test in parallel

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		try {
			//takeScreenshot(testName, driver);// screenshot to file path
			
			String ScreenshotFilePath = takeScreenshot(testName, driver); // creating object for saving the screenshot 
			extentTestThread.get().addScreenCaptureFromPath(ScreenshotFilePath,testName); // Adding the screenshot to the extentReport report
			
			
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		extentReport.flush();

	}

}
