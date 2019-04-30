package lu.uni.serval.icc_bindservice2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.telephony.TelephonyManager;

public class InFlowService
  extends Service
{
  LocalBinder mBinder = new LocalBinder();
  
  public InFlowService() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return mBinder;
  }
  
  class LocalBinder
    extends Binder
  {
    LocalBinder() {}
    
    public String getDeviceId()
    {
      return ((TelephonyManager)getSystemService("phone")).getDeviceId();
    }
  }
}
