package com.itgirls.testsuite.base;

import com.itgirls.FW.common.AbstractLog;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends AbstractLog implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Failure listener implemented ");
    }
}
