/**
 * 
 */
package dream.first.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import dream.first.core.DreamFirstCore;

/**
 * @author PengFei
 *
 */
@ConditionalOnProperty(prefix = DreamFirstCore.DREAM_FIRST_PROPERTIES_PREFIX,
name = "jedis",
havingValue = "true",
matchIfMissing = false)
public class JedisConfiguration {
//	
//	@Value("${spring.redis.host:localhost}")
//    private String host;
// 
//    @Value("${spring.redis.port:6379}")
//    private int port;
// 
//    @Value("${spring.redis.timeout:0}")
//    private int timeout;
// 
//    @Value("${spring.redis.pool.max-active:200}")
//    private int maxActive;
// 
//    @Value("${spring.redis.pool.max-idle:8}")
//    private int maxIdle;
// 
//    @Value("${spring.redis.pool.min-idle:0}")
//    private int minIdle;
// 
//    @Value("${spring.redis.pool.max-wait:-1}")
//    private long maxWaitMillis;
// 
//    @Bean
//    public JedisPool redisPoolFactory(){
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        jedisPoolConfig.setMaxTotal(maxActive);
//        jedisPoolConfig.setMinIdle(minIdle);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,null);
//        return  jedisPool;
//    }
//	
//	public static final Gson gson = new Gson();
//	
//	@Primary
//	@Bean("simpleCacheManagerFactory")
//	public CacheManagerFactory simpleCacheManagerFactory() {
//		return new SimpleCacheManagerFactory();
//	}
//	
//	@Bean("jedisCacheManagerFactory")
//	public JedisCacheManagerFactory jedisCacheManagerFactory(JedisPool jedisPool) {
//		JedisCacheManagerFactoryBuilder builder = new JedisCacheManagerFactoryBuilder(jedisPool);
//		builder.setJsonToObject(gson::fromJson);
//		builder.setObjectToJson(gson::toJson);
//		return builder.build();
//	}
//    
}
