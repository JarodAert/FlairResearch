package lu.uni.serval.iac_startactivity1_sink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IsolateActivity
  extends Activity
{
  public IsolateActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Log.i("DroidBench", getIntent().getStringExtra("DroidBench"));
  }
}
