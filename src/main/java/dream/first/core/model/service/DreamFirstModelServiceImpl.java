/**
 * 
 */
package dream.first.core.model.service;

import org.springframework.transaction.annotation.Transactional;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.mybatis.spring.MyBatisModelService;
import org.yelong.support.orm.mybaits.mapper.MyBatisBaseDataBaseOperation;

import dream.first.core.queryinfo.filter.QueryFilterInfoResolver;

/**
 * 默认实现。数据库操作使用MyBatis
 * 
 * @since 1.0.0
 */
@Transactional
public class DreamFirstModelServiceImpl extends MyBatisModelService implements DreamFirstModelService {

	private final QueryFilterInfoResolver queryFilterInfoResolver;

	public DreamFirstModelServiceImpl(ModelConfiguration modelConfiguration,
			MyBatisBaseDataBaseOperation myBatisBaseDataBaseOperation,
			QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, myBatisBaseDataBaseOperation);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	@Override
	public QueryFilterInfoResolver getQueryFilterInfoResolver() {
		return queryFilterInfoResolver;
	}

	@Override
	public Class<?> getTargetClass() {
		return DreamFirstModelServiceImpl.class;
	}

}
