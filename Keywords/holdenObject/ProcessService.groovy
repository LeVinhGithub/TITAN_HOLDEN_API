package holdenObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class ProcessService extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseProcessServiceVisitForAddDeleteCase(){
		RequestObject ProcessServiceVisit = findTestObject('Holden/Holden_05A_AddServiceVisit', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code, 
			('obj_DocumentID') : GlobalVariable.Glb_DocumentId, 
			('Obj_GivenName') : GlobalVariable.Glb_FirstName, 
			('Obj_FamilyName') : GlobalVariable.Glb_LastName, 
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
			('obj_DateEndAppointment') : GlobalVariable.Glb_ServiceEndDate, 
			('obj_LaborCode') : GlobalVariable.Glb_Ser_LaborCode, 
			('obj_LaborDescription') : GlobalVariable.Glb_Ser_LaborDescription])
		return WS.sendRequest(ProcessServiceVisit)
	}
	
	
}