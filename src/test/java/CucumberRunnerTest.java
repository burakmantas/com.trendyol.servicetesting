import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( publish = false,
        features = "src/main/resources/features",
        plugin = "pretty"
        )

public class CucumberRunnerTest {
    @BeforeClass()
    public static void openBaseUrl(){
        RestAssured.baseURI ="https://fakerapi.it";
    }
}
