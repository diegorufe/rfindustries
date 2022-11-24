package service

import (
	"encoding/json"
	"io/ioutil"
	"launcher/pkg/model"
	"log"
	"os"
	"os/exec"
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

	appContextEnviroment.AppsConfig = make(map[string]*model.AppConfig)

	if appContextEnviroment.AppsPidsRun == nil {
		appContextEnviroment.AppsPidsRun = make(map[string]int)
	}

	appContextEnviroment.RoutesIntercept = map[string]string{}

	for _, appConfig := range configModel.AppsConfig {
		if len(appConfig.Name) > 0 {
			appContextEnviroment.AppsConfig[appConfig.Name] = &appConfig

			// Run process app
			go func() {
				service.runProcessAppConfig(appConfig)
			}()

			if len(appConfig.Route) > 0 {
				appContextEnviroment.RoutesIntercept[appConfig.Route] = appConfig.DestinationHost
			}
		}
	}

}

func (service AppContextService) runProcessAppConfig(appConfig model.AppConfig) {
	pid, isRun := appContextEnviroment.AppsPidsRun[appConfig.Name]
	if appConfig.RunOnStart && (!isRun || pid == 0) {

		cmd := exec.Command(appConfig.PathExecutable)
		err := cmd.Start()

		if err == nil {
			pid := cmd.Process.Pid
			appContextEnviroment.AppsPidsRun[appConfig.Name] = pid

			// use goroutine waiting, manage process
			// this is important, otherwise the process becomes in S mode
			go func() {
				err = cmd.Wait()
				log.Printf("Command finished with error: %v | pid %d | application %s", err, pid, appConfig.Name)
				appContextEnviroment.AppsPidsRun[appConfig.Name] = 0
			}()
		}
	}
}
