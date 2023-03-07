package com.itgirls.testsuite.base;

import com.itgirls.FW.common.AbstractLog;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListeners extends AbstractLog implements ITestListener {
    /**
     * Invoked after the test class is instantiated and before
     * any configuration method is called.
     *
     * @param context
     */
    public void onStart(ITestContext context) {
        logger.info("onStart -> Test Tag Name: " + context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        logger.info("These methods will be executed in this <test> tag");
        for (ITestNGMethod method : methods) {
            logger.info(method.getMethodName());
        }
    }

    /**
     * Invoked after all the tests have run and all their
     * Configuration methods have been called.
     *
     * @param context
     */
    public void onFinish(ITestContext context) {
        logger.info("onFinish -> Test Tag Name: " + context.getName());
    }

    /**
     * Invoked each time before a test method will be invoked.
     *
     * @param result
     * @see ITestResult#STARTED
     */
    public void onTestStart(ITestResult result) {
        // Do nothing
    }

    /**
     * Invoked each time a test method succeeds.
     *
     * @param result
     * @see ITestResult#SUCCESS
     */
    public void onTestSuccess(ITestResult result) {
        logger.info("onTestSuccess -> Test Method Name: " + result.getName());
    }

    /**
     * Invoked each time a test method fails.
     *
     * @param result
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        logger.info("onTestFailure -> Test Method Name: " + result.getName());
    }

    /**
     * Invoked each time a test method is skipped.
     *
     * @param result
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        logger.info("onTestSkipped -> Test Method Name: " + result.getName());
    }
}
