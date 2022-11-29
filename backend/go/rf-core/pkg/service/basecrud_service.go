package service

import "rf-core/pkg/features"

type BaseCrudService interface {
	Insert(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{}
	Update(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{}
	Delete(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, entity interface{}) bool
}
