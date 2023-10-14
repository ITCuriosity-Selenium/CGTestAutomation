@login @regression
Feature: Cars Guide Login Functionality September
  As Cars Guide User, I am on the Login Page
  By entering Valid Credentials, User should be taken to the Account Page
  If the user enter invalid credentials, then show appopriate validation messages

  @login001 @Jira-001 @smoketest
  Scenario: 001_Active Login as User withCorrect credentials
    Given As CarsGuide active User, I'm on the Login Page
    When I enter active Username, Password and SignIn
    Then I should land on the Account Page
  
  @login002 @Jira-001
  Scenario: 002_Active Login as User withCorrect credentials
    Given As CarsGuide active User, I'm on the Login Page
    When I enter active 'ITCuriosity.selenium@gmail.com', 'Test12345' and SignIn
    Then I should land on the Account Page
   
  @login003 @Jira-002
  Scenario Outline: 003_Active Login as User withCorrect credentials
    Given As CarsGuide active User, I'm on the Login Page
    When I enter active '<UserName>', '<Password>' and SignIn
    Then I should land on the Account Page '<AccountName>'

    Examples: 
      | UserName                        | Password   |AccountName|
      | ITCuriosity.selenium@gmail.com  | Test12345  |John       |
      | ITCuriosity.selenium@gmail.com  | Test12345  |John       |
      | ITCuriosity.selenium@gmail.com  | Test12345  |John       |
