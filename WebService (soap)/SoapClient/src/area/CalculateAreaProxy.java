package area;

public class CalculateAreaProxy implements area.CalculateArea {
  private String _endpoint = null;
  private area.CalculateArea calculateArea = null;
  
  public CalculateAreaProxy() {
    _initCalculateAreaProxy();
  }
  
  public CalculateAreaProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculateAreaProxy();
  }
  
  private void _initCalculateAreaProxy() {
    try {
      calculateArea = (new area.CalculateAreaServiceLocator()).getCalculateArea();
      if (calculateArea != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculateArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculateArea)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculateArea != null)
      ((javax.xml.rpc.Stub)calculateArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public area.CalculateArea getCalculateArea() {
    if (calculateArea == null)
      _initCalculateAreaProxy();
    return calculateArea;
  }
  
  public double areaTriangle(double side1, double side2, double side3) throws java.rmi.RemoteException{
    if (calculateArea == null)
      _initCalculateAreaProxy();
    return calculateArea.areaTriangle(side1, side2, side3);
  }
  
  
}