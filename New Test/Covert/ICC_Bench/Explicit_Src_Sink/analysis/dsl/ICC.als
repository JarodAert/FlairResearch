//Automatically Generated
module ICC 





fact {
existingApps.apps = 
}

check privEscal for 1 but exactly 0 Application, exactly 0 Component, exactly 0 IntentFilter, exactly 0 Intent, exactly 0 DetailedPath 

check InfoLeaksInterApp for 1 but exactly 0 Application, exactly 0 Component, exactly 0 IntentFilter, exactly 0 Intent, exactly 0 DetailedPath 

check InfoLeaksIntraAppTransitive1 for 1 but exactly 0 Application, exactly 0 Component, exactly 0 IntentFilter, exactly 0 Intent, exactly 0 DetailedPath 
check InfoLeaksIntraAppTransitive2 for 1 but exactly 0 Application, exactly 0 Component, exactly 0 IntentFilter, exactly 0 Intent, exactly 0 DetailedPath 
check InfoLeaksIntraAppTransitive3 for 1 but exactly 0 Application, exactly 0 Component, exactly 0 IntentFilter, exactly 0 Intent, exactly 0 DetailedPath 
check InfoLeaksIntraAppTransitive4 for 1 but exactly 0 Application, exactly 0 Component, exactly 0 IntentFilter, exactly 0 Intent, exactly 0 DetailedPath 


pred generateInfoLeak{
 some GeneratedExp
}
//The exact number of each element is the one shown minus one (except Service & Receiver (=), and DetailedPath (=-2))
run generateInfoLeak for 1 but exactly 1 Application, exactly 1 Activity, exactly 0 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 1 Intent, exactly 2 DetailedPath

pred generateActivityLunch{
 some GeneratedExpActivityLunch
}
//The exact number of each element is the one shown minus one (except Service, Receiver & IntentFilter (=))
run generateActivityLunch for 1 but exactly 1 Application, exactly 1 Activity, exactly 0 Service, exactly 0 Receiver, exactly 0 IntentFilter, exactly 1 Intent, exactly 1 DetailedPath


pred generateIntentHijack{
	some GeneratedExpIntentHijack
}
//The exact number of each element is the one shown minus one (except Service & Receiver)
run generateIntentHijack for 1 but exactly 1 Application, exactly 1 Activity, exactly 0 Service, exactly 0 Receiver, exactly 1 IntentFilter, exactly 0 Intent, exactly 1 DetailedPath
