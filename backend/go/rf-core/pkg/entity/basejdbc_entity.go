package entity

import "time"

type BaseJDBCEntity struct {
	Id                 int64     `json:"id"`
	UserCreatedAtId    int64     `json:"userCreatedAtId"`
	UserUpdatedAtId    int64     `json:"userUpdatedAtId"`
	CreatedAt          time.Time `json:"createdAt"`
	UpdatedAt          time.Time `json:"updatedAt"`
	BusinessCustomerId int64     `json:"businessCustomerId"`
	EnterpriseId       int64     `json:"enterpriseId"`
}

func (entity BaseJDBCEntity) Audit(userId interface{}, create bool) {

	now := time.Now()

	if create {
		if userId != nil {
			entity.UserCreatedAtId = userId.(int64)
		}
		entity.CreatedAt = now
	}

	if userId != nil {
		entity.UserUpdatedAtId = userId.(int64)
	}
	entity.UpdatedAt = now
}

func (entity BaseJDBCEntity) ResolveBusinessCustomer(businessCustomerId interface{}) {

	if businessCustomerId != nil {
		entity.BusinessCustomerId = businessCustomerId.(int64)
	}
}

func (entity BaseJDBCEntity) ResolveEnterprise(enterprirseId interface{}) {

	if enterprirseId != nil {
		entity.EnterpriseId = enterprirseId.(int64)
	}
}
