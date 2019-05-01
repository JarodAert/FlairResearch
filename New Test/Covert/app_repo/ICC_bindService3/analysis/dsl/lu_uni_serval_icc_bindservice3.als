//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_bindservice3 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_bindservice3_InFlowService extends Service{}{
	app in lu_uni_serval_icc_bindservice3
	no intentFilter
	no detailedPaths
	no compPermissions
}

one sig lu_uni_serval_icc_bindservice3_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_bindservice3
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_bindservice3_1
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_bindservice3_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice3_1_calledAt
	<lu.uni.serval.icc_bindservice3.OutFlowActivity$InnerServiceConnection: void onServiceConnected(android.content.ComponentName,android.os.IBinder)>@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_bindservice3_1_calledAt
	<lu.uni.serval.icc_bindservice3.OutFlowActivity$InnerServiceConnection: void onServiceConnected(android.content.ComponentName,android.os.IBinder)>@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_bindservice3_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice3_2_calledAt
	lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_bindservice3_2_calledAt
	lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_bindservice3_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice3_3_calledAt
	lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_bindservice3_3_calledAt
	lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_bindservice3_4 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice3_4_calledAt
	<lu.uni.serval.icc_bindservice3.IsolateService: android.os.IBinder onBind(android.content.Intent)>
	<lu.uni.serval.icc_bindservice3.InFlowService: android.os.IBinder onBind(android.content.Intent)>@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_bindservice3_4_calledAt
	<lu.uni.serval.icc_bindservice3.IsolateService: android.os.IBinder onBind(android.content.Intent)>
	<lu.uni.serval.icc_bindservice3.InFlowService: android.os.IBinder onBind(android.content.Intent)>@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_bindservice3.~app = 2 
}

pred show(){
#Application=1
#Component=2
#IntentFilter=1
#DetailedPath=4
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
