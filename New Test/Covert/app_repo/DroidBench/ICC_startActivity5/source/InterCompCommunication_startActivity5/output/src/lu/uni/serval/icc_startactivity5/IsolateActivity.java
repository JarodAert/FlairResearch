package lu.uni.serval.icc_startactivity5;

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
    Log.i("DroidBench", getIntent().getStringExtra("DroidBench"));
  }
}
