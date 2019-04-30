package org.json;

import java.io.StringWriter;

public class JSONStringer
  extends JSONWriter
{
  public JSONStringer()
  {
    super(new StringWriter());
  }
  
  public String toString()
  {
    if (mode == 'd') {
      return writer.toString();
    }
    return null;
  }
}
