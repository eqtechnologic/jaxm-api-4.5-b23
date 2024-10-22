package javax.xml.messaging;

import com.sun.messaging.AdministeredObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.MissingResourceException;
import java.util.Properties;























































class FactoryFinder
{
  private static Object newInstance(String paramString, ClassLoader paramClassLoader) throws JAXMException {
    String str = "";
    try {
      str = AdministeredObject.cr.getKString("C4200", paramString);
    } catch (MissingResourceException missingResourceException) {}
    
    try {
      Class<?> clazz;
      
      if (paramClassLoader == null) {
        clazz = Class.forName(paramString);
      } else {
        clazz = paramClassLoader.loadClass(paramString);
      } 
      return clazz.newInstance();
    } catch (ClassNotFoundException classNotFoundException) {
      throw new JAXMException(str);
    }
    catch (Exception exception) {
      throw new JAXMException(str);
    } 
  }
























  
  static Object find(String paramString1, String paramString2) throws JAXMException {
    ClassLoader classLoader;
    try {
      classLoader = Thread.currentThread().getContextClassLoader();
    } catch (Exception exception) {
      throw new JAXMException(exception.toString(), exception);
    } 

    
    try {
      String str1 = System.getProperty(paramString1);
      
      if (str1 != null) {
        return newInstance(str1, classLoader);
      }
    } catch (SecurityException securityException) {}


    
    try {
      String str1 = System.getProperty("java.home");
      String str2 = str1 + File.separator + "lib" + File.separator + "jaxm.properties";
      
      File file = new File(str2);
      if (file.exists()) {
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        String str3 = properties.getProperty(paramString1);
        return newInstance(str3, classLoader);
      } 
    } catch (Exception exception) {}

    
    String str = "META-INF/services/" + paramString1;
    
    try {
      InputStream inputStream = null;
      if (classLoader == null) {
        inputStream = ClassLoader.getSystemResourceAsStream(str);
      } else {
        inputStream = classLoader.getResourceAsStream(str);
      } 
      
      if (inputStream != null) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        
        String str1 = bufferedReader.readLine();
        bufferedReader.close();
        
        if (str1 != null && !"".equals(str1))
        {
          return newInstance(str1, classLoader);
        }
      } 
    } catch (Exception exception) {}

    
    if (paramString2 == null) {
      throw new JAXMException("Provider for " + paramString1 + " cannot be found", null);
    }

    
    return newInstance(paramString2, classLoader);
  }
}
