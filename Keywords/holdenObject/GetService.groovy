package holdenObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe


class GetService extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseGetServiceDetailInformation(){
		RequestObject GetServiceVisit = findTestObject('Holden/Holden_07_GetServiceVisit', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code,
			('obj_BookingId') : GlobalVariable.Glb_Booking_ID])
		return WS.sendRequest(GetServiceVisit)
	}

	@Keyword
	boolean validateNotExistBookingID(ResponseObject response){
		if(GlobalVariable.Glb_Booking_ID.toString().toLowerCase()=='notexist'){
			verifyResponseCode_Msg(response, 200, "Invalid Service Appointment Id")
			println "Invalid Booking ID or not found!"
			return true
		} else return false
	}
}