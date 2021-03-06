<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Holden_05B_ChangeServiceVisit</name>
   <tag></tag>
   <elementGuidId>5c42d79e-5977-4779-80dc-466665383e5a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;soapenv:Envelope xmlns:soapenv=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot; xmlns:wsse=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd&quot; xmlns:wsu=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd&quot; xmlns:tran=&quot;http://www.starstandards.org/webservices/2009/transport&quot; xmlns:ns=&quot;http://www.starstandard.org/STAR/5&quot; xmlns:ns1=&quot;http://www.openapplications.org/oagis/9&quot;>
&lt;soapenv:Header>
      &lt;wsse:Security soapenv:mustUnderstand = &quot;1&quot;>
         &lt;!--Optional:-->
         &lt;wsu:Timestamp Id=&quot;Timestamp-f1272c36-8b22-41e4-9962-4028429e5315&quot;>
            &lt;wsu:Created>2018-11-30T13:21:12Z&lt;/wsu:Created>
            &lt;wsu:Expires>2018-11-30T21:21:12Z&lt;/wsu:Expires>
         &lt;/wsu:Timestamp>
         &lt;!--Optional:-->
         &lt;wsse:UsernameToken wsu:Id=&quot;UsernameToken-736fa6d4-6cda-4f4f-b8e6-2c068ede4cf2&quot;>
            &lt;!--Optional:-->
            &lt;wsse:Username>sysad&lt;/wsse:Username>
            &lt;!--Optional:-->
            &lt;wsse:Password Type=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText&quot;>3IZgX1GQSGH2qsIMZ5o39Q==&lt;/wsse:Password>
            &lt;!--Optional:-->
            &lt;wsse:Nonce EncodingType=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary&quot;>sysad&lt;/wsse:Nonce>
            &lt;wsu:Created>2018-11-30T13:21:12Z&lt;/wsu:Created>
         &lt;/wsse:UsernameToken>
      &lt;/wsse:Security>
      &lt;wsa:To xmlns:wsa=&quot;http://www.w3.org/2005/08/addressing&quot;>http://localhost:1489/HoldenManufacturerInterface.asmx&lt;/wsa:To>
      &lt;wsa:From xmlns:wsa=&quot;http://www.w3.org/2005/08/addressing&quot;>GM&lt;/wsa:From>
      &lt;ns0:payloadManifest xmlns:ns0=&quot;http://www.starstandards.org/webservices/2009/transport&quot;>
	     &lt;ns0:manifest version=&quot;5.6.4&quot; namespaceURI=&quot;http://www.starstandard.org/STAR/5&quot; element=&quot;ProcessServiceVisit&quot; contentID=&quot;0&quot;/>
	 &lt;/ns0:payloadManifest>
   &lt;/soapenv:Header>
   &lt;soapenv:Body>
      &lt;tran:ProcessMessage>
		&lt;!--Optional:-->
		&lt;tran:payload>
		   &lt;!--Optional:-->
		   &lt;tran:content id=&quot;0&quot;>
			  &lt;!--Optional:-->
			  &lt;ns:ProcessServiceVisit releaseID=&quot;5.6.4&quot; versionID=&quot;5.6.4&quot; systemEnvironmentCode=&quot;Test&quot; languageCode=&quot;en-US&quot;>
			  &lt;!--Optional:-->
				&lt;ns:ApplicationArea>
					&lt;ns:Sender>
						&lt;ns:CreatorNameCode>GM&lt;/ns:CreatorNameCode>
						&lt;ns:SenderNameCode>OSS&lt;/ns:SenderNameCode>
						&lt;ns:DealerNumberID>${obj_DealerCode}&lt;/ns:DealerNumberID>
						&lt;ns:DealerCountryCode>US&lt;/ns:DealerCountryCode>
						&lt;ns:LanguageCode>en-US&lt;/ns:LanguageCode>
					&lt;/ns:Sender>
					&lt;ns:CreationDateTime>2016-05-17T09:41:01.673-04:00&lt;/ns:CreationDateTime>
					&lt;ns1:Signature/>
					&lt;ns:BODID>5ab690dd-4580-4b00-b988-f826b83c44ca&lt;/ns:BODID>
					&lt;ns:Destination>
						&lt;ns:DestinationNameCode>QI&lt;/ns:DestinationNameCode>
						&lt;ns:DestinationSoftwareCode>QI&lt;/ns:DestinationSoftwareCode>
						&lt;ns:DestinationSoftware>QI&lt;/ns:DestinationSoftware>
						&lt;ns:DealerNumberID>${obj_DealerCode}&lt;/ns:DealerNumberID>
						&lt;ns:DealerTargetCountry>US&lt;/ns:DealerTargetCountry>
					&lt;/ns:Destination>
				&lt;/ns:ApplicationArea>
				&lt;!--Optional:-->
				&lt;ns:ProcessServiceVisitDataArea>
					&lt;ns:Process>
						&lt;ns1:ActionCriteria>
							&lt;ns1:ActionExpression actionCode=&quot;Add&quot;>Add&lt;/ns1:ActionExpression>
						&lt;/ns1:ActionCriteria>
					&lt;/ns:Process>
					&lt;ns:ServiceVisit>
						&lt;ns:ServiceVisitHeader>
							&lt;ns:DocumentIdentificationGroup>
								&lt;ns:DocumentIdentification>
									&lt;ns:DocumentID>${obj_DocumentId}&lt;/ns:DocumentID>
								&lt;/ns:DocumentIdentification>
							&lt;/ns:DocumentIdentificationGroup>
							&lt;ns:CustomerInfo>
								&lt;ns:AppointmentContactParty>
									&lt;ns:SpecifiedPerson>
										&lt;ns:GivenName>${Obj_GivenName}&lt;/ns:GivenName>
										&lt;ns:FamilyName>${Obj_FamilyName}&lt;/ns:FamilyName>
										&lt;ns:ResidenceAddress>
											&lt;ns:LineOne>${obj_LineOne}&lt;/ns:LineOne>
											&lt;ns:CityName>${obj_CityName}&lt;/ns:CityName>
											&lt;ns:CountryID>${obj_CountryId}&lt;/ns:CountryID>
											&lt;ns:Postcode>${obj_PostCode}&lt;/ns:Postcode>
											&lt;ns:StateOrProvinceCountrySub-DivisionID>${obj_State}&lt;/ns:StateOrProvinceCountrySub-DivisionID>
										&lt;/ns:ResidenceAddress>
                                      	
											&lt;ns:TelephoneCommunication>
												&lt;ns:ChannelCode>WORKPHONE&lt;/ns:ChannelCode>
												&lt;ns:CompleteNumber>${obj_PhoneNumber}&lt;/ns:CompleteNumber>
											&lt;/ns:TelephoneCommunication>
											&lt;ns:TelephoneCommunication>
												&lt;ns:ChannelCode>CELLPHONE&lt;/ns:ChannelCode>
												&lt;ns:CompleteNumber>${obj_PhoneNumber}&lt;/ns:CompleteNumber>
											&lt;/ns:TelephoneCommunication>
											&lt;ns:TelephoneCommunication>
												&lt;ns:ChannelCode>HOMEPHONE&lt;/ns:ChannelCode>
												&lt;ns:CompleteNumber>${obj_PhoneNumber}&lt;/ns:CompleteNumber>
											&lt;/ns:TelephoneCommunication>
																			
										&lt;ns:URICommunication>
											&lt;ns:URIID>${obj_Email}&lt;/ns:URIID>
											&lt;ns:ChannelCode>EMAIL&lt;/ns:ChannelCode>
										&lt;/ns:URICommunication>
										&lt;ns:ContactMethodTypeCode>Day Phone&lt;/ns:ContactMethodTypeCode>
									&lt;/ns:SpecifiedPerson>
								&lt;/ns:AppointmentContactParty>
							&lt;/ns:CustomerInfo>
							&lt;ns:VehicleInfo>
								&lt;ns:Vehicle>
									&lt;ns:Model>${obj_Model}&lt;/ns:Model>
									&lt;ns:ModelYear>${obj_ModelYear}&lt;/ns:ModelYear>
									&lt;ns:MakeString>${obj_MakeString}&lt;/ns:MakeString>
									&lt;ns:ManufacturerName>${obj_ManufacturerName}&lt;/ns:ManufacturerName>
                                  	&lt;ns:VehicleID>${obj_VIN}&lt;/ns:VehicleID>
								&lt;/ns:Vehicle>
								&lt;ns:InDistanceMeasure unitCode=&quot;mile&quot;>5000&lt;/ns:InDistanceMeasure>
							&lt;/ns:VehicleInfo>
						&lt;/ns:ServiceVisitHeader>
						&lt;ns:ServiceVisitDetail>
							&lt;ns:ServiceAppointment>
								&lt;ns:ServiceVisitAppointmentHeader>
									&lt;ns:DocumentIdentificationGroup>
										&lt;ns:DocumentIdentification>
											&lt;ns:DocumentID>${obj_BookingId}&lt;/ns:DocumentID>
										&lt;/ns:DocumentIdentification>
									&lt;/ns:DocumentIdentificationGroup>
								&lt;/ns:ServiceVisitAppointmentHeader>
								&lt;ns:ServiceVisitAppointmentDetail>
									&lt;ns:Appointment>
										&lt;ns:AppointmentDateTime>${obj_DateAppointment}&lt;/ns:AppointmentDateTime>
										&lt;ns:AppointmentNotes>Please wash car. Thank you.&lt;/ns:AppointmentNotes>
										&lt;ns:AppointmentStatus>SCHEDULED&lt;/ns:AppointmentStatus>
										&lt;ns:AlternateTransportation>WAIT_AT_DEALER&lt;/ns:AlternateTransportation>
										&lt;ns:EndAppointmentDateTime>${obj_DateEndAppointment}&lt;/ns:EndAppointmentDateTime>
										&lt;ns:RequestedService>
											&lt;ns:JobNumberString>A&lt;/ns:JobNumberString>
											&lt;ns:RepeatRepairIndicator>false&lt;/ns:RepeatRepairIndicator>
											&lt;ns:JobTypeString>Customer Pay&lt;/ns:JobTypeString>
											&lt;ns:ServiceLaborScheduling>
												&lt;ns:LaborOperationID>1&lt;/ns:LaborOperationID>
												&lt;ns:LaborOperationIdTypeCode>${obj_LaborCode}&lt;/ns:LaborOperationIdTypeCode>
												&lt;ns:LaborOperationDescription>${obj_LaborDescription}&lt;/ns:LaborOperationDescription>
											&lt;/ns:ServiceLaborScheduling>
											&lt;ns:CustomerSalesRequestDescription>${obj_LaborDescription}&lt;/ns:CustomerSalesRequestDescription>
										&lt;/ns:RequestedService>
                                      	
										&lt;ns:ServiceAdvisorParty>
											&lt;ns:PartyID>${obj_PartyId}&lt;/ns:PartyID>
											&lt;ns:DealerManagementSystemID>${obj_AdvisorId}&lt;/ns:DealerManagementSystemID>
											&lt;ns:SpecifiedPerson>
												&lt;ns:GivenName>${obj_AdvisorGivenName}&lt;/ns:GivenName>
												&lt;ns:FamilyName>${obj_AdvisorFamilyName}&lt;/ns:FamilyName>
											&lt;/ns:SpecifiedPerson>
										&lt;/ns:ServiceAdvisorParty>
									&lt;/ns:Appointment>
								&lt;/ns:ServiceVisitAppointmentDetail>
							&lt;/ns:ServiceAppointment>
						&lt;/ns:ServiceVisitDetail>
					&lt;/ns:ServiceVisit>
				&lt;/ns:ProcessServiceVisitDataArea>	
			  &lt;/ns:ProcessServiceVisit>
		   &lt;/tran:content>
		&lt;/tran:payload>
      &lt;/tran:ProcessMessage>
   &lt;/soapenv:Body>
&lt;/soapenv:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>ProcessMessage</soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.Glb_Dealer_Code</defaultValue>
      <description>Dealer Code Value, Holden --> 111148</description>
      <id>3a465e54-fda5-4e78-9e05-ee0e97459087</id>
      <masked>false</masked>
      <name>obj_DealerCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_FirstName</defaultValue>
      <description>First Name --> TITAN</description>
      <id>85c129da-0769-4c1f-80b4-e8497690d37f</id>
      <masked>false</masked>
      <name>Obj_GivenName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_LastName</defaultValue>
      <description>Last Name --> DMS</description>
      <id>4cfaa8f7-532b-4ae9-91d5-6b0cb3612ef2</id>
      <masked>false</masked>
      <name>Obj_FamilyName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_DocumentId</defaultValue>
      <description></description>
      <id>e968a851-b595-4474-adac-fd4d0b39001a</id>
      <masked>false</masked>
      <name>obj_DocumentId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_LineOne</defaultValue>
      <description></description>
      <id>c09c7a65-ff6c-467f-8ac4-3ed95f0c17c2</id>
      <masked>false</masked>
      <name>obj_LineOne</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_CityName</defaultValue>
      <description></description>
      <id>98fcc536-e547-4f78-bb77-c65e527aa020</id>
      <masked>false</masked>
      <name>obj_CityName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_CountryID</defaultValue>
      <description></description>
      <id>244ce809-03af-4677-a2e4-830fb68f2eb7</id>
      <masked>false</masked>
      <name>obj_CountryId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_Postcode</defaultValue>
      <description></description>
      <id>b9e0add0-1968-41e8-96ef-efda73047ae4</id>
      <masked>false</masked>
      <name>obj_PostCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_State</defaultValue>
      <description></description>
      <id>5f137998-7395-47fe-b618-8b2c37876fa9</id>
      <masked>false</masked>
      <name>obj_State</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_ChannelCode</defaultValue>
      <description></description>
      <id>60466553-7a2f-4637-a115-eabf89bfcd85</id>
      <masked>false</masked>
      <name>obj_ChannelCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_PhoneNumber</defaultValue>
      <description></description>
      <id>d028aa84-cabe-42a6-af04-b6c0e22006aa</id>
      <masked>false</masked>
      <name>obj_PhoneNumber</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Cus_Email</defaultValue>
      <description></description>
      <id>e2bb963f-def4-4078-95b5-16e443b36823</id>
      <masked>false</masked>
      <name>obj_Email</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_veh_Model</defaultValue>
      <description></description>
      <id>b0efba2d-cb94-48f8-be2a-9039166463e4</id>
      <masked>false</masked>
      <name>obj_Model</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_veh_ModelYear</defaultValue>
      <description></description>
      <id>4574e68c-b580-41f9-ba95-b886bf9c5ef1</id>
      <masked>false</masked>
      <name>obj_ModelYear</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_veh_MakeString</defaultValue>
      <description></description>
      <id>6badc366-d6d1-4b57-b79c-37d7047020a4</id>
      <masked>false</masked>
      <name>obj_MakeString</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_veh_ManufacturerName</defaultValue>
      <description></description>
      <id>cc46092b-3dc0-462f-be58-67d7b22d0f8a</id>
      <masked>false</masked>
      <name>obj_ManufacturerName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Adv_Id</defaultValue>
      <description></description>
      <id>37e3604e-6429-40d8-a7f0-bba6a2e710dc</id>
      <masked>false</masked>
      <name>obj_AdvisorId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Adv_FirstName</defaultValue>
      <description>FirstName</description>
      <id>079cc7bc-8c1f-46cf-adb8-0895402dd71c</id>
      <masked>false</masked>
      <name>obj_AdvisorGivenName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Adv_LastName</defaultValue>
      <description>LastName</description>
      <id>e3ad26a4-666f-407e-8931-808813ad48c5</id>
      <masked>false</masked>
      <name>obj_AdvisorFamilyName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_PartyID</defaultValue>
      <description>Temporary</description>
      <id>50b8fe75-5fee-4257-a2fb-d08f03c08ddb</id>
      <masked>false</masked>
      <name>obj_PartyId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_ServiceDate</defaultValue>
      <description>Temporary</description>
      <id>2142e78e-4452-4325-b8b7-2559b4ac4d5e</id>
      <masked>false</masked>
      <name>obj_DateAppointment</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Ser_LaborCode</defaultValue>
      <description></description>
      <id>f5685a67-55c5-4e32-9534-8b53c5db9abf</id>
      <masked>false</masked>
      <name>obj_LaborCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Ser_LaborDescription</defaultValue>
      <description></description>
      <id>89fa9732-bf74-46df-a8b3-1e819559b8d6</id>
      <masked>false</masked>
      <name>obj_LaborDescription</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Booking_ID</defaultValue>
      <description></description>
      <id>574d344a-2a5d-435e-8584-08560266b5ed</id>
      <masked>false</masked>
      <name>obj_BookingId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_ServiceEndDate</defaultValue>
      <description></description>
      <id>56071a47-44c3-4b0d-8543-ac3ce043017c</id>
      <masked>false</masked>
      <name>obj_DateEndAppointment</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>5e828506-9b16-42f9-98a0-bc3e508c7b4c</id>
      <masked>false</masked>
      <name>obj_VIN</name>
   </variables>
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
   <wsdlAddress>http://hcm-dev-testing.titandms.net.au:55551/NightlyBuildManufacturerInterfacesFacade/HoldenManufacturerInterface.asmx?WSDL</wsdlAddress>
</WebServiceRequestEntity>
