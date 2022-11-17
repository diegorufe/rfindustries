package model

type AppContext struct {
	AppsConfig      map[string]*AppConfig // Applications
	RoutesIntercept map[string]string     // Routes http intercept
	AppsPidsRun     map[string]int        // Pids apps run
}
