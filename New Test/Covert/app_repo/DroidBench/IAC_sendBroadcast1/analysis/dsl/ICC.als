//Automatically Generated
module ICC 

open lu_uni_serval_iac_sendbroadcast1_sink
open lu_uni_serval_iac_sendbroadcast1_source


one sig intent1__136jhmkicvb6ipq3jdq9skasjl extends Intent{}{
//  lu.uni.serval.iac_sendbroadcast1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_sendbroadcast1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_sendbroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_sendbroadcast1_source_1 + detailedPath_lu_uni_serval_iac_sendbroadcast1_source_2
}
one sig intent2__lm9j8g4cc8vp5b0928kvand4tj extends Intent{}{
//  lu.uni.serval.iac_sendbroadcast1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_sendbroadcast1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_sendbroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_sendbroadcast1_source_1 + detailedPath_lu_uni_serval_iac_sendbroadcast1_source_2
}
one sig intent3__f4mc69ud8vkpi0t3lifts2p6go extends Intent{}{
//  lu.uni.serval.iac_sendbroadcast1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_sendbroadcast1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_sendbroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_sendbroadcast1_source_1 + detailedPath_lu_uni_serval_iac_sendbroadcast1_source_2
}
one sig intent4__m9etn6e20ck4fo3qbmlu4gpvpj extends Intent{}{
//  lu.uni.serval.iac_sendbroadcast1_source.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_iac_sendbroadcast1_source_OutFlowActivity
	no component
	action=lu_uni_serval_iac_sendbroadcast1_ACTION_A
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_iac_sendbroadcast1_source_1 + detailedPath_lu_uni_serval_iac_sendbroadcast1_source_2
}


fact {
existingApps.apps = lu_uni_serval_iac_sendbroadcast1_sink + lu_uni_serval_iac_sendbroadcast1_source
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
run generateInfoLeak for 1 but exactly 3 Application, exactly 3 Activity, exactly 0 Service, exactly 2 Receiver, exactly 4 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 3 Application, exactly 3 Activity, exactly 0 Service, exactly 2 Receiver, exactly 3 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 3 Application, exactly 3 Activity, exactly 0 Service, exactly 2 Receiver, exactly 4 IntentFilter, exactly 4 Intent, exactly 4 DetailedPath
