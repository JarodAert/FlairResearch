package lu.uni.serval.icc_startactivityforresult2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class InFlowActivity
  extends Activity
{
  public InFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    Intent localIntent = new Intent();
    localIntent.putExtra("DroidBench", str);
    setResult(1, localIntent);
    finish();
  }
}
