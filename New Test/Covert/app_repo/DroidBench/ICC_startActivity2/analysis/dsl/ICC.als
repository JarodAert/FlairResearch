//Automatically Generated
module ICC 

open lu_uni_serval_icc_startactivity2


one sig intent1__uvjekp4suqok8fpq2ep3t0qgl2 extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent2__gmclqg4iob0k6isvu8hel1b06j extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent3__5djoakvv8uco9i77be441te3jo extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}
one sig intent4__6le10dcmviaan59a1hd95ukum7 extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}
one sig intent5__voc25t1stpapkjtr5d6ov78anj extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent6__4lqko8fevjddpkhjr5nt1mr1gb extends Intent{}{
//  lu.uni.serval.icc_startactivity2.IntermediateFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	component=lu_uni_serval_icc_startactivity2_InFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_2
}
one sig intent7__njdbrn1amb1f457k2bsdapl0g extends Intent{}{
//  lu.uni.serval.icc_startactivity2.OutFlowActivity: void onCreate(android.os.Bundle)
    sender=lu_uni_serval_icc_startactivity2_OutFlowActivity
	component=lu_uni_serval_icc_startactivity2_IntermediateFlowActivity
	action=NoAction
	categories=android_intent_category_DEFAULT_C
	dataType=NoMIMEType
	dataScheme=NoScheme
	detailedPaths=detailedPath_lu_uni_serval_icc_startactivity2_4 + detailedPath_lu_uni_serval_icc_startactivity2_5
}
one sig intent8__coffkc8v5j4r43ief7sar5rcrq extends Intent{}{
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
