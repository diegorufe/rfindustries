package features

type BaseCommonsParamenters interface {
	GetUserId() interface{}
	GetBusinessCustomerId() interface{}
	GetEnterpriseId() interface{}
	GetOtherParams() map[string]interface{}
	GetContextParams() map[string]interface{}
}

type BaseCommonsParamentersImpl struct {
	UserId             int64
	BusinessCustomerId int64
	EnterpriseId       int64
	OtherParams        map[string]interface{}
	ContextParams      map[string]interface{}
}

func (commonsParameters BaseCommonsParamentersImpl) GetUserId() interface{} {
	return commonsParameters.UserId
}

func (commonsParameters BaseCommonsParamentersImpl) GetBusinessCustomerId() interface{} {
	return commonsParameters.BusinessCustomerId
}

func (commonsParameters BaseCommonsParamentersImpl) GetEnterpriseId() interface{} {
	return commonsParameters.EnterpriseId
}

func (commonsParameters BaseCommonsParamentersImpl) GetOtherParams() map[string]interface{} {
	return commonsParameters.OtherParams
}

func (commonsParameters BaseCommonsParamentersImpl) GetContextParams() map[string]interface{} {
	return commonsParameters.ContextParams
}
