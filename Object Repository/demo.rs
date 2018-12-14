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
	     &lt;ns0:manifest version=&quot;5.6.4&quot; namespaceURI=&quot;http://www.starstandard.org/STAR/5&quot; element=&quot;SearchCustomerInformation&quot; contentID=&quot;0&quot;/>
	 &lt;/ns0:payloadManifest>
   &lt;/soapenv:Header>
   &lt;soapenv:Body>
      &lt;tran:ProcessMessage>
		&lt;!--Optional:-->
		&lt;tran:payload>
		   &lt;!--Optional:-->
		   &lt;tran:content id=&quot;0&quot;>
			  &lt;!--Optional:-->
			  &lt;ns:SearchCustomerInformation releaseID=&quot;5.6.4&quot; versionID=&quot;5.6.4&quot; systemEnvironmentCode=&quot;Test&quot; languageCode=&quot;en-US&quot;>
				 &lt;!--Optional:-->
				 &lt;ns:ApplicationArea>
					&lt;!--Optional:-->
					&lt;ns:Sender>
					   &lt;!--Optional:-->
					   &lt;ns:CreatorNameCode>GM&lt;/ns:CreatorNameCode>
					   &lt;!--Optional:-->
					   &lt;ns:SenderNameCode>OSS&lt;/ns:SenderNameCode>
					   &lt;!--Optional:-->
					   &lt;ns:DealerNumberID>299560&lt;/ns:DealerNumberID>
					   &lt;!--Optional:-->
					   &lt;ns:DealerCountryCode>US&lt;/ns:DealerCountryCode>
					   &lt;!--Optional:-->
					   &lt;ns:LanguageCode>en-US&lt;/ns:LanguageCode>
					&lt;/ns:Sender>
					&lt;ns:CreationDateTime>2016-05-17T13:21:12.582-04:00&lt;/ns:CreationDateTime>
					&lt;!--Optional:-->
					&lt;ns1:Signature/>
					&lt;!--Optional:-->
					&lt;ns:BODID>1a122bf9-558f-45a7-b2c4-bdf7396a5b60&lt;/ns:BODID>
					&lt;!--Optional:-->
					&lt;ns:Destination>
					   &lt;!--Optional:-->
					   &lt;ns:DestinationNameCode>QI&lt;/ns:DestinationNameCode>
					   &lt;!--Optional:-->
					   &lt;ns:DestinationSoftwareCode>QI&lt;/ns:DestinationSoftwareCode>
					   &lt;!--Optional:-->
					   &lt;ns:DestinationSoftware>QI&lt;/ns:DestinationSoftware>
					   &lt;ns:DealerNumberID>299560&lt;/ns:DealerNumberID>
					   &lt;!--Optional:-->
					   &lt;ns:DealerTargetCountry>US&lt;/ns:DealerTargetCountry>
					&lt;/ns:Destination>
				 &lt;/ns:ApplicationArea>
				 &lt;!--Optional:-->
				 &lt;ns:SearchCustomerInformationDataArea>
					&lt;!--Optional:-->
					&lt;ns:Get uniqueIndicator=&quot;true&quot;>
					   &lt;!--Optional:-->
					   &lt;ns1:Expression/>
					&lt;/ns:Get>
					&lt;!--Optional:-->
					&lt;ns:SearchCustomerInformationCriteria>
					   &lt;!--Optional:-->
					   &lt;ns:VehicleInfo>
						  &lt;!--Optional:-->
						  &lt;ns:Vehicle/>
					   &lt;/ns:VehicleInfo>
					   &lt;!--Optional:-->
					   &lt;ns:CustomerParty>
						  &lt;ns:SpecifiedPerson>
							 &lt;!--Optional:-->
							 &lt;ns:GivenName>QATEAM_VINHLE181208130956&lt;/ns:GivenName>
							 &lt;!--Optional:-->
							 &lt;ns:FamilyName>HOLDEN181208130956&lt;/ns:FamilyName>
						   &lt;/ns:SpecifiedPerson>
					   &lt;/ns:CustomerParty>
					&lt;/ns:SearchCustomerInformationCriteria>
				 &lt;/ns:SearchCustomerInformationDataArea>
			  &lt;/ns:SearchCustomerInformation>
			  &lt;!--Optional:-->
		   &lt;/tran:content>
            &lt;/tran:payload>
      &lt;/tran:ProcessMessage>
   &lt;/soapenv:Body>
&lt;/soapenv:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>ProcessMessage</soapServiceFunction>
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
