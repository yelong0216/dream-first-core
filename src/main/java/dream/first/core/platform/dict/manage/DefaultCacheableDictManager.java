/**
 * 
 */
package dream.first.core.platform.dict.manage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.yelong.core.cache.CacheManager;
import org.yelong.core.cache.CacheManagerFactory;

import dream.first.core.cache.CacheManagerUtils;
import dream.first.core.platform.dict.model.Dict;
import dream.first.core.platform.dict.service.DictCommonService;

/**
 * 缓存支持的字典管理器
 * 
 * @since 2.0
 */
public class DefaultCacheableDictManager implements CacheableDictManager {

	protected final CacheManager cacheManager;

	protected final DictManager dictManager;

	public DefaultCacheableDictManager(DictCommonService dictCommonService, CacheManagerFactory cacheManagerFactory) {
		this(new SimpleDictManager(dictCommonService), cacheManagerFactory);
	}

	public DefaultCacheableDictManager(DictManager dictManager, CacheManagerFactory cacheManagerFactory) {
		this.dictManager = Objects.requireNonNull(dictManager);
		this.cacheManager = Objects.requireNonNull(cacheManagerFactory).create("DICT_MANAGER");
	}

	@Override
	public List<Dict> getAll() {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "DICT_ALL", x -> dictManager.getAll());
	}

	@Override
	public List<Dict> getByDictType(String dictType) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "DICT_TYPE:" + dictType,
				x -> dictManager.getByDictType(dictType));
	}

	@Override
	public List<Dict> getByDictTypes(String[] dictTypes) {
		String dictTypesStr = Stream.of(dictTypes).collect(Collectors.joining(","));
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "DICT_TYPES:" + dictTypesStr,
				x -> dictManager.getByDictTypes(dictTypes));
	}

	@Override
	public Dict getByDictTypeAndValue(String dictType, String dictValue) {
		String dictTypeAndValue = dictType + ":" + dictValue;
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "DICT_TYPE_AND_VALUE:" + dictTypeAndValue,
				x -> dictManager.getByDictTypeAndValue(dictType, dictValue));
	}

	@Override
	public CacheManager getCacheManager() {
		return this.cacheManager;
	}

}
