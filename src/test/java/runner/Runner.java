package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features="src/test/java/features/LeafTaps.feature"
					,glue="steps"
					,monochrome=true
//					,dryRun=true /*remove dryRun while executing */
					,snippets=SnippetType.CAMELCASE)
public class Runner extends AbstractTestNGCucumberTests {

}
