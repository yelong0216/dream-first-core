/**
 * 
 */
package dream.first.core.model.service;

import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.convertor.ModelAndMapConvertor;
import org.yelong.core.model.service.JdbcModelService;

import dream.first.core.queryinfo.filter.QueryFilterInfoResolver;

/**
 * 默认实现。数据库操作使用普通的JDBC
 * 
 * @since 2.0
 */
public class JdbcDreamFirstModelService extends JdbcModelService implements DreamFirstModelService {

	private final QueryFilterInfoResolver queryFilterInfoResolver;

	public JdbcDreamFirstModelService(ModelConfiguration modelConfiguration, BaseDataBaseOperation db,
			QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, db);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	public JdbcDreamFirstModelService(ModelConfiguration modelConfiguration, BaseDataBaseOperation db,
			ModelAndMapConvertor modelAndMapConvertor, QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, db, modelAndMapConvertor);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	@Override
	public Class<?> getTargetClass() {
		return JdbcDreamFirstModelService.class;
	}

	@Override
	public QueryFilterInfoResolver getQueryFilterInfoResolver() {
		return queryFilterInfoResolver;
	}

}
