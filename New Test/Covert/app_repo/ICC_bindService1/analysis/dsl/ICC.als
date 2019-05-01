//Automatically Generated
module ICC 

open lu_uni_serval_icc_bindservice1


one sig intent1__cirkppn023ce30ca8p4mv750ib extends Intent{}{
//  lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice1_InFlowService
	component=lu_uni_serval_icc_bindservice1_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_3
}
one sig intent2__uro1ftho41cr4ca2sh6937a97l extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}
one sig intent3__qat6tf2u2j5vtmobmuqtvpa4l1 extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}
one sig intent4__smialcmo68v8i3sgustanalmkt extends Intent{}{
//  lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice1_InFlowService
	component=lu_uni_serval_icc_bindservice1_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_2
}
one sig intent5__a40tfeatksdk60em4gu5q854ct extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}
one sig intent6__ads3fbpeiegi59c7gd3pq7fp4t extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}


fact {
existingApps.apps = lu_uni_serval_icc_bindservice1
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
