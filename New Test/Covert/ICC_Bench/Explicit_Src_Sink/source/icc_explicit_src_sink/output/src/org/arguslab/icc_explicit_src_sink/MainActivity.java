package org.arguslab.icc_explicit_src_sink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity
  extends Activity
{
  public MainActivity() {}
  
  private void leakImei()
  {
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    Intent localIntent = new Intent(getApplicationContext(), FooActivity.class);
    localIntent.putExtra("data", str);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    if (checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
      requestPermissions(new String[] { "android.permission.READ_PHONE_STATE" }, 1);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    leakImei();
  }
}
