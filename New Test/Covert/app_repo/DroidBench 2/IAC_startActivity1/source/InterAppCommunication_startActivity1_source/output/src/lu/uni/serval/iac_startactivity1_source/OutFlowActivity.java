package lu.uni.serval.iac_startactivity1_source;

import android.app.Activity;
import android.content.Intent;
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
    Intent localIntent = new Intent();
    localIntent.setAction("lu.uni.serval.iac_startactivity1.ACTION");
    localIntent.putExtra("DroidBench", str);
    startActivity(localIntent);
  }
}
