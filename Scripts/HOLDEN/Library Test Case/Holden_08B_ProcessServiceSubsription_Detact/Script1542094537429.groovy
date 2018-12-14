import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.SubscriptionProcess

/**
 * V0. Create framework 13/11/18
 * Verify response
 * Transfer new framework 07/12/18
 */

//BEFORE
	ResponseObject res_SubscriptionDetact
	Common common = new Common()
	SubscriptionProcess proSub = new SubscriptionProcess()
//TEST CASE
	 res_SubscriptionDetact = proSub.getResponseTestCaseSubscriptionWithTypeInput("detact")
	 if(common.validateInvalidDealerCode(res_SubscriptionDetact)){}
		 else{
			 common.verifyStatusCodeIs200OK(res_SubscriptionDetact)
			 common.verifyApplicationAreaResponse(res_SubscriptionDetact)
			 proSub.verifyServiceSubscriptionSectionResponse(res_SubscriptionDetact)
				 
			 common.setStatusPassedForTestCaseWithTypeInput("subd")
		 }
