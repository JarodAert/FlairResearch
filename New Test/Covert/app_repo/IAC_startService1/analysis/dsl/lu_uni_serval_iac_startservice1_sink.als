//Automatically Generated
open appDeclaration

one sig lu_uni_serval_iac_startservice1_sink extends Application{}{
	usesPermissions = READ_PHONE_STATE
	no appPermissions
	no APIPermissions
}


one sig lu_uni_serval_iac_startservice1_sink_InFlowService extends Service{}{
	app in lu_uni_serval_iac_startservice1_sink
	intentFilter = IntentFilter1
	detailedPaths = detailedPath_lu_uni_serval_iac_startservice1_sink_1
	no compPermissions
}

one sig lu_uni_serval_iac_startservice1_sink_IsolateService extends Service{}{
	app in lu_uni_serval_iac_startservice1_sink
	no intentFilter
	detailedPaths = detailedPath_lu_uni_serval_iac_startservice1_sink_1
	no compPermissions
}

one sig lu_uni_serval_iac_startservice1_sink_LaunchingActivity extends Activity{}{
	app in lu_uni_serval_iac_startservice1_sink
	intentFilter = IntentFilter2
	no detailedPaths
	no compPermissions
}


one sig IntentFilter1 extends IntentFilter{}{
	actions=lu_uni_serval_iac_startservice1_ACTION_A
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

one sig detailedPath_lu_uni_serval_iac_startservice1_sink_1 extends DetailedPath{}{
/*detailedPath_lu_uni_serval_iac_startservice1_sink_1_calledAt
	lu.uni.serval.iac_startservice1_sink.InFlowService: int onStartCommand(android.content.Intent,int,int)
	lu.uni.serval.iac_startservice1_sink.IsolateService: int onStartCommand(android.content.Intent,int,int)@
*/
	source = IPC 
/*detailedPath_lu_uni_serval_iac_startservice1_sink_1_calledAt
	lu.uni.serval.iac_startservice1_sink.InFlowService: int onStartCommand(android.content.Intent,int,int)
	lu.uni.serval.iac_startservice1_sink.IsolateService: int onStartCommand(android.content.Intent,int,int)@
*/
	sink = LOG 
}

fact{
#lu_uni_serval_iac_startservice1_sink.~app = 3 
}

pred show(){
#Application=1
#Component=3
#IntentFilter=2
#DetailedPath=1
#DataScheme=2
#existingApps.apps=1
no Intent
}
run show
