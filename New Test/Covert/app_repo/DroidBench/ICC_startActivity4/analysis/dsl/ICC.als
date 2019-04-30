//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivity4


one sig intent1__3vv7bt7cjq8v2nlgp7kqck44ln extends Intent{}{
//  lu.uni.serval.icc_startactivity4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity4_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=YesScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity4_2 + detailedPath_lu_uni_serval_icc_startactivity4_3
}
one sig intent2__ev7sq1s9hi74cp6f9o2o4p4ob2 extends Intent{}{
//  lu.uni.serval.icc_startactivity4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity4_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=YesScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity4_2 + detailedPath_lu_uni_serval_icc_startactivity4_3
}
one sig intent3__c5hmupnq91pec13tiubt998v5f extends Intent{}{
//  lu.uni.serval.icc_startactivity4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity4_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=YesScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity4_2 + detailedPath_lu_uni_serval_icc_startactivity4_3
}
one sig intent4__b2n3blhadod306ea7j1m41tljn extends Intent{}{
//  lu.uni.serval.icc_startactivity4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity4_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=YesScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity4_2 + detailedPath_lu_uni_serval_icc_startactivity4_3
}


fact {
existingApps.apps = lu_uni_serval_icc_startactivity4
}

check privEscal for 1 but exactly 1 Application, exactly 3 Component, exactly 2 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 3 Component, exactly 2 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 3 Component, exactly 2 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 3 Component, exactly 2 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 3 Component, exactly 2 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 3 Component, exactly 2 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 3 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 3 IntentFilter, exactly 4 Intent, exactly 4 DetailedPath
