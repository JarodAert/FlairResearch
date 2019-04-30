package lu.uni.serval.icc_bindservice4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class InFlowService
  extends Service
{
  public InFlowService() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("DroidBench");
    Log.i("DroidBench", str);
    return new LocalBinder(str);
  }
  
  class LocalBinder
    extends Binder
  {
    String imei;
    
    public LocalBinder(String paramString)
    {
      imei = paramString;
    }
    
    public String getDeviceId()
    {
      return imei;
    }
  }
}
