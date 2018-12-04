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


class GetIntegration extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseIntegrationConfig(){
		RequestObject IntegrationConfig = findTestObject('Holden/Holden_01_GetIntegrationConfiguration', [
			('obj_DealerId') : GlobalVariable.Glb_Dealer_Code])
		return WS.sendRequest(IntegrationConfig)
	}

	@Keyword
	void verifyIntegrationConfig(ResponseObject response){
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "SyncMode", "ASYNCHRONOUS", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "AppointmentsUpdatable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "AppointmentCustomerUpdatable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "AppointmentVehicleUpdatable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "AppointmentsRetrievable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "AppointmentsSearchable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "RepairOrderCreatable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "RepairOrderUpdatable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "RepairOrderRetrievable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "CustomerSearchable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "VehicleSearchable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "CustomerInformationSearchable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "AdvisorsRetrievable", "true", 0, 0)
		verifyValueSOAPNode(response, "IntegrationConfigurationDetail", "LaborOperationCodesRetrievable", "true", 0, 0)
	}
}