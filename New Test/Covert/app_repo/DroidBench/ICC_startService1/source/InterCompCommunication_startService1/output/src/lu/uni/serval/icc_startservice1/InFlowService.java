package lu.uni.serval.icc_startservice1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class InFlowService
  extends Service
{
  public InFlowService() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.i("DroidBench", paramIntent.getStringExtra("DroidBench"));
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}
