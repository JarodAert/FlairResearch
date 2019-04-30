package org.arguslab.icc_implicit_data2;

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
    Intent localIntent = new Intent();
    localIntent.setType("test/type");
    localIntent.putExtra("data", str);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
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
