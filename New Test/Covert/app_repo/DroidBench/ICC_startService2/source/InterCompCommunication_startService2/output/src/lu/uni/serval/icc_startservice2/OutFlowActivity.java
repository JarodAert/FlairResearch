package lu.uni.serval.icc_startservice2;

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
    Intent localIntent = new Intent(this, InFlowService.class);
    localIntent.putExtra("DroidBench", str);
    startService(localIntent);
  }
}
