package dto

import "time"

type BaseJDBCDTO struct {
	BaseDTO
	Id                 int64     `json:"id"`
	UserCreatedAtId    int64     `json:"userCreatedAtId"`
	UserUpdatedAtId    int64     `json:"userUpdatedAtId"`
	CreatedAt          time.Time `json:"createdAt"`
	UpdatedAt          time.Time `json:"updatedAt"`
	BusinessCustomerId int64     `json:"businessCustomerId"`
	EnterpriseId       int64     `json:"enterpriseId"`
}
