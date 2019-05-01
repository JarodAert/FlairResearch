//Automatically Generated
module ICC 

open lu_uni_serval_iac_startservice1_source
open lu_uni_serval_iac_startservice1_sink


one sig intent1__vnu1asdug12ql5bc9eim3bgn9l extends Intent{}{
//  lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_startservice1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_startservice1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_startservice1_source_2 + detailedPath_lu_uni_serval_iac_startservice1_source_1
}
one sig intent2__jc6sq08nsr0pai7n0jh324u95t extends Intent{}{
//  lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_startservice1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_startservice1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_startservice1_source_2 + detailedPath_lu_uni_serval_iac_startservice1_source_1
}
one sig intent3__hcit3l08nddq10t3paltfd9lh7 extends Intent{}{
//  lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_startservice1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_startservice1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_startservice1_source_2 + detailedPath_lu_uni_serval_iac_startservice1_source_1
}
one sig intent4__9ik8r61adokpcai197avr9fils extends Intent{}{
//  lu.uni.serval.iac_startservice1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_startservice1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_startservice1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_startservice1_source_2 + detailedPath_lu_uni_serval_iac_startservice1_source_1
}


fact {
existingApps.apps = lu_uni_serval_iac_startservice1_source + lu_uni_serval_iac_startservice1_sink
}

check privEscal for 1 but exactly 2 Application, exactly 4 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 2 Application, exactly 4 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 2 Application, exactly 4 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 2 Application, exactly 4 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 2 Application, exactly 4 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 2 Application, exactly 4 Component, exactly 3 IntentFilter, exactly 4 Intent, exactly 3 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 3 Application, exactly 3 Activity, exactly 2 Service, exactly 0 Receiver, exactly 4 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 3 Application, exactly 3 Activity, exactly 2 Service, exactly 0 Receiver, exactly 3 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 3 Application, exactly 3 Activity, exactly 2 Service, exactly 0 Receiver, exactly 4 IntentFilter, exactly 4 Intent, exactly 4 DetailedPath
