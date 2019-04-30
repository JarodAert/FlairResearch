package lu.uni.serval.icc_startactivityforresult4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class OutFlowActivity
  extends Activity
{
  public OutFlowActivity() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("DroidBench", paramIntent.getStringExtra("DroidBench"));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    Intent localIntent = new Intent(this, InFlowActivity.class);
    localIntent.putExtra("DroidBench", str);
    startActivityForResult(localIntent, 1);
  }
}
