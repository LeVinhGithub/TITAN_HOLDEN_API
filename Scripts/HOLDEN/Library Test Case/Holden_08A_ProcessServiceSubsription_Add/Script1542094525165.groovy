import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.SubscriptionProcess
import internal.GlobalVariable as GlobalVariable

/**
 * V0. Create framework 13/11/18
 * Verify response
 * Transfer new framework 07/12/18
 */

//BEFORE
	ResponseObject res_SubscriptionAdd
	Common common = new Common()
	SubscriptionProcess proSub = new SubscriptionProcess()
//TEST CASE
	 res_SubscriptionAdd = proSub.getResponseTestCaseSubscriptionWithTypeInput("add")
	 if(common.validateInvalidDealerCode(res_SubscriptionAdd)){}
	 	else{
			 common.verifyStatusCodeIs200OK(res_SubscriptionAdd)
			 common.verifyApplicationAreaResponse(res_SubscriptionAdd)
			 proSub.verifyServiceSubscriptionSectionResponse(res_SubscriptionAdd)
				 
			 common.setStatusPassedForTestCaseWithTypeInput("suba")
		 }
