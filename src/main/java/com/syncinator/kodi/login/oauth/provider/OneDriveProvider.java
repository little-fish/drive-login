package com.syncinator.kodi.login.oauth.provider;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component(Provider.NAME_PREFIX + OneDriveProvider.NAME)
@ConditionalOnProperty(
		name = "provider",
		havingValue = OneDriveProvider.NAME
)
public class OneDriveProvider extends Provider {
	public static final String NAME = "onedrive";

	private static final Logger LOG = LoggerFactory.getLogger(OneDriveProvider.class);

	@Override
    public String authorize(String pin) {
        return getAuthorizeUrl(NAME, pin, new HashMap<String, String>() {{
			put("scope", "offline_access sites.read.all files.read.all user.read");
			put("response_mode", "form_post");
		}});
	}

	@Override
	public Map<String,Object> tokens(String grantType, String value) throws Exception {
		return getTokens(NAME, grantType, value);
	}
}
