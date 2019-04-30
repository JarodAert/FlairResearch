package org.arguslab.icc_implicit_mix1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class FooActivity
  extends Activity
{
  public FooActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Intent localIntent = new Intent();
    localIntent.setAction("test_action2");
    localIntent.addCategory("test_category3");
    localIntent.addCategory("test_category4");
    localIntent.setDataAndType(Uri.parse("amandroid://fgwei:8888/xxx/xxx.com"), "test/type");
    localIntent.putExtra("data", getIntent().getStringExtra("data"));
    startActivity(localIntent);
  }
}
