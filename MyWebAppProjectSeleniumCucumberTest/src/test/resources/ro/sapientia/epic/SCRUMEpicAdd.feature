Feature: Check if the scrum epic add works
	As Sapientia scrum tool user I want to be able to add an epic

   Scenario: AddTestEpic1
   Given I open the "/epic/add" view
   When I enter "firstTest" in  the title textbox and I push the add button
   Then I should get result "firstTest" in new epic view
   
    Scenario: AddTestEpic2
   Given I open the "/epic/add" view
   When I enter "secondTest" in  the title textbox and I push the add button
   Then I should get result "secondTest" in new epic view