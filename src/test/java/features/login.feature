@userLogin
Feature: Verify user login page scenarios

  @TestCase1
  Scenario: Verify login page logo
    Given Open chrome browser and enter application URLs
    Then I should see login page logo as "LOGIN Panel"

  @TestCase2
  Scenario Outline: Verify user login with correct credential
    Given Open chrome browser and enter application URLs
    When I enter username as "<Username>", password as "<UserPassword>" and click login
    Then I should see the landing page with "<WelcomeMsg>"
    And I logout from the application
    Examples:
    |Username|UserPassword|WelcomeMsg|
    |opensourcecms|opensourcecms|Welcome Admin|

  @TestCase3
  Scenario: Verify user login with incorrect credential
    Given Open chrome browser and enter application URLs
    When I enter incorrect username as "incorrectusr", password as "incorrectpsr" and click login
    Then I should see the error message as "Invalid credentials"
