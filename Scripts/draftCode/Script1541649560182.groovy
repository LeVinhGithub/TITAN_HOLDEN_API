import static org.assertj.core.api.Assertions.*

import groovy.sql.Sql//Convert String to XML object
import qaVinhLe.Library_Method_VinhLe
/**
 * @author ANH THY
 * 1. add sql for customer information
 */
Library_Method_VinhLe lib = new Library_Method_VinhLe()
//String OpCodeQuery = "SELECT DISTINCT CB.OPERATION_CODE,OC.DESCRIPTION,CP.STANDARD_HOUR,CB.CODEBOOK_KEY FROM CODEBOOK CB "+
//				"LEFT JOIN OPERATION_CODE OC ON CB.OPERATION_CODE = OC.CODE "+
//				"LEFT JOIN CODEBOOK_PRICE CP ON CP.CODEBOOK_KEY = CB.CODEBOOK_KEY "+
//				"WHERE CB.CODEBOOK_MODEL_KEY <> 2 ORDER BY CB.CODEBOOK_KEY ASC"
//		int sizeSQl = lib.getSQLSize(OpCodeQuery)
//
//		//Assert value
//		def conn = lib.createSQLConnection()
//		def sql = new Sql(conn)
//		int countNumber = 0
//		//Executive query for database
//		//Read data row by row by expression eachRow
//		int count = 0
//		int count1 = 0
//		sql.eachRow(OpCodeQuery) {row ->
//			if(!(count1 == 0||count1 == 1)){
//				
//				println row[0]
//				count+=1
//			}
//			
//			count1 += 1
//
//		}
//		println count
//		println count1
//		lib.closeSQLConnection(conn, sql)

String a = '5'
String b = '6'

if((a as Integer) < (b as Integer)) println 'ok'