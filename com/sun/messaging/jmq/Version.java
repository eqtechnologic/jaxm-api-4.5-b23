package com.sun.messaging.jmq;

import com.sun.messaging.jmq.resources.SharedResources;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.StringTokenizer;























































public class Version
{
  private static String[] patchTermsList = new String[] { "SP", "UR", "_", "U", "PATCH", "UPDATE" };



  
  private static HashSet patchTerms = new HashSet();

  
  static {
    for (byte b = 0; b < patchTermsList.length; b++) {
      try {
        patchTerms.add(patchTermsList[b]);
      } catch (Exception exception) {
        
        System.out.println("Version: Could not add patch term " + patchTermsList[b] + ": " + exception);
      } 
    } 
  }




  
  private String propname = "/com/sun/messaging/jmq/version.properties";
  private String comm_propname = "/com/sun/messaging/jmq/brand_version.properties";



  
  private static String imqhome_propname = "imq.home";



  
  private static final String IMQ_HOME = System.getProperty(imqhome_propname, ".");



  
  private static final String PATCHIDFILE = IMQ_HOME + File.separator + "patches" + File.separator + "VERSION";



  
  private Properties props = null;



  
  private String miniCopyright = "Copyright (c) 2010, Oracle and/or its affiliates.  All rights reserved.";




  
  private String shortCopyright = "Copyright (c) 2010, Oracle and/or its affiliates.  All rights reserved.";




























































  
  private String longCopyright = "Copyright (c) 2010, Oracle and/or its affiliates.  All rights reserved.";



























  
  public static final int MINI_COPYRIGHT = 0;



























  
  public static final int SHORT_COPYRIGHT = 1;


























  
  public static final int LONG_COPYRIGHT = 2;


























  
  private static String thisPackage = "com.sun.messaging";



  
  private static SharedResources rb = SharedResources.getResources();

  
  private boolean isJar = false;


  
  public Version() {
    this(true);
  }
  
  public Version(boolean paramBoolean) {
    this.isJar = paramBoolean;
    try {
      InputStream inputStream = getClass().getResourceAsStream(this.propname);
      if (inputStream == null) {
        System.err.println(rb.getString("S3006"));
      }
      this.props = new Properties();
      this.props.load(inputStream);




      
      inputStream = getClass().getResourceAsStream(this.comm_propname);
      if (inputStream != null) {
        this.props.load(inputStream);
      }
    }
    catch (Exception exception) {
      System.err.println(rb.getString("S3007"));
      exception.printStackTrace();
    } 
  }








  
  public Properties getProps() {
    return this.props;
  }






  
  public String getProductVersion() {
    return this.props.getProperty("imq.product.version");
  }






  
  public int getMajorVersion() {
    try {
      return Integer.parseInt(this.props.getProperty("imq.product.major"));
    } catch (Exception exception) {
      return -1;
    } 
  }







  
  public int getMinorVersion() {
    try {
      return Integer.parseInt(this.props.getProperty("imq.product.minor"));
    } catch (Exception exception) {
      return -1;
    } 
  }








  
  public String getVersionProperty(String paramString) {
    return this.props.getProperty(paramString);
  }






  
  public String getBuildMilestone() {
    String str = this.props.getProperty("imq.build.milestone");
    if ("FCS".equals(str)) {
      return "";
    }
    return str;
  }








  
  public String getBuildDate() {
    return this.props.getProperty("imq.build.date");
  }







  
  public String getBuildVersion() {
    return this.props.getProperty("imq.product.version") + " " + getBuildMilestone() + " (Build " + this.props.getProperty("imq.build.number") + "-" + this.props.getProperty("imq.build.letter") + ")";
  }






  
  public String getProductName() {
    if (this.isJar)
      return this.props.getProperty("imq.product.jarname"); 
    return this.props.getProperty("imq.product.name");
  }



  
  public String getReleaseQID() {
    return this.props.getProperty("imq.product.releaseqid");
  }







  
  public String getAbbreviatedProductName() {
    return this.props.getProperty("imq.product.name.abbrev");
  }







  
  public String getLowerCaseAbbreviatedProductName() {
    return this.props.getProperty("imq.product.name.abbrev.lowercase");
  }






  
  public String getShortProductName() {
    return this.props.getProperty("imq.product.name.short");
  }






  
  public String getProductCopyrightDate() {
    return this.props.getProperty("imq.product.copyright.date");
  }






  
  public String getProductCompanyName() {
    return this.props.getProperty("imq.product.companyname");
  }






  
  public String getVersionPackageName() {
    return this.props.getProperty("imq.version.package");
  }




  
  public String getImplementationVersion() {
    return this.props.getProperty("imq.api.version");
  }









  
  public String getProtocolVersion() {
    return this.props.getProperty("imq.protocol.version");
  }




  
  public String getTargetJMSVersion() {
    return this.props.getProperty("imq.jms.api.version");
  }





  
  public boolean isCommercialProduct() {
    boolean bool = false;
    
    String str = this.props.getProperty("imq.product.brand");
    
    return Boolean.parseBoolean(str);
  }




  
  public boolean isProductValid() {
    if (!isCommercialProduct()) return true;
    
    int i = getMajorVersion();
    int j = getMinorVersion();

    
    int k = -1;
    int m = -1;
    try {
      k = Integer.parseInt(this.props.getProperty("imq.product.brand.major"));
      m = Integer.parseInt(this.props.getProperty("imq.product.brand.minor"));
    } catch (Exception exception) {}
    
    return (k == i && m == j);
  }











  
  public String getUserAgent() {
    return getShortProductName() + "/" + getProductVersion() + " " + "(JMS; " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch") + ")";
  }










  
  public String toString() {
    return getBanner(false);
  }



















  
  public String getHeader() {
    return getHeader(2);
  }







  
  public String getHeader(int paramInt) {
    return rb.getString("S1000") + getProductName() + " " + getReleaseQID() + SharedResources.NL + getProductCompanyName() + SharedResources.NL + rb.getString("S1001") + getBuildVersion() + SharedResources.NL + rb.getString("S1002") + getBuildDate() + SharedResources.NL + SharedResources.NL + getCopyright(paramInt) + SharedResources.NL + rb.getString("S1000");
  }

















  
  public String getRAVersion() {
    return rb.getString("S1001") + getBuildVersion() + " " + rb.getString("S1002") + getBuildDate();
  }








  
  public String getCopyright(int paramInt) {
    switch (paramInt) {
      case 0:
        return this.miniCopyright;
      case 1:
        return this.shortCopyright;
      case 2:
        return this.longCopyright;
    } 
    return this.shortCopyright;
  }









  
  public String[] getPatchIds() {
    File file = new File(PATCHIDFILE);

    
    if (!file.exists()) {
      return null;
    }

    
    if (!file.canRead()) {
      return null;
    }


    
    Properties properties = new Properties();
    
    try {
      FileInputStream fileInputStream = new FileInputStream(PATCHIDFILE);
      properties.load(fileInputStream);
    } catch (Exception exception) {
      return null;
    } 

    
    String str = getMajorVersion() + "." + getMinorVersion();




























    
    String[] arrayOfString1 = new String[1000];
    
    byte b1 = 0;
    for (byte b2 = 1; b2 < arrayOfString1.length; b2++) {
      String str1 = properties.getProperty(str + "_" + b2);
      if (str1 == null)
        break; 
      arrayOfString1[b1++] = str1;
    } 



    
    String[] arrayOfString2 = new String[b1];
    for (byte b3 = 0; b3 < b1; b3++) {
      arrayOfString2[b3] = arrayOfString1[b3];
    }
    
    return arrayOfString2;
  }










  
  public String getPatchString() {
    String[] arrayOfString = getPatchIds();
    String str = "";
    
    if (arrayOfString == null) {
      str = "";
    } else if (arrayOfString.length == 0) {
      str = "";
    } else if (arrayOfString.length >= 1) {
      for (byte b = 0; b < arrayOfString.length && 
        arrayOfString[b] != null; b++) {
        
        if (str.equals("")) {
          str = str + rb.getString("S1009") + arrayOfString[b] + SharedResources.NL;
        } else if (arrayOfString[b] != null) {
          str = str + rb.getString("S1010") + arrayOfString[b] + SharedResources.NL;
        } 
      } 
    } 
    
    return str;
  }







  
  public String getJMSAdminSpiVersion() {
    return this.props.getProperty("imq.jmsadmin.spi.version");
  }






  
  public String getVersion() {
    return getVersionPackageName() + rb.getString("S1004") + rb.getString("S1005") + getImplementationVersion() + SharedResources.NL + rb.getString("S1006") + getProtocolVersion() + SharedResources.NL + rb.getString("S1007") + getTargetJMSVersion() + SharedResources.NL + getPatchString();
  }











  
  public String getBanner(boolean paramBoolean) {
    return getBanner(paramBoolean, 1);
  }








  
  public String getBanner(boolean paramBoolean, int paramInt) {
    if (this.props == null) {
      return rb.getString("S3008") + thisPackage;
    }
    if (paramBoolean) return getHeader(paramInt) + getVersion(); 
    return getHeader(paramInt);
  }








































  
  public static int[] getIntVersion(String paramString) throws NumberFormatException {
    int[] arrayOfInt = new int[4];

    
    String str1 = stripTrailingLetters(paramString.toUpperCase().trim());
    Object object = null;

    
    StringTokenizer stringTokenizer = new StringTokenizer(str1, ".");
    String str2 = "";
    
    byte b = 0;
    while (stringTokenizer.hasMoreTokens() && b < 4)
    { str2 = stringTokenizer.nextToken();

      
      try {
        arrayOfInt[b] = Integer.parseInt(str2);
        b++; continue;
      } catch (NumberFormatException numberFormatException) {
        int i = 0;


        
        if (Character.isDigit(str2.charAt(i))) {
          String str3 = getNumber(str2);
          try {
            arrayOfInt[b] = Integer.parseInt(str3);
            b++;
          } catch (NumberFormatException numberFormatException1) {
            
            System.out.println("Can't parse " + str2 + ": " + numberFormatException);
          } 
          
          i += str3.length();
          
          str2 = str2.substring(i);
        } 


        
        for (i = 0; i < str2.length() && 
          !Character.isDigit(str2.charAt(i)); i++);




        
        String str = str2.substring(0, i).trim();
        if (patchTerms.contains(str)) {
          
          String str3 = str2.substring(i);
          str3 = getNumber(str3);
          try {
            arrayOfInt[3] = Integer.parseInt(str3);
          } catch (NumberFormatException numberFormatException1) {}
        } 
      } 




      
      return arrayOfInt; }  return arrayOfInt;
  }




  
  static String getNumber(String paramString) {
    byte b;
    for (b = 0; b < paramString.length(); b++) {
      
      if (!Character.isDigit(paramString.charAt(b))) {
        break;
      }
    } 
    return paramString.substring(0, b);
  }










  
  private static String stripTrailingLetters(String paramString) {
    boolean bool = false;

    
    int i = paramString.length() - 1;
    while (!Character.isDigit(paramString.charAt(i)))
    {
      i--;
    }
    
    if (i == paramString.length() - 1)
    {
      return paramString;
    }
    return paramString.substring(0, i + 1);
  }













  
  public static int compareVersions(String paramString1, String paramString2) {
    return compareVersions(paramString1, paramString2, true);
  }














  
  public static int compareVersions(String paramString1, String paramString2, boolean paramBoolean) throws NumberFormatException {
    int[] arrayOfInt1 = getIntVersion(paramString1);
    int[] arrayOfInt2 = getIntVersion(paramString2);
    if (paramBoolean) {
      arrayOfInt1[3] = 0;
      arrayOfInt2[3] = 0;
    } 
    return compareVersions(arrayOfInt1, arrayOfInt2);
  }















  
  public static int compareVersions(int[] paramArrayOfint1, int[] paramArrayOfint2) {
    int i = (paramArrayOfint1.length > paramArrayOfint2.length) ? paramArrayOfint1.length : paramArrayOfint2.length;
    
    byte b = 0;
    
    while (b < i) {
      byte b1 = (paramArrayOfint1.length > b) ? paramArrayOfint1[b] : 0;
      byte b2 = (paramArrayOfint2.length > b) ? paramArrayOfint2[b] : 0;
      if (b1 > b2)
        return 1; 
      if (b1 < b2)
        return -1; 
      b++;
    } 
    
    return 0;
  }








  
  public static String toVersionString(int[] paramArrayOfint) {
    String str = "";
    for (byte b = 0; b < paramArrayOfint.length; b++) {
      str = str + paramArrayOfint[b];
      if (b + 1 < paramArrayOfint.length)
        str = str + "."; 
    } 
    return str;
  }








  
  public static void main(String[] paramArrayOfString) {
    Version version = new Version();
    System.out.println(version);
  }
}
