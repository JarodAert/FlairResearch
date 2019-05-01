package org.arguslab.icc_implicit_category;

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
    setContentView(2130903040);
    Intent localIntent = getIntent();
    Log.d("deviceid", "" + localIntent.getStringExtra("data"));
  }
}
