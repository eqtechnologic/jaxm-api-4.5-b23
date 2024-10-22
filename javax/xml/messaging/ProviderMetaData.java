package javax.xml.messaging;

public interface ProviderMetaData {
  String getName();
  
  int getMajorVersion();
  
  int getMinorVersion();
  
  String[] getSupportedProfiles();
}
