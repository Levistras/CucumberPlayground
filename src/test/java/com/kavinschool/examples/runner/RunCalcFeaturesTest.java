package com.kavinschool.examples.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",

        glue = {"classpath:com.kavinschool.examples.steps",
                "classpath:com.kavinschool.examples.hooks"},

        plugin = {
                "pretty",
                "junit:target/cucumber.xml",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },

        snippets= CAMELCASE,
        //dryRun = true,
        monochrome = true,
        tags= "@calc"
)
public class RunCalcFeaturesTest {

}
