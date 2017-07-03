@suite @smoke
Feature: Test the exit survey


  # // New Exit Survey - All Only to test 'Give Feedback' Landing page. All other tests commented out.
    Scenario: Navigate to the Sign out page and complete survey
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    When user signs out
    Then user sees text 'Give feedback' on the page

  Scenario: Navigate to the Sign out page and complete survey in Welsh toggle
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    When user signs out
    And user clicks on language 'Cymraeg' link
    And an link-click language select event to 'Cymraeg' is sent to google analytics
    And user can not click language 'Cymraeg' link
    Then user sees text 'Rhoi adborth' on the page
    And user sees text 'Mae pob cwestiwn yn yr arolwg yn ddewisol' on the page
    And user sees text 'A oeddech yn gallu gwneud yr hyn yr oedd angen i chi'i wneud heddiw' on the page
    And user clicks an option with the ID 'ableToDoWhatNeeded-yes'
    And user clicks the continue button
    Then user sees text 'Pa ffynonellau o wybodaeth a roesoch gynnig arnynt cyn i chi ddefnyddio'r gwasanaeth hwn?' on the page
    And user sees text 'Dewiswch bob un sy'n gymwys' on the page
    And user sees text 'Ffonio CThEM' on the page
    And user sees text 'Ysgrifennu at CThEM' on the page
    And user sees text 'Llenwi ffurflen ar-lein' on the page
    And user sees text 'Darllen arweiniad ar GOV.UK' on the page
    And user sees text 'Siarad â'ch cyflogwr, asiant neu gyfrifydd' on the page
    And user sees text 'Siarad â ffrind neu aelod o'r teulu' on the page
    And user sees text 'Dim un o'r rhain' on the page
    And user clicks the continue button
    Then user sees text 'At ei gilydd, sut oeddech yn teimlo am y gwasanaeth a gawsoch heddiw?' on the page
    And user sees text 'Bodlon iawn' on the page
    And user sees text 'Bodlon' on the page
    And user sees text 'Ddim yn fodlon nac yn anfodlon' on the page
    And user sees text 'Anfodlon' on the page
    And user sees text 'Anfodlon iawn' on the page
    And user clicks the continue button
    Then user sees text 'Pa mor debygol ydych i argymell y gwasanaeth hwn i ffrind neu gydweithiwr pe bai angen iddo wneud yr un peth?' on the page
    And user sees text '10 Tebygol iawn' on the page
    And user sees text '0 Annhebygol iawn' on the page
    And user sees text 'Pam wnaethoch roi'r asesiad hwn?' on the page
    And user sees text 'Peidiwch â chynnwys gwybodaeth bersonol neu ariannol, fel eich rhif Yswiriant Gwladol neu fanylion banc.' on the page
    And user clicks the continue button
    Then user sees text 'Diolch am eich adborth' on the page
    And user clicks on language 'English' link
    And an link-click language select event to 'Cymraeg' is sent to google analytics

  

#  As a user
#  I want to be able to give my feedback to PTA
#  So that PTA can iterate the service to meet my needs
#  JIRA story history: MTA-2051, MTA-2253, MTA-2625
#
#  Scenario: Navigate to the Sign out page and log back in
#    Given User with a PAYE account and SA account is logged into the service using gg
#    And user completes 2FA Journey
#    And user completes IV Uplift Journey
#    And user Continues the journey to PTA
#    When  user signs out
#    Then  user is on the page with title 'Signed out' and URL is as expected
#    And   user sees text 'You can' on the Exit page
#    And   user sees text 'if you need to.' on the Exit page
#    Then  user sees 'sign in to your account again' link on the page and its href is as expected
#
#  Scenario: Navigate to the Sign out page and complete survey
#    Given User with a PAYE account and SA account is logged into the service using gg
#    And user completes 2FA Journey
#    And user completes IV Uplift Journey
#    And user Continues the journey to PTA
#    When  user signs out
#    Then  user sees text 'Before you go, please answer some questions to help us improve your experience' on the Exit page
##    Satisfaction question
#
#    And   user sees text 'how do you feel about your experience' on the Exit page
#    And   user sees the radio button 'Very satisfied'
#    And   user sees the radio button 'Satisfied'
#    And   user sees the radio button 'Neither satisfied nor dissatisfied'
#    And   user sees the radio button 'Dissatisfied'
#    And   user sees the radio button 'Very dissatisfied'
#
##  Get help question
#    And user sees text 'Did you get help going online from any of the following today?' on the Exit page
#    And user sees checkbox 'Friend or family member'
#    And user sees checkbox 'Someone at HMRC'
#    And user sees checkbox 'Citizens Advice'
#    And user sees checkbox 'A charity'
#    And user sees checkbox 'Other'
#    And user sees checkbox 'I didn't get help'
#    And user sees checkbox 'Other'
#    And user clicks checkbox 'other'
#    And user now sees the 'tellUsWhatYouNeedToDo' text box
#    And user is able to select multiple checkboxes
#    When  user clicks checkbox 'friendOrFamily'
#    And  user clicks checkbox 'didntNeedHelp'
#    Then Friend or Family is unselected
#
##  //This functionality should apply to all the first 5 checkboxes.
##  //phone or write question
#    And  user sees text 'Before using your personal tax account, were you going to phone or write to HM Revenue and Customs (HMRC) about your query?' on the Exit page
#    And  user sees radio button 'Yes' under Before using your tax account
#    And  user sees radio button 'No' under Before using your personal tax account
#
##  //Still need to phone question
#
#    When user selects yes radio button on 'before using your tax account' question
#    And  user sees text 'After using your personal tax account, do you still need to phone or write to HMRC?' on the Exit page
#    And  user sees radio button 'Yes' under still need to phone or write to HMRC
#    And  user sees radio button 'No' under still need to phone or write to HMRC
#    And  user sees radio button 'Don't know' under still need to phone or write to HMRC
#
##  //Now need to phone question
#
#    When user selects no radio button on 'before using your tax account' question
#    And  user sees text 'After using your personal tax account, do you now need to phone or write to HMRC?' on the Exit page
#    And  user sees radio button 'Yes' under now need to phone or write to HMRC
#    And  user sees radio button 'No' under now need to phone or write to HMRC
#    And  user sees radio button 'Don't know' under now need to phone or write to HMRC
#
##  //Deselect buttons based on selection
#
#    When  user selects yes radio button on 'before using your tax account' question
#    And   user selects radio button 'Yes' under still need to phone or write to HMRC
#    And   user selects no radio button on 'before using your tax account' question
#    And   The selection Yes for still need to phone section is removed
#
##   //text box
#
#    And   user sees text 'Tell us how we can improve your experience' on the Exit page
#    And   user sees text '1200' on the Exit page
#    And   user enters the 10 characters: '1234567891' into the free text box
#    Then  user sees text '1190' on the Exit page
#
##  //Button
#
#    And  user clicks on the Send feedback button on Exit survey page
#    Then user is on the page with title 'Thanks for your feedback' and URL is as expected
#
#
#

