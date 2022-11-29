package dao

import "rf-core/pkg/features"

type BaseJDBCDao struct {
}

func (dao BaseJDBCDao) TableName(self BaseDao) string {
	return self.TableName(self)
}

func Insert(self BaseDao, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{} {

	return entity
}

func Update(self BaseDao, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{} {

	return entity
}

func Delete(self BaseDao, commonsParameters features.BaseCommonsParamenters, entity interface{}) bool {

	return true
}
