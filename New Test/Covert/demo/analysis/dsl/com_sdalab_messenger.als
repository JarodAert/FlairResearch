//Automatically Generated
open appDeclaration

one sig com_sdalab_messenger extends Application{}{
	usesPermissions = INTERNET + SEND_SMS
	no appPermissions
	APIPermissions = SEND_SMS
}


one sig com_sdalab_messenger_MainActivity extends Activity{}{
	app in com_sdalab_messenger
	intentFilter = IntentFilter1
	no detailedPaths
	no compPermissions
}

one sig com_sdalab_messenger_PublishDataService extends Service{}{
	app in com_sdalab_messenger
	intentFilter = IntentFilter2
	detailedPaths = detailedPath_com_sdalab_messenger_4 + detailedPath_com_sdalab_messenger_3
	no compPermissions
}

one sig com_sdalab_messenger_SendSmsService extends Service{}{
	app in com_sdalab_messenger
	intentFilter = IntentFilter3
	detailedPaths = detailedPath_com_sdalab_messenger_2 + detailedPath_com_sdalab_messenger_1
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}
one sig IntentFilter2 extends IntentFilter{}{
	actions=shareMsg_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}
one sig IntentFilter3 extends IntentFilter{}{
	actions=sendSMS_A
	categories=android_intent_category_DEFAULT_C
	dataType=text_plain_D
	dataScheme=NoScheme
}

one sig detailedPath_com_sdalab_messenger_1 extends DetailedPath{}{
/*detailedPath_com_sdalab_messenger_1_calledAt
	com.sdalab.messenger.SendSmsService: void onHandleIntent(android.content.Intent)@
*/
	source = IPC 
/*detailedPath_com_sdalab_messenger_1_calledAt
	com.sdalab.messenger.SendSmsService: void onHandleIntent(android.content.Intent)@
*/
	sink = SMS_MMS 
}
one sig detailedPath_com_sdalab_messenger_2 extends DetailedPath{}{
/*detailedPath_com_sdalab_messenger_2_calledAt
	com.sdalab.messenger.SendSmsService: void onHandleIntent(android.content.Intent)@
*/
	source = NETWORK_INFORMATION 
/*detailedPath_com_sdalab_messenger_2_calledAt
	com.sdalab.messenger.SendSmsService: void onHandleIntent(android.content.Intent)@
*/
	sink = SMS_MMS 
}
one sig detailedPath_com_sdalab_messenger_3 extends DetailedPath{}{
/*detailedPath_com_sdalab_messenger_3_calledAt
	com.sdalab.messenger.PublishDataService: int onStartCommand(android.content.Intent,int,int)@
*/
	source = IPC 
/*detailedPath_com_sdalab_messenger_3_calledAt
	com.sdalab.messenger.PublishDataService: void sendRequest(java.lang.String,java.lang.String)@
*/
	sink = NETWORK 
}
one sig detailedPath_com_sdalab_messenger_4 extends DetailedPath{}{
/*detailedPath_com_sdalab_messenger_4_calledAt
	com.sdalab.messenger.PublishDataService: void sendRequest(java.lang.String,java.lang.String)@
*/
	source = NETWORK 
/*detailedPath_com_sdalab_messenger_4_calledAt
	com.sdalab.messenger.PublishDataService: void sendRequest(java.lang.String,java.lang.String)@
*/
	sink = LOG 
}
one sig detailedPath_com_sdalab_messenger_5 extends DetailedPath{}{
/*detailedPath_com_sdalab_messenger_5_calledAt
	com.sdalab.messenger.MainActivity$2: void onClick(android.view.View)
	com.sdalab.messenger.MainActivity$1: void onClick(android.view.View)@
*/
	source = NO_CATEGORY 
/*detailedPath_com_sdalab_messenger_5_calledAt
	com.sdalab.messenger.MainActivity$2: void onClick(android.view.View)
	com.sdalab.messenger.MainActivity$1: void onClick(android.view.View)@
*/
	sink = IPC 
}
one sig detailedPath_com_sdalab_messenger_6 extends DetailedPath{}{
/*detailedPath_com_sdalab_messenger_6_calledAt
	com.sdalab.messenger.MainActivity$2: void onClick(android.view.View)
	com.sdalab.messenger.MainActivity$1: void onClick(android.view.View)@
*/
	source = UNDEFINED 
/*detailedPath_com_sdalab_messenger_6_calledAt
	com.sdalab.messenger.MainActivity$2: void onClick(android.view.View)
	com.sdalab.messenger.MainActivity$1: void onClick(android.view.View)@
*/
	sink = IPC 
}

fact{
#com_sdalab_messenger.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=3
#DetailedPath=6
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
