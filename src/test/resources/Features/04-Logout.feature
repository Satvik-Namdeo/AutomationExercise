Feature: Logout

  @logout
  Scenario Outline: Logout feature
    Given User is in Home page
    When User clicked on signup/login button
    When User entered "<email>" and "<password>"
    Then User is Logged in and username is displayed
    When User clicked logout button
    Then User redirected to login page

    Examples: 
      | email            | password   |
      | david1@gmail.com | david@123  |
