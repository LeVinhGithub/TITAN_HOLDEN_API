import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
import java.lang.reflect.Field
import java.nio.charset.CoderMalfunctionError
import java.security.AccessControlContext
import static org.assertj.core.api.Assertions.*
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return
import org.sikuli.api.API
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.annotation.TearDownIfPassed
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.jna.platform.win32.WinNT.ACCESS_ACEStructure
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

/**
 * V0. Build framework 10.10.18
 * V1. Add before and after 
 */
//Initial Declare GlobalVariable value
//Dataline
//Setup
GlobalVariable.Glb_Status_Integration = 'failed'
GlobalVariable.Glb_Status_GetCustomer = 'failed'
GlobalVariable.Glb_Status_GetAdvisor = 'failed'
GlobalVariable.Glb_Status_GetLabor = 'failed'
GlobalVariable.Glb_Status_ProcessAdd = 'failed'
GlobalVariable.Glb_Status_ProcessChange = 'failed'
GlobalVariable.Glb_Status_ProcessDelete = 'failed'
GlobalVariable.Glb_Status_GetService = 'failed'
GlobalVariable.Glb_Status_SearchService = 'failed'
GlobalVariable.Glb_Status_SubscriptionAdd = 'failed'
GlobalVariable.Glb_Status_SubscriptionDetact = 'failed'
GlobalVariable.Glb_BookingStatus = 'not yet'

//STEP
//0. Setup Global Variable and other value
WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_00_Setup_Method_And_Variables'), [
	('Setup_LineNumber') : var_LineNumber],
	FailureHandling.STOP_ON_FAILURE)

//1. Get Integration
//Verify the authentification of OSS to integrate with DMS
if(var_Status_GetIntegration == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_01_GetIntegrationConfiguration'), [:], FailureHandling.STOP_ON_FAILURE)

//2. Get Customer Information
//Get information and validate them
if(var_Status_GetCustomer == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_02_SearchCustomerInformation'), [:], FailureHandling.STOP_ON_FAILURE)
	
//3. Get Personel
//Get all Advisor and vrify all of them
if(var_Status_GetPersonel == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_03_GetPersonel'), [:], FailureHandling.STOP_ON_FAILURE)
	
//4. Get Labor Operation Code
//Get all Labor Op Code and vrify all of them
if(var_Status_GetLaborCode == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_04_GetLaborOperations'), [:], FailureHandling.CONTINUE_ON_FAILURE)
	
//5. Process service Add action
//Create Appointment
if(var_Status_ProcessServiceAdd == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_05A_AddServiceVisit'), [:], FailureHandling.STOP_ON_FAILURE)
	
//6. Search Service Visit
//Search there has any appointment in range of day
if(var_Status_SearchService == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_06_SearchServiceVisit'), [:], FailureHandling.STOP_ON_FAILURE)
	
//7. Get Service Visit
//Get all information about the service with specific Booking Id
if(var_Status_GetService == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_07_GetServiceVisit'), [:], FailureHandling.STOP_ON_FAILURE)
	
//5. Process service Add action
//Create Appointment
if(var_Status_ProcessServiceChange == 'true'){
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_05B_ChangeServiceVisit'), [:],FailureHandling.STOP_ON_FAILURE)
	if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase()=='true'){
		GlobalVariable.Glb_AddJobLine = 'false'
		WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_05B_ChangeServiceVisit'), [:],FailureHandling.STOP_ON_FAILURE)
	}
}
		
//5. Process service Add action
//Create Appointment
if(var_Status_ProcessServiceDelete == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_05C_DeleteServiceVisit'), [:], FailureHandling.STOP_ON_FAILURE)
	
//6. Process Subscription
if(var_Status_Subscription == 'true'){
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_08A_ProcessServiceSubsription_Add'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_08B_ProcessServiceSubsription_Detact'), [:], FailureHandling.STOP_ON_FAILURE)
}

@TearDownIfError
public void printLineError(){
	println "Testcase is ERRORED"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.write2File'(var_LineNumber as String, "Error")
}

@TearDownIfFailed
public void printLineFailed(){
	println "Testcase is FAILED"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.write2File'(var_LineNumber as String, "Failed")
}

	
@TearDownIfPassed
public void NotificationPassed(){
	println "Testcase is PASSED"
}

		