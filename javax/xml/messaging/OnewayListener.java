package javax.xml.messaging;

import javax.xml.soap.SOAPMessage;

public interface OnewayListener {
  void onMessage(SOAPMessage paramSOAPMessage);
}
