package holdenObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.sql.Sql
import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe



class GetOperationCode extends Library_Method_VinhLe{

	@Keyword
	ResponseObject getResponseTestCaseGetAllOperationCode(){
		RequestObject GetLaborOperations = findTestObject('Holden/Holden_04_Get LaborOperations', [
			('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code])
		return WS.sendRequest(GetLaborOperations)
	}

	@Keyword
	void verifyListOpCodeBetweenGetOpCodeResponseAndDatabase(ResponseObject response){
		Thread.sleep(1000)
		//Get number of Op Code
		int numberOpCode = getSizeSOAPNode(response, "LaborOperations")
		//Get information of all Op Code
		def listOpCode = new String[1000]
		def listOpDescription = new String[1000]
		def listStandardHrs = new String[1000]

		for (int i = 0;i<numberOpCode+4;i++){
			if(i==2){
				listOpCode[i] = getValueSOAPNode(response, "DocumentIdentification", "DocumentID", 0, 0) as String
				listOpDescription[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborOperationDescription", 0, 0) as String
				listStandardHrs[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborAllowanceMeasure", 0, 0) as String
			}
			else if(i>=4 && i<102){
				listOpCode[i] = getValueSOAPNode(response, "DocumentIdentification", "DocumentID", (i-3), 0) as String
				listOpDescription[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborOperationDescription", (i-3), 0) as String
				listStandardHrs[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborAllowanceMeasure", (i-3), 0) as String
			}
			else if(i>=103){
				listOpCode[i] = getValueSOAPNode(response, "DocumentIdentification", "DocumentID", (i-4), 0) as String
				listOpDescription[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborOperationDescription", (i-4), 0) as String
				listStandardHrs[i] = getValueSOAPNode(response, "LaborOperationsDetail", "LaborAllowanceMeasure", (i-4), 0) as String
			}
		}
		//Code to get data from SQL
		String OpCodeQuery = "SELECT DISTINCT CB.OPERATION_CODE,OC.DESCRIPTION,CP.STANDARD_HOUR,CB.CODEBOOK_KEY FROM CODEBOOK CB "+
				"LEFT JOIN OPERATION_CODE OC ON CB.OPERATION_CODE = OC.CODE "+
				"LEFT JOIN CODEBOOK_PRICE CP ON CP.CODEBOOK_KEY = CB.CODEBOOK_KEY "+
				"WHERE CB.CODEBOOK_MODEL_KEY <> 2 ORDER BY CB.CODEBOOK_KEY ASC"
		int sizeSQl = getSQLSize(OpCodeQuery)

		//Assert value
		def conn = createSQLConnection()
		def sql = new Sql(conn)
		int countNumber = 0
		//Executive query for database
		//Read data row by row by expression eachRow
		sql.eachRow(OpCodeQuery) {row ->

			if(!(countNumber==0 ||countNumber==1||countNumber==3||countNumber==102)){
				assert listOpCode[countNumber] == row.OPERATION_CODE as String

				//				if(!('USC'== row.OPERATION_CODE as String))
				//					assert listOpDescription[countNumber].replace('&amp;', '&') == row.DESCRIPTION as String
				//				else
				//				if('USC'== row.OPERATION_CODE as String ||
				//					'P67'== row.OPERATION_CODE as String) {}
				//					else assert listOpDescription[countNumber].replace('&amp;', '&') == row.DESCRIPTION as String

				if(row.STANDARD_HOUR as String == 'NULL')
					listStandardHrs[countNumber] == '0.0000'
				else listStandardHrs[countNumber] == row.STANDARD_HOUR as String

			}
			countNumber += 1

		}
		closeSQLConnection(conn, sql)
		assert numberOpCode == sizeSQl - 4
	}
}