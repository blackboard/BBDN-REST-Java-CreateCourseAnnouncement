package bbdn.rest.util;

import java.util.Arrays;
import java.util.Iterator;

public abstract class UrlUtil {

  public static String processFields(String endpoint, String[] fields) {
    if(fields == null) {
      return endpoint;
    }

    Iterator<String> iterator = Arrays.asList(fields).iterator();

    endpoint += "?fields=";



    while(iterator.hasNext()) {
      endpoint += iterator.next();
      if(iterator.hasNext()) {
        endpoint += ",";
      }
    }

    return endpoint;
  }
}
