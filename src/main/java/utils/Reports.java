package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Reports {

	public ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test, eachnode;
	public String testCaseName, testCaseDesc, author, category, device;

	@BeforeSuite
	public void startReport() {
		spark = new ExtentSparkReporter("./reports/report.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@BeforeClass
	public void startTestCase() {
		test = extent.createTest(testCaseName, testCaseDesc);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	public abstract long takeSnap();

	public void reportStep(String desc, String status) {
		long snapNumber;
		snapNumber = takeSnap();
		Media img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/"+snapNumber+".png").build();
		
		if(status.equals("PASS")) {
			eachnode.pass(desc, img);
		}else if(status.equals("FAIL")) {
			eachnode.fail(desc, img);
		}else if(status.equals("WARNING")) {
			eachnode.warning(desc, img);
		}else if(status.equals("INFO")) {
			eachnode.info(desc, img);
		}
	}

	@AfterSuite
	public void endReports() {
		extent.flush();
	}
}
