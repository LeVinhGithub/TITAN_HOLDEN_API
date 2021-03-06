import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.ProcessService
import internal.GlobalVariable as GlobalVariable

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 */


	ResponseObject res_ProcessService
	Common common = new Common()
	ProcessService proDel = new ProcessService()
	
//TEST CASE
	 res_ProcessService = proDel.getResponseTestCaseProcessServiceVisitForDeleteCase()
	 if(common.validateInvalidDealerCode(res_ProcessService)){}
	 	else{
			 common.printErrorMessageforProcessService(res_ProcessService)
			 common.verifyStatusCodeIs200OK(res_ProcessService)
			 common.verifyApplicationAreaResponse(res_ProcessService)
			 common.verifyAcknowledgeServiceAreaResponse(res_ProcessService)
			 common.verifyExistCustomerAndVehicleInformationResponse(res_ProcessService,false,false)
			 common.verifyWholeAppointmentInformationWithOneJobline(res_ProcessService,true)
			 common.setStatusPassedForTestCaseWithTypeInput("del")
		 }
	