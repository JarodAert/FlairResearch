//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivityforresult1


one sig intent1__sd12i11jp25adga758euhvmlfd extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult1_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult1_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult1_6 + detailedPath_lu_uni_serval_icc_startactivityforresult1_3 + detailedPath_lu_uni_serval_icc_startactivityforresult1_5
}
one sig intent2__v6r048q542pl061ibiufo8q5l4 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult1_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult1_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult1_6 + detailedPath_lu_uni_serval_icc_startactivityforresult1_3 + detailedPath_lu_uni_serval_icc_startactivityforresult1_5
}
one sig intent3__639jggovcif741td0bb31ian9r extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult1_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult1_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult1_6 + detailedPath_lu_uni_serval_icc_startactivityforresult1_3 + detailedPath_lu_uni_serval_icc_startactivityforresult1_5
}
one sig intent4__jk52ptl11a3j5sbvilvlupevo2 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult1_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult1_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult1_6 + detailedPath_lu_uni_serval_icc_startactivityforresult1_3 + detailedPath_lu_uni_serval_icc_startactivityforresult1_5
}


fact {
existingApps.apps = lu_uni_serval_icc_startactivityforresult1
}

check privEscal for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 6 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 6 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 6 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 6 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 6 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 6 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 5 Intent, exactly 8 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 5 Intent, exactly 7 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 4 Intent, exactly 7 DetailedPath
