package org.arguslab.icc_dynregister1;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity
  extends Activity
{
  public MainActivity() {}
  
  private void leakImei()
  {
    String str = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    Intent localIntent = new Intent("com.fgwei");
    localIntent.putExtra("id", str);
    sendBroadcast(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    if (checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
      requestPermissions(new String[] { "android.permission.READ_PHONE_STATE" }, 1);
    }
    registerReceiver(new MyReceiver(), new IntentFilter("com.fgwei"));
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
