//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_delete1 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_delete1_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_delete1
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_delete1_1
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_delete1_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_delete1_1_calledAt
	lu.uni.serval.icc_delete1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_delete1_1_calledAt
	lu.uni.serval.icc_delete1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = DATABASE_INFORMATION 
}

fact{
#lu_uni_serval_icc_delete1.~app = 1 
}

pred show(){
#Application=1
#Component=1
#IntentFilter=1
#DetailedPath=1
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show