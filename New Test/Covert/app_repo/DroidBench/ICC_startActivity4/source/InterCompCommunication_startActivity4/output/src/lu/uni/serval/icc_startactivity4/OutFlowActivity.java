package lu.uni.serval.icc_startactivity4;

import android.app.Activity;
import android.content.Intent;
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
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    Intent localIntent = new Intent("lu.uni.serval.icc_startactivity4.ACTION", Uri.parse("http://wwwen.uni.lu"));
    localIntent.putExtra("DroidBench", str);
    startActivity(localIntent);
  }
}
