package lu.uni.serval.icc_startactivity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InFlowActivity
  extends Activity
{
  public InFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Log.i("DroidBench", getIntent().getStringExtra("DroidBench"));
  }
}
