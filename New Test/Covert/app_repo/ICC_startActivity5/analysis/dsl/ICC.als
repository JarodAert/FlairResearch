//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivity5


one sig intent1__99s9k2ah534bti7ftud07voslp extends Intent{}{
//  lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity5_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=text_plain_D
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity5_3 + detailedPath_lu_uni_serval_icc_startactivity5_2
}
one sig intent2__jjvr0ejjtuaqr0e66pjnljnf15 extends Intent{}{
//  lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity5_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=text_plain_D
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity5_3 + detailedPath_lu_uni_serval_icc_startactivity5_2
}
one sig intent3__limc599kuf13pdf19d3n44utld extends Intent{}{
//  lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity5_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=text_plain_D
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity5_3 + detailedPath_lu_uni_serval_icc_startactivity5_2
}
one sig intent4__vq1j1htn16j82og7csvnlvgl6r extends Intent{}{
//  lu.uni.serval.icc_startactivity5.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity5_OutFlowActivity
	no component
	action=lu_uni_serval_icc_startactivity4_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=text_plain_D
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity5_3 + detailedPath_lu_uni_serval_icc_startactivity5_2
}


fact {
existingApps.apps = lu_uni_serval_icc_startactivity5
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
