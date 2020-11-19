/**
 * 
 */
package dream.first.core.model;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.sql.SqlModel;

import dream.first.base.model.DreamFirstBaseModel;

/**
 * 基础模型。包含基础的字段，并提供常用的方法
 * 
 * 注意：该类继承{@link SqlModel}，这个类的子类是可以转换为SQL的
 * 
 * @param <M> model type
 * @since 1.0
 */
public abstract class BaseModel<M extends Modelable> extends DreamFirstBaseModel<M> implements BaseModelable {

	private static final long serialVersionUID = -4023707437316252376L;

}
