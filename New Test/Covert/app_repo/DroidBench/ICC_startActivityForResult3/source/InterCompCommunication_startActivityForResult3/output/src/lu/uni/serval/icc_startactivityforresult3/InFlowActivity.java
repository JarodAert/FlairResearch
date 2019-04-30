package lu.uni.serval.icc_startactivityforresult3;

import android.app.Activity;
import android.os.Bundle;

public class InFlowActivity
  extends Activity
{
  public InFlowActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    setResult(1, getIntent());
    finish();
  }
}
