package query

type FilterType string

const (
	Equal FilterType = "LIKE"
	Like  FilterType = "LIKE"
)

type FilterOperator string

const (
	And FilterOperator = "AND"
	Or  FilterOperator = "OR"
)

type JoinType string

const (
	Inner FilterType = "INNER"
	Left  FilterType = "LEFT"
	Right FilterType = "RIGHT"
)

type OrderType string

const (
	Asc  OrderType  = "ASC"
	Desc FilterType = "DESC"
)

type QueryBuilderType int

const (
	Postgress QueryBuilderType = 0
)
