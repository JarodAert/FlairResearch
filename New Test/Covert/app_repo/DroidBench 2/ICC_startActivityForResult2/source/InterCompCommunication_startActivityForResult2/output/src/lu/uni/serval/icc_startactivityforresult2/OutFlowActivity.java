package lu.uni.serval.icc_startactivityforresult2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
    startActivityForResult(new Intent(this, InFlowActivity.class), 1);
  }
}
