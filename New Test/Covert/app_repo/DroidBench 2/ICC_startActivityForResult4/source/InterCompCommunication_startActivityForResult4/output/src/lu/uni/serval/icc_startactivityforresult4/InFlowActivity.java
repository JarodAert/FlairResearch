package lu.uni.serval.icc_startactivityforresult4;

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
    Intent localIntent = getIntent();
    Log.i("DroidBench", localIntent.getStringExtra("DroidBench"));
    setResult(1, localIntent);
    finish();
  }
}
