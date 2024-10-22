package com.sun.messaging;

import com.sun.messaging.jmq.Version;
import java.util.Properties;























































public class Version
{
  private Version version = null;





  
  public static final int MINI_COPYRIGHT = 0;




  
  public static final int SHORT_COPYRIGHT = 1;




  
  public static final int LONG_COPYRIGHT = 2;





  
  public Version() {
    this.version = new Version(false);
  }








  
  public Properties getProps() {
    return this.version.getProps();
  }







  
  public String getProductVersion() {
    return this.version.getProductVersion();
  }






  
  public int getMajorVersion() {
    return this.version.getMajorVersion();
  }






  
  public int getMinorVersion() {
    return this.version.getMinorVersion();
  }









  
  public String getVersionProperty(String paramString) {
    return this.version.getVersionProperty(paramString);
  }







  
  public String getBuildMilestone() {
    return this.version.getBuildMilestone();
  }








  
  public String getBuildDate() {
    return this.version.getBuildDate();
  }








  
  public String getBuildVersion() {
    return this.version.getBuildVersion();
  }




  
  public String getProductName() {
    return this.version.getProductName();
  }




  
  public String getReleaseQID() {
    return this.version.getReleaseQID();
  }








  
  public String getAbbreviatedProductName() {
    return this.version.getAbbreviatedProductName();
  }








  
  public String getLowerCaseAbbreviatedProductName() {
    return this.version.getLowerCaseAbbreviatedProductName();
  }







  
  public String getShortProductName() {
    return this.version.getShortProductName();
  }







  
  public String getProductCopyrightDate() {
    return this.version.getProductCopyrightDate();
  }







  
  public String getProductCompanyName() {
    return this.version.getProductCompanyName();
  }







  
  public String getVersionPackageName() {
    return this.version.getVersionPackageName();
  }




  
  public String getImplementationVersion() {
    return this.version.getImplementationVersion();
  }










  
  public String getProtocolVersion() {
    return this.version.getProtocolVersion();
  }




  
  public String getTargetJMSVersion() {
    return this.version.getTargetJMSVersion();
  }











  
  public String getUserAgent() {
    return this.version.getUserAgent();
  }








  
  public String toString() {
    return this.version.toString();
  }





















  
  public String getHeader() {
    return this.version.getHeader();
  }








  
  public String getHeader(int paramInt) {
    return this.version.getHeader(paramInt);
  }









  
  public String getCopyright(int paramInt) {
    return this.version.getCopyright(paramInt);
  }









  
  public String[] getPatchIds() {
    return this.version.getPatchIds();
  }










  
  public String getPatchString() {
    return this.version.getPatchString();
  }








  
  public String getJMSAdminSpiVersion() {
    return this.version.getJMSAdminSpiVersion();
  }






  
  public String getVersion() {
    return this.version.getVersion();
  }








  
  public String getBanner(boolean paramBoolean) {
    return this.version.getBanner(paramBoolean);
  }









  
  public String getBanner(boolean paramBoolean, int paramInt) {
    return this.version.getBanner(paramBoolean, paramInt);
  }
























  
  public static int[] getIntVersion(String paramString) throws NumberFormatException {
    return Version.getIntVersion(paramString);
  }














  
  public static int compareVersions(String paramString1, String paramString2) {
    return compareVersions(paramString1, paramString2, true);
  }















  
  public static int compareVersions(String paramString1, String paramString2, boolean paramBoolean) throws NumberFormatException {
    return Version.compareVersions(paramString1, paramString2, paramBoolean);
  }















  
  public static int compareVersions(int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return Version.compareVersions(paramArrayOfint1, paramArrayOfint2);
  }










  
  public static String toVersionString(int[] paramArrayOfint) {
    return Version.toVersionString(paramArrayOfint);
  }









  
  public static void main(String[] paramArrayOfString) {
    Version.main(paramArrayOfString);
  }
}
