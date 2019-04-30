package lu.uni.serval.iac_sendbroadcast1_sink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class InFlowReceiver
  extends BroadcastReceiver
{
  public InFlowReceiver() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("DroidBench", paramIntent.getStringExtra("DroidBench"));
  }
}
