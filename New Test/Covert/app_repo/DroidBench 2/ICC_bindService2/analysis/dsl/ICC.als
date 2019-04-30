//Automatically Generated
module ICC 

open lu_uni_serval_icc_bindservice2


one sig intent1__1g1ig5j8qhvkj7a0so0vtc6i7 extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent2__40tcamkqis76ohtbubf9lip7ei extends Intent{}{
//  lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()
    sender=lu_uni_serval_icc_bindservice2_InFlowService
	component=lu_uni_serval_icc_bindservice2_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice2_3
}
one sig intent3__dgs9eanv307e5oabjj60r7hu40 extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent4__age28rshln3lpj2vdk9ih6fs1c extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent5__mm3al9qvts9mbg2lunq0ri7gro extends Intent{}{
//  lu.uni.serval.icc_bindservice2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice2_OutFlowActivity
	component=lu_uni_serval_icc_bindservice2_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	no detailedPaths
}
one sig intent6__t4gbp36gh50fdu21h5sp2tjli1 extends Intent{}{
//  lu.uni.serval.icc_bindservice2.InFlowService$LocalBinder: java.lang.String getDeviceId()
    sender=lu_uni_serval_icc_bindservice2_InFlowService
	component=lu_uni_serval_icc_bindservice2_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice2_2
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
