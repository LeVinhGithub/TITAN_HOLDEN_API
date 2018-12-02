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


class SetupAndSetVariable extends Library_Method_VinhLe{
	Common common = new Common()
	
	@Keyword
	void setValueToGlobalVariable(int rowIndex){
		GlobalVariable.Glb_Dealer_Code = getValueFromTestDataWithColumnNameAndRowIndex("var_DealerCode", rowIndex)
		GlobalVariable.Glb_ServiceDate = getValueFromTestDataWithColumnNameAndRowIndex("var_StartServiceDate", rowIndex)
		GlobalVariable.Glb_ServiceEndDate = getValueFromTestDataWithColumnNameAndRowIndex("var_EndServiceDate", rowIndex)
		GlobalVariable.Glb_CustomerType = getValueFromTestDataWithColumnNameAndRowIndex("var_CustomerType", rowIndex)
		GlobalVariable.Glb_FirstName = getValueFromTestDataWithColumnNameAndRowIndex("var_FirstName", rowIndex)
		GlobalVariable.Glb_LastName = getValueFromTestDataWithColumnNameAndRowIndex("var_LastName", rowIndex)
		GlobalVariable.Glb_Cus_TradingEntity = getValueFromTestDataWithColumnNameAndRowIndex("var_TradingEntityID", rowIndex)
		GlobalVariable.Glb_Cus_LineOne = getValueFromTestDataWithColumnNameAndRowIndex("var_LineOne", rowIndex)
		GlobalVariable.Glb_Cus_CityName = getValueFromTestDataWithColumnNameAndRowIndex("var_CityName", rowIndex)
		GlobalVariable.Glb_Cus_CountryID = getValueFromTestDataWithColumnNameAndRowIndex("var_CountryID", rowIndex)
		GlobalVariable.Glb_Cus_Postcode = getValueFromTestDataWithColumnNameAndRowIndex("var_Postcode", rowIndex)
		GlobalVariable.Glb_Cus_State = getValueFromTestDataWithColumnNameAndRowIndex("var_State", rowIndex)
		GlobalVariable.Glb_Cus_ChannelCode = getValueFromTestDataWithColumnNameAndRowIndex("var_ChannelCode", rowIndex)
		GlobalVariable.Glb_Cus_PhoneNumber = getValueFromTestDataWithColumnNameAndRowIndex("var_PhoneNumber", rowIndex)
		GlobalVariable.Glb_Cus_Email = getValueFromTestDataWithColumnNameAndRowIndex("var_Email", rowIndex)
		GlobalVariable.Glb_VehicleType = getValueFromTestDataWithColumnNameAndRowIndex("var_VehicleType", rowIndex)
		GlobalVariable.Glb_veh_Model = getValueFromTestDataWithColumnNameAndRowIndex("var_Model", rowIndex)
		GlobalVariable.Glb_veh_ModelYear = getValueFromTestDataWithColumnNameAndRowIndex("var_ModelYear", rowIndex)
		GlobalVariable.Glb_veh_MakeString = getValueFromTestDataWithColumnNameAndRowIndex("var_MakeString", rowIndex)
		GlobalVariable.Glb_veh_ManufacturerName = getValueFromTestDataWithColumnNameAndRowIndex("var_ManufacturerName", rowIndex)
		GlobalVariable.Glb_veh_VehicleId = getValueFromTestDataWithColumnNameAndRowIndex("var_VehicleID", rowIndex)
		GlobalVariable.Glb_Ser_LaborCode = getValueFromTestDataWithColumnNameAndRowIndex("var_OperationCode", rowIndex)
		GlobalVariable.Glb_Ser_LaborDescription = getValueFromTestDataWithColumnNameAndRowIndex("var_OperationDescription", rowIndex)
		GlobalVariable.Glb_AdvisorType = getValueFromTestDataWithColumnNameAndRowIndex("var_AdvisorType", rowIndex)
		GlobalVariable.Glb_Booking_ID = getValueFromTestDataWithColumnNameAndRowIndex("var_BookingId", rowIndex)
		GlobalVariable.Glb_ChangeDate = getValueFromTestDataWithColumnNameAndRowIndex("var_ChangeDate", rowIndex)
		GlobalVariable.Glb_ChangeChangeCustomerVehicle = getValueFromTestDataWithColumnNameAndRowIndex("var_ChangeCustomerVehicle", rowIndex)
		GlobalVariable.Glb_ChangeChangeOpCodeContent = getValueFromTestDataWithColumnNameAndRowIndex("var_ChangeOpCodeContent", rowIndex)
		GlobalVariable.Glb_AddJobLine = getValueFromTestDataWithColumnNameAndRowIndex("var_AddJobLine", rowIndex)
		GlobalVariable.Glb_StartSearchDate = getValueFromTestDataWithColumnNameAndRowIndex("var_StartSearchDate", rowIndex)
		GlobalVariable.Glb_EndSearchDate = getValueFromTestDataWithColumnNameAndRowIndex("var_EndSearchDate", rowIndex)
	}
	
	@Keyword
	void setValueForAdvisorWithAdvisorTypeInput(){
		if(!(GlobalVariable.Glb_AdvisorType.toString().toLowerCase() == 'exist')) {
			GlobalVariable.Glb_Adv_Id = 'invalid'
			GlobalVariable.Glb_Adv_FirstName= 'invalid'
			GlobalVariable.Glb_Adv_LastName= 'invalid'
		} else {
			GlobalVariable.Glb_Adv_Id = 'agrim'
			GlobalVariable.Glb_Adv_FirstName= 'Andrew'
			GlobalVariable.Glb_Adv_LastName= 'Grima'
		}
	}
	
	@Keyword
	void setValueNewCustomerForGlobalVariable(){
		GlobalVariable.Glb_FirstName = common.setValueRandomWithTimeValue("fname")
		println GlobalVariable.Glb_FirstName
		GlobalVariable.Glb_LastName = common.setValueRandomWithTimeValue("lname")
		println GlobalVariable.Glb_LastName
	}
	
	@Keyword
	void setValueNewVehicleForGlobalVariable(){
		GlobalVariable.Glb_veh_ManufacturerName = common.setValueRandomWithTimeValue("rego")
		println GlobalVariable.Glb_veh_ManufacturerName
		GlobalVariable.Glb_veh_VehicleId = common.setValueRandomWithTimeValue("vin")
		println GlobalVariable.Glb_veh_VehicleId
	}
	
	@Keyword
	String createValueNewCustomerForLocalVariable(String value){
		String createdValue = common.setValueRandomWithTimeValue(value)
		println createdValue
		return createdValue
	}
	
	@Keyword
	String createValueNewVehicleForLocalVariable(String value){
		String createdValue = common.setValueRandomWithTimeValue(value)
		println createdValue
		return createdValue
	}
	
	@Keyword
	void setDateValueForAppointmentDate(){
		GlobalVariable.Glb_ServiceDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_ServiceDate, "YYYY-MM-dd'T'HH:50:00")
		GlobalVariable.Glb_ServiceEndDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_ServiceEndDate, "YYYY-MM-dd'T'HH:50:00")
	}
	
	@Keyword
	void setDateValueForSearchServiceDate(){
		GlobalVariable.Glb_StartSearchDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_StartSearchDate, "YYYY-MM-dd'T'HH:50:00")
		GlobalVariable.Glb_EndSearchDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_EndSearchDate, "YYYY-MM-dd'T'HH:50:00")
	}
	
	
}