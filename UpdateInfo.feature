Claimant Portal project

URL: https://claimant-portal.opt-qa2.optimumui.com/#!/login
Test Data :
    • User ID: lobid
    • Password : Test@1234
      
Manual Test case / Gherkin Script
Feature: Claimant portal login and update information
Scenario: User able to update their information
Given I am on ClaimantPortal landing page
when I click on login Button
And I am on Login page
And I enter username as “lobid” on userName field
And I enter password as “Test@1234” on passWord field
And I click on login button
And I am on UserHome page
And I click on My Profile
And I click on editClaimantDetails button
And I am on Edit pop-up window
And I enter home phone number as “8898427871” on homePhone field
And I enter mobile number as “7892341234” on mobileNumber field
And I enter preferred occupation as “Software Tester”
And I select language preference as “English”
And I select gender as “Male”
And I select education level as “Bachelor’s degree”
And I enter race as “Asian”
And I select ethnicity as “Not Hispanic or Latino”
And I click on update button 
Then I verify “Information Updated” message displayed.
