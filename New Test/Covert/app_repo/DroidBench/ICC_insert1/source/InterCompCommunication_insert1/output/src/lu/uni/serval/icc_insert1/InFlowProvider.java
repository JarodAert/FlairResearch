package lu.uni.serval.icc_insert1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class InFlowProvider
  extends ContentProvider
{
  String NAME = "lu.uni.serval.icc_insert1";
  String URL = "content://" + NAME + "/deviceid";
  
  public InFlowProvider() {}
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramUri.toString().equals(URL)) {
      Log.i("DroidBench", paramContentValues.getAsString("DroidBench"));
    }
    return paramUri;
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
