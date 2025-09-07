Feature: Registration

@register
  Scenario Outline: User Registration to Sign-Up Page
    Given User is on the Home page
    And User clicks on the Sign-Up and Login button
    Then User is redirected to the Sign-Up page
    When User fills in the signup details "<username>" and "<email>"
    And User clicks the Sign-Up button
    Then User is redirected to the account information page
    When User enters the following details "<days>", "<months>" ,"<years>", "<password>", "<firstname>", "<lastname>", "<address>", "<country>", "<state>", "<city>", "<zipcode>", and "<mobileNumber>"
    And User clicks on the Create Account button
    Then User account created
    And Account created message verified
    And User clicks on Continue button
    And logged in as username is visible
    When user clicks on delete account button
    Then account deleted is visible
    And user clicks continue button

    Examples: 
      | username | email                   | days | months | years | password  | firstname | lastname | address     | country | state          | city   | zipcode | mobileNumber |
      | satvik   | namdeosat007@gmail.com  | 28   | July   | 2002  | satvik123 | satvik    | namdeo   | 123 Main St | India   | Madhya Pradesh | Bhopal |   10001 |   1234567890 |
