package holdenObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe


class SubscriptionProcess extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseSubscriptionWithTypeInput(String methodType){
		if(methodType.toLowerCase()=='add')
			methodType = 'Holden/Holden_08A_ProcessServiceSubsription_Add'
		else methodType = 'Holden/Holden_08B_ProcessServiceSubsription_Detact'
		RequestObject Subscription = findTestObject(methodType, [
			('obj_DealerId') : GlobalVariable.Glb_Dealer_Code])
		return WS.sendRequest(Subscription)
	}

	@Keyword
	void verifyServiceSubscriptionSectionResponse(ResponseObject response){
		verifyValueSOAPNode(response, "ServiceSubscription", "CallbackUrl", "https://gmb2b.pp.gm.com/GlobalServiceSpecification/ProcessMessage", 0, 0)
		verifyValueSOAPNode(response, "ServiceSubscription", "EventType", "AcknowledgeServiceVisitAppointment", 0, 0)
		verifyValueSOAPNode(response, "ServiceSubscription", "EventType", "AcknowledgeServiceAppointmentConversion", 0, 1)
		verifyValueSOAPNode(response, "ServiceSubscription", "EventType", "ShowServiceVisit", 0, 2)
	}
}