//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_startactivity2 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_startactivity2_InFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity2
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity2_3
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity2_IntermediateFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity2
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity2_2 + detailedPath_lu_uni_serval_icc_startactivity2_1
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity2_IsolateActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity2
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity2_3
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity2_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity2
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

one sig detailedPath_lu_uni_serval_icc_startactivity2_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity2_1_calledAt
	lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity2_1_calledAt
	lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = UNDEFINED 
}
one sig detailedPath_lu_uni_serval_icc_startactivity2_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity2_2_calledAt
	lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity2_2_calledAt
	lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivity2_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity2_3_calledAt
	lu.uni.serval.icc_startactivity2.InFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity2.IsolateActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity2_3_calledAt
	lu.uni.serval.icc_startactivity2.InFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity2.IsolateActivity: void onCreate(android.os.Bundle)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_startactivity2_4 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity2_4_calledAt
	lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_startactivity2_4_calledAt
	lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivity2_5 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity2_5_calledAt
	lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_startactivity2_5_calledAt
	lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_startactivity2.~app = 4 
}

pred show(){
#Application=1
#Component=4
#IntentFilter=1
#DetailedPath=5
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
