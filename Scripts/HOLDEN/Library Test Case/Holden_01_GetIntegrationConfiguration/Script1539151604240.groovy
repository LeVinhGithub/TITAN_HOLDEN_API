import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.GetIntegration

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 * Transfer to new framework 04/12/18
 */

//BEFORE 
     ResponseObject res_IntegrationConfig
	 Common common =new Common()
	 GetIntegration getInt = new GetIntegration()
//TEST CASE
	 res_IntegrationConfig = getInt.getResponseTestCaseIntegrationConfig()
	 
	 if(common.validateInvalidDealerCode(res_IntegrationConfig)){}
	 	else{
			 common.verifyStatusCodeIs200OK(res_IntegrationConfig)
			 common.verifyApplicationAreaResponse(res_IntegrationConfig)
			 getInt.verifyIntegrationConfig(res_IntegrationConfig)
			 common.setStatusPassedForTestCaseWithTypeInput("int")
		 }
