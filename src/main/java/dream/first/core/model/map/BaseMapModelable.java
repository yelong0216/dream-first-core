/**
 * 
 */
package dream.first.core.model.map;

import java.util.Date;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.map.MapModelable;

import dream.first.core.model.BaseModelable;

/**
 * 基础的MapModel支持 该类的继承接口层级中 {@link MapModelable}优先级必须比 {@link Modelable}优先级高
 * 
 * @since 2.0
 */
public interface BaseMapModelable extends MapModelable, BaseModelable {

	@Override
	default String getId() {
		return (String) get(ID);
	}

	@Override
	default String getCreator() {
		return (String) get(CREATOR);
	}

	@Override
	default Date getCreateTime() {
		return (Date) get(CREATETIME);
	}

	@Override
	default String getUpdator() {
		return (String) get(UPDATOR);
	}

	@Override
	default Date getUpdateTime() {
		return (Date) get(UPDATETIME);
	}

	@Override
	default String getState() {
		return (String) get(STATE);
	}

	@Override
	default void setId(String id) {
		put(ID, id);
	}

	@Override
	default void setCreator(String creator) {
		put(CREATOR, creator);
	}

	@Override
	default void setCreateTime(Date createTime) {
		put(CREATETIME, createTime);
	}

	@Override
	default void setUpdator(String updator) {
		put(UPDATOR, updator);
	}

	@Override
	default void setUpdateTime(Date updateTime) {
		put(UPDATETIME, updateTime);
	}

	@Override
	default void setState(String state) {
		put(STATE, state);
	}

}
