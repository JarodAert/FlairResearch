package lu.uni.serval.icc_update1;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class OutFlowActivity
  extends Activity
{
  public OutFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Uri localUri = Uri.parse("content://lu.uni.serval.icc_update1/deviceid");
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("DroidBench", str);
    getContentResolver().update(localUri, localContentValues, null, null);
  }
}
