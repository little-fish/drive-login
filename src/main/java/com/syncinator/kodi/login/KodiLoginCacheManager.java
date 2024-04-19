package com.syncinator.kodi.login;

import java.time.Duration;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import com.syncinator.kodi.login.model.Pin;

public class KodiLoginCacheManager {
	
	private static final String PIN_ALIAS = "pin";
	
	private static final CacheManager PIN_CACHE_MANAGER = CacheManagerBuilder.newCacheManagerBuilder()
			.withCache(PIN_ALIAS, 
					CacheConfigurationBuilder
						.newCacheConfigurationBuilder(String.class, Pin.class, ResourcePoolsBuilder.heap(100000))
						.withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(3))))
			.build();
	
	static {
		PIN_CACHE_MANAGER.init();
	}
	
	public static Cache<String, Pin> getPinCache(){
		return PIN_CACHE_MANAGER.getCache(PIN_ALIAS, String.class, Pin.class);
	}
}
