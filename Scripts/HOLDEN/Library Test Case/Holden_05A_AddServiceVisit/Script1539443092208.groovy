import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.ProcessService
import internal.GlobalVariable as GlobalVariable

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 * V2. Handle for new customer, verify customer information from Get Customer Information and from DB
 * Transfer to new framework
 */

//BEFORE
	ResponseObject res_ProcessServiceVisit
	Common common = new Common()
	ProcessService proAdd = new ProcessService()
//TEST CASE
	 res_ProcessServiceVisit = proAdd.getResponseTestCaseProcessServiceVisitForAddCase()
	 if(common.validateInvalidDealerCode(res_ProcessServiceVisit)){}
	 	else if(proAdd.validateInvalidAdvisor(res_ProcessServiceVisit)){}
		 	else if(common.validateStartTimeAfterEndDate(res_ProcessServiceVisit, GlobalVariable.Glb_ServiceDate, GlobalVariable.Glb_ServiceEndDate)){}
			 	//else if(common.validateStartTimeInPast(res_ProcessServiceVisit, GlobalVariable.Glb_ServiceDate)){}
				 	else{
						 common.verifyStatusCodeIs200OK(res_ProcessServiceVisit)
						 GlobalVariable.Glb_BookingStatus = "current"
						 common.verifyApplicationAreaResponse(res_ProcessServiceVisit)
						 common.verifyAcknowledgeServiceAreaResponse(res_ProcessServiceVisit)
						 common.setBookingIdFromResponseToGlobalVariable(res_ProcessServiceVisit)
						 common.verifyExistCustomerAndVehicleInformationResponse(res_ProcessServiceVisit,true)
						 common.verifyWholeAppointmentInformationWithOneJobline(res_ProcessServiceVisit)
						 
						 common.verifyCustomerAndVehicleInformationBySQL()
						 common.setStatusPassedForTestCaseWithTypeInput("add")
					 }
