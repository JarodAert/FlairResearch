//Automatically Generated
module ICC 

open lu_uni_serval_icc_sendBroadcast1


one sig intent1__anp2asb63s2ntiot9i3hjc8esi extends Intent{}{
//  lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_sendBroadcast1_OutFlowActivity
	no component
	action=lu_uni_serval_icc_sendBroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_sendBroadcast1_2 + detailedPath_lu_uni_serval_icc_sendBroadcast1_3
}
one sig intent2__m3tdt3b3nm98uoc2tpci52apj5 extends Intent{}{
//  lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_sendBroadcast1_OutFlowActivity
	no component
	action=lu_uni_serval_icc_sendBroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_sendBroadcast1_2 + detailedPath_lu_uni_serval_icc_sendBroadcast1_3
}
one sig intent3__psrtoamm5595pkgsis0sdfk651 extends Intent{}{
//  lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_sendBroadcast1_OutFlowActivity
	no component
	action=lu_uni_serval_icc_sendBroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_sendBroadcast1_2 + detailedPath_lu_uni_serval_icc_sendBroadcast1_3
}
one sig intent4__49ugoccdf4lvf43pk487cjth5 extends Intent{}{
//  lu.uni.serval.icc_sendBroadcast1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_sendBroadcast1_OutFlowActivity
	no component
	action=lu_uni_serval_icc_sendBroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_sendBroadcast1_2 + detailedPath_lu_uni_serval_icc_sendBroadcast1_3
}


fact {
existingApps.apps = lu_uni_serval_icc_sendBroadcast1
}

check privEscal for 1 but exactly 1 Application, exactly 3 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 3 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 3 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 3 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 3 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 3 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 2 Activity, exactly 0 Service, exactly 2 Receiver, exactly 4 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 2 Activity, exactly 0 Service, exactly 2 Receiver, exactly 3 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 2 Activity, exactly 0 Service, exactly 2 Receiver, exactly 4 IntentFilter, exactly 4 Intent, exactly 4 DetailedPath
