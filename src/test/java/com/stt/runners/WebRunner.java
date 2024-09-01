package com.stt.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login_test.feature",
        glue = "com.stt.steps",
        tags = "@LT5",
        plugin = "pretty",
        //monochrome = true,
        dryRun = false
)
public class WebRunner {


}
