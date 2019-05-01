//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivityforresult3


one sig intent1__ptfaktel9hj045l2d8ap27t5h6 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult3_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult3_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult3_4 + detailedPath_lu_uni_serval_icc_startactivityforresult3_3
}
one sig intent2__1n2umqjkb6et031fkcvegb92s3 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult3_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult3_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult3_4 + detailedPath_lu_uni_serval_icc_startactivityforresult3_3
}
one sig intent3__j1fueupa4imttdtrqra3djujai extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult3.InFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult3_InFlowActivity
	component=lu_uni_serval_icc_startactivityforresult3_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult3_2
}
one sig intent4__dgkht013sqmpv5598usdkeg1c7 extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult3_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult3_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult3_4 + detailedPath_lu_uni_serval_icc_startactivityforresult3_3
}
one sig intent5__bemp87840gmjl2rlqpgke7ueeu extends Intent{}{
//  lu.uni.serval.icc_startactivityforresult3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivityforresult3_OutFlowActivity
	component=lu_uni_serval_icc_startactivityforresult3_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivityforresult3_4 + detailedPath_lu_uni_serval_icc_startactivityforresult3_3
}


fact {
existingApps.apps = lu_uni_serval_icc_startactivityforresult3
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
