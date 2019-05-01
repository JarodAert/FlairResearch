//Automatically Generated
module ICC 

open lu_uni_serval_icc_bindservice3


one sig intent1__q9bbrsivhfpmd8qc4jlda2fgie extends Intent{}{
//  lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice3_OutFlowActivity
	component=lu_uni_serval_icc_bindservice3_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice3_2 + detailedPath_lu_uni_serval_icc_bindservice3_3
}
one sig intent2__sb23ao2ht07pcrtt84vm4ot0be extends Intent{}{
//  lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice3_OutFlowActivity
	component=lu_uni_serval_icc_bindservice3_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice3_2 + detailedPath_lu_uni_serval_icc_bindservice3_3
}
one sig intent3__o9feouamp2t7o2gl98oofbqg1f extends Intent{}{
//  lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice3_OutFlowActivity
	component=lu_uni_serval_icc_bindservice3_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice3_2 + detailedPath_lu_uni_serval_icc_bindservice3_3
}
one sig intent4__dia1g681ep6h16phkofubl6rje extends Intent{}{
//  lu.uni.serval.icc_bindservice3.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice3_InFlowService
	component=lu_uni_serval_icc_bindservice3_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice3_4
}
one sig intent5__4ee091q3uh1tpuah2a2hibirjq extends Intent{}{
//  lu.uni.serval.icc_bindservice3.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice3_OutFlowActivity
	component=lu_uni_serval_icc_bindservice3_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice3_2 + detailedPath_lu_uni_serval_icc_bindservice3_3
}


fact {
existingApps.apps = lu_uni_serval_icc_bindservice3
}

check privEscal for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 2 Component, exactly 1 IntentFilter, exactly 5 Intent, exactly 4 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 2 Activity, exactly 1 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 6 Intent, exactly 6 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 2 Activity, exactly 1 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 6 Intent, exactly 5 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 2 Activity, exactly 1 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 5 Intent, exactly 5 DetailedPath
