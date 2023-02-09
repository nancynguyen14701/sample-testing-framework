package com.itgirls.testsuite.base;

import org.testng.annotations.BeforeTest;

public class BaseTest {
    String sBrowser;
    @BeforeTest
    public void initializeDriver(){
        sBrowser = System.getProperty("browser");
        System.out.println(sBrowser);
    }

}
