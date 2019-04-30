package lu.uni.serval.icc_startservice2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class InFlowService
  extends IntentService
{
  public InFlowService()
  {
    super("ReceiverService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Log.i("DroidBench", paramIntent.getStringExtra("DroidBench"));
  }
}
