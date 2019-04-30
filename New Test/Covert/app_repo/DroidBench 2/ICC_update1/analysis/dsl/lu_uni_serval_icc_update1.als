//Automatically Generated
open appDeclaration

one sig lu_uni_serval_icc_update1 extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	APIPermissions = READ_PHONE_STATE
}


one sig lu_uni_serval_icc_update1_InFlowProvider extends Provider{}{
	app in lu_uni_serval_icc_update1
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_update1_2
	no compPermissions
}

one sig lu_uni_serval_icc_update1_IsolateProvider extends Provider{}{
	app in lu_uni_serval_icc_update1
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_icc_update1_2
	no compPermissions
}

one sig lu_uni_serval_icc_update1_OutFlowActivity extends Activity{}{
	app in lu_uni_serval_icc_update1
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_icc_update1_1
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=android_intent_action_MAIN_A
	categories=android_intent_category_LAUNCHER_C
	dataType=NoMIMEType
	dataScheme=NoScheme
}

one sig detailedPath_lu_uni_serval_icc_update1_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_update1_1_calledAt
	lu.uni.serval.icc_update1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	source = UNIQUE_IDENTIFIER 
/*detailedPath_lu_uni_serval_icc_update1_1_calledAt
	lu.uni.serval.icc_update1.OutFlowActivity: void onCreate(android.os.Bundle)@
*/
	sink = NO_CATEGORY 
}
one sig detailedPath_lu_uni_serval_icc_update1_2 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_icc_update1_2_calledAt
	lu.uni.serval.icc_update1.InFlowProvider: int update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[])
	lu.uni.serval.icc_update1.IsolateProvider: int update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[])@
*/
	source = NO_CATEGORY 
/*detailedPath_lu_uni_serval_icc_update1_2_calledAt
	lu.uni.serval.icc_update1.InFlowProvider: int update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[])
	lu.uni.serval.icc_update1.IsolateProvider: int update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[])@
*/
	sink = LOG 
}

fact{
#lu_uni_serval_icc_update1.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=1
#DetailedPath=2
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
