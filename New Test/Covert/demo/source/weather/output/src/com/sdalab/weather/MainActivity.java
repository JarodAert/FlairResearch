package com.sdalab.weather;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity
  extends Activity
  implements LocationListener
{
  protected double lat;
  protected LocationManager locationManager;
  protected double lon;
  
  public MainActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    locationManager = ((LocationManager)getSystemService("location"));
    locationManager.requestLocationUpdates("gps", 0L, 0.0F, this);
    ((Button)findViewById(2131034173)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditText localEditText = (EditText)findViewById(2131034172);
        showWeather(localEditText.getText().toString(), null, null);
      }
    });
    ((Button)findViewById(2131034174)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Location localLocation = locationManager.getLastKnownLocation("gps");
        showWeather(null, Double.valueOf(localLocation.getLatitude()), Double.valueOf(localLocation.getLongitude()));
      }
    });
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    lat = paramLocation.getLatitude();
    lon = paramLocation.getLongitude();
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  void showWeather(String paramString, Double paramDouble1, Double paramDouble2)
  {
    Intent localIntent = new Intent("showWeather");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.putExtra("city", paramString);
    if ((paramDouble1 != null) && (paramDouble2 != null))
    {
      localIntent.putExtra("lat", paramDouble1.toString());
      localIntent.putExtra("lon", paramDouble2.toString());
    }
    startService(localIntent);
  }
}
