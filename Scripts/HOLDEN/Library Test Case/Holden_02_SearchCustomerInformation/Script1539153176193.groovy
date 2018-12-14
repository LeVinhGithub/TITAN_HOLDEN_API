import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.GetCustomerInformation

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 * Transfer to new framework 04/12/18
 */

//BEFORE 
	ResponseObject res_SearchCustomerInformation
	Common common = new Common()
	GetCustomerInformation getCus = new GetCustomerInformation()
//TEST CASE
	 res_SearchCustomerInformation = getCus.getResponseTestCaseSearchCustomerInformation()
	 println res_SearchCustomerInformation.getResponseText()
	 if(common.validateInvalidDealerCode(res_SearchCustomerInformation)){}
	 	else{
			 common.verifyStatusCodeIs200OK(res_SearchCustomerInformation)
			 common.verifyApplicationAreaResponse(res_SearchCustomerInformation)
			 getCus.verifySearchNotExistCustomerResponse(res_SearchCustomerInformation)
			 common.verifyOldCustomerInformationResponse(res_SearchCustomerInformation)
			 common.verifyVehicleInformationResponse(res_SearchCustomerInformation)
			 common.verifyCustomerAndVehicleInformationBySQL()
			 common.setStatusPassedForTestCaseWithTypeInput("cus")
		 }
