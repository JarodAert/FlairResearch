package lu.uni.serval.icc_bindservice1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class InFlowService
  extends Service
{
  IBinder mBinder = new LocalBinder();
  
  public InFlowService() {}
  
  public String getDeviceId()
  {
    return "device-id";
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.i("DroidBench", paramIntent.getStringExtra("DroidBench"));
    return mBinder;
  }
  
  class LocalBinder
    extends Binder
  {
    LocalBinder() {}
    
    public InFlowService getServiceInstance()
    {
      return InFlowService.this;
    }
  }
}
