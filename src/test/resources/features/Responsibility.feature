Feature: Environmental Information

  @ui
  Scenario: As a user, I want to be able to access information
  about the company's approach to environmental issues and its practices.

    Given the user is on homepage
    When the user hovers over the "Responsibility" dropdown menu
    And  clicks on the "Planet" option
    Then the user should be able to view the information



