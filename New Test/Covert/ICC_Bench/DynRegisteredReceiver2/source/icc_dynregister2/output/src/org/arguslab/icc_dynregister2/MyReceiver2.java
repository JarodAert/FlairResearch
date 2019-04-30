package org.arguslab.icc_dynregister2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver2
  extends BroadcastReceiver
{
  public MyReceiver2() {}
  
  private void process(String paramString)
  {
    Log.d("leak2", paramString);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    process("" + paramIntent.getStringExtra("id"));
  }
}
