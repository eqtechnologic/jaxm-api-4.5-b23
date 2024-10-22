package javax.xml.messaging;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

public interface ProviderConnection {
  ProviderMetaData getMetaData() throws JAXMException;
  
  void close() throws JAXMException;
  
  MessageFactory createMessageFactory(String paramString) throws JAXMException;
  
  void send(SOAPMessage paramSOAPMessage) throws JAXMException;
}
