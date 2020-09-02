/**
 * 
 */
package dream.first.test.core;

import java.util.Arrays;

import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.jdbc.DataBaseOperationType;
import org.yelong.core.jdbc.DataSourceProperties;
import org.yelong.core.jdbc.DefaultBaseDataBaseOperation;
import org.yelong.core.jdbc.dialect.impl.mysql.MySqlDialect;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.ModelConfigurationBuilder;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.model.service.JdbcDreamFirstModelService;
import dream.first.core.queryinfo.filter.impl.oracle.OracleQueryFilterInfoResolver;

/**
 * 
 * @since
 */
public final class ModelObjectSupplier {

	public static final BaseDataBaseOperation db;

	public static final DreamFirstModelService modelService;

	static {
		DataSourceProperties dataSourceProperties = new DataSourceProperties();
		dataSourceProperties.setUsername("test");
		dataSourceProperties.setPassword("test");
		dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/test");
		dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
		try {
			db = new DefaultBaseDataBaseOperation(dataSourceProperties) {
				@Override
				public Object execute(String sql, Object[] params, DataBaseOperationType operationType) {
					System.out.println("sql:" + sql);
					System.out.println("params:" + Arrays.asList(params));
					return super.execute(sql, params, operationType);
				}
			};
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		ModelConfiguration modelConfiguration = ModelConfigurationBuilder.create(new MySqlDialect()).build();
		modelService = new JdbcDreamFirstModelService(modelConfiguration, db, OracleQueryFilterInfoResolver.INSTANCE);
	}

	private ModelObjectSupplier() {
	}

}
