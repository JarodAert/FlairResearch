package com.sdalab.messenger;

import android.app.IntentService;
import android.content.Intent;
import android.telephony.SmsManager;

public class SendSmsService
  extends IntentService
{
  public SendSmsService()
  {
    super("SendSmsService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("destinationAddress");
    String str2 = paramIntent.getStringExtra("message");
    SmsManager.getDefault().sendTextMessage(str1, null, str2, null, null);
  }
}
