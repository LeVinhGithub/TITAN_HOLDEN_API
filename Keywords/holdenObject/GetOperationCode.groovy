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
import java.sql.Driver



class GetOperationCode extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseGetAllOperationCode(){
		RequestObject GetLaborOperations = findTestObject('Holden/Holden_04_Get LaborOperations', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code])
		return WS.sendRequest(GetLaborOperations)
	}
	
	@Keyword
	void verifyListOpCodeBetweenGetOpCodeResponseAndDatabase(ResponseObject response){
		//Get number of Op Code
		int numberOpCode = getSizeSOAPNode(response, "LaborOperations")
		//Get information of all Op Code
		def listOpCode = new String[1000]
		def listOpDescription = new String[1000]
		
		for (int i = 0;i<numberOpCode;i++){
			listOpCode[i] = getValueSOAPNode(response, "DocumentIdentification", "DocumentID", i, 0) as String
			listOpDescription[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborOperationDescription", i, 0) as String
		}
	//Code to get data from SQL
		String OpCodeQuery = "SELECT CB.OPERATION_CODE,OC.DESCRIPTION FROM CODEBOOK CB JOIN OPERATION_CODE OC ON CB.OPERATION_CODE = OC.CODE WHERE CB.CODEBOOK_MODEL_KEY <> 2 ORDER BY CB.CODEBOOK_KEY ASC"
		int sizeSQl = getSQLSize(OpCodeQuery)
		
	//Assert value
		 def conn = createSQLConnection()
		 def sql = new Sql(conn)
		 int countNumber = 0
		//Executive query for database
		//Read data row by row by expression eachRow
		 sql.eachRow(OpCodeQuery) {row ->
			 assert listOpCode[countNumber] == row.OPERATION_CODE as String
			 if(!('UCD'== row.OPERATION_CODE as String))
			 assert listOpDescription[countNumber] == row.DESCRIPTION as String
			 else if('UCD'== row.OPERATION_CODE as String) assert listOpDescription[countNumber] == 'SUBLET USED CAR DETAI'
			 countNumber += 1
			  
		  }
		  closeSQLConnection(conn, sql)
		  assert numberOpCode == sizeSQl
	}
}