//Automatically Generated
module ICC 

open lu_uni_serval_icc_insert1




fact {
existingApps.apps = lu_uni_serval_icc_insert1
}

check privEscal for 1 but exactly 1 Application, exactly 1 Component, exactly 1 IntentFilter, exactly 0 Intent, exactly 2 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 1 Application, exactly 1 Component, exactly 1 IntentFilter, exactly 0 Intent, exactly 2 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 1 Application, exactly 1 Component, exactly 1 IntentFilter, exactly 0 Intent, exactly 2 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 1 Application, exactly 1 Component, exactly 1 IntentFilter, exactly 0 Intent, exactly 2 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 1 Application, exactly 1 Component, exactly 1 IntentFilter, exactly 0 Intent, exactly 2 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 1 Application, exactly 1 Component, exactly 1 IntentFilter, exactly 0 Intent, exactly 2 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 2 Application, exactly 2 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 1 Intent, exactly 4 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 2 Application, exactly 2 Activity, exactly 0 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 1 Intent, exactly 3 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 2 Application, exactly 2 Activity, exactly 0 Service, exactly 0 Receiver, exactly 2 IntentFilter, exactly 0 Intent, exactly 3 DetailedPath
