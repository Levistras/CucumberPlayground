package com.kavinschool.examples.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ticket",

        glue = {"classpath:com.kavinschool.examples.steps",
                "classpath:com.kavinschool.examples.hooks"},

        plugin = {
                "pretty",
                "junit:target/cucumber.xml",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },

        snippets= SnippetType.UNDERSCORE,
        //snippets= SnippetType.CAMELCASE,
        //dryRun = true,
        monochrome = true,
        tags= "@new-ticket"
)
public class RunTicketFeaturesTest {

}
