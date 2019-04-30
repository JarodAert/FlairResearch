package com.sdalab.weather;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RetrieveWeather
  extends Service
{
  public RetrieveWeather() {}
  
  private void sendRequest(String paramString)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    try
    {
      String str = EntityUtils.toString(new DefaultHttpClient().execute(localHttpPost).getEntity(), "UTF-8");
      Intent localIntent = new Intent(this, ShowWeather.class);
      localIntent.putExtra("weather", str);
      localIntent.addFlags(268435456);
      startActivity(localIntent);
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str1 = paramIntent.getStringExtra("city");
    String str2 = paramIntent.getStringExtra("lat");
    String str3 = paramIntent.getStringExtra("lon");
    String str4 = "";
    if (str1 != null) {
      str4 = "q=" + str1;
    }
    if ((str2 != null) && (str3 != null)) {
      str4 = "lat=" + str2 + "&lon=" + str3;
    }
    String str5 = "http://api.openweathermap.org/data/2.5/weather?units=imperial&" + str4;
    new Connection(null).execute(new String[] { str5 });
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  private class Connection
    extends AsyncTask<String, Void, Void>
  {
    private Connection() {}
    
    protected Void doInBackground(String... paramVarArgs)
    {
      RetrieveWeather.this.sendRequest(paramVarArgs[0]);
      return null;
    }
  }
}
