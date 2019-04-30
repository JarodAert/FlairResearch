package lu.uni.serval.icc_delete1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class IsolateProvider
  extends ContentProvider
{
  String NAME = "lu.uni.serval.icc_delete1";
  String URL = "content://" + NAME + "/isolate";
  
  public IsolateProvider() {}
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i;
    if ((paramUri.toString().equals(URL)) && (paramString.contains("deviceid"))) {
      i = paramArrayOfString.length;
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return 1;
      }
      Log.i("DroidBench", paramArrayOfString[j]);
    }
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}
