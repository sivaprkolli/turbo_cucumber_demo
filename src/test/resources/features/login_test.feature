Feature: Login
  1. Verify user able to login and verify products list

  @Login @LT1 @Smoke
  Scenario: Verify user able to login and verify products list
    Given User on login screen
    When User enter credentials and submit login form
    And User on products screen
    Then User verify products list

  @Login @LT2 @Smoke
  Scenario: Enter credentials and verify products list
    Given User on login screen
    When User enter credentials username "standard_user" and password "secret_sauce"
    And User on products screen
    Then User verify products list


  @Login @LT3 @Smoke
  Scenario: Enter credentials with table row and verify products list
    Given User on login screen
    When User enter credentials
      | standard_user | secret_sauce |
    And User on products screen
    Then User verify products list

  @Login @LT4 @Smoke
  Scenario: Enter credentials with table row with header and verify products list
    Given User on login screen
    When User enter login credentials
      | username      | password     |
      | standard_user | secret_sauce |
    And User on products screen
    Then User verify products list

  @Login @LT5 @Smoke
  Scenario Outline: Enter credentials and verify products list
    Given User on login screen
    When User enter credentials username "<username>" and password "<password>"
    And User on products screen
    Then User verify products list
    And User Logout
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |

