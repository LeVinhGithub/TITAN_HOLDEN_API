import static org.assertj.core.api.Assertions.*

import qaVinhLe.Library_Method_VinhLe
import org.w3c.dom.Document;//Convert String to XML object
import org.w3c.dom.Element;//Convert String to XML object
import org.w3c.dom.NodeList;//Convert String to XML object
import org.xml.sax.InputSource;//Convert String to XML object
import java.io.StringReader;//Convert String to XML object
import javax.xml.parsers.DocumentBuilderFactory;//Convert String to XML object
/**
 * @author ANH THY
 * 1. add sql for customer information
 */
Library_Method_VinhLe lib = new Library_Method_VinhLe()
String trValue = "<A>"+
"<B>"+
"<C>ok</C>"+
"</B>"+
"</A>"
Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(trValue)))
		NodeList errNodes = doc.getElementsByTagName("A")
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.get;
			
//			println parentnode + "." + childrennode +  ":  "+err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
//			assert expectedValue == err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
		}