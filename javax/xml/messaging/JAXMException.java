package javax.xml.messaging;

import javax.xml.soap.SOAPException;




































































public class JAXMException
  extends SOAPException
{
  private Throwable cause;
  
  public JAXMException() {}
  
  public JAXMException(String paramString) {
    super(paramString);
  }











  
  public JAXMException(String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }







  
  public JAXMException(Throwable paramThrowable) {
    super(paramThrowable);
  }
}
