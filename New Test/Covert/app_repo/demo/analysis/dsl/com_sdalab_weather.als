//Automatically Generated
open appDeclaration

one sig com_sdalab_weather extends Application{}{
	usesPermissions = ACCESS_COARSE_LOCATION + INTERNET + ACCESS_FINE_LOCATION
	no appPermissions
	APIPermissions = ACCESS_FINE_LOCATION + ACCESS_COARSE_LOCATION + INTERNET
}


one sig com_sdalab_weather_MainActivity extends Activity{}{
	app in com_sdalab_weather
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_com_sdalab_weather_1
	no compPermissions
}

one sig com_sdalab_weather_RetrieveWeather extends Service{}{
	app in com_sdalab_weather
	intentFilter = IntentFilter2
	no detailedPaths
	no compPermissions
}

one sig com_sdalab_weather_ShowWeather extends Activity{}{
	app in com_sdalab_weather
	no intentFilter
	detailedPaths = detailedPath_com_sdalab_weather_2
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}
one sig IntentFilter2 extends IntentFilter{}{
	actions=showWeather_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_com_sdalab_weather_1 extends DetailedPath{}{
/*detailedPath_com_sdalab_weather_1_calledAt
	com.sdalab.weather.MainActivity: void onLocationChanged(android.location.Location)@
*/
	source = LOCATION_INFORMATION 
/*detailedPath_com_sdalab_weather_1_calledAt
	com.sdalab.weather.MainActivity: void onCreate(android.os.Bundle)@
*/
	sink = NO_CATEGORY 
}
one sig detailedPath_com_sdalab_weather_2 extends DetailedPath{}{
/*detailedPath_com_sdalab_weather_2_calledAt
	com.sdalab.weather.ShowWeather: void fillForm(java.lang.String)@
*/
	source = NO_CATEGORY 
/*detailedPath_com_sdalab_weather_2_calledAt
	com.sdalab.weather.ShowWeather: void fillForm(java.lang.String)@
*/
	sink = NETWORK 
}
one sig detailedPath_com_sdalab_weather_3 extends DetailedPath{}{
/*detailedPath_com_sdalab_weather_3_calledAt
	com.sdalab.weather.MainActivity$1: void onClick(android.view.View)@
*/
	source = UNDEFINED 
/*detailedPath_com_sdalab_weather_3_calledAt
	com.sdalab.weather.MainActivity: void showWeather(java.lang.String,java.lang.Double,java.lang.Double)@
*/
	sink = IPC 
}
one sig detailedPath_com_sdalab_weather_4 extends DetailedPath{}{
/*detailedPath_com_sdalab_weather_4_calledAt
	com.sdalab.weather.MainActivity$1: void onClick(android.view.View)@
*/
	source = NO_CATEGORY 
/*detailedPath_com_sdalab_weather_4_calledAt
	com.sdalab.weather.MainActivity: void showWeather(java.lang.String,java.lang.Double,java.lang.Double)@
*/
	sink = IPC 
}
one sig detailedPath_com_sdalab_weather_5 extends DetailedPath{}{
/*detailedPath_com_sdalab_weather_5_calledAt
	com.sdalab.weather.MainActivity$2: void onClick(android.view.View)@
*/
	source = LOCATION_INFORMATION 
/*detailedPath_com_sdalab_weather_5_calledAt
	com.sdalab.weather.MainActivity: void showWeather(java.lang.String,java.lang.Double,java.lang.Double)@
*/
	sink = IPC 
}
one sig detailedPath_com_sdalab_weather_6 extends DetailedPath{}{
/*detailedPath_com_sdalab_weather_6_calledAt
	com.sdalab.weather.RetrieveWeather: void sendRequest(java.lang.String)@
*/
	source = NETWORK 
/*detailedPath_com_sdalab_weather_6_calledAt
	com.sdalab.weather.RetrieveWeather: void sendRequest(java.lang.String)@
*/
	sink = IPC 
}

fact{
#com_sdalab_weather.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=2
#DetailedPath=6
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
