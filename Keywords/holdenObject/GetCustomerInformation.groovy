package holdenObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe


class GetCustomerInformation extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseSearchCustomerInformation(){
		RequestObject SearchCustomerInformation = findTestObject('Holden/Holden_02_SearchCustomerInformation', [
			('obj_DealerId') : GlobalVariable.Glb_Dealer_Code,
			('obj_GivenName') : GlobalVariable.Glb_FirstName,
			('obj_FamilyName') : GlobalVariable.Glb_LastName])
		return WS.sendRequest(SearchCustomerInformation)
	}

	@Keyword
	void verifySearchNotExistCustomerResponse(ResponseObject response){
		if(GlobalVariable.Glb_CustomerType.toString().toLowerCase() == 'new'){
			verifyValueSOAPNode(response, "CustomerParty", "DealerManagementSystemID", null, 0, 0)
			println('Not exist Customer')
		}
	}
}