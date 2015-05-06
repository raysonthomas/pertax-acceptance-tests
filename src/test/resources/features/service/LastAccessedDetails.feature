@wip

Scenario - User sees when they last logged in to the service where ever they are in the service

As a user who has logged in to my personal account
I need to be able to see when I last accessed the service
So that I know it was me

JIRA story - MTA-490

Given 'user' has logged into PTA
And the page address path is '/home'
Or '/profile'
Then I will see the time, day and date of when I last signed into the service
Given 'user' has logged into PTA for the first time
And the page address path is '/home'
Or '/profile'
Then I will not see the time, day and date of when I last signed into the service
