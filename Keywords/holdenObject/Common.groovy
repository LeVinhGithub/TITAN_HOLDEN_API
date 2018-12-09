package holdenObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject

import groovy.sql.Sql
import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe


class Common extends Library_Method_VinhLe{

	@Keyword
	boolean validateInvalidDealerCode(ResponseObject response) {
		if(!(GlobalVariable.Glb_Dealer_Code == '299560')){
			verifyResponseCode_Msg(response, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
			println "Dealer Code is invalid"
			return true
		} else return false
	}

	@Keyword
	boolean validateStartTimeAfterEndDate(ResponseObject response,Object StartDate, Object EndDate) {
		Date dStartDate = convertStringtoDate(StartDate.toString(), "yyyy-MM-dd'T'HH:mm:ss")
		Date dEndDate = convertStringtoDate(EndDate.toString(), "yyyy-MM-dd'T'HH:mm:ss")
		if(dStartDate.after(dEndDate)){
			verifyResponseCode_Msg(response, 200, "is later than")
			println "Invalid Time Input: Start Date is after End Date"
			return true
		} else return false
	}

	@Keyword
	void verifyStatusCodeIs200OK(ResponseObject response){
		verifyResponseCode_Msg(response, 200, "")
		println 'Request send successfully'
	}

	@Keyword
	void verifyApplicationAreaResponse(ResponseObject response) {
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
	void verifyAcknowledgeServiceAreaResponse(ResponseObject response) {
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
	}

	@Keyword
	void verifyOldCustomerInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_DocumentId.toString(), 0, 0)
		verifyValueSOAPNode(response, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		verifyValueSOAPNode(response, "AppointmentContactParty", "DealerManagementSystemID", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		verifyCustomerAddressInformationResponse(response)
		verifyCustomerContactInformationResponse(response)
	}

	@Keyword
	void verifyOldCustomerInformationResponse(ResponseObject response, int noOfNode,boolean isSearchMethod){
		verifyValueSOAPNode(response, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_DocumentId.toString(), 2*noOfNode, 0)
		verifyValueSOAPNode(response, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, noOfNode, 0)
		if(!isSearchMethod) verifyValueSOAPNode(response, "AppointmentContactParty", "DealerManagementSystemID", GlobalVariable.Glb_Cus_TradingEntity, 1+2*noOfNode, 0)
		verifyCustomerAddressInformationResponse(response,noOfNode)
		verifyCustomerContactInformationResponse(response,noOfNode)
	}

	@Keyword
	void verifyNewCustomerInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_DocumentId.toString(), 0, 0)
		GlobalVariable.Glb_Cus_TradingEntity = getValueSOAPNode(response, "AppointmentContactParty", "DealerManagementSystemID", 0, 0)
		verifyValueSOAPNode(response, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		verifyCustomerAddressInformationResponse(response)
		verifyCustomerContactInformationResponse(response)
	}

	@Keyword
	void verifyCustomerAddressInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, 0, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "StateOrProvinceCountrySub-DivisionID", GlobalVariable.Glb_Cus_State, 0, 0)
	}

	@Keyword
	void verifyCustomerAddressInformationResponse(ResponseObject response, int noOfNode){
		verifyValueSOAPNode(response, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, noOfNode, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, noOfNode, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, noOfNode, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, noOfNode, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, noOfNode, 0)
		verifyValueSOAPNode(response, "ResidenceAddress", "StateOrProvinceCountrySub-DivisionID", GlobalVariable.Glb_Cus_State, noOfNode, 0)
	}

	@Keyword
	void verifyCustomerContactInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "TelephoneCommunication", "ChannelCode", 'WORKPHONE', 0, 0)
		verifyValueSOAPNode(response, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, 0, 0)
		verifyValueSOAPNode(response, "TelephoneCommunication", "ChannelCode", 'CELLPHONE', 0, 1)
		verifyValueSOAPNode(response, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, 0, 1)
		verifyValueSOAPNode(response, "TelephoneCommunication", "ChannelCode", 'HOMEPHONE', 0, 2)
		verifyValueSOAPNode(response, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, 0, 2)

		verifyValueSOAPNode(response, "URICommunication", "URIID", GlobalVariable.Glb_Cus_Email, 0, 0)
	}

	@Keyword
	void verifyCustomerContactInformationResponse(ResponseObject response, int noOfNode){
		verifyValueSOAPNode(response, "TelephoneCommunication", "ChannelCode", 'WORKPHONE', noOfNode*3, noOfNode*3)
		verifyValueSOAPNode(response, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, noOfNode*3, noOfNode*3)
		verifyValueSOAPNode(response, "TelephoneCommunication", "ChannelCode", 'CELLPHONE', noOfNode*3, 1+noOfNode*3)
		verifyValueSOAPNode(response, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, noOfNode*3, 1+noOfNode*3)
		verifyValueSOAPNode(response, "TelephoneCommunication", "ChannelCode", 'HOMEPHONE', noOfNode*3, 2+noOfNode*3)
		verifyValueSOAPNode(response, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, noOfNode*3, 2+noOfNode*3)

		verifyValueSOAPNode(response, "URICommunication", "URIID", GlobalVariable.Glb_Cus_Email, noOfNode*3, 0)
	}

	@Keyword
	void verifyExistCustomerAndVehicleInformationResponse(ResponseObject response,boolean isTradingEntityNull){
		if(isTradingEntityNull)
			verifyNewCustomerInformationResponse(response)
		else verifyOldCustomerInformationResponse(response)
		verifyVehicleInformationResponse(response)
	}

	@Keyword
	void verifyExistCustomerAndVehicleInformationResponseForChangeCase(ResponseObject response,Object globalVar){
		if(GlobalVariable.Glb_ChangeChangeCustomerVehicle.toString().toLowerCase().charAt(0)=='n')
			verifyExistCustomerAndVehicleInformationResponse(response, true)
			else if(GlobalVariable.Glb_ChangeChangeCustomerVehicle.toString().toLowerCase().charAt(0)=='o') 
				verifyExistCustomerAndVehicleInformationResponse(response, false)
	}

	@Keyword

	void verifyExistCustomerAndVehicleInformationResponse(ResponseObject response, int noOfNode){
		verifyOldCustomerInformationResponse(response, noOfNode, true)
		verifyVehicleInformationResponse(response, noOfNode)
	}

	@Keyword
	void verifyCustomerAndVehicleInformationBySQL(){
		def conn = createSQLConnection()
		def sql = new Sql(conn)
		String queryCustomer = "select TE.TRADING_ENTITY_KEY,STREET_LINE_1,SUBURB,POSTCODE,CP.PHONE_NO,CO.EMAIL from TRADING_ENTITY TE"+
				" join CONTACT_ADDRESS CA on TE.CONTACT_KEY = CA.CONTACT_KEY join CONTACT_PHONE CP on TE.CONTACT_KEY = CP.CONTACT_KEY"+
				" join CONTACT CO on TE.CONTACT_KEY = CO.CONTACT_KEY"+
				" where TE.NAME = '"+GlobalVariable.Glb_FirstName+" "+GlobalVariable.Glb_LastName+ "'"
		boolean stopCondition = false
		sql.eachRow(queryCustomer) {row ->
			if(!stopCondition){
				assert GlobalVariable.Glb_Cus_TradingEntity.toString() == row.TRADING_ENTITY_KEY as String
				assert GlobalVariable.Glb_Cus_LineOne.toString() == row.STREET_LINE_1 as String
				assert GlobalVariable.Glb_Cus_CityName.toString() == row.SUBURB as String
				assert GlobalVariable.Glb_Cus_Postcode.toString() == row.POSTCODE as String
				assert GlobalVariable.Glb_Cus_PhoneNumber.toString() == row.PHONE_NO as String
				assert GlobalVariable.Glb_Cus_Email.toString() == row.EMAIL as String
				stopCondition = true
			}
		}
		String queryVehicle ="select * from VEHICLE where REGO_NO = '"+GlobalVariable.Glb_veh_ManufacturerName+"'"
		sql.eachRow("select * from VEHICLE where REGO_NO = '"+GlobalVariable.Glb_veh_ManufacturerName+"'") {row ->
			assert GlobalVariable.Glb_veh_modelKey.toString() == row.MODEL_KEY as String
			assert GlobalVariable.Glb_Cus_TradingEntity.toString() == row.OWNER_TRADING_ENTITY_KEY as String
			assert GlobalVariable.Glb_veh_VehicleId.toString() == row.VIN as String
		}
		closeSQLConnection(conn, sql)
	}

	@Keyword
	void verifyVehicleInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "Vehicle", "Model", GlobalVariable.Glb_veh_modelKey, 0, 0)
		verifyValueSOAPNode(response, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, 0, 0)
		verifyValueSOAPNode(response, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, 0, 0)
		verifyValueSOAPNode(response, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, 0, 0)
		verifyValueSOAPNode(response, "Vehicle", "VehicleID", GlobalVariable.Glb_veh_VehicleId, 0, 0)

		verifyAttributeSOAPNode(response, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", 0, 0)
	}

	@Keyword
	void verifyVehicleInformationResponse(ResponseObject response, int noOfNode){
		verifyValueSOAPNode(response, "Vehicle", "Model", GlobalVariable.Glb_veh_modelKey, noOfNode, 0)
		verifyValueSOAPNode(response, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, noOfNode, 0)
		verifyValueSOAPNode(response, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, noOfNode, 0)
		verifyValueSOAPNode(response, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, noOfNode, 0)
		verifyValueSOAPNode(response, "Vehicle", "VehicleID", GlobalVariable.Glb_veh_VehicleId, noOfNode, 0)

		verifyAttributeSOAPNode(response, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", noOfNode, 0)
	}

	@Keyword
	void setBookingIdFromResponseToGlobalVariable(ResponseObject response){
		GlobalVariable.Glb_Booking_ID =  getValueSOAPNode(response, "DocumentIdentification", "DocumentID", 1, 0)
	}

	@Keyword
	void setBookingIdFromResponseToGlobalVariable(ResponseObject response, int noOfNode){
		GlobalVariable.Glb_Booking_ID =  getValueSOAPNode(response, "DocumentIdentification", "DocumentID", 1+2*noOfNode, 0)
	}

	@Keyword
	void verifyWholeAppointmentInformationWithOneJobline(ResponseObject response){
		setBookingIdFromResponseToGlobalVariable(response)
		verifyBookingIdResponse(response)
		verifyTimeAppointmentInformationResponse(response)
		verifyGeneralAppointmentJoblineAInformationResponse(response)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()=='invalid')
			verifyJoblineWithOpCodeNotExistInformationResponse(response, 0)
		else verifyJoblineWithOpCodeExistInformationResponse(response, 0)
	}

	@Keyword
	void verifyWholeAppointmentInformationWithOneJobline(ResponseObject response, boolean isCancelled){
		setBookingIdFromResponseToGlobalVariable(response)
		verifyBookingIdResponse(response)
		verifyTimeAppointmentInformationResponse(response,isCancelled)
		verifyGeneralAppointmentJoblineAInformationResponse(response)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()=='invalid')
			verifyJoblineWithOpCodeNotExistInformationResponse(response, 0)
		else verifyJoblineWithOpCodeExistInformationResponse(response, 0)
	}

	@Keyword
	void verifyWholeAppointmentInformationWithOneJobline(ResponseObject response, int noOfNode){
		setBookingIdFromResponseToGlobalVariable(response, noOfNode)
		verifyBookingIdResponse(response, noOfNode)
		verifyTimeAppointmentInformationResponse(response, noOfNode)
		verifyGeneralAppointmentJoblineAInformationResponse(response, noOfNode)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()=='invalid')
			verifyJoblineWithOpCodeNotExistInformationResponse(response, noOfNode)
		else verifyJoblineWithOpCodeExistInformationResponse(response, noOfNode)
	}

	@Keyword
	void verifyWholeAppointmentInformationWithTwoJobline(ResponseObject response){
		verifyWholeAppointmentInformationWithOneJobline(response)
		verifyGeneralAppointmentJoblineBInformationResponse(response)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()=='invalid')
			verifyJoblineWithOpCodeNotExistInformationResponse(response,1 )
		else verifyJoblineWithOpCodeExistInformationResponse(response, 1)
	}
	
	@Keyword
	void verifyWholeAppointmentInformationForChangeCase(ResponseObject response){
		if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase()=='true')
			verifyWholeAppointmentInformationWithOneJobline(response)
			else verifyWholeAppointmentInformationWithTwoJobline(response)
	}

	@Keyword
	void verifyBookingIdResponse(ResponseObject response){
		verifyValueSOAPNode(response, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID, 1, 0)
	}

	@Keyword
	void verifyBookingIdResponse(ResponseObject response, int noOfNode){
		verifyValueSOAPNode(response, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID, 1+2*noOfNode, 0)
	}

	@Keyword
	void verifyTimeAppointmentInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "Appointment", "AppointmentDateTime",GlobalVariable.Glb_ServiceDate , 0, 0)
		verifyValueSOAPNode(response, "Appointment", "EndAppointmentDateTime", GlobalVariable.Glb_ServiceEndDate, 0, 0)
	}

	@Keyword
	void verifyTimeAppointmentInformationResponse(ResponseObject response,boolean isCancelled){
		verifyValueSOAPNode(response, "Appointment", "AppointmentDateTime",GlobalVariable.Glb_ServiceDate , 0, 0)
		if(isCancelled) verifyValueSOAPNode(response, "Appointment", "AppointmentStatus", 'CANCELLED', 0, 0)
		verifyValueSOAPNode(response, "Appointment", "EndAppointmentDateTime", GlobalVariable.Glb_ServiceEndDate, 0, 0)
	}

	@Keyword
	void verifyTimeAppointmentInformationResponse(ResponseObject response, int noOfNode){
		verifyValueSOAPNode(response, "Appointment", "AppointmentDateTime",GlobalVariable.Glb_ServiceDate , noOfNode, 0)
		verifyValueSOAPNode(response, "Appointment", "EndAppointmentDateTime", GlobalVariable.Glb_ServiceEndDate, noOfNode, 0)
	}

	@Keyword
	void verifyGeneralAppointmentJoblineAInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "RequestedService", "JobNumberString", "A", 0, 0)
		verifyValueSOAPNode(response, "RequestedService", "JobTypeString", "Customer Pay", 0, 0)
	}

	@Keyword
	void verifyGeneralAppointmentJoblineAInformationResponse(ResponseObject response, int noOfNode){
		verifyValueSOAPNode(response, "RequestedService", "JobNumberString", "A", noOfNode, 0)
		verifyValueSOAPNode(response, "RequestedService", "JobTypeString", "Customer Pay", noOfNode, 0)
	}

	@Keyword
	void verifyGeneralAppointmentJoblineBInformationResponse(ResponseObject response){
		verifyValueSOAPNode(response, "RequestedService", "JobNumberString", "B", 1, 0)
		verifyValueSOAPNode(response, "RequestedService", "JobTypeString", "Customer Pay", 1, 0)
	}

	@Keyword
	void verifyJoblineWithOpCodeExistInformationResponse(ResponseObject response, int noJobline){
		verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationID", GlobalVariable.Glb_Ser_LaborCode, noJobline, 0)
		verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationIdTypeCode", GlobalVariable.Glb_Ser_LaborCode, noJobline, 0)
		if(!(GlobalVariable.Glb_Ser_LaborDescription.toString().toLowerCase().contains('invalid'))){
			verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborDescription, noJobline, 0)
			verifyValueSOAPNode(response, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborDescription, noJobline, 0)
		}
		else{
			verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, noJobline, 0)
			verifyValueSOAPNode(response, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, noJobline, 0)
		}
	}

	@Keyword
	void verifyJoblineWithOpCodeNotExistInformationResponse(ResponseObject response, int noJobline){
		verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationID", '', noJobline, 0)
		verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationIdTypeCode", '', noJobline, 0)
		verifyValueSOAPNode(response, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborDescription, noJobline, 0)
		verifyValueSOAPNode(response, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborDescription, noJobline, 0)
	}

	@Keyword
	String setValueRandomWithTimeValue(String globalVariable){
		if(globalVariable.toLowerCase()=='fname')
			return 'QATEAM_VINHLE'+ getDateFormat('yyMMddHHmmss')
		if(globalVariable.toLowerCase()=='lname')
			return 'HOLDEN'+ getDateFormat('yyMMddHHmmss')
		if(globalVariable.toLowerCase()=='rego')
			return 'REGNUMBER'+ getDateFormat('yyMMddHHmmss')
		if(globalVariable.toLowerCase()=='vin')
			return 'VNVNV'+ getDateFormat('yyMMddHHmmss')
	}

	@Keyword
	String setValueDateForEachCasesWithAUTimeZone(Object valueCase, String formatDate){
		String date
		if(valueCase.toString().toLowerCase() =="cr")
			date =  changeValueTimeDateOfToday(0, 0, 0, 5, 0, 0, formatDate)
		else if (valueCase.toString().toLowerCase() =="crh")
			date =  changeValueTimeDateOfToday(0, 0, 0, 5, 0, 0, formatDate)
		else if (valueCase.toString().toLowerCase() =="p")
			date =  changeValueTimeDateOfToday(0, 0, -1, 5, 0, 0, formatDate)
		else if (valueCase.toString().toLowerCase() =="f")
			date = changeValueTimeDateOfToday(0, 0, 1, 5, 0, 0, formatDate)
		return date
	}

	@Keyword
	void setStatusPassedForTestCaseWithTypeInput(String testcaseName){
		if(testcaseName.toLowerCase()=='int') GlobalVariable.Glb_Status_Integration = 'passed'
		if(testcaseName.toLowerCase()=='cus') GlobalVariable.Glb_Status_GetCustomer = 'passed'
		if(testcaseName.toLowerCase()=='adv') GlobalVariable.Glb_Status_GetAdvisor = 'passed'
		if(testcaseName.toLowerCase()=='lab') GlobalVariable.Glb_Status_GetLabor = 'passed'
		if(testcaseName.toLowerCase()=='add') GlobalVariable.Glb_Status_ProcessAdd = 'passed'
		if(testcaseName.toLowerCase()=='sea') GlobalVariable.Glb_Status_SearchService = 'passed'
		if(testcaseName.toLowerCase()=='get') GlobalVariable.Glb_Status_GetService = 'passed'
		if(testcaseName.toLowerCase()=='cha') GlobalVariable.Glb_Status_ProcessChange = 'passed'
		if(testcaseName.toLowerCase()=='del') GlobalVariable.Glb_Status_ProcessDelete = 'passed'
		if(testcaseName.toLowerCase()=='suba') GlobalVariable.Glb_Status_SubscriptionAdd = 'passed'
		if(testcaseName.toLowerCase()=='subd') GlobalVariable.Glb_Status_SubscriptionDetact = 'passed'
	}

	@Keyword
	void printAllCurrentValueGlobalVariable(){
		println 'Dealer Code: '+GlobalVariable.Glb_Dealer_Code
		println 'DocumentId: '+GlobalVariable.Glb_DocumentId
		println 'CustomerType: '+GlobalVariable.Glb_CustomerType
		println 'TradingEntity: '+GlobalVariable.Glb_Cus_TradingEntity
		println 'FirstName: '+GlobalVariable.Glb_FirstName
		println 'LastName: '+GlobalVariable.Glb_LastName
		println 'Cus_LineOne: '+GlobalVariable.Glb_Cus_LineOne
		println 'Cus_CityName: '+GlobalVariable.Glb_Cus_CityName
		println 'Cus_CountryID: '+GlobalVariable.Glb_Cus_CountryID
		println 'Cus_Postcode: '+GlobalVariable.Glb_Cus_Postcode
		println 'Cus_State: '+GlobalVariable.Glb_Cus_State
		println 'Cus_PhoneNumber: '+GlobalVariable.Glb_Cus_PhoneNumber
		println 'Cus_Email: '+GlobalVariable.Glb_Cus_Email
		println 'VehicleType: '+GlobalVariable.Glb_VehicleType
		println 'veh_Model: '+GlobalVariable.Glb_veh_Model
		println 'veh_ModelYear: '+GlobalVariable.Glb_veh_ModelYear
		println 'veh_MakeString: '+GlobalVariable.Glb_veh_MakeString
		println 'veh_ManufacturerName: '+GlobalVariable.Glb_veh_ManufacturerName
		println 'veh_VehicleId: '+GlobalVariable.Glb_veh_VehicleId
		println 'Booking_ID: '+GlobalVariable.Glb_Booking_ID
		println 'ServiceDate: '+GlobalVariable.Glb_ServiceDate
		println 'ServiceEndDate: '+GlobalVariable.Glb_ServiceEndDate
		println 'LaborCode: '+GlobalVariable.Glb_Ser_LaborCode
		println 'LaborDescription: '+GlobalVariable.Glb_Ser_LaborDescription
		println 'AdvisorType: '+GlobalVariable.Glb_AdvisorType
		println 'ChangeDate: '+GlobalVariable.Glb_ChangeDate
		println 'ChangeChangeCustomerVehicle: '+GlobalVariable.Glb_ChangeChangeCustomerVehicle
		println 'ChangeChangeOpCodeContent: '+GlobalVariable.Glb_ChangeChangeOpCodeContent
		println 'AddJobLine: '+GlobalVariable.Glb_AddJobLine
		println 'StartSearchDate: '+GlobalVariable.Glb_StartSearchDate
		println 'EndSearchDate: '+GlobalVariable.Glb_EndSearchDate
		println 'AdvisorType: '+GlobalVariable.Glb_AdvisorType
		println 'Adv_FirstName: '+GlobalVariable.Glb_Adv_FirstName
		println 'Adv_LastName: '+GlobalVariable.Glb_Adv_LastName
	}

	@Keyword
	void printErrorMessageforProcessService(ResponseObject response){
		String msg = getValueSOAPNode(response, "ErrorProcessMessage", "Description", 0, 0)
	}
}