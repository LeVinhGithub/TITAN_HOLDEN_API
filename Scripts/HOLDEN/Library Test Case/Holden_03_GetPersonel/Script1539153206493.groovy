import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
import java.security.AccessControlContext
import static org.assertj.core.api.Assertions.*
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
import org.sikuli.api.API
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.jna.platform.win32.WinNT.ACCESS_ACEStructure
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import groovy.sql.Sql
import holdenObject.Common
import holdenObject.GetAdvisor

import java.sql.Driver


/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 * Transfer to new framework 05/12/18
 */

//BEFORE
	ResponseObject res_GetPersonel
	Common common = new Common()
	GetAdvisor getAdv = new GetAdvisor()
//TEST CASE
	 res_GetPersonel = getAdv.getResponseTestCaseGetAdvisorInformation()
	 if(common.validateInvalidDealerCode(res_GetPersonel)){}
	 	else{
			 common.verifyStatusCodeIs200OK(res_GetPersonel)
			 common.verifyApplicationAreaResponse(res_GetPersonel)
			 getAdv.verifyListAdvisorBetweenGetAdvisorResponseAndDatabase(res_GetPersonel)
			 common.setStatusPassedForTestCaseWithTypeInput("adv")
		 }
