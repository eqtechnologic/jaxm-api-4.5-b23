package javax.xml.messaging;

import com.sun.messaging.AdministeredObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;




























































public abstract class JAXMServlet
  extends HttpServlet
{
  protected MessageFactory msgFactory = null;











  
  public void init(ServletConfig paramServletConfig) throws ServletException {
    super.init(paramServletConfig);
    
    try {
      this.msgFactory = MessageFactory.newInstance();
    } catch (SOAPException sOAPException) {
      String str = AdministeredObject.cr.getKString("C4201");
      throw new ServletException(str + "\n" + sOAPException.getMessage());
    } 
  }














  
  public void setMessageFactory(MessageFactory paramMessageFactory) {
    this.msgFactory = paramMessageFactory;
  }











  
  protected static MimeHeaders getHeaders(HttpServletRequest paramHttpServletRequest) {
    Enumeration<String> enumeration = paramHttpServletRequest.getHeaderNames();
    MimeHeaders mimeHeaders = new MimeHeaders();
    
    while (enumeration.hasMoreElements()) {
      String str1 = enumeration.nextElement();
      String str2 = paramHttpServletRequest.getHeader(str1);
      
      StringTokenizer stringTokenizer = new StringTokenizer(str2, ",");
      while (stringTokenizer.hasMoreTokens()) {
        mimeHeaders.addHeader(str1, stringTokenizer.nextToken().trim());
      }
    } 
    return mimeHeaders;
  }












  
  protected static void putHeaders(MimeHeaders paramMimeHeaders, HttpServletResponse paramHttpServletResponse) {
    Iterator<MimeHeader> iterator = paramMimeHeaders.getAllHeaders();
    while (iterator.hasNext()) {
      MimeHeader mimeHeader = iterator.next();
      
      String[] arrayOfString = paramMimeHeaders.getHeader(mimeHeader.getName());
      if (arrayOfString.length == 1) {
        paramHttpServletResponse.setHeader(mimeHeader.getName(), mimeHeader.getValue());
        continue;
      } 
      StringBuffer stringBuffer = new StringBuffer();
      byte b = 0;
      while (b < arrayOfString.length) {
        if (b != 0)
          stringBuffer.append(','); 
        stringBuffer.append(arrayOfString[b++]);
      } 
      
      paramHttpServletResponse.setHeader(mimeHeader.getName(), stringBuffer.toString());
    } 
  }






















  
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
    try {
      MimeHeaders mimeHeaders = getHeaders(paramHttpServletRequest);

      
      ServletInputStream servletInputStream = paramHttpServletRequest.getInputStream();


      
      SOAPMessage sOAPMessage1 = this.msgFactory.createMessage(mimeHeaders, (InputStream)servletInputStream);
      
      SOAPMessage sOAPMessage2 = null;

      
      if (this instanceof ReqRespListener) {
        sOAPMessage2 = ((ReqRespListener)this).onMessage(sOAPMessage1);
      } else if (this instanceof OnewayListener) {
        ((OnewayListener)this).onMessage(sOAPMessage1);
      } else {
        String str = AdministeredObject.cr.getKString("C4202", getClass().getName());
        
        throw new ServletException(str);
      } 



      
      if (sOAPMessage2 != null) {




        
        if (sOAPMessage2.saveRequired()) {
          sOAPMessage2.saveChanges();
        }
        
        paramHttpServletResponse.setStatus(200);
        
        putHeaders(sOAPMessage2.getMimeHeaders(), paramHttpServletResponse);

        
        ServletOutputStream servletOutputStream = paramHttpServletResponse.getOutputStream();
        sOAPMessage2.writeTo((OutputStream)servletOutputStream);
        
        servletOutputStream.flush();
      } else {
        
        paramHttpServletResponse.setStatus(204);
      } 
    } catch (Exception exception) {
      String str = AdministeredObject.cr.getKString("C4203");
      throw new ServletException(str + "\n" + exception.getMessage());
    } 
  }
}
