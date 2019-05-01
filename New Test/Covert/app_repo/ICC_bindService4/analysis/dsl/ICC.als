//Automatically Generated
module ICC 

open lu_uni_serval_icc_bindservice4


one sig intent1__e3743hgt0nlshkqh81vego6425 extends Intent{}{
//  lu.uni.serval.icc_bindservice4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice4_OutFlowActivity
	component=lu_uni_serval_icc_bindservice4_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice4_3 + detailedPath_lu_uni_serval_icc_bindservice4_4
}
one sig intent2__vee1aovigur49isoqg4edjh1ih extends Intent{}{
//  lu.uni.serval.icc_bindservice4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice4_OutFlowActivity
	component=lu_uni_serval_icc_bindservice4_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice4_3 + detailedPath_lu_uni_serval_icc_bindservice4_4
}
one sig intent3__f2tgqjmb4b2iibqadis8ga31i6 extends Intent{}{
//  lu.uni.serval.icc_bindservice4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice4_OutFlowActivity
	component=lu_uni_serval_icc_bindservice4_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice4_3 + detailedPath_lu_uni_serval_icc_bindservice4_4
}
one sig intent4__llh2t0n4546cvdg4g0cu93r99a extends Intent{}{
//  lu.uni.serval.icc_bindservice4.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice4_InFlowService
	component=lu_uni_serval_icc_bindservice4_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice4_2
}
one sig intent5__1oipparv3ll2j97kj40cn9guit extends Intent{}{
//  lu.uni.serval.icc_bindservice4.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice4_OutFlowActivity
	component=lu_uni_serval_icc_bindservice4_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice4_3 + detailedPath_lu_uni_serval_icc_bindservice4_4
}
one sig intent6__5lcp48v4qan8696mg8gsmd04kl extends Intent{}{
//  lu.uni.serval.icc_bindservice4.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice4_InFlowService
	component=lu_uni_serval_icc_bindservice4_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice4_5
}


fact {
existingApps.apps = lu_uni_serval_icc_bindservice4
}

check privEscal for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 2 Activity, exactly 2 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 7 Intent, exactly 7 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 2 Activity, exactly 2 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 7 Intent, exactly 6 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 2 Activity, exactly 2 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 6 Intent, exactly 6 DetailedPath
