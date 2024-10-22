package com.sun.messaging.jmq.util;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


























































public class MQResourceBundle
  extends ResourceBundle
{
  public static final String NL = System.getProperty("line.separator", "\n");
  
  private ResourceBundle rb = null;
  private boolean convertEOL = false;
  private static String UnixEOL = "\n";
  
  private HashMap cache = null;
  
  private static boolean DEBUG = false;
  
  public MQResourceBundle(ResourceBundle paramResourceBundle) {
    this.rb = paramResourceBundle;
    String str = System.getProperty("line.separator");


    
    if (!str.equals(UnixEOL)) {
      this.convertEOL = true;
      this.cache = new HashMap<Object, Object>();
      if (DEBUG) {
        System.out.println(getClass().getName() + ": Will convert messages to use native EOL.");
      }
    } 
  }










  
  public Object handleGetObject(String paramString) {
    if (this.convertEOL) {


      
      Object object = null;
      synchronized (this.cache) {
        object = this.cache.get(paramString);
        if (object == null) {
          
          object = this.rb.getObject(paramString);
          if (object instanceof String) {
            object = unix2native((String)object);
            this.cache.put(paramString, object);
          } 
        } 
      } 
      return object;
    } 
    return this.rb.getObject(paramString);
  }















  
  public String getString(String paramString, Object paramObject) throws MissingResourceException {
    if (paramObject instanceof Object[]) {
      return MessageFormat.format(getString(paramString), (Object[])paramObject);
    }
    Object[] arrayOfObject = { paramObject };
    
    return MessageFormat.format(getString(paramString), arrayOfObject);
  }












  
  public String getString(String paramString, Object paramObject1, Object paramObject2) throws MissingResourceException {
    Object[] arrayOfObject = { paramObject1, paramObject2 };
    
    return MessageFormat.format(getString(paramString), arrayOfObject);
  }











  
  public String getString(String paramString, Object[] paramArrayOfObject) throws MissingResourceException {
    return MessageFormat.format(getString(paramString), paramArrayOfObject);
  }

















  
  public String getKString(String paramString) throws MissingResourceException {
    return "[" + paramString + "]: " + getString(paramString);
  }










  
  public String getKString(String paramString, Object paramObject) throws MissingResourceException {
    return "[" + paramString + "]: " + getString(paramString, paramObject);
  }











  
  public String getKString(String paramString, Object paramObject1, Object paramObject2) throws MissingResourceException {
    return "[" + paramString + "]: " + getString(paramString, paramObject1, paramObject2);
  }










  
  public String getKString(String paramString, Object[] paramArrayOfObject) throws MissingResourceException {
    return "[" + paramString + "]: " + getString(paramString, paramArrayOfObject);
  }












  
  public char getChar(String paramString) throws MissingResourceException {
    boolean bool;
    String str = getString(paramString);

    
    try {
      bool = str.charAt(0);
    } catch (Exception exception) {
      bool = false;
    } 
    
    return bool;
  }









  
  public String getCString(String paramString) throws MissingResourceException {
    return getString(paramString) + ":";
  }





  
  public static String unix2native(String paramString) {
    boolean bool = false;
    StringBuffer stringBuffer = null;
    String str = System.getProperty("line.separator");
    
    int i = 0;
    
    if (paramString == null) return "<null>";

    
    if (str.equals("\n")) return paramString;

    
    for (byte b = 0; b < paramString.length(); b++) {
      if (paramString.charAt(b) == '\n') {
        if (stringBuffer == null)
        {
          stringBuffer = new StringBuffer(2 * paramString.length());
        }
        stringBuffer.append(paramString.substring(i, b));
        stringBuffer.append(str);
        i = b + 1;
      } 
    } 
    
    if (stringBuffer != null) {
      
      if (i < paramString.length()) {
        stringBuffer.append(paramString.substring(i, paramString.length()));
      }
      return stringBuffer.toString();
    } 
    
    return paramString;
  }


  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    
    stringBuffer.append(getClass().getName() + ": convertEOL=" + this.convertEOL);
    
    if (this.convertEOL && 
      this.cache != null) {
      stringBuffer.append(" cache=" + this.cache.toString());
      stringBuffer.append("\n");
    } 
    
    stringBuffer.append(" resourceBundle=" + this.rb.toString());
    
    return stringBuffer.toString();
  }
  
  public Enumeration getKeys() {
    return this.rb.getKeys();
  }
  
  public Locale getLocale() {
    return this.rb.getLocale();
  }
}
