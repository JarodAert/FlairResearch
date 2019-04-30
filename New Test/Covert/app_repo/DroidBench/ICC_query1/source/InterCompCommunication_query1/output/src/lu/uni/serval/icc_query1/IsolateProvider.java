package lu.uni.serval.icc_query1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class IsolateProvider
  extends ContentProvider
{
  String NAME = "lu.uni.serval.icc_query1";
  String URL = "content://" + NAME + "/isolate";
  
  public IsolateProvider() {}
  
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
    return null;
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(new String[] { "DeviceId" });
    if (paramUri.toString().equals(URL)) {
      localMatrixCursor.addRow(new String[] { ((TelephonyManager)getContext().getSystemService("phone")).getDeviceId() });
    }
    return localMatrixCursor;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}
