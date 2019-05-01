//Automatically Generated
module ICC 

open lu_uni_serval_icc_bindservice2


one sig intent1__ajipi6bnucsr54gn5l81tjee82 extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent2__rcoei350eutjimv8lipjva2j9e extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent3__pd01b89q9leplmoqf6r78cntfg extends Intent{}{
//  lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()
    sender=lu_uni_serval_icc_bindservice2_InFlowService
	component=lu_uni_serval_icc_bindservice2_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice2_2
}
one sig intent4__kgq5q0qvln42009qd9k9qgsils extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent5__ieos9o4342e1esmk3suuaal9ks extends Intent{}{
//  lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()
    sender=lu_uni_serval_icc_bindservice2_InFlowService
	component=lu_uni_serval_icc_bindservice2_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice2_3
}
one sig intent6__o61db1kunntkrfba0bithcp4nt extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}


fact {
existingApps.apps = lu_uni_serval_icc_bindservice2
}

check privEscal for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 3 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 3 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 3 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 3 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 2 Activity, exactly 1 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 7 Intent, exactly 5 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 2 Activity, exactly 1 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 7 Intent, exactly 4 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 2 Activity, exactly 1 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 6 Intent, exactly 4 DetailedPath
