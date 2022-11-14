package service

import "launcher/pkg/model"

var appContextEnviroment *model.AppContext = &model.AppContext{}

func GetAppContext() *model.AppContext {
	return appContextEnviroment
}
