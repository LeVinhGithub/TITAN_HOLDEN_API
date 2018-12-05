import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.GetService
import internal.GlobalVariable as GlobalVariable


/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 */

ResponseObject res_GetServiceVisit
	Common common = new Common()
	GetService getSer = new GetService()
//TEST CASE
	 res_GetServiceVisit = getSer.getResponseTestCaseGetServiceDetailInformation()
	 if(common.validateInvalidDealerCode(res_GetServiceVisit)){}
	 	else{
			 common.verifyStatusCodeIs200OK(res_GetServiceVisit)
			 common.verifyApplicationAreaResponse(res_GetServiceVisit)
			 common.verifyAcknowledgeServiceAreaResponse(res_GetServiceVisit)
			 common.setBookingIdFromResponseToGlobalVariable(res_GetServiceVisit)
			 common.verifyExistCustomerAndVehicleInformationResponse(res_GetServiceVisit)
			 if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase()=='false')
			 	common.verifyWholeAppointmentInformationWithOneJobline(res_GetServiceVisit)
				 else common.verifyWholeAppointmentInformationWithTwoJobline(res_GetServiceVisit)
				 
			 common.setStatusPassedForTestCaseWithTypeInput("get")
		 }
