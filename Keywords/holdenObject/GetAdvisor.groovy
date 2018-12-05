package holdenObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import groovy.sql.Sql


class GetAdvisor extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseGetAdvisorInformation(){
		RequestObject GetPersonel = findTestObject('Holden/Holden_03_GetPersonel', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code])
		return WS.sendRequest(GetPersonel)
	}

	@Keyword
	void verifyListAdvisorBetweenGetAdvisorResponseAndDatabase(ResponseObject response){
		//Get information of all personel
		def listDocId = new String[100]
		def listGivenName = new String[100]
		def listFamilyName = new String[100]

		int numberPersonel = getSizeSOAPNode(response, "DocumentID")
		for (int i = 0;i<numberPersonel;i++){
			listDocId[i] = getValueSOAPNode(response, "DocumentIdentification", "DocumentID", i, 0) as String
			listGivenName[i] = getValueSOAPNode(response, "SpecifiedPerson", "GivenName", i, 0) as String
			listFamilyName[i] = getValueSOAPNode(response, "SpecifiedPerson", "FamilyName", i, 0) as String
		}

		//Code to get data from SQL
		String currentDate = getDateFormat("MM/dd/YYYY") //TerminationDate =currentDate
		String advisorQuery = "exec Get_All_Service_Advisors @TerminationDate= '"+currentDate+"', @FinancialYearKey= 20"
		int sizeSQl = getSQLSize(advisorQuery)

		//Assert value
		def conn = createSQLConnection()
		def sql = new Sql(conn)
		int countNumber = 0
		//Executive query for database
		//Read data row by row by expression eachRow
		sql.eachRow(advisorQuery) {row ->
			assert listDocId[countNumber] == row[0] as String
			assert listGivenName[countNumber] == row.First_Name as String
			assert listFamilyName[countNumber] == row.Family_Name as String
			countNumber += 1

		}
		closeSQLConnection(conn, sql)
	}


}