/**
 * 
 */
package dream.first.core.model.map;

import java.util.Date;

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
		this(KeyStoreMode.UPPER);
	}

	public BaseMapModel(KeyStoreMode keyStoreMode) {
		super(keyStoreMode);
	}

	@Override
	public String getId() {
		return getString(ID);
	}

	@Override
	public String getCreator() {
		return getString(CREATOR);
	}

	@Override
	public Date getCreateTime() {
		return getDate(CREATETIME);
	}

	@Override
	public String getUpdator() {
		return getString(UPDATOR);
	}

	@Override
	public Date getUpdateTime() {
		return getDate(UPDATETIME);
	}

	@Override
	public String getState() {
		return getString(STATE);
	}

}
