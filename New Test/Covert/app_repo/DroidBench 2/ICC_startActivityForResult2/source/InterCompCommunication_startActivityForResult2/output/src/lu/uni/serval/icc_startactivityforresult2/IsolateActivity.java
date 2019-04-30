package lu.uni.serval.icc_startactivityforresult2;

import android.app.Activity;
import android.os.Bundle;

public class IsolateActivity
  extends Activity
{
  public IsolateActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(1, getIntent());
    finish();
  }
}
