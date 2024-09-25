package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",     // Caminho para os arquivos .feature
        glue = "stepDefinitions",                // Caminho para os arquivos de step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}  // Gera relatório HTML dos testes
)
public class TestRunner {
}
