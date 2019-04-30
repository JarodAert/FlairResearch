//Automatically Generated
module ICC 

open lu_uni_serval_icc_bindservice1


one sig intent1__nbl5saauv3oq52p140hjmih3b5 extends Intent{}{
//  lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice1_InFlowService
	component=lu_uni_serval_icc_bindservice1_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_2
}
one sig intent2__ji8mujfuu225blconr3l1k5t9u extends Intent{}{
//  lu.uni.serval.icc_bindservice1.InFlowService: android.os.IBinder onBind(android.content.Intent)
    sender=lu_uni_serval_icc_bindservice1_InFlowService
	component=lu_uni_serval_icc_bindservice1_OutFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_3
}
one sig intent3__dbgtoec7iep6e3cbbh7sbvbtko extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}
one sig intent4__4sbl64r1vd98ldcdksjbnv6eci extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}
one sig intent5__q9p53kv9vc6cs5gis54cflelj8 extends Intent{}{
//  lu.uni.serval.icc_bindservice1.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_bindservice1_OutFlowActivity
	component=lu_uni_serval_icc_bindservice1_InFlowService
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_bindservice1_4 + detailedPath_lu_uni_serval_icc_bindservice1_5
}
one sig intent6__piept4bolror5p1dtkhqbbefa7 extends Intent{}{
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
