package holdenObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe


class SearchService extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseSearchServiceInformation(){
		RequestObject SearchServiceVisit = findTestObject('Holden/Holden_06_SearchServiceVisit', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code            ,
			('obj_StartSearchDate') : GlobalVariable.Glb_StartSearchDate,
			('obj_EndSearchDate') : GlobalVariable.Glb_EndSearchDate])
		return WS.sendRequest(SearchServiceVisit)
	}

	@Keyword
	int getIndexOfExpectedROInDOM(ResponseObject response){
		return getLocatorValueSOAPNodeforHoldenOSS(response, 'ServiceVisit',"DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID )
	}
}