package com.shoplocal.utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListenerClass extends ExtentManager implements ITestListener {
    Action action= new Action();

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
        }
    }

    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                test.log(Status.FAIL,
                        MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
                test.log(Status.FAIL,
                        MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
                String imgPath = action.screenShot(BaseClass.getDriver(), result.getName());

                test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

            } catch (Exception e) {
                e.printStackTrace();
            }

            XmlSuite failedSuite = new XmlSuite();
            failedSuite.setName("FailedTestSuite");

//            // Create a new TestNG XML test
//            XmlTest failedTest = new XmlTest(failedSuite);
//            failedTest.setName("FailedTest");

            // Create a list of classes for the failed test
            List<XmlClass> failedClasses = new ArrayList<>();
            XmlClass failedClass = new XmlClass(result.getTestClass().getName());

            List<XmlInclude> includedMethods = new ArrayList<>();
            includedMethods.add(new XmlInclude(result.getMethod().getMethodName())); // Add the failed method
            failedClasses.add(failedClass);

            // Set the list of classes for the test
           // failedTest.setXmlClasses(failedClasses);

            // Create a TestNG XML suite list and add the failed suite to it
            List<XmlSuite> suites = new ArrayList<>();
            suites.add(failedSuite);

            // Create a TestNG XML suite file and save it
            TestNG testNG = new TestNG();
            testNG.setXmlSuites(suites);
            testNG.setOutputDirectory("test-output"); // Specify the output directory
            testNG.run();

            // Optionally, you can log or print a message indicating that the failed XML file was generated.
            System.out.println("Generated testng-failed.xml for the failed test: " + result.getName());


        }
    }

    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }
}
