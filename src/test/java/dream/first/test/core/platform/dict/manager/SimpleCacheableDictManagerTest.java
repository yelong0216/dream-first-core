/**
 * 
 */
package dream.first.test.core.platform.dict.manager;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.yelong.core.cache.simple.SimpleCacheManagerFactory;
import org.yelong.core.order.OrderDirection;
import org.yelong.core.support.Dictionary;

import dream.first.core.platform.dict.manage.CacheableDictManager;
import dream.first.core.platform.dict.manage.DefaultCacheableDictManager;
import dream.first.core.platform.dict.model.Dict;
import dream.first.core.platform.dict.service.impl.DictCommonServiceImpl;
import dream.first.test.core.ModelObjectSupplier;

/**
 * 
 * @since
 */
public class SimpleCacheableDictManagerTest {

	CacheableDictManager dictManager = new DefaultCacheableDictManager(
			new DictCommonServiceImpl(ModelObjectSupplier.modelService), new SimpleCacheManagerFactory());

	@Test
	public void getByDictType() {
		List<Dict> dicts = dictManager.getByDictType("poaState");
		System.out.println(dicts);
		List<Dict> dicts2 = dictManager.getByDictType("poaState");
		System.out.println(dicts2);
		List<Dict> dicts22 = dictManager.getByDictType("gender");
		System.out.println(dicts22);
		dictManager.clearCache();
		List<Dict> dicts3 = dictManager.getByDictType("poaState");
		System.out.println(dicts3);
	}

	@Test
	public void getByDictTypes() {
		List<Dict> dicts = dictManager.getByDictTypes(ArrayUtils.toArray("poaState", "gender"));
		System.out.println(dicts);
		List<Dict> dicts2 = dictManager.getByDictTypes(ArrayUtils.toArray("poaState", "gender"));
		System.out.println(dicts2);
		dictManager.clearCache();
		List<Dict> dicts3 = dictManager.getByDictTypes(ArrayUtils.toArray("poaState", "gender"));
		System.out.println(dicts3);
	}

	@Test
	public void getDictionary() {
		Dictionary<String, String, String> dictionary = dictManager.getDictionary("poaState");
		System.out.println(dictionary);
		System.out.println(dictionary.getType());
		System.out.println(dictionary.getDictionaryAttributes());
		System.out.println(dictionary.getDictionaryAttributes(OrderDirection.ASC));

	}

	@Test
	public void getDictionarys() {
		Map<String, Dictionary<String, String, String>> dictionarys = dictManager
				.getDictionarys(ArrayUtils.toArray("poaState", "gender"));
		System.out.println(dictionarys);
	}

	@Test
	public void getByDictTypeAndValue() {
		Dict dict = dictManager.getByDictTypeAndValue("poaState", "100");
		System.out.println(dict);
	}

	@Test
	public void getDictTextByDictTypeAndValue() {
		String dictText = dictManager.getDictTextByDictTypeAndValue("poaState", "01");
		System.out.println(dictText);
		String dictText2 = dictManager.getDictTextByDictTypeAndValue("poaState", "01");
		System.out.println(dictText2);
	}

	@Test
	public void getDictTextByDictTypeAndValue2() {
		String dictText = dictManager.getDictTextByDictTypeAndValue("poaState", "100", "--");
		System.out.println(dictText);
	}

}
