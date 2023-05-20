package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	static ExtentReports extentReports;

	public static ExtentReports getExtentReport() {

		String extentReportFilePath = System.getProperty("user.dir") + "\\Report\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportFilePath);
		reporter.config().setReportName("TEST REPORT");
		reporter.config().setDocumentTitle("Test Document Title");

		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("OS", "Windows 11");

		return extentReports;

	}

}
