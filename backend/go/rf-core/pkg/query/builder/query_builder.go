package builder

import (
	"rf-core/pkg/features"
	"rf-core/pkg/query"
)

type QueryBuilder struct {
	fields  []query.Field
	joins   []query.Join
	filters []query.Filter
	orders  []query.OrderBy
	groups  []query.GroupBy
	params  map[string]interface{}
	Type    query.QueryBuilderType
}

func InitQueryBuilder(commosBarameters features.BaseCommonsParamenters) QueryBuilder {
	queryBuilder := QueryBuilder{}

	return queryBuilder
}

func (queryBuilder QueryBuilder) Clear() {
	queryBuilder.params = make(map[string]interface{})
	queryBuilder.fields = nil
	queryBuilder.joins = nil
	queryBuilder.filters = nil
	queryBuilder.orders = nil
	queryBuilder.groups = nil
}

func (queryBuilder QueryBuilder) BuildQuery() string {
	var result string = ""

	switch queryBuilder.Type {
	case query.Postgress:
		result = BuildSQLQuery(queryBuilder)
		break
	}

	return result
}
