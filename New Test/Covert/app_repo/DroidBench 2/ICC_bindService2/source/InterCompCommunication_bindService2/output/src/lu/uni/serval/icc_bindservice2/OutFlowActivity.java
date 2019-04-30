package lu.uni.serval.icc_bindservice2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class OutFlowActivity
  extends Activity
{
  InnerServiceConnection mConnection = new InnerServiceConnection();
  
  public OutFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    bindService(new Intent(this, InFlowService.class), mConnection, 1);
  }
  
  class InnerServiceConnection
    implements ServiceConnection
  {
    InnerServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Log.i("DroidBench", ((InFlowService.LocalBinder)paramIBinder).getDeviceId());
      unbindService(this);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}
