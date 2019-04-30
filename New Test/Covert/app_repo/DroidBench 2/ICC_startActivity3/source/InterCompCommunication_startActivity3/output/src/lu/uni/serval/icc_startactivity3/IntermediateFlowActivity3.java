package lu.uni.serval.icc_startactivity3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntermediateFlowActivity3
  extends Activity
{
  public IntermediateFlowActivity3() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    String str = getIntent().getStringExtra("DroidBench");
    Intent localIntent = new Intent(this, InFlowActivity.class);
    localIntent.putExtra("DroidBench", str);
    startActivity(localIntent);
  }
}
