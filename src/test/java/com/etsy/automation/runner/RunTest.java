package com.etsy.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue= "com/etsy/automation/step_definitions",
        format = {"pretty", "html:target", "json:target/cucumber.json"},
        monochrome = true,
        tags = {"@search"}
)

public class RunTest {
}