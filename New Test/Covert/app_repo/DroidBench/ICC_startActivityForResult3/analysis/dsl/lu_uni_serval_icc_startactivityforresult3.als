//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_startactivityforresult3 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_startactivityforresult3_InFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivityforresult3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivityforresult3_2
	no compPermissions
}

one sig lu_uni_serval_icc_startactivityforresult3_IsolateActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivityforresult3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivityforresult3_2
	no compPermissions
}

one sig lu_uni_serval_icc_startactivityforresult3_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivityforresult3
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivityforresult3_1
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_startactivityforresult3_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_1_calledAt
	lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onActivityResult(int,int,android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_1_calledAt
	lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onActivityResult(int,int,android.content.Intent)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult3_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_2_calledAt
	lu.uni.serval.icc_startactivityforresult3.InFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivityforresult3.IsolateActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_2_calledAt
	lu.uni.serval.icc_startactivityforresult3.InFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivityforresult3.IsolateActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult3_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_3_calledAt
	lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_3_calledAt
	lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult3_4 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_4_calledAt
	lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_startactivityforresult3_4_calledAt
	lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_startactivityforresult3.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=1
#DetailedPath=4
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
