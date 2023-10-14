@SignUp @regression
Feature: SignUp Functionality

  @SignUp001 @smoketest
  Scenario: Signup functionality on signup page
    Given As new Cars Guide User, I'm on the Signup Page
    When I enter user details to SignUp create my account
      | john1.smith@itcuriosity.com.au | Test123455 | Joe  | lando |
      | john2.smith@itcuriosity.com.au | Test123456 | Jon  | smith |
      | john3.smith@itcuriosity.com.au | Test123457 | John | erir  |
      | john4.smith@itcuriosity.com.au | Test123458 | John | dory  |
    #Then My user should be created
