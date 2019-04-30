package org.json;

import java.io.IOException;
import java.io.Writer;

public class JSONWriter
{
  private static final int maxdepth = 20;
  private boolean comma = false;
  protected char mode = 'i';
  private JSONObject[] stack = new JSONObject[20];
  private int top = 0;
  protected Writer writer;
  
  public JSONWriter(Writer paramWriter)
  {
    writer = paramWriter;
  }
  
  private JSONWriter append(String paramString)
    throws JSONException
  {
    if (paramString == null) {
      throw new JSONException("Null pointer");
    }
    if ((mode == 'o') || (mode == 'a')) {
      try
      {
        if ((comma) && (mode == 'a')) {
          writer.write(44);
        }
        writer.write(paramString);
        if (mode == 'o') {
          mode = 'k';
        }
        comma = true;
        return this;
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException);
      }
    }
    throw new JSONException("Value out of sequence.");
  }
  
  private JSONWriter end(char paramChar1, char paramChar2)
    throws JSONException
  {
    if (mode != paramChar1)
    {
      if (paramChar1 == 'o') {}
      for (String str = "Misplaced endObject.";; str = "Misplaced endArray.") {
        throw new JSONException(str);
      }
    }
    pop(paramChar1);
    try
    {
      writer.write(paramChar2);
      comma = true;
      return this;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException);
    }
  }
  
  private void pop(char paramChar)
    throws JSONException
  {
    char c1 = 'a';
    if (top <= 0) {
      throw new JSONException("Nesting error.");
    }
    if (stack[(-1 + top)] == null) {}
    for (char c2 = c1; c2 != paramChar; c2 = 'k') {
      throw new JSONException("Nesting error.");
    }
    top = (-1 + top);
    if (top == 0) {
      c1 = 'd';
    }
    for (;;)
    {
      mode = c1;
      return;
      if (stack[(-1 + top)] != null) {
        c1 = 'k';
      }
    }
  }
  
  private void push(JSONObject paramJSONObject)
    throws JSONException
  {
    if (top >= 20) {
      throw new JSONException("Nesting too deep.");
    }
    stack[top] = paramJSONObject;
    if (paramJSONObject == null) {}
    for (char c = 'a';; c = 'k')
    {
      mode = c;
      top = (1 + top);
      return;
    }
  }
  
  public JSONWriter array()
    throws JSONException
  {
    if ((mode == 'i') || (mode == 'o') || (mode == 'a'))
    {
      push(null);
      append("[");
      comma = false;
      return this;
    }
    throw new JSONException("Misplaced array.");
  }
  
  public JSONWriter endArray()
    throws JSONException
  {
    return end('a', ']');
  }
  
  public JSONWriter endObject()
    throws JSONException
  {
    return end('k', '}');
  }
  
  public JSONWriter key(String paramString)
    throws JSONException
  {
    if (paramString == null) {
      throw new JSONException("Null key.");
    }
    if (mode == 'k') {
      try
      {
        if (comma) {
          writer.write(44);
        }
        stack[(-1 + top)].putOnce(paramString, Boolean.TRUE);
        writer.write(JSONObject.quote(paramString));
        writer.write(58);
        comma = false;
        mode = 'o';
        return this;
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException);
      }
    }
    throw new JSONException("Misplaced key.");
  }
  
  public JSONWriter object()
    throws JSONException
  {
    if (mode == 'i') {
      mode = 'o';
    }
    if ((mode == 'o') || (mode == 'a'))
    {
      append("{");
      push(new JSONObject());
      comma = false;
      return this;
    }
    throw new JSONException("Misplaced object.");
  }
  
  public JSONWriter value(double paramDouble)
    throws JSONException
  {
    return value(new Double(paramDouble));
  }
  
  public JSONWriter value(long paramLong)
    throws JSONException
  {
    return append(Long.toString(paramLong));
  }
  
  public JSONWriter value(Object paramObject)
    throws JSONException
  {
    return append(JSONObject.valueToString(paramObject));
  }
  
  public JSONWriter value(boolean paramBoolean)
    throws JSONException
  {
    if (paramBoolean) {}
    for (String str = "true";; str = "false") {
      return append(str);
    }
  }
}
