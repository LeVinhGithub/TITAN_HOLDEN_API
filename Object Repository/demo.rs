<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>demo</name>
   <tag></tag>
   <elementGuidId>b983015c-80a3-4805-baed-20ed97e8825e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;soapenv:Envelope xmlns:soapenv=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot; xmlns:tem=&quot;http://tempuri.org/&quot; xmlns:int=&quot;http://integration.vitalsoftware.net&quot;>
   &lt;soapenv:Header/>
   &lt;soapenv:Body>
      &lt;tem:WriteToTitan>
         &lt;tem:mesage>
            &lt;int:Dealers>
               &lt;int:Dealer>
                  &lt;int:Data>
                     &lt;int:Contacts>
                        &lt;int:ContactChange>
                           &lt;int:ContactChangeType>None&lt;/int:ContactChangeType>
                           &lt;int:ContactInfo>
                              &lt;int:ContactIds>
                                 &lt;int:Id>
                                    &lt;int:Key>14021333&lt;/int:Key>
                                    &lt;int:System>ContactTracker&lt;/int:System>
                                 &lt;/int:Id>
                              &lt;/int:ContactIds>
                              &lt;int:EntityType>PRIVATE&lt;/int:EntityType>
                              &lt;int:FirstName>CO_10&lt;/int:FirstName>
                              &lt;int:LastName>Test124&lt;/int:LastName>
                              &lt;int:Mobile>0456 111 338&lt;/int:Mobile>
                              &lt;int:PostalAddress>
                                 &lt;int:Address1>18 Eagle St&lt;/int:Address1>
                                 &lt;int:City>BRISBANE&lt;/int:City>
                                 &lt;int:PostCode>4000&lt;/int:PostCode>
                                 &lt;int:State>QLD&lt;/int:State>
                              &lt;/int:PostalAddress>
                              &lt;int:PrivacyCode>
                                 &lt;int:CanContactByEmail>true&lt;/int:CanContactByEmail>
                                 &lt;int:CanContactByMail>true&lt;/int:CanContactByMail>
                                 &lt;int:CanRingByPhone>true&lt;/int:CanRingByPhone>
                                 &lt;int:CanSms>true&lt;/int:CanSms>
                              &lt;/int:PrivacyCode>
                              &lt;int:PrivateEmail>COTest08@example.com&lt;/int:PrivateEmail>
                              &lt;int:Spouse/>
                              &lt;int:StreetAddress>
                                 &lt;int:Address1>18 Eagle St&lt;/int:Address1>
                                 &lt;int:City>BRISBANE&lt;/int:City>
                                 &lt;int:PostCode>4000&lt;/int:PostCode>
                                 &lt;int:State>QLD&lt;/int:State>
                              &lt;/int:StreetAddress>
                              &lt;int:Title>Mr&lt;/int:Title>
                           &lt;/int:ContactInfo>
                        &lt;/int:ContactChange>
                     &lt;/int:Contacts>
                     &lt;int:Opportunities>
                        &lt;int:OpportunityChange>
                           &lt;int:OpportunityChangeType>Update&lt;/int:OpportunityChangeType>
                           &lt;int:OpportunityInfo>
                              &lt;int:Campaign>Carsales&lt;/int:Campaign>
                              &lt;int:ContactIds>
                                 &lt;int:Id>
                                    &lt;int:Key>14021333&lt;/int:Key>
                                    &lt;int:System>ContactTracker&lt;/int:System>
                                 &lt;/int:Id>
                              &lt;/int:ContactIds>
                              &lt;int:Department>Vehicles - Carzoos Sales - QLD - Central Northside-21101-USED&lt;/int:Department>
                              &lt;int:LeadSource>Phone Call&lt;/int:LeadSource>
                              &lt;int:OpportunityIds>
                                 &lt;int:Id>
                                    &lt;int:Key>14021333&lt;/int:Key>
                                    &lt;int:System>ContactTracker&lt;/int:System>
                                 &lt;/int:Id>
                              &lt;/int:OpportunityIds>
                              &lt;int:SalesPerson>
                                 &lt;int:Ids>
                                    &lt;int:Id>
                                       &lt;int:Key>clarj&lt;/int:Key>
                                       &lt;int:System>Titan&lt;/int:System>
                                    &lt;/int:Id>
                                 &lt;/int:Ids>
                                 &lt;int:Name>Jordan Clark&lt;/int:Name>
                              &lt;/int:SalesPerson>
                              &lt;int:Status>Ongoing&lt;/int:Status>
                              &lt;int:Type>Buy&lt;/int:Type>
                              &lt;int:VehicleInfo>
                                 &lt;int:Make>HYUNDAI&lt;/int:Make>
                                 &lt;int:RegNo>REGO020&lt;/int:RegNo>
                                 &lt;int:SaleType>Used&lt;/int:SaleType>
                                 &lt;int:VIN>TH07U81XSDU145420&lt;/int:VIN>
                              &lt;/int:VehicleInfo>
                           &lt;/int:OpportunityInfo>
                        &lt;/int:OpportunityChange>
                     &lt;/int:Opportunities>
                  &lt;/int:Data>
                  &lt;int:DealerInfo>
                     &lt;int:Ids>
                        &lt;int:Id>
                           &lt;int:Key>Carzoos_Direct_Beta&lt;/int:Key>
                           &lt;int:System>Titan&lt;/int:System>
                        &lt;/int:Id>
                     &lt;/int:Ids>
                     &lt;int:Name>Carzoos contact and opp Testing 10&lt;/int:Name>
                  &lt;/int:DealerInfo>
               &lt;/int:Dealer>
            &lt;/int:Dealers>
         &lt;/tem:mesage>
      &lt;/tem:WriteToTitan>
   &lt;/soapenv:Body>
&lt;/soapenv:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>WriteToTitan</soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress>http://111.125.161.51/VitalSoft/VitalSoftContactAndOppSync.asmx?wsdl</wsdlAddress>
</WebServiceRequestEntity>
