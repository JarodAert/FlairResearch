//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_startactivityforresult1 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_startactivityforresult1_InFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivityforresult1
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivityforresult1_4
	no compPermissions
}

one sig lu_uni_serval_icc_startactivityforresult1_IsolateActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivityforresult1
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivityforresult1_3
	no compPermissions
}

one sig lu_uni_serval_icc_startactivityforresult1_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivityforresult1
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivityforresult1_1 + detailedPath_lu_uni_serval_icc_startactivityforresult1_3 + detailedPath_lu_uni_serval_icc_startactivityforresult1_2
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_startactivityforresult1_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_1_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onActivityResult(int,int,android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_1_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = UNDEFINED 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult1_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_2_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onActivityResult(int,int,android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_2_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = NO_CATEGORY 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult1_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_3_calledAt
	lu.uni.serval.icc_startactivityforresult1.IsolateActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onActivityResult(int,int,android.content.Intent)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_3_calledAt
	lu.uni.serval.icc_startactivityforresult1.IsolateActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult1_4 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_4_calledAt
	lu.uni.serval.icc_startactivityforresult1.InFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_4_calledAt
	lu.uni.serval.icc_startactivityforresult1.InFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult1_5 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_5_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_5_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivityforresult1_6 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_6_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_startactivityforresult1_6_calledAt
	lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_startactivityforresult1.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=1
#DetailedPath=6
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
