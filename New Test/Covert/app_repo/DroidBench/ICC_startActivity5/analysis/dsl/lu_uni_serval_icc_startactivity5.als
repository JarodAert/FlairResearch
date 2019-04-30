//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_startactivity5 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_startactivity5_InFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity5
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity5_1
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity5_IsolateActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity5
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity5_1
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity5_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity5
	intentFilter = IntentFilter2
	no detailedPaths
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=lu_uni_serval_icc_startactivity4_ACTION_A
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

one sig detailedPath_lu_uni_serval_icc_startactivity5_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity5_1_calledAt
	lu.uni.serval.icc_startactivity5.IsolateActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity5.InFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity5_1_calledAt
	lu.uni.serval.icc_startactivity5.IsolateActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity5.InFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_startactivity5_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity5_2_calledAt
	lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_startactivity5_2_calledAt
	lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivity5_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity5_3_calledAt
	lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_startactivity5_3_calledAt
	lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_startactivity5.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=2
#DetailedPath=3
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
