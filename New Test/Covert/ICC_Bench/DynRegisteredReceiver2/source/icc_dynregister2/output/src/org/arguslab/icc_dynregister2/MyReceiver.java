package org.arguslab.icc_dynregister2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver
  extends BroadcastReceiver
{
  public MyReceiver() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("leak", "" + paramIntent.getStringExtra("id"));
  }
}
