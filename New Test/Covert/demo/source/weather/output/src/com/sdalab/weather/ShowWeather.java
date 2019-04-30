package com.sdalab.weather;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowWeather
  extends Activity
{
  public ShowWeather() {}
  
  private void fillForm(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      setTxtVal(2131034172, localJSONObject1.getString("name"));
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("main");
      setTxtVal(2131034177, localJSONObject2.getString("temp"));
      localJSONObject2.getString("humidity");
      JSONArray localJSONArray = localJSONObject1.getJSONArray("weather");
      if (!localJSONArray.isNull(0))
      {
        JSONObject localJSONObject3 = localJSONArray.getJSONObject(0);
        setTxtVal(2131034175, localJSONObject3.getString("description"));
        String str = localJSONObject3.getString("icon");
        ((ImageView)findViewById(2131034176)).setImageBitmap(BitmapFactory.decodeStream(new URL("http://openweathermap.org/img/w/" + str + ".png").openConnection().getInputStream()));
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void setTxtVal(int paramInt, String paramString)
  {
    ((TextView)findViewById(paramInt)).setText(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903065);
    String str = getIntent().getStringExtra("weather");
    if (str != null) {
      fillForm(str);
    }
  }
}
