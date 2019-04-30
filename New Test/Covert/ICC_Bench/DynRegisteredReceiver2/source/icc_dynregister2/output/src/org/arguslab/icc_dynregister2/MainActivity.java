package org.arguslab.icc_dynregister2;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.");
    localStringBuilder.append("ksu");
    Intent localIntent = new Intent(localStringBuilder.toString());
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
    registerReceiver(new MyReceiver(), new IntentFilter("com.ksu"));
    registerReceiver(new MyReceiver2(), new IntentFilter("com.ksu2"));
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
