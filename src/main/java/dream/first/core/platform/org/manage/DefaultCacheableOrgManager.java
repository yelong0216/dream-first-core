package dream.first.core.platform.org.manage;

import java.util.List;
import java.util.Objects;

import org.yelong.core.cache.CacheManager;
import org.yelong.core.cache.CacheManagerFactory;

import dream.first.core.cache.CacheManagerUtils;
import dream.first.core.platform.org.model.Org;
import dream.first.core.platform.org.service.OrgCommonService;

/**
 * 简单的缓存支持的组织管理器
 * 
 * @since 2.0
 */
public class DefaultCacheableOrgManager implements CacheableOrgManager {

	protected final OrgManager orgManager;

	protected final CacheManager cacheManager;

	public DefaultCacheableOrgManager(OrgCommonService orgCommonService, CacheManagerFactory cacheManagerFactory) {
		this(new SimpleOrgManager(orgCommonService), cacheManagerFactory);
	}

	public DefaultCacheableOrgManager(OrgManager orgManager, CacheManagerFactory cacheManagerFactory) {
		this.orgManager = Objects.requireNonNull(orgManager);
		this.cacheManager = Objects.requireNonNull(cacheManagerFactory).create("ORG_MANAGER");
	}

	@Override
	public List<Org> getAll() {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "ORG_ALL", x -> orgManager.getAll());
	}

	@Override
	public Org getByOrgNo(String orgNo) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "orgNo:" + orgNo, x -> orgManager.getByOrgNo(orgNo));
	}

	@Override
	public List<Org> getByParentOrgNo(String parentOrgNo) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "parentOrgNo:" + parentOrgNo,
				x -> orgManager.getByParentOrgNo(parentOrgNo));
	}

	@Override
	public CacheManager getCacheManager() {
		return cacheManager;
	}

}
