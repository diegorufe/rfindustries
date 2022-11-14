package config

import "launcher/pkg/service"

func LoadConfig() {
	var appContextService service.AppContextService = service.AppContextService{}
	appContextService.ReloadAppConfig()
}
