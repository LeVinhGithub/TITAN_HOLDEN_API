import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject

import holdenObject.Common

/**
 * @author ANH THY
 * 1. add sql for customer information
 */
Common common = new Common()
ResponseObject response
Object demo1 = '2018-12-07T15:12:17'
Object demo2 = '2018-12-07T15:09:17'

boolean rs = common.validateStartTimeAfterEndDate(response, demo1, demo2)
assert rs == true