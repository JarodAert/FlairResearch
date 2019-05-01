//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_bindservice2 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_bindservice2_InFlowService extends Service{}{
	app in lu_uni_serval_icc_bindservice2
	no intentFilter
	no detailedPaths
	no compPermissions
}

one sig lu_uni_serval_icc_bindservice2_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_bindservice2
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_bindservice2_1
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_bindservice2_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice2_1_calledAt
	<lu.uni.serval.icc_bindservice2.OutFlowActivity$InnerServiceConnection: void onServiceConnected(android.content.ComponentName,android.os.IBinder)>@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_bindservice2_1_calledAt
	<lu.uni.serval.icc_bindservice2.OutFlowActivity$InnerServiceConnection: void onServiceConnected(android.content.ComponentName,android.os.IBinder)>@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_bindservice2_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice2_2_calledAt
	<lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()>
	<lu.uni.serval.icc_bindservice2.IsolateService$LocalBinder: java.lang.String getDeviceId()>@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_bindservice2_2_calledAt
	<lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()>
	<lu.uni.serval.icc_bindservice2.IsolateService$LocalBinder: java.lang.String getDeviceId()>@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_bindservice2_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice2_3_calledAt
	<lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()>
	<lu.uni.serval.icc_bindservice2.IsolateService$LocalBinder: java.lang.String getDeviceId()>@
*/
	source = NO_CATEGORY 
/*detailedPath_lu_uni_serval_icc_bindservice2_3_calledAt
	<lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()>
	<lu.uni.serval.icc_bindservice2.IsolateService$LocalBinder: java.lang.String getDeviceId()>@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_bindservice2.~app = 2 
}

pred show(){
#Application=1
#Component=2
#IntentFilter=1
#DetailedPath=3
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
