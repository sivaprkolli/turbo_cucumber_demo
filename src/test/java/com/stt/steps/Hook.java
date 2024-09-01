package com.stt.steps;

import com.stt.automation.WebDriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import java.time.Duration;

public class Hook {


    @BeforeAll
    public static void initialize() {
        WebDriverFactory.initializeBrowser("chrome");
    }

    @Before
    public static void launchApplication() {
        WebDriverFactory.openApplication();
    }

    @AfterAll
    public static void killSession() {
        WebDriverFactory.killSession();
    }
}
