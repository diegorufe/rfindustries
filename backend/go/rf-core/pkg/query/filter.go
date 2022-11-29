package query

type Filter struct {
	Name       string
	AliasTable string
	Value      interface{}
	Type       FilterType
	Operator   FilterOperator
}
