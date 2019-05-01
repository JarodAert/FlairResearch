//Automatically Generated
module ICC 

open lu_uni_serval_icc_startservice1


one sig intent1__teb0p738gl11is3mlaelj25adf extends Intent{}{
//  lu.uni.serval.icc_startservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startservice1_OutFlowActivity
	component=lu_uni_serval_icc_startservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startservice1_3 + detailedPath_lu_uni_serval_icc_startservice1_2
}
one sig intent2__7aqjhaf0dm06d5sfg0hosg23bs extends Intent{}{
//  lu.uni.serval.icc_startservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startservice1_OutFlowActivity
	component=lu_uni_serval_icc_startservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startservice1_3 + detailedPath_lu_uni_serval_icc_startservice1_2
}
one sig intent3__dsa4ffoo5blmmcpr3cctl4t4f3 extends Intent{}{
//  lu.uni.serval.icc_startservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startservice1_OutFlowActivity
	component=lu_uni_serval_icc_startservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startservice1_3 + detailedPath_lu_uni_serval_icc_startservice1_2
}
one sig intent4__dhg1tjp1qspmlic4nkh0siph4d extends Intent{}{
//  lu.uni.serval.icc_startservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startservice1_OutFlowActivity
	component=lu_uni_serval_icc_startservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startservice1_3 + detailedPath_lu_uni_serval_icc_startservice1_2
}


fact {
existingApps.apps = lu_uni_serval_icc_startservice1
}

check privEscal for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 2 Activity, exactly 2 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 2 Activity, exactly 2 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 2 Activity, exactly 2 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 4 Intent, exactly 4 DetailedPath
