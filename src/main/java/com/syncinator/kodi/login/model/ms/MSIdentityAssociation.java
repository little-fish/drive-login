package com.syncinator.kodi.login.model.ms;

import java.io.Serializable;
import java.util.List;

/**
 * @author Martin Misiarz `<dev.misiarz@gmail.com>`
 */
public record MSIdentityAssociation(List<AssociatedApplication> associatedApplications) implements Serializable { }

