package lu.uni.serval.icc_query1;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class OutFlowActivity
  extends Activity
{
  public OutFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Uri localUri = Uri.parse("content://lu.uni.serval.icc_query1/deviceid");
    Cursor localCursor = getContentResolver().query(localUri, null, null, null, null);
    localCursor.moveToFirst();
    Log.i("DroidBench", localCursor.getString(0));
  }
}
