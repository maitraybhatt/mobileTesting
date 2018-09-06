package com.j2.listner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.j2.utils.Basefunctions;
import com.j2.utils.Basefunctions.MessageType;
import com.j2.utils.PropertyManager;

public class TestNGListener implements ITestListener, IAnnotationTransformer, IInvokedMethodListener2, ISuiteListener {

	static Logger log = Logger.getLogger(TestNGListener.class.getName());

	public int passcount = 0, failedcount = 0, skipcount = 0, executed = 0;

	public void onFinish(ITestContext arg0) {
	}

	public void onStart(ITestContext arg0) {
	}

	public void logstatus() {
		Basefunctions.logWithScreenShot("Test Case End : ");
		log.info("Pass Count : " + passcount + ". Failed Count : " + failedcount + ". Skipped Count : " + skipcount
				+ ". Total Executed : " + (passcount + failedcount + skipcount));

		PropertyManager.getResourceBundle().setProperty("PassCount", String.valueOf(passcount));

		PropertyManager.getResourceBundle().setProperty("FailCount", String.valueOf(failedcount));

		PropertyManager.getResourceBundle().setProperty("SkipCount", String.valueOf(skipcount));

		PropertyManager.getResourceBundle().setProperty("ExecutedCount", String.valueOf((executed - 1)));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {

		if (null != arg0.getThrowable() && testFail(arg0)) {
			if (null != arg0.getThrowable().getMessage()
					&& (arg0.getThrowable().getMessage().contains("Assertion Error")
							|| arg0.getThrowable().getMessage().contains("Wait Timeout "))) {
				arg0.setThrowable(null);
			} else {
				Basefunctions.log("Exception occured : " + arg0.getThrowable().getMessage(), MessageType.FAIL);
			}
		}

		failedcount++;
		logstatus();
	}

	public void onTestSkipped(ITestResult arg0) {
		skipcount++;
		logstatus();
	}

	public void onTestStart(ITestResult arg0) {
		// Reporter.logWithScreenShot("Test Case Started");
	}

	public void onTestSuccess(ITestResult arg0) {
		passcount++;
		logstatus();
	}

	public void transform(ITestAnnotation arg0, @SuppressWarnings("rawtypes") Class arg1,
			@SuppressWarnings("rawtypes") Constructor arg2, Method arg3) {

		log.info("Test Case Started " + arg0.getTestName());
	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1, ITestContext arg2) {

		if (testFail(arg1)) {
			if (arg2.getPassedTests() != null) {
				if (arg2.getPassedTests().getResults(arg1.getMethod()).size() > 1) {
					arg2.getPassedTests().getResults(arg1.getMethod()).remove(arg1);
				}
			}

			arg1.setStatus(2);

			if (arg2.getFailedTests() != null) {
				arg2.getFailedTests().addResult(arg1, arg1.getMethod());
			}
		}

		executed++;
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1, ITestContext arg2) {
		if (arg0.isTestMethod()) {
			log.info("Test Case Stated : " + arg1.getName());
		}
	}

	private boolean testFail(ITestResult arg0) {
		if (org.testng.Reporter.getOutput(arg0).size() > 0) {
			List<String> outputMessages = org.testng.Reporter.getOutput(arg0);
			for (int i = 0; i < outputMessages.size(); i++) {
				if (outputMessages.get(i).contains("FAIL "))
					return true;
			}
		}

		return false;
	}

	public void onStart(ISuite suite) {
		PropertyManager.getResourceBundle().setProperty("currentBrowser", "First");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}
}
