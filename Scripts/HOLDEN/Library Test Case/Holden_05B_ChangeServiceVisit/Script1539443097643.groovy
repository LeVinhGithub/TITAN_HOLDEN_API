import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
import java.security.AccessControlContext
import static org.assertj.core.api.Assertions.*
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
import org.sikuli.api.API
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

import holdenObject.Common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 * Add logic test
 */

//CODE 
//## DECLARE VIABLE
	Common common = new Common()
	String objectRepo = "Holden/Holden_05B_ChangeServiceVisit"
	if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase() == 'true')
		objectRepo = "Holden/Holden_05B_ChangeServiceVisit_AddOpCode"
	
	String StartDateService, EndDateService, OperationCode, OperationDescription, LastName, FirstName, ManufacturerName, VehicleId

//## PROCESS API
//Declare request
	RequestObject ProcessServiceVisit = findTestObject(objectRepo, [
	('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code, 
	('Obj_GivenName') : GlobalVariable.Glb_FirstName, 
	('Obj_FamilyName') : GlobalVariable.Glb_LastName, 
	('obj_DocumentId') : GlobalVariable.Glb_DocumentId, 
	('obj_LineOne') : GlobalVariable.Glb_Cus_LineOne, 
	('obj_CityName') : GlobalVariable.Glb_Cus_CityName, 
	('obj_CountryId') : GlobalVariable.Glb_Cus_CountryID, 
	('obj_PostCode') : GlobalVariable.Glb_Cus_Postcode, 
	('obj_State') : GlobalVariable.Glb_Cus_State, 
	('obj_ChannelCode') : GlobalVariable.Glb_Cus_ChannelCode, 
	('obj_PhoneNumber') : GlobalVariable.Glb_Cus_PhoneNumber, 
	('obj_Email') : GlobalVariable.Glb_Cus_Email, 
	('obj_Model') : GlobalVariable.Glb_veh_Model, 
	('obj_ModelYear') : GlobalVariable.Glb_veh_ModelYear, 
	('obj_MakeString') : GlobalVariable.Glb_veh_MakeString, 
	('obj_ManufacturerName') : GlobalVariable.Glb_veh_ManufacturerName,
	('obj_VIN') : GlobalVariable.Glb_veh_VehicleId,
	('obj_AdvisorId') : GlobalVariable.Glb_Adv_Id, 
	('obj_AdvisorGivenName') : GlobalVariable.Glb_Adv_FirstName, 
	('obj_AdvisorFamilyName') : GlobalVariable.Glb_Adv_LastName, 
	('obj_PartyId') : GlobalVariable.Glb_PartyID, 
	('obj_DateAppointment') : GlobalVariable.Glb_ServiceDate, 
	('obj_LaborCode') : GlobalVariable.Glb_Ser_LaborCode, 
	('obj_LaborDescription') : GlobalVariable.Glb_Ser_LaborDescription])
//Declare response
	ResponseObject res_ProcessServiceVisit = WS.sendRequest(ProcessServiceVisit)
	if(common.validateInvalidDealerCode(res_ProcessServiceVisit)){}
	else{
		common.verifyStatusCodeIs200OK(res_ProcessServiceVisit)
		common.verifyApplicationAreaResponse(res_ProcessServiceVisit)
		common.verifyAcknowledgeServiceAreaResponse(res_ProcessServiceVisit)
		common.verifyExistCustomerAndVehicleInformationResponse(res_ProcessServiceVisit)
		common.verifyWholeAppointmentInformationWithOneJobline(res_ProcessServiceVisit)
		common.setStatusPassedForTestCaseWithTypeInput("add")
	}
