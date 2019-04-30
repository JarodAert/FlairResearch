package org.arguslab.icc_explicit_src_sink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class FooActivity
  extends Activity
{
  public FooActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    Log.d("deviceid", "" + localIntent.getStringExtra("data"));
  }
}
