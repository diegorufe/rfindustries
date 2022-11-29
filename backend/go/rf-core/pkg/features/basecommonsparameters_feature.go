package features

type BaseCommonsParamenters interface {
	getUserId() interface{}
	getBusinessCustomerId() interface{}
	getEnterpriseId() interface{}
}

type BaseCommonsParamentersImpl struct {
	UserId             int64
	BusinessCustomerId int64
	EnterpriseId       int64
}

func (commonsParameters BaseCommonsParamentersImpl) getUserId() interface{} {
	return commonsParameters.UserId
}

func (commonsParameters BaseCommonsParamentersImpl) getBusinessCustomerId() interface{} {
	return commonsParameters.BusinessCustomerId
}

func (commonsParameters BaseCommonsParamentersImpl) getEnterpriseId() interface{} {
	return commonsParameters.EnterpriseId
}
