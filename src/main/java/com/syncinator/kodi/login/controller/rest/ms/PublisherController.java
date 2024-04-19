package com.syncinator.kodi.login.controller.rest.ms;

import com.syncinator.kodi.login.model.ms.AssociatedApplication;
import com.syncinator.kodi.login.model.ms.MSIdentityAssociation;
import com.syncinator.kodi.login.oauth.provider.OneDriveProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Martin Misiarz `<dev.misiarz@gmail.com>`
 */
@RestController
@RequestMapping(path = "/.well-known")
@ConditionalOnProperty(
        name = "provider",
        havingValue = OneDriveProvider.NAME
)
public class PublisherController {

    private final MSIdentityAssociation msIdentityAssociation;

    public PublisherController(@Value("${provider.onedrive.client.id}") String applicationId) {
        this.msIdentityAssociation = new MSIdentityAssociation(List.of(new AssociatedApplication(applicationId)));
    }

    @GetMapping(
            path = "/microsoft-identity-association.json",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MSIdentityAssociation identify() {
        return msIdentityAssociation;
    }
}
