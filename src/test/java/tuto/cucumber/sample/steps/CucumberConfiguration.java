package tuto.cucumber.sample.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import tuto.cucumber.sample.TutoCucumberSampleApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = TutoCucumberSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfiguration {

}
