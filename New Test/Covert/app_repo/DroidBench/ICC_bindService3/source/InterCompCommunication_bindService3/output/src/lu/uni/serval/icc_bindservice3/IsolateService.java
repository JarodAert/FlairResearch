package lu.uni.serval.icc_bindservice3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class IsolateService
  extends Service
{
  public IsolateService() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return new LocalBinder(paramIntent.getStringExtra("DroidBench"));
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
