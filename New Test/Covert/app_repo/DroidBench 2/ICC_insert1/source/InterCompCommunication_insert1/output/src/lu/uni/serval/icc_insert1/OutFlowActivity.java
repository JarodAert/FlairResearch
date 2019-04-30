package lu.uni.serval.icc_insert1;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import java.io.PrintStream;

public class OutFlowActivity
  extends Activity
{
  public OutFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Uri localUri1 = Uri.parse("content://lu.uni.serval.icc_insert1/deviceid");
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("DroidBench", str);
    Uri localUri2 = getContentResolver().insert(localUri1, localContentValues);
    System.out.println(localUri2.toString());
  }
}
