//Automatically Generated
open appDeclaration

one sig lu_uni_serval_iac_sendbroadcast1_sink extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	no APIPermissions
}


one sig lu_uni_serval_iac_sendbroadcast1_sink_InFlowReceiver extends Receiver{}{
	app in lu_uni_serval_iac_sendbroadcast1_sink
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_iac_sendbroadcast1_sink_1
	no compPermissions
}

one sig lu_uni_serval_iac_sendbroadcast1_sink_IsolateReceiver extends Receiver{}{
	app in lu_uni_serval_iac_sendbroadcast1_sink
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_iac_sendbroadcast1_sink_1
	no compPermissions
}

one sig lu_uni_serval_iac_sendbroadcast1_sink_LaunchingActivity extends Activity{}{
	app in lu_uni_serval_iac_sendbroadcast1_sink
	intentFilter = IntentFilter2
	no detailedPaths
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=lu_uni_serval_iac_sendbroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}
one sig IntentFilter2 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_iac_sendbroadcast1_sink_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_iac_sendbroadcast1_sink_1_calledAt
	lu.uni.serval.iac_sendbroadcast1_sink.InFlowReceiver: void onReceive(android.content.Context,android.content.Intent)
	lu.uni.serval.iac_sendbroadcast1_sink.IsolateReceiver: void onReceive(android.content.Context,android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_iac_sendbroadcast1_sink_1_calledAt
	lu.uni.serval.iac_sendbroadcast1_sink.InFlowReceiver: void onReceive(android.content.Context,android.content.Intent)
	lu.uni.serval.iac_sendbroadcast1_sink.IsolateReceiver: void onReceive(android.content.Context,android.content.Intent)@
*/
	sink = LOG 
}

fact{
#lu_uni_serval_iac_sendbroadcast1_sink.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=2
#DetailedPath=1
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
