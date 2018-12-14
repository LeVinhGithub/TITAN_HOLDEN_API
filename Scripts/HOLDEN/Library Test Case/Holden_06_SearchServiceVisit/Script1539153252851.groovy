import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import holdenObject.Common
import holdenObject.SearchService
import internal.GlobalVariable as GlobalVariable

 /**
  *V0. Create framework 09/10/18
  *V1. Verify response 13/10/18
  *Declare request  14/10/18
  *Transfer new framework 07/12/18
  */

//BEFORE
	ResponseObject res_SearchServiceVisit
	Common common = new Common()
	SearchService searchSer = new SearchService()
	int indexExpectedNode
	common.printAllCurrentValueGlobalVariable()
//TEST CASE
	 res_SearchServiceVisit = searchSer.getResponseTestCaseSearchServiceInformation()
	 if(common.validateInvalidDealerCode(res_SearchServiceVisit)){}
	 	else if(common.validateStartTimeAfterEndDate(res_SearchServiceVisit, GlobalVariable.Glb_StartSearchDate, GlobalVariable.Glb_StartSearchDate)){}
		 	else{
				 common.verifyStatusCodeIs200OK(res_SearchServiceVisit)
				 common.verifyApplicationAreaResponse(res_SearchServiceVisit)
				 
				 indexExpectedNode = searchSer.getIndexOfExpectedROInDOM(res_SearchServiceVisit)
				 common.verifyExistCustomerAndVehicleInformationResponse(res_SearchServiceVisit,indexExpectedNode)
				 common.verifyWholeAppointmentInformationWithOneJobline(res_SearchServiceVisit,indexExpectedNode)
					 
				 common.setStatusPassedForTestCaseWithTypeInput("sea")
			 }
