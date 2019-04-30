//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_sendBroadcast1 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_sendBroadcast1_InFlowReceiver extends Receiver{}{
	app in lu_uni_serval_icc_sendBroadcast1
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_sendBroadcast1_1
	no compPermissions
}

one sig lu_uni_serval_icc_sendBroadcast1_IsolateReceiver extends Receiver{}{
	app in lu_uni_serval_icc_sendBroadcast1
	intentFilter = IntentFilter2
	detailedPaths = detailedPath_lu_uni_serval_icc_sendBroadcast1_1
	no compPermissions
}

one sig lu_uni_serval_icc_sendBroadcast1_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_sendBroadcast1
	intentFilter = IntentFilter3
	no detailedPaths
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=lu_uni_serval_icc_sendBroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}
one sig IntentFilter2 extends IntentFilter{}{
	actions=lu_uni_serval_icc_sendBroadcast1_ISOLATE_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}
one sig IntentFilter3 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_sendBroadcast1_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_sendBroadcast1_1_calledAt
	lu.uni.serval.icc_sendBroadcast1.InFlowReceiver: void onReceive(android.content.Context,android.content.Intent)
	lu.uni.serval.icc_sendBroadcast1.IsolateReceiver: void onReceive(android.content.Context,android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_sendBroadcast1_1_calledAt
	lu.uni.serval.icc_sendBroadcast1.InFlowReceiver: void onReceive(android.content.Context,android.content.Intent)
	lu.uni.serval.icc_sendBroadcast1.IsolateReceiver: void onReceive(android.content.Context,android.content.Intent)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_sendBroadcast1_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_sendBroadcast1_2_calledAt
	lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_sendBroadcast1_2_calledAt
	lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_sendBroadcast1_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_sendBroadcast1_3_calledAt
	lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_sendBroadcast1_3_calledAt
	lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_sendBroadcast1.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=3
#DetailedPath=3
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
