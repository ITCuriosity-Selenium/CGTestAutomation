@regression
Feature: Car Guide Car Filter

  @CarFilter001 @smoketest
  Scenario Outline: Search cars using make and model
   
    Given As CarsGuide active User, I'm on the landing Page
    When I filter cars by '<Make>' and '<Model>'
    Then I should get search '<results>' displayed on landing Page

    Examples: 
      | Make  | Model   | results                       |
     # | BMW   |  116i   | 9 BMW 116is for Sale          |
      | BMW   |  116i   |  BMW 116is for Sale          |

  