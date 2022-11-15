package service

import (
	"encoding/json"
	"io/ioutil"
	"launcher/pkg/model"
	"log"
	"os"
)

var appContextEnviroment *model.AppContext = &model.AppContext{}

type AppContextService struct {
}

func GetAppContext() *model.AppContext {
	return appContextEnviroment
}

func (service AppContextService) StartApplication(nameApp string) {

}

func (service AppContextService) StoptApplication(nameApp string) {

}

func (service AppContextService) ReloadAppConfig() {
	var pathJsonConfig string = "C:/programing/rfindustries/configLauncher.json"

	jsonFile, err := os.Open(pathJsonConfig)
	// if we os.Open returns an error then handle it
	if err != nil {
		log.Println(err)
	}

	log.Println("Successfully Opened users.json")
	// defer the closing of our jsonFile so that we can parse it later on
	defer jsonFile.Close()

	// read our opened xmlFile as a byte array.
	byteValue, _ := ioutil.ReadAll(jsonFile)

	var configModel model.Config

	json.Unmarshal(byteValue, &configModel)

	appContextEnviroment.AppsConfig = make(map[string]model.AppConfig)

	if appContextEnviroment.AppsConfigRun == nil {
		appContextEnviroment.AppsConfigRun = make(map[string]model.AppConfig)
	}

	appContextEnviroment.RoutesIntercept = map[string]string{}

	for _, appConfig := range configModel.AppsConfig {
		if len(appConfig.Name) > 0 {
			appContextEnviroment.AppsConfig[appConfig.Name] = appConfig

			_, isRun := appContextEnviroment.AppsConfigRun[appConfig.Name]

			if !isRun && appConfig.RunOnStart {
				// TODO run application
				appContextEnviroment.AppsConfigRun[appConfig.Name] = appConfig
			}

			if len(appConfig.Route) > 0 {
				appContextEnviroment.RoutesIntercept[appConfig.Route] = appConfig.DestinationHost
			}
		}
	}

}
