package dao

import "rf-core/pkg/features"

type BaseDao interface {
	TableName(self BaseDao) string
	Insert(self BaseDao, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{}
	Update(self BaseDao, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{}
	Delete(self BaseDao, commonsParameters features.BaseCommonsParamenters, entity interface{}) bool
}
