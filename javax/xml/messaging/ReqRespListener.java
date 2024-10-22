package javax.xml.messaging;

import javax.xml.soap.SOAPMessage;

public interface ReqRespListener {
  SOAPMessage onMessage(SOAPMessage paramSOAPMessage);
}
