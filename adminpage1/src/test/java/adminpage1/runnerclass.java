package adminpage1;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src/test/resources/feature/admin.feature" ,"src/test/resources/feature/configarations.feature","src/test/resources/feature/vendor.feature"}, glue = {"adminpage1"}, 
tags = "  @SmokeTest")
public class runnerclass {

}
