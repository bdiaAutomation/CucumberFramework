package com.bdia.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(plugin = {"pretty", "summary"}, dryRun = true, glue = {"com.bdia.Stepdefs", "com.bdia.GlobalHooks"}, features = "src/test/java/com/bdia/Feature", snippets = CAMELCASE
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
   /* @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

}
