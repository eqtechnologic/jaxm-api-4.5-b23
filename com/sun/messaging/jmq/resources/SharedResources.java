package com.sun.messaging.jmq.resources;

import com.sun.messaging.jmq.util.MQResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;



















































public class SharedResources
  extends MQResourceBundle
{
  private static SharedResources resources = null; public static final String M_ERROR = "S0000"; public static final String M_WARNING = "S0001"; public static final String I_BANNER_LINE = "S1000"; public static final String I_VERSION = "S1001"; public static final String I_COMPILE = "S1002"; public static final String I_RIGHTS = "S1003"; public static final String I_VERSION_INFO = "S1004"; public static final String I_IMPLEMENTATION = "S1005"; public static final String I_PROTOCOL_VERSION = "S1006"; public static final String I_TARGET_JMS_VERSION = "S1007"; public static final String I_RSA_CREDIT = "S1008"; public static final String I_PATCHES = "S1009"; public static final String I_PATCH_INDENT = "S1010"; public static final String W_BAD_NFORMAT = "S2000"; public static final String W_BAD_LOGLEVELSTR = "S2001"; public static final String W_BAD_LOGSTREAM = "S2002"; public static final String W_BAD_LOGCONFIG = "S2003"; public static final String W_LOGCHANNEL_DISABLED = "S2004"; public static final String W_SET_UNCAUGHT_EX_HANDLER_FAIL = "S2005"; public static final String W_SCHEDULE_UNCAUGHT_EX_HANDLER_TASK_FAIL = "S2006"; public static final String E_BAD_LOGFILE = "S3000"; public static final String E_BAD_LOGDEVICE = "S3001"; public static final String E_LOGMESSAGE = "S3002";
  
  public static synchronized SharedResources getResources() {
    return getResources(null);
  }
  public static final String E_NO_LOGHANDLERLIST = "S3003"; public static final String E_NO_LOGHANDLER = "S3004"; public static final String E_BAD_LOGHANDLERCLASS = "S3005"; public static final String E_VERSION_PROPS = "S3006"; public static final String E_VERSION_LOAD = "S3007"; public static final String E_VERSION_INFO = "S3008"; public static final String E_CANNOT_COMPACT_ON_OPENED_FILE = "S3009"; public static final String E_VRFILE_NOT_OPEN = "S3010"; public static final String E_RENAME_TO_BACKUP_FILE_FAILED = "S3011"; public static final String E_RENAME_TO_BACKING_FILE_FAILED = "S3012"; public static final String E_DELETE_BACKUP_FILE_FAILED = "S3013"; public static final String E_BAD_FILE_MAGIC_NUMBER = "S3014"; public static final String E_BAD_VRFILE_VERSION = "S3015"; public static final String E_UNRECOGNIZED_VRECORD = "S3016"; public static final String E_UNRECOGNIZED_VRFILE_FORMAT = "S3017"; public static final String E_BAD_APPLICATION_COOKIE = "S3018"; public static final String E_UNCAUGHT_EX_IN_THREAD = "S3019"; public static final String X_DIR_CREATE = "S4000"; public static final String X_FILE_WRITE = "S4001"; public static final String X_DIR_NOT_FILE = "S4002"; public static final String X_FILE_WRITE_TIMESTAMP = "S4003"; public static final String X_FILE_READ_TIMESTAMP = "S4004"; public static final String X_BAD_PROPERTY = "S4005"; public static final String X_BAD_PORTMAPPER_VERSION = "S4006";
  
  public static synchronized SharedResources getResources(Locale paramLocale) {
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    
    if (resources == null || !paramLocale.equals(resources.getLocale())) {
      ResourceBundle resourceBundle = ResourceBundle.getBundle("com.sun.messaging.jmq.resources.SharedResources", paramLocale);


      
      resources = new SharedResources(resourceBundle);
    } 
    return resources;
  }
  
  private SharedResources(ResourceBundle paramResourceBundle) {
    super(paramResourceBundle);
  }
}
