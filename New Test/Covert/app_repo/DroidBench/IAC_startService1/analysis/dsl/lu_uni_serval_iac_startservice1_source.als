//Automatically Generated
open appDeclaration

one sig lu_uni_serval_iac_startservice1_source extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_iac_startservice1_source_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_iac_startservice1_source
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

one sig detailedPath_lu_uni_serval_iac_startservice1_source_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_iac_startservice1_source_1_calledAt
	lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNDEFINED 
/*detailedPath_lu_uni_serval_iac_startservice1_source_1_calledAt
	lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}
one sig detailedPath_lu_uni_serval_iac_startservice1_source_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_iac_startservice1_source_2_calledAt
	lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_iac_startservice1_source_2_calledAt
	lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = IPC 
}

fact{
#lu_uni_serval_iac_startservice1_source.~app = 1 
}

pred show(){
#Application=1
#Component=1
#IntentFilter=1
#DetailedPath=2
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
