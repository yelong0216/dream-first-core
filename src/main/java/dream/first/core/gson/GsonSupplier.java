package dream.first.core.gson;

import java.util.Date;

import org.yelong.support.json.gson.adapter.DateTypeAdapter;
import org.yelong.support.json.gson.adapter.StringTypeAdapter;
import org.yelong.support.json.gson.model.sql.SqlModelExclusionStrategy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * {@link Gson}供应商
 * 
 * @since 2.0
 */
public final class GsonSupplier {

	private static GsonBuilder defaultGsonBuilder = createGsonBuilder();

	private static Gson defaultGson = defaultGsonBuilder.create();

	private GsonSupplier() {
	}

	/**
	 * @return 默认的Gson实例
	 * @see #defaultGson
	 */
	public static Gson getDefaultGson() {
		return defaultGson;
	}

	/**
	 * 设置默认的Gson实例
	 * 
	 * @param defaultGson 默认的Gson实例
	 */
	public synchronized static void setDefaultGson(Gson defaultGson) {
		GsonSupplier.defaultGson = defaultGson;
	}

	/**
	 * @return 创建一个Gson实例
	 * @see #createGsonBuilder()
	 */
	public static Gson createGson() {
		return createGsonBuilder().create();
	}

	/**
	 * @return 默认的GsonBuilder实例
	 * @see #defaultGsonBuilder
	 */
	public static GsonBuilder getDefaultGsonBuilder() {
		return defaultGsonBuilder;
	}

	/**
	 * 设置默认的GsonBuilder实例
	 * 
	 * @param defaultGsonBuilder 默认的GsonBuilder实例
	 */
	public static void setDefaultGsonBuilder(GsonBuilder defaultGsonBuilder) {
		GsonSupplier.defaultGsonBuilder = defaultGsonBuilder;
	}

	/**
	 * 创建一个Gson建造者，且Gson建造者持有以下特性：
	 * <p>
	 * 1、Date类型属性如果为null则返回""，否则返回时间格式为：yyyy-MM-dd HH:mm:ss </br>
	 * 2、如果字符串为null则返回""</br>
	 * 3、忽略对SqlModel的属性</br>
	 * </p>
	 * 
	 * @return 创建一个GsonBuilder实例
	 */
	public static GsonBuilder createGsonBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		gsonBuilder.registerTypeAdapter(String.class, new StringTypeAdapter());
		gsonBuilder.addSerializationExclusionStrategy(SqlModelExclusionStrategy.DEFAULT);
		return gsonBuilder;
	}

}
