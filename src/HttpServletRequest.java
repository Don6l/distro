import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {

  Map<String, String> paramsMap = new HashMap<String, String>();

  public HttpServletRequest(String params) {
    String[] paramsArray = params.split("&");
    for (String param : paramsArray) {
      String[] nvPair = param.split("=");
      paramsMap.put(nvPair[0], nvPair[1]) ;
    }
  }

  String getParameter(String key) {
    return paramsMap.get(key) ;
  }
}
