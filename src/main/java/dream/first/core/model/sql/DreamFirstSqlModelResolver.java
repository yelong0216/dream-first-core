/**
 * 
 */
package dream.first.core.model.sql;

import java.util.ArrayList;
import java.util.List;

import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.core.jdbc.sql.condition.support.ConditionResolver;
import org.yelong.core.jdbc.sql.factory.SqlFragmentFactory;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.manage.ModelManager;
import org.yelong.core.model.property.ModelProperty;
import org.yelong.core.model.sql.DefaultSqlModelResolver;
import org.yelong.core.model.sql.SqlModel;

/**
 * 提供对特定的操作符继续特殊处理操作的后置处理。
 * <ul>
 * <li>运算符为IN时，如果值不为集合则默认转换为集合</li>
 * <li>运算符为LIKE时，值添加模糊条件(值前后添加%)。</li>
 * <li>运算符为RLIKE时，值添加右模糊(值最后添加%)，运算符修改为LIKE</li>
 * <li>运算符为LLIKE时，值添加左模糊(值开始添加%)，运算符修改为LIKE</li>
 * </ul>
 * 
 * @since 2.0
 */
public class DreamFirstSqlModelResolver extends DefaultSqlModelResolver {

	public DreamFirstSqlModelResolver(ModelManager modelManager, ConditionResolver conditionResolver,
			SqlFragmentFactory sqlFragmentFactory, ModelProperty modelProperty) {
		super(modelManager, conditionResolver, sqlFragmentFactory, modelProperty);
	}

	@Override
	protected List<Condition> afterResolveToCondition(SqlModel<? extends Modelable> sqlModel, boolean isTableAlias,
			List<Condition> conditions) {
		for (Condition condition : conditions) {
			String operator = condition.getOperator(conditionalOperatorResolver);
			Object value = condition.getValue();
			if (null == value) {
				continue;
			}
			if ("IN".equalsIgnoreCase(operator)) {
				if (!(value instanceof List)) {
					List<Object> values = new ArrayList<Object>();
					values.add(value);
					value = values;
				}
			} else if ("LIKE".equalsIgnoreCase(operator)) {
				String v = value.toString();
				// 自己定义 %后不会添加%
				if (v.startsWith("%") || v.endsWith("%")) {
					value = v;
					continue;
				}
				if (!v.startsWith("%")) {
					v = "%" + v;
				}
				if (!v.endsWith("%")) {
					v = v + "%";
				}
				value = v;
			} else if ("RLIKE".equalsIgnoreCase(operator)) {
				String v = value.toString();
				if (!v.endsWith("%")) {
					v = v + "%";
				}
				value = v;
				condition.setOperator("LIKE");
			} else if ("LLIKE".equalsIgnoreCase(operator)) {
				String v = value.toString();
				if (!v.startsWith("%")) {
					v = "%" + v;
				}
				value = v;
				condition.setOperator("LIKE");
			}
			condition.setValue(value);
		}
		return conditions;
	}

}
