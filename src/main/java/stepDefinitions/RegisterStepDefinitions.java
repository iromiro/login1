package stepDefinitions;

import com.example.login1.model.User;

import cucumber.api.java.en.*;


public class RegisterStepDefinitions {


    @Given("I go to register")
    public void iGoToRegister() {

        System.out.println("I am o the register page");
    }

    @When("email, firstname,lastname,username,password entered")
    public void emailFirstnameLastnameUsernamePasswordEntered() {

        System.out.println("required information entered");
    }


    @And("set role as user,set enabled and save user")
    public void setRoleAsUserSetEnabledAndSaveUser(User user) {
        System.out.println("set role as user, set user enabled and user saved to repository");
    }


    @Then("user created")
    public void userCreated() {
        System.out.println("User created");
    }


    @But("password is not valid")
    public void passwordIsNotValid() {
        System.out.println("password is not suitable for pattern");
    }


    @Then("prints {string}")
    public void prints(String arg0) {
        System.out.println(arg0);
    }

    @And("validation handler catches the error")
    public void validationHandlerCatchesTheError() {
        System.out.println("Validation handler catches the error");
    }
}

