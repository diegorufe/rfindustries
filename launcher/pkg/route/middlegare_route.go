package route

import (
	"launcher/pkg/service"
	"net/http"
)

type Middleware struct {
	handler http.Handler
}

// ServeHTTP handles the request by passing it to the real
// handler and logging the request details
func (l *Middleware) ServeHTTP(w http.ResponseWriter, r *http.Request) {

	// log.Printf("%s %s", r.Method, r.URL.Path)

	appContext := service.GetAppContext()
	_, containsPath := appContext.RoutesIntercept[r.URL.Path]

	if containsPath {
		l.handler.ServeHTTP(w, r)
	} else {
		w.WriteHeader(http.StatusNotFound)
		w.Write([]byte("Resource " + r.URL.Path + " not found"))
	}

	// log.Printf("%s %s", r.Method, r.URL.Path)
}

func NewMiddleware(handlerToWrap http.Handler) *Middleware {
	return &Middleware{handlerToWrap}
}
