//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_bindservice1 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_bindservice1_InFlowService extends Service{}{
	app in lu_uni_serval_icc_bindservice1
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_bindservice1_1
	no compPermissions
}

one sig lu_uni_serval_icc_bindservice1_IsolateService extends Service{}{
	app in lu_uni_serval_icc_bindservice1
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_bindservice1_1
	no compPermissions
}

one sig lu_uni_serval_icc_bindservice1_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_bindservice1
	intentFilter = IntentFilter1
	no detailedPaths
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_bindservice1_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice1_1_calledAt
	lu.uni.serval.icc_bindservice1.IsolateService: android.os.IBinder onBind(android.content.Intent)
	lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_bindservice1_1_calledAt
	lu.uni.serval.icc_bindservice1.IsolateService: android.os.IBinder onBind(android.content.Intent)
	lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_bindservice1_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice1_2_calledAt
	<lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)>
	<lu.uni.serval.icc_bindservice1.IsolateService: android.os.IBinder onBind(android.content.Intent)>@
*/
	source = LOG 
/*detailedPath_lu_uni_serval_icc_bindservice1_2_calledAt
	<lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)>
	<lu.uni.serval.icc_bindservice1.IsolateService: android.os.IBinder onBind(android.content.Intent)>@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_bindservice1_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice1_3_calledAt
	<lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)>
	<lu.uni.serval.icc_bindservice1.IsolateService: android.os.IBinder onBind(android.content.Intent)>@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_bindservice1_3_calledAt
	<lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)>
	<lu.uni.serval.icc_bindservice1.IsolateService: android.os.IBinder onBind(android.content.Intent)>@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_bindservice1_4 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice1_4_calledAt
	lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_bindservice1_4_calledAt
	lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_bindservice1_5 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_bindservice1_5_calledAt
	lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_bindservice1_5_calledAt
	lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_bindservice1.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=1
#DetailedPath=5
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
