package javax.xml.messaging;


























































public class URLEndpoint
  extends Endpoint
{
  public URLEndpoint(String paramString) {
    super(paramString);
  }






  
  public String getURL() {
    return this.id;
  }
}
