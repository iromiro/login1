package stepDefinitions;

import com.example.login1.service.UserService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.jupiter.api.Assertions.*;


public class loginStepDefinitions {

    UserService userService;


    @When("{string} and {string} entered")
        public void username_and_password_entered(String password, String username){

        }

    @Then("control {string} exists and {string} matches")
    public void control_username_exists_and_password_matches(String username, String password){
        assertTrue(userService.login(username, password));
    }


    @Then("prints true on the screen")
    public void printsTrueOnTheScreen(String username, String password) {
        assertTrue(userService.login(username, password));
    }


    @Given("I go to login")
    public void iGoToLogin() {
        System.out.println("login");
    }
}
