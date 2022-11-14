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

func (service AppContextService) GetAppContext() *model.AppContext {
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
}
