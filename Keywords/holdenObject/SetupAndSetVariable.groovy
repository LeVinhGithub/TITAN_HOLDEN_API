package holdenObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Connection
import groovy.sql.Sql //SQL Connection
import java.sql.Driver //SQL Connection

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
	void setValueForNotExistAdvisor(){
		GlobalVariable.Glb_Adv_Id = 'invalid'
		GlobalVariable.Glb_Adv_FirstName= 'invalid'
		GlobalVariable.Glb_Adv_LastName= 'invalid'
		println 'Value for Not Exist Adviosr: invalid'
	}

	@Keyword
	void setValueForExistAdvisor(){
		int countNumber = 0
		String cmdQuery = "exec Get_All_Service_Advisors @TerminationDate= '10/12/2018', @FinancialYearKey= 20"
		Connection conn = createSQLConnection()
		def sql = new Sql(conn)
		sql.eachRow(cmdQuery) {row ->
			if(countNumber == 1){
				GlobalVariable.Glb_Adv_Id = row[0] as String
				GlobalVariable.Glb_Adv_FirstName= row.First_Name as String
				GlobalVariable.Glb_Adv_LastName= row.Family_Name as String
				println 'Value for Exist Adviosr: ' + GlobalVariable.Glb_Adv_Id + GlobalVariable.Glb_Adv_FirstName  + GlobalVariable.Glb_Adv_LastName
			}
			countNumber += 1
		}
		closeSQLConnection(conn, sql)

	}

	@Keyword
	void setValueForAdvisorWithTypeInput(){
		if(GlobalVariable.Glb_AdvisorType.toString().toLowerCase()=='exist')
			setValueForExistAdvisor()
		else setValueForNotExistAdvisor()
	}

	@Keyword
	void setValueNewCustomerForGlobalVariable(){
		GlobalVariable.Glb_FirstName = common.setValueRandomWithTimeValue("fname")
		println GlobalVariable.Glb_FirstName
		GlobalVariable.Glb_LastName = common.setValueRandomWithTimeValue("lname")
		println GlobalVariable.Glb_LastName
	}

	@Keyword
	void setValueOldCustomerForGlobalVariable(){
		GlobalVariable.Glb_Cus_TradingEntity = '1173278'
		println 'Old Customer Trading Entity: '+GlobalVariable.Glb_Cus_TradingEntity
		GlobalVariable.Glb_FirstName = 'QATEAM_VINHLE190125131028'
		println 'Old Customer First Name: '+GlobalVariable.Glb_FirstName
		GlobalVariable.Glb_LastName = 'HOLDEN190125131028'
		println 'Old Customer Last Name: '+GlobalVariable.Glb_LastName
	}

	@Keyword
	void setValueNewVehicleForGlobalVariable(){
		GlobalVariable.Glb_veh_ManufacturerName = common.setValueRandomWithTimeValue("rego")
		println GlobalVariable.Glb_veh_ManufacturerName
		GlobalVariable.Glb_veh_VehicleId = common.setValueRandomWithTimeValue("vin")
		println GlobalVariable.Glb_veh_VehicleId
	}

	@Keyword
	void setValueOldVehicleForGlobalVariable(){
		GlobalVariable.Glb_veh_ManufacturerName = 'REGNUMBER190125131028'
		println 'Old Vehicle Rego: '+GlobalVariable.Glb_veh_ManufacturerName
		GlobalVariable.Glb_veh_VehicleId = 'VNVNV190125131028'
		println 'Old Vehicle VIN: '+GlobalVariable.Glb_veh_VehicleId
	}

	@Keyword
	void setValueExistOperationCodeForGlobalVariable(int indicator){
		if(indicator == 0) {
			GlobalVariable.Glb_Ser_LaborCode = 'S105'
			println 'Exist Operation Code changed to: '+GlobalVariable.Glb_Ser_LaborCode
		}
		if(indicator == 1) {
			GlobalVariable.Glb_Ser_LaborDescription = 'GENERIC - Carry out 105,000km service as per handbook.'
			println 'Exist Operation Description changed to: '+GlobalVariable.Glb_Ser_LaborDescription
		}

	}

	@Keyword
	void setValueNotExistOperationCodeForGlobalVariable(int indicator){
		if(indicator == 0) {
			GlobalVariable.Glb_Ser_LaborCode = 'INVALID - CHANGE'
			println 'Not Exist Operation Code changed to: '+GlobalVariable.Glb_Ser_LaborCode
		}
		if(indicator == 1) {
			GlobalVariable.Glb_Ser_LaborDescription = 'INVALID - CHANGE - GENERIC - Carry out 75,000km intermediate service'
			println 'Not Exist Operation Description changed to: '+GlobalVariable.Glb_Ser_LaborDescription
		}
	}

	@Keyword
	void setValueForCustomerAndVehicleWithTypeInput(){
		if(GlobalVariable.Glb_CustomerType.toString().toLowerCase()=='new')
			setValueNewCustomerForGlobalVariable()
		if(GlobalVariable.Glb_VehicleType.toString().toLowerCase()=='new')
			setValueNewVehicleForGlobalVariable()
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
		GlobalVariable.Glb_ServiceEndDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_ServiceEndDate, "YYYY-MM-dd'T'HH:55:00")
	}

	@Keyword
	void setDateValueForAppointmentDateWithInvalidHour(){
		GlobalVariable.Glb_ServiceDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_ServiceDate, "YYYY-MM-dd'T'HH:50:00")
		GlobalVariable.Glb_ServiceEndDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_ServiceEndDate, "YYYY-MM-dd'T'HH:00:00")
	}

	@Keyword
	void setDateValueForSearchServiceDate(){
		GlobalVariable.Glb_StartSearchDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_StartSearchDate, "YYYY-MM-dd'T00:00:00'")
		GlobalVariable.Glb_EndSearchDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_EndSearchDate, "YYYY-MM-dd'T23:59:00'")
	}

	@Keyword
	void setDateValueForSearchServiceDateWithInvalidHour(){
		GlobalVariable.Glb_StartSearchDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_StartSearchDate, "YYYY-MM-dd'T23:00:00'")
		GlobalVariable.Glb_EndSearchDate = common.setValueDateForEachCasesWithAUTimeZone(GlobalVariable.Glb_EndSearchDate, "YYYY-MM-dd'T00:00:00'")
	}

	@Keyword
	void setValueDateForAllDateGlobalVariable(){
		if(GlobalVariable.Glb_ServiceDate.toString().toLowerCase()=='crh')
			setDateValueForAppointmentDateWithInvalidHour()
		else setDateValueForAppointmentDate()

		if(GlobalVariable.Glb_StartSearchDate.toString().toLowerCase()=='crh')
			setDateValueForSearchServiceDateWithInvalidHour()
		else setDateValueForSearchServiceDate()
	}

	@Keyword
	void setFinancialYear(){
		String cmdQuery = "select top 1 * from ENTERPRISE"
		Connection conn = createSQLConnection()
		def sql = new Sql(conn)
		sql.eachRow(cmdQuery) {row ->
			GlobalVariable.Glb_FinancialYear = row.CURRENT_FINANCIAL_YEAR_KEY as String
			println 'Financial Year is: '+GlobalVariable.Glb_FinancialYear
		}
		closeSQLConnection(conn, sql)
	}

	//FOR HOLDEN WINDSOR
	@Keyword
	void setThirdPartyAppointmentConfirmationKey(){
		String cmdQuery = "select * from THIRD_PARTY_APPOINTMENT_KEY_MAPPING "
		String valueKey = "0"
		Connection conn = createSQLConnection()
		def sql = new Sql(conn)
		sql.eachRow(cmdQuery) {row ->
			String valueKeyTemp = row.THIRD_PARTY_APPOINTMENT_CONFIRMATION_KEY as String
			if((valueKeyTemp as Integer) > (valueKey as Integer))
				valueKey = valueKeyTemp
		}
		GlobalVariable.Glb_DocumentId = (valueKey as Integer) + 1
		println 'Documentation ID is: '+GlobalVariable.Glb_DocumentId
		closeSQLConnection(conn, sql)
	}

	//	FOR HOLDEN BMG
	//	@Keyword
	//	void setThirdPartyAppointmentConfirmationKey(){
	//		String cmdQuery = "select * from THIRD_PARTY_APPOINTMENT_KEY_MAPPING "+
	//							"ORDER BY THIRD_PARTY_APPOINTMENT_CONFIRMATION_KEY DESC"
	//		String valueKey = ""
	//		Connection conn = createSQLConnection()
	//		def sql = new Sql(conn)
	//		sql.eachRow(cmdQuery) {row ->
	//			String valueKeyTemp = row.THIRD_PARTY_APPOINTMENT_CONFIRMATION_KEY as String
	//			if(valueKeyTemp == "xxx")
	//				GlobalVariable.Glb_DocumentId = (valueKey as Integer) + 1
	//			else valueKey = valueKeyTemp
	//		}
	//		println 'Documentation ID is: '+GlobalVariable.Glb_DocumentId
	//		closeSQLConnection(conn, sql)
	//	}

	@Keyword
	String getMakeCodeFromMakeTableSQL(Connection connection){
		String makeIdQuery = "select * from MAKE where MAKE_ID = '"+GlobalVariable.Glb_veh_MakeString+"'"
		String makeID
		def sql = new Sql(connection)
		sql.eachRow(makeIdQuery) {row ->
			makeID = row.MAKE_KEY as String
			println 'Make ID Value: '+makeID
		}
		return makeID
	}

	@Keyword
	void setModelKeyFromMakeID(){
		Connection conn = createSQLConnection()
		String makeID = getMakeCodeFromMakeTableSQL(conn)
		String modelKeyQuery = "SELECT TOP 1 M.MODEL_KEY FROM MODEL M "+
				"INNER JOIN MODEL_TYPE MT "+
				"ON M.MODEL_TYPE_KEY = MT.MODEL_TYPE_KEY "+
				"WHERE MT.MAKE_KEY = "+ makeID +" AND "+
				"M.SERIES = '"+GlobalVariable.Glb_veh_Model+"' "+
				"ORDER BY M.MODEL_KEY DESC"
		def sql = new Sql(conn)
		sql.eachRow(modelKeyQuery) {row ->
			GlobalVariable.Glb_veh_modelKey = row[0] as String
			println 'Model Key is: '+GlobalVariable.Glb_veh_modelKey
		}
		closeSQLConnection(conn, sql)
	}


}