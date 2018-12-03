import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.SQLClientInfoException
import java.sql.Time
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.sql.Sql
import holdenObject.SetupAndSetVariable

import java.sql.Driver
/**
 * @author ANH THY
 * STRUCTRUE
 * 1. SET VALUE FOR GLOBAL VARIABLE FROM OR BASE ON DATASET
 * 2. SET DATE VALUE
 * 3. GET VALUE FROM SQL: FINANCIAL YEAR, ADVISOR INFORMATION, DOCUMENT ID FROM THIRD PARTY
 *
 */

//Set Value for GlobalVariable
	SetupAndSetVariable setup = new SetupAndSetVariable()

	setup.setValueToGlobalVariable(Setup_LineNumber as Integer)
	setup.setValueForAdvisorWithTypeInput()
	setup.setValueForCustomerAndVehicleWithTypeInput()
	setup.setValueDateForAllDateGlobalVariable()
	setup.setFinancialYear()
	setup.setThirdPartyAppointmentConfirmationKey()
	setup.setModelKeyFromMakeID()
