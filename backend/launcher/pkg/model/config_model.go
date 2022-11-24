package model

type Config struct {
	AppsConfig []AppConfig
}

type AppConfig struct {
	PathExecutable  string // for start aplication if neeed
	PathIcon        string // for load icon and convert base64 string
	Icon            string // base64
	Name            string // Name of application
	Route           string // Route intercept middeware
	DestinationHost string // Host destination http/grpc/ etc... aplication
	RunOnStart      bool   // Indicate run application on start
}
