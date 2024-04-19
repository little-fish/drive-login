package com.syncinator.kodi.login.oauth.provider;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component(Provider.NAME_PREFIX + GoogleDriveProvider.NAME)
@ConditionalOnProperty(
		name = "provider",
		havingValue = GoogleDriveProvider.NAME
)
public class GoogleDriveProvider extends Provider {
	protected static final String NAME = "googledrive";
	
	
	@Override
	@SuppressWarnings("serial")
	public String authorize(String pin) {
		return getAuthorizeUrl(NAME, pin, new HashMap<String,String>() {{
			put("scope", "https://www.googleapis.com/auth/drive.readonly https://www.googleapis.com/auth/drive.photos.readonly https://www.googleapis.com/auth/photoslibrary.readonly profile");
			put("access_type", "offline");
			put("prompt", "consent");
		}});
	}
	
	@Override
	public Map<String,Object> tokens(String grantType, String value) throws Exception {
		return getTokens(NAME, grantType, value);
	}
}
