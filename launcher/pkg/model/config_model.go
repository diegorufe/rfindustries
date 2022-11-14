package model

type Config struct {
	AppsConfig []AppConfig
}

type AppConfig struct {
	PathExecutable string // for start aplication if neeed
	PathIcon       string // for load icon and convert base64 string
	Icon           string // base64
	Start          bool   // if is true application start when launcher
}
