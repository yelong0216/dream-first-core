/**
 * 
 */
package org.yelong.dream.first.core.configuration;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.yelong.core.interceptor.Interceptor;
import org.yelong.core.interceptor.InterceptorChain;
import org.yelong.core.jdbc.dialect.Dialect;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.dream.first.core.queryinfo.filter.QueryFilterInfoResolver;
import org.yelong.dream.first.core.queryinfo.filter.impl.oracle.OracleQueryFilterInfoResolver;
import org.yelong.dream.first.core.service.DreamFirstModelService;
import org.yelong.dream.first.core.service.DreamFirstModelServiceImpl;
import org.yelong.dream.first.core.service.ModifyModelServiceInterceptor;
import org.yelong.dream.first.core.service.SaveModelServiceInterceptor;
import org.yelong.support.orm.mybaits.mapper.MyBatisBaseDataBaseOperation;

/**
 * 
 * 基础配置
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class DreamFirstCoreConfiguration {

	/**
	 * 查询过滤信息解析器
	 * @param dialect 方言
	 * @return 查询过滤信息解析器
	 */
	@Bean
	@ConditionalOnMissingBean(QueryFilterInfoResolver.class)
	public QueryFilterInfoResolver queryFilterInfoResolver(Dialect dialect) {
		return new OracleQueryFilterInfoResolver();
	}
	
	/**
	 * yelong-labbol默认的ModelService
	 * @param modelConfiguration model 配置
	 * @param myBatisBaseDataBaseOperation 基础数据库操作
	 * @param queryFilterInfoResolver 查询过滤解析器
	 * @return model service
	 */
	@Bean
	@ConditionalOnMissingBean(DreamFirstModelService.class)
	public DreamFirstModelService modelService(ModelConfiguration modelConfiguration,
			MyBatisBaseDataBaseOperation myBatisBaseDataBaseOperation,
			QueryFilterInfoResolver queryFilterInfoResolver,ObjectProvider<List<Interceptor>> interceptorProvider) {
		//return new DefaultLabbolModelServiceImpl(modelConfiguration, myBatisBaseDataBaseOperation, queryFilterInfoResolver);
		List<Interceptor> interceptors = interceptorProvider.getIfAvailable();
		InterceptorChain interceptorChain =  new InterceptorChain();
		interceptorChain.addInterceptor(interceptors);
		return (DreamFirstModelService) interceptorChain.pluginAll(new DreamFirstModelServiceImpl(modelConfiguration, myBatisBaseDataBaseOperation, queryFilterInfoResolver));
	}
	
	@Bean
	public Interceptor saveModelServiceInterceptor() {
		return new SaveModelServiceInterceptor();
	}
	
	@Bean
	public Interceptor modifyModelServiceInterceptor() {
		return new ModifyModelServiceInterceptor();
	}
	
}
