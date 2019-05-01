//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivityforresult2


one sig intent1__28cb82s76ttvf6g1mqnd3nadh9 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult2.InFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult2_InFlowActivity
	component=lu_uni_serval_icc_startactivityforresult2_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult2_4 + detailedPath_lu_uni_serval_icc_startactivityforresult2_3
}
one sig intent2__gond23csu4d0nphld2j93t809k extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult2_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent3__dvgenogqe37b0v8o6ct75qtcev extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult2_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent4__jodo3eb4d95kfqsoigkgkii2bv extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult2_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent5__roiogj5vf9abk24dss0to8tcg6 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult2_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}


fact {
existingApps.apps = lu_uni_serval_icc_startactivityforresult2
}

check privEscal for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 3 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 6 Intent, exactly 6 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 4 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath
