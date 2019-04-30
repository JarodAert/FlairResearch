package lu.uni.serval.icc_bindservice1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;

public class OutFlowActivity
  extends Activity
{
  InnerServiceConnection mConnection = new InnerServiceConnection();
  
  public OutFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    Intent localIntent = new Intent(this, InFlowService.class);
    localIntent.putExtra("DroidBench", str);
    bindService(localIntent, mConnection, 1);
    unbindService(mConnection);
  }
  
  class InnerServiceConnection
    implements ServiceConnection
  {
    InnerServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}
