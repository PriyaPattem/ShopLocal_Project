package com.shoplocal.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;


public class ExtentManager {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() throws IOException {
        //sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
        sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports/"+"MyReport.html");
        sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent_config.xml");
        //sparkReporter.config().setDocumentTitle("Automation Test Report");
        //sparkReporter.config().setReportName("OrangeHRM Test Automation Report");
        //sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "ShopLocalProject");
        extent.setSystemInfo("Tester", "swathipriya");
        extent.setSystemInfo("OS", "Win8");
        extent.setSystemInfo("Browser", "Chrome");
    }
    public static void endReport() {
        extent.flush();
    }
}
