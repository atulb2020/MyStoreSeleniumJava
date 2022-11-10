package com.MyStore.utility;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-"+timestamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:","testpc1");
		reports.setSystemInfo("OS", "window 10");
		reports.setSystemInfo("browser", readConfig.getBrowser());
		reports.setSystemInfo("user name", " atul");
		
		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener report Demo");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onFinish(ITestContext Result) {
		System.out.println("on finish method invoked......");
		reports.flush(); // it is mandatory to call flush method
	}

	@Override
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("on start method invoked......");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of test method failed:"+ Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:"+Result.getName(), ExtentColor.RED));
     
		String screenShotPath = System.getProperty("user.dir")+"\\ScreenShot\\"+Result.getName()+".png";
		File screenShotFile = new File(screenShotPath);
		if(screenShotFile.exists())
		{
			test.fail("capture screenshot is below:"+test.addScreenCaptureFromPath(screenShotPath));
		}
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skiped:"+ Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skiped test case is:"+Result.getName(), ExtentColor.YELLOW));


	}
	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println("Name of test method start:"+ Result.getName());

	}
	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method succefully exicute:"+ Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the succesfully exicute test case is:"+Result.getName(), ExtentColor.GREEN));
		
	}
		

}
