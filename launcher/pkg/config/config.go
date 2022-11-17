package config

import (
	"launcher/pkg/route"
	"launcher/pkg/service"
	"log"
	"net/http"
)

func LoadConfig() {
	var appContextService service.AppContextService = service.AppContextService{}
	appContextService.ReloadAppConfig()

	loadServer()
}

func HelloHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello, World!"))
}

func loadServer() {
	mux := http.NewServeMux()
	mux.HandleFunc("/test", HelloHandler)
	log.Fatal(http.ListenAndServe(":6000", route.NewMiddleware(mux)))
}
