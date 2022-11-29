package entity

type BaseEntity interface {
	Audit(userId interface{}, create bool)
	ResolveBusinessCustomer(businessCustomerId interface{})
	ResolveEnterprise(enterprirseId interface{})
}
