package org.arguslab.icc_dynregister1;

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
    Log.d("Id", "" + paramIntent.getStringExtra("id"));
  }
}
