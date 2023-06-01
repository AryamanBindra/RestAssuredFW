package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import reusables.LoginUtils;

public class BaseTest {
	LoginUtils lu = null;
	protected static Logger logger = LogManager.getLogger();
	protected static ExtentReports extent = new ExtentReports();
	protected static ExtentHtmlReporter report = null;
	public static ExtentTest test = null;

	@BeforeClass
	public void SetUp() {
		lu = new LoginUtils();
		logger.debug("Utilities Setup Complete");
	}
	
	@BeforeSuite
	public void initializeReport() {
		logger.debug("BaseTest: setup: configuration started ");
		String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\" + dateFormat
				+ "RestAPI.html";
		extent = new ExtentReports();
		report = new ExtentHtmlReporter(reportPath);
		
		extent.attachReporter(report);
		logger.debug("BaseTest: setup: configuration complete");
	}
	
	@AfterSuite
	public void flushReport() {
		extent.flush();
		logger.debug("BaseTest: tearDown: completed ");
	}

}
