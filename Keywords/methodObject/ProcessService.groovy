package methodObject
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
	void validateInvalidDealerCode(ResponseObject response) {
		verifyResponseCode_Msg(response, 0, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code is invalid"
	}
	
	@Keyword
	void verifyApplicationAreaOneTimeResponse(ResponseObject response) {
		verifyValueSOAPNode(response, "Sender", "CreatorNameCode", "GM", 0, 0)
		verifyValueSOAPNode(response, "Sender", "SenderNameCode", "OSS", 0, 0)
		verifyValueSOAPNode(response, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		verifyValueSOAPNode(response, "Sender", "DealerCountryCode", "US", 0, 0)
		verifyValueSOAPNode(response, "Sender", "LanguageCode", "en-US", 0, 0)
		
		verifyValueSOAPNode(response, "Destination", "DestinationNameCode", "QI", 0, 0)
		verifyValueSOAPNode(response, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
		verifyValueSOAPNode(response, "Destination", "DestinationSoftware", "QI", 0, 0)
		verifyValueSOAPNode(response, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		verifyValueSOAPNode(response, "Destination", "DealerTargetCountry", "US", 0, 0)
		
		verifyAttributeSOAPNode(response, "ResponseCriteria", "ResponseExpression", "actionCode", "Accepted", 0, 0)
	}
	
	@Keyword
	void verifyApplicationAreaTwoTimeResponse(ResponseObject response) {
		verifyValueSOAPNode(response, "Sender", "CreatorNameCode", "GM", 0, 0)
		verifyValueSOAPNode(response, "Sender", "SenderNameCode", "OSS", 0, 0)
		verifyValueSOAPNode(response, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		verifyValueSOAPNode(response, "Sender", "DealerCountryCode", "US", 0, 0)
		verifyValueSOAPNode(response, "Sender", "LanguageCode", "en-US", 0, 0)
		
		verifyValueSOAPNode(response, "Destination", "DestinationNameCode", "QI", 0, 0)
		verifyValueSOAPNode(response, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
		verifyValueSOAPNode(response, "Destination", "DestinationSoftware", "QI", 0, 0)
		verifyValueSOAPNode(response, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		verifyValueSOAPNode(response, "Destination", "DealerTargetCountry", "US", 0, 0)
		
		verifyValueSOAPNode(response, "Sender", "CreatorNameCode", "GM", 1, 0)
		verifyValueSOAPNode(response, "Sender", "SenderNameCode", "OSS", 1, 0)
		verifyValueSOAPNode(response, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 1, 0)
		verifyValueSOAPNode(response, "Sender", "DealerCountryCode", "US", 1, 0)
		verifyValueSOAPNode(response, "Sender", "LanguageCode", "en-US", 1, 0)
		
		verifyValueSOAPNode(response, "Destination", "DestinationNameCode", "QI", 1, 0)
		verifyValueSOAPNode(response, "Destination", "DestinationSoftwareCode", "QI", 1, 0)
		verifyValueSOAPNode(response, "Destination", "DestinationSoftware", "QI", 1, 0)
		verifyValueSOAPNode(response, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 1, 0)
		verifyValueSOAPNode(response, "Destination", "DealerTargetCountry", "US", 1, 0)
		
		verifyAttributeSOAPNode(response, "ResponseCriteria", "ResponseExpression", "actionCode", "Accepted", 0, 0)
	}
	
	@Keyword
	void verifyCustomerInformationResponse(ResponseObject response){
		if(GlobalVariable.Glb_CustomerType.toString().toLowerCase() == 'old'){
			verifyValueSOAPNode(response, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
			verifyValueSOAPNode(response, "AppointmentContactParty", "DealerManagementSystemID", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		}
		else if(GlobalVariable.Glb_CustomerType.toString().toLowerCase() == 'new'){
			GlobalVariable.Glb_Cus_TradingEntity = getValueSOAPNode(response, "AppointmentContactParty", "DealerManagementSystemID", 0, 0)
			verifyValueSOAPNode(response, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		}
		verifyValueSOAPNode(response, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, 0, 0)
		//CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(response, "SpecifiedPerson", "FamilyName", GlobalVariable.Glb_LastName, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "StateOrProvinceCountrySub-DivisionID", GlobalVariable.Glb_Cus_State, 0, 0)
		
	}

	

}