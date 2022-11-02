Feature: Verify Customer ID

@PrintStatement
	Scenario: Print account statement for one year
	Given the user click on account statement button
	And the user click on custom button
		And the user click on from date dropdown and select month as "July" and year as "2019" and date as "18"
		And the user click on to date dropdown and select month as "July" and year as "2020" and date as "17"
	When the user click on download button it will download the file
	Then user verify the file is downloaded with name contains "IDFCFIRSTBankstatement_10041287945"
