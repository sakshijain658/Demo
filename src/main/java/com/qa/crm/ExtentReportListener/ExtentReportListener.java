package com.qa.crm.ExtentReportListener;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.IReporter;

//public class ExtentReportListener implements IReporter {
//	private ExtentReports extent;
//	public void generateReport(List<XmlSuite> xmlSuites,List<ISuite> suites,String outputDirectory){
//		
//		extent=new ExtentReports(outputDirectory +File.separator+"Extent.html",true);
//		
//		for(ISuite suite : suites) {
//			Map<String,ISuiteResult> result=suite.getResults();
//			
//			for (ISuiteResult r:result.values()) {
//				ITestContext context=r.getTextContext();
//				buildTestNodes(context.getPassedTests(),LogStatus.PASS);
//				buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
//				buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
//			}
		}
		extent.flush();
		extent.close();
		
	}
}
