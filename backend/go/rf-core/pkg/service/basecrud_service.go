package service

import (
	"rfindustries/rf-core/pkg/dao"
	"rfindustries/rf-core/pkg/features"
)

type BaseCrudService interface {
	GetDao(self BaseCrudService, commonsParameters features.BaseCommonsParamenters) *dao.BaseDao
	CheckBeforeInsertUpdate(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}, insert bool) (interface{}, error)
	CheckAfterInsertUpdate(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}, insert bool) (interface{}, error)
	Insert(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) (interface{}, error)
	Update(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) (interface{}, error)
	Delete(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) (bool, error)
	ToDTO(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, entity interface{}) interface{}
	ToEntity(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) interface{}
}

type BaseCrudServiceImpl struct {
	Dao dao.BaseDao
}

func (baseCrudService BaseCrudServiceImpl) GetDao(self BaseCrudService, commonsParameters features.BaseCommonsParamenters) dao.BaseDao {
	return baseCrudService.Dao
}

func (baseCrudService BaseCrudServiceImpl) CheckBeforeInsertUpdate(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}, insert bool) (interface{}, error) {
	result := dto
	var err error

	if self != nil {
		result, dto = self.CheckBeforeInsertUpdate(nil, commonsParameters, dto, insert)
	}

	return result, err
}

func (baseCrudService BaseCrudServiceImpl) CheckAfterInsertUpdate(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}, insert bool) (interface{}, error) {
	result := dto
	var err error

	if self != nil {
		result, dto = self.CheckAfterInsertUpdate(nil, commonsParameters, dto, insert)
	}

	return result, err
}

func (baseCrudService BaseCrudServiceImpl) Insert(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) (interface{}, error) {
	dto, err := baseCrudService.CheckBeforeInsertUpdate(self, commonsParameters, dto, true)

	if err == nil {
		entity := self.ToEntity(nil, commonsParameters, dto)
		dao := baseCrudService.GetDao(nil, commonsParameters)
		entity = dao.Insert(dao, commonsParameters, entity)
		dto = self.ToDTO(self, commonsParameters, entity)
		dto, err = self.CheckAfterInsertUpdate(nil, commonsParameters, dto, true)
	}

	return dto, err
}

func (baseCrudService BaseCrudServiceImpl) Update(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) (interface{}, error) {
	dto, err := baseCrudService.CheckBeforeInsertUpdate(self, commonsParameters, dto, false)

	if err == nil {
		entity := self.ToEntity(nil, commonsParameters, dto)
		dao := baseCrudService.GetDao(nil, commonsParameters)
		entity = dao.Update(dao, commonsParameters, entity)
		dto = self.ToDTO(self, commonsParameters, entity)
		dto, err = self.CheckAfterInsertUpdate(nil, commonsParameters, dto, false)
	}

	return dto, err
}

func (baseCrudService BaseCrudServiceImpl) Delete(self BaseCrudService, commonsParameters features.BaseCommonsParamenters, dto interface{}) (bool, error) {
	entity := self.ToEntity(nil, commonsParameters, dto)
	var err error

	dao := baseCrudService.GetDao(nil, commonsParameters)

	return dao.Delete(dao, commonsParameters, entity), err
}
