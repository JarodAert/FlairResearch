package lu.uni.serval.icc_startactivity1;

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
    Intent localIntent = new Intent(this, InFlowActivity.class);
    localIntent.putExtra("DroidBench", str);
    startActivity(localIntent);
  }
}
