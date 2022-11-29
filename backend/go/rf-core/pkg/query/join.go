package query

type Join struct {
	Type      JoinType
	Condition string
	Params    map[string]interface{}
}
