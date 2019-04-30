package com.sdalab.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PublishDataService
  extends Service
{
  public PublishDataService() {}
  
  private void sendRequest(String paramString1, String paramString2)
  {
    HttpPost localHttpPost = new HttpPost("http://129.174.91.90:8080/PublicWall/wall.jsp");
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(new BasicNameValuePair("name", paramString2));
    localArrayList.add(new BasicNameValuePair("message", paramString1));
    localArrayList.add(new BasicNameValuePair("Post", "Post"));
    try
    {
      localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        try
        {
          Log.d("Http Response:", EntityUtils.toString(new DefaultHttpClient().execute(localHttpPost).getEntity(), "UTF-8"));
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
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str1 = paramIntent.getStringExtra("message");
    String str2 = paramIntent.getStringExtra("sender");
    new Connection(null).execute(new String[] { str1, str2 });
    return 2;
  }
  
  private class Connection
    extends AsyncTask<String, Void, Void>
  {
    private Connection() {}
    
    protected Void doInBackground(String... paramVarArgs)
    {
      PublishDataService.this.sendRequest(paramVarArgs[0], paramVarArgs[1]);
      return null;
    }
  }
}
