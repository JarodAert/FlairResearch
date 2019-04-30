package lu.uni.serval.icc_delete1;

import android.app.Activity;
import android.content.ContentResolver;
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
    Uri localUri = Uri.parse("content://lu.uni.serval.icc_delete1/deviceid");
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    getContentResolver().delete(localUri, "deviceid=?", new String[] { str });
  }
}
