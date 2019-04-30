//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_startactivity3 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_startactivity3_InFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity3_3
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity3_IntermediateFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity3_2 + detailedPath_lu_uni_serval_icc_startactivity3_1
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity3_IntermediateFlowActivity2 extends Activity{}{
	app in lu_uni_serval_icc_startactivity3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity3_2 + detailedPath_lu_uni_serval_icc_startactivity3_1
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity3_IntermediateFlowActivity3 extends Activity{}{
	app in lu_uni_serval_icc_startactivity3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity3_2 + detailedPath_lu_uni_serval_icc_startactivity3_1
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity3_IsolateActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity3
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_startactivity3_3
	no compPermissions
}

one sig lu_uni_serval_icc_startactivity3_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_startactivity3
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

one sig detailedPath_lu_uni_serval_icc_startactivity3_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity3_1_calledAt
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity2: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity3: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity3_1_calledAt
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity2: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity3: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivity3_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity3_2_calledAt
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity2: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity3: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity3_2_calledAt
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity2: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.IntermediateFlowActivity3: void onCreate(android.os.Bundle)@
*/
	sink = UNDEFINED 
}
one sig detailedPath_lu_uni_serval_icc_startactivity3_3 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity3_3_calledAt
	lu.uni.serval.icc_startactivity3.IsolateActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.InFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_icc_startactivity3_3_calledAt
	lu.uni.serval.icc_startactivity3.IsolateActivity: void onCreate(android.os.Bundle)
	lu.uni.serval.icc_startactivity3.InFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = LOG 
}
one sig detailedPath_lu_uni_serval_icc_startactivity3_4 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity3_4_calledAt
	lu.uni.serval.icc_startactivity3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_startactivity3_4_calledAt
	lu.uni.serval.icc_startactivity3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_icc_startactivity3_5 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_startactivity3_5_calledAt
	lu.uni.serval.icc_startactivity3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_icc_startactivity3_5_calledAt
	lu.uni.serval.icc_startactivity3.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_icc_startactivity3.~app = 6 
}

pred show(){
#Application=1
#Component=6
#IntentFilter=1
#DetailedPath=5
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
