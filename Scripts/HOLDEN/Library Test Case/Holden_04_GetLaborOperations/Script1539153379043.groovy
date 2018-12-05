import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.GetOperationCode


/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 * Transfer to new framework 05/12/18
 */

//BEFORE
	ResponseObject res_GetLaborOperations
	Common common = new Common()
	GetOperationCode getOp = new GetOperationCode()
//TEST CASE
	 res_GetLaborOperations = getOp.getResponseTestCaseGetAllOperationCode()
	 if(common.validateInvalidDealerCode(res_GetLaborOperations)){}
	 	else{
			 common.verifyStatusCodeIs200OK(res_GetLaborOperations)
			 common.verifyApplicationAreaResponse(res_GetLaborOperations)
			 getOp.verifyListOpCodeBetweenGetOpCodeResponseAndDatabase(res_GetLaborOperations)
			 common.setStatusPassedForTestCaseWithTypeInput("lab")
		 }
