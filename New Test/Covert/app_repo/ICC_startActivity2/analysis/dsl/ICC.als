//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivity2


one sig intent1__ttpvnd6k2m7l5ao86ultdbd1nf extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}
one sig intent2__ui15iocg7mcn6avhar0rmvg525 extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}
one sig intent3__raiehflnccc4s1817rr9ih9v2n extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent4__9g74ip4d1169okrcj5n73tarcj extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent5__ufl2fo1q6rglg8h7ndk3cnb8re extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent6__89c6rsk37uhqumqkpg5jjrs1i4 extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent7__p49ra197mj450narv2q66gv63k extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}
one sig intent8__m22p8sm451far4drhc5eii5nki extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}


fact {
existingApps.apps = lu_uni_serval_icc_startactivity2
}

check privEscal for 1 but exactly 1 Application, exactly 4 Component, exactly 1 IntentFilter, exactly 8 Intent, exactly 5 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 4 Component, exactly 1 IntentFilter, exactly 8 Intent, exactly 5 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 4 Component, exactly 1 IntentFilter, exactly 8 Intent, exactly 5 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 4 Component, exactly 1 IntentFilter, exactly 8 Intent, exactly 5 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 4 Component, exactly 1 IntentFilter, exactly 8 Intent, exactly 5 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 4 Component, exactly 1 IntentFilter, exactly 8 Intent, exactly 5 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 5 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 9 Intent, exactly 7 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 5 Activity, exactly 0 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 9 Intent, exactly 6 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 5 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 8 Intent, exactly 6 DetailedPath
