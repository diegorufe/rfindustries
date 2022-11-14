package model

type AppContext struct {
	AppsConfigRun map[string]AppConfig // Applications run
	AppsConfig    map[string]AppConfig // Applications
}
