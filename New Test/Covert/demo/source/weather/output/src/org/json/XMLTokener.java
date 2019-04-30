package org.json;

import java.util.HashMap;

public class XMLTokener
  extends JSONTokener
{
  public static final HashMap entity = new HashMap(8);
  
  static
  {
    entity.put("amp", XML.AMP);
    entity.put("apos", XML.APOS);
    entity.put("gt", XML.GT);
    entity.put("lt", XML.LT);
    entity.put("quot", XML.QUOT);
  }
  
  public XMLTokener(String paramString)
  {
    super(paramString);
  }
  
  public String nextCDATA()
    throws JSONException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    do
    {
      char c = next();
      if (c == 0) {
        throw syntaxError("Unclosed CDATA");
      }
      localStringBuffer.append(c);
      i = -3 + localStringBuffer.length();
    } while ((i < 0) || (localStringBuffer.charAt(i) != ']') || (localStringBuffer.charAt(i + 1) != ']') || (localStringBuffer.charAt(i + 2) != '>'));
    localStringBuffer.setLength(i);
    return localStringBuffer.toString();
  }
  
  public Object nextContent()
    throws JSONException
  {
    char c;
    do
    {
      c = next();
    } while (Character.isWhitespace(c));
    if (c == 0) {
      return null;
    }
    if (c == '<') {
      return XML.LT;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if ((c == '<') || (c == 0))
    {
      back();
      return localStringBuffer.toString().trim();
    }
    if (c == '&') {
      localStringBuffer.append(nextEntity(c));
    }
    for (;;)
    {
      c = next();
      break;
      localStringBuffer.append(c);
    }
  }
  
  public Object nextEntity(char paramChar)
    throws JSONException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    char c;
    for (;;)
    {
      c = next();
      if ((!Character.isLetterOrDigit(c)) && (c != '#')) {
        break;
      }
      localStringBuffer.append(Character.toLowerCase(c));
    }
    String str;
    if (c == ';')
    {
      str = localStringBuffer.toString();
      Object localObject = entity.get(str);
      if (localObject != null) {
        return localObject;
      }
    }
    else
    {
      throw syntaxError("Missing ';' in XML entity: &" + localStringBuffer);
    }
    return paramChar + str + ";";
  }
  
  public Object nextMeta()
    throws JSONException
  {
    char c1;
    do
    {
      c1 = next();
    } while (Character.isWhitespace(c1));
    switch (c1)
    {
    }
    for (;;)
    {
      char c3 = next();
      if (Character.isWhitespace(c3))
      {
        return Boolean.TRUE;
        throw syntaxError("Misshaped meta tag");
        return XML.LT;
        return XML.GT;
        return XML.SLASH;
        return XML.EQ;
        return XML.BANG;
        return XML.QUEST;
        char c2;
        do
        {
          c2 = next();
          if (c2 == 0) {
            throw syntaxError("Unterminated string");
          }
        } while (c2 != c1);
        return Boolean.TRUE;
      }
      switch (c3)
      {
      }
    }
    back();
    return Boolean.TRUE;
  }
  
  public Object nextToken()
    throws JSONException
  {
    char c1;
    do
    {
      c1 = next();
    } while (Character.isWhitespace(c1));
    StringBuffer localStringBuffer2;
    switch (c1)
    {
    default: 
      localStringBuffer2 = new StringBuffer();
    }
    for (;;)
    {
      localStringBuffer2.append(c1);
      c1 = next();
      if (Character.isWhitespace(c1))
      {
        return localStringBuffer2.toString();
        throw syntaxError("Misshaped element");
        throw syntaxError("Misplaced '<'");
        return XML.GT;
        return XML.SLASH;
        return XML.EQ;
        return XML.BANG;
        return XML.QUEST;
        StringBuffer localStringBuffer1 = new StringBuffer();
        for (;;)
        {
          char c2 = next();
          if (c2 == 0) {
            throw syntaxError("Unterminated string");
          }
          if (c2 == c1) {
            return localStringBuffer1.toString();
          }
          if (c2 == '&') {
            localStringBuffer1.append(nextEntity(c2));
          } else {
            localStringBuffer1.append(c2);
          }
        }
      }
      switch (c1)
      {
      }
    }
    return localStringBuffer2.toString();
    back();
    return localStringBuffer2.toString();
    throw syntaxError("Bad character in a name");
  }
  
  public boolean skipPast(String paramString)
    throws JSONException
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i];
    int j = 0;
    int k;
    int i2;
    for (;;)
    {
      if (j < i)
      {
        int i3 = next();
        if (i3 == 0) {
          return false;
        }
        arrayOfChar[j] = i3;
        j++;
        continue;
        arrayOfChar[k] = i2;
        k++;
        if (k >= i) {
          k -= i;
        }
      }
    }
    for (;;)
    {
      int m = k;
      int n = 0;
      label71:
      if (n < i) {
        if (arrayOfChar[m] == paramString.charAt(n)) {}
      }
      for (int i1 = 0;; i1 = 1)
      {
        if (i1 != 0)
        {
          return true;
          m++;
          if (m >= i) {
            m -= i;
          }
          n++;
          break label71;
        }
        i2 = next();
        if (i2 != 0) {
          break;
        }
        return false;
      }
      k = 0;
    }
  }
}
