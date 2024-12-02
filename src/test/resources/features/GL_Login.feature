
@LoginFunction

Feature: Login functionality on Geek Ladder website
@Login
  Scenario: Valid user logs in successfully
    Given User navigates to the URL "https://stg.geekladder.com/"
    And Click on Login button on the top
    And User enter email address "kalai@thinktime.in" and enter password "Kalai@123"
    When User clicks the Login button
    Then User should be redirected to the dashboard
@Login
  Scenario: Invalid login attempt with incorrect password
    Given User navigates to the URL "https://stg.geekladder.com/"
    And Click on Login button on the top
    And User enter email address "kalai@thinktime.in" and enter password "Kalai@1234"
    When User clicks the Login button
    Then Error message "Invalid email or password" should be displayed    
@Login
   Scenario: Login attempt with an empty email address
    Given User navigates to the URL "https://stg.geekladder.com/"
    And Click on Login button on the top
    And User enter email address "" and enter password "Kalai@123"
    When User clicks the Login button
    Then Error message "Please enter a valid Email to Login." should be display
    
    
    
    