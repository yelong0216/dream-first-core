/**
 * 
 */
package dream.first.core.model.map;

import org.yelong.commons.util.map.CaseInsensitiveMapUtils.KeyStoreMode;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.map.MapModel;
import org.yelong.core.model.map.MapModelable;

/**
 * 该类的继承接口层级中 {@link MapModelable}优先级必须比 {@link Modelable}优先级高
 * 
 * @since 1.0
 */
public abstract class BaseMapModel extends MapModel implements BaseMapModelable {

	private static final long serialVersionUID = -4448830529149248472L;

	public BaseMapModel() {
		this(KeyStoreMode.LOWER);
	}

	public BaseMapModel(KeyStoreMode keyStoreMode) {
		super(keyStoreMode);
	}

}
