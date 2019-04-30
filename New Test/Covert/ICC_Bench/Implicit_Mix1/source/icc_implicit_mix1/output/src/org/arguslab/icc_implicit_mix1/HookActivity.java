package org.arguslab.icc_implicit_mix1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HookActivity
  extends Activity
{
  public HookActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    Intent localIntent = getIntent();
    Log.d("deviceid", "" + localIntent.getStringExtra("data"));
  }
}
