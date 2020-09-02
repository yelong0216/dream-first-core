/**
 * 
 */
package dream.first.test.core.platform.dict.manager;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.yelong.core.order.OrderDirection;
import org.yelong.core.support.Dictionary;

import dream.first.core.platform.dict.manage.SimpleDictManager;
import dream.first.core.platform.dict.model.Dict;
import dream.first.core.platform.dict.service.impl.DictCommonServiceImpl;
import dream.first.test.core.ModelObjectSupplier;

/**
 * 
 * @since
 */
public class SimpleDictManagerTest {

	SimpleDictManager simpleDictManager = new SimpleDictManager(
			new DictCommonServiceImpl(ModelObjectSupplier.modelService));

	@Test
	public void getByDictType() {
		List<Dict> dicts = simpleDictManager.getByDictType("poaState");
		System.out.println(dicts);
	}

	@Test
	public void getByDictTypes() {
		List<Dict> dicts = simpleDictManager.getByDictTypes(ArrayUtils.toArray("poaState", "gender"));
		System.out.println(dicts);
	}

	@Test
	public void getDictionary() {
		Dictionary<String, String, String> dictionary = simpleDictManager.getDictionary(null);
		System.out.println(dictionary);
		System.out.println(dictionary.getType());
		System.out.println(dictionary.getDictionaryAttributes());
		System.out.println(dictionary.getDictionaryAttributes(OrderDirection.ASC));

	}

	@Test
	public void getDictionarys() {
		Map<String, Dictionary<String, String, String>> dictionarys = simpleDictManager
				.getDictionarys(ArrayUtils.toArray("poaState", "gender"));
		System.out.println(dictionarys);
	}

	@Test
	public void getByDictTypeAndValue() {
		Dict dict = simpleDictManager.getByDictTypeAndValue("poaState", "100");
		System.out.println(dict);
	}

	@Test
	public void getDictTextByDictTypeAndValue() {
		String dictText = simpleDictManager.getDictTextByDictTypeAndValue("poaState", "01");
		System.out.println(dictText);
	}

	@Test
	public void getDictTextByDictTypeAndValue2() {
		String dictText = simpleDictManager.getDictTextByDictTypeAndValue("poaState", "100", "--");
		System.out.println(dictText);
	}

}
