package holdenObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe


class ProcessService extends Library_Method_VinhLe{
	Common common = new Common()

	@Keyword
	ResponseObject getResponseTestCaseProcessServiceVisitForAddCase(){
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

	@Keyword
	ResponseObject getResponseTestCaseProcessServiceVisitForDeleteCase(){
		RequestObject ProcessServiceVisit = findTestObject('Holden/Holden_05C_DeleteServiceVisit', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code,
			('obj_DocumentId') : GlobalVariable.Glb_DocumentId,
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
			('obj_BookingId') : GlobalVariable.Glb_Booking_ID,
			('obj_DateAppointment') : GlobalVariable.Glb_ServiceDate,
			('obj_DateEndAppointment') : GlobalVariable.Glb_ServiceEndDate,
			('obj_LaborCode') : GlobalVariable.Glb_Ser_LaborCode,
			('obj_LaborDescription') : GlobalVariable.Glb_Ser_LaborDescription])
		return WS.sendRequest(ProcessServiceVisit)
	}
	
	@Keyword
	ResponseObject getResponseTestCaseProcessServiceVisitForChangeCase(){
		String objectRepo = "Holden/Holden_05B_ChangeServiceVisit"
		if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase() == 'true')
			objectRepo = "Holden/Holden_05B_ChangeServiceVisit_AddOpCode"

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
		return WS.sendRequest(ProcessServiceVisit)
	}

	@Keyword
	boolean validateInvalidAdvisor(ResponseObject response) {
		if(!(GlobalVariable.Glb_AdvisorType.toString().toLowerCase() == 'exist')){
			verifyResponseCode_Msg(response, 200, "Invalid service advisor")
			println "Advisor is invalid"
			return true
		} else return false
	}
	
	@Keyword
	void setDateForChangeDateCaseWithInput(Object dateVariable) {
		if(dateVariable.toString().toLowerCase()!='false')
		GlobalVariable.Glb_ServiceDate = common.setValueDateForEachCasesWithAUTimeZone(dateVariable, "YYYY-MM-dd'T'HH:45:00")
		GlobalVariable.Glb_ServiceEndDate = common.setValueDateForEachCasesWithAUTimeZone(dateVariable, "YYYY-MM-dd'T'HH:50:00")
	}
	
}