/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.search.experiences.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.search.experiences.constants.SXPConstants;
import com.liferay.search.experiences.model.SXPElement;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Petteri Karttunen
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.search.experiences.model.SXPElement",
	service = ModelResourcePermission.class
)
public class SXPElementModelResourcePermission
	implements ModelResourcePermission<SXPElement> {

	@Override
	public void check(
			PermissionChecker permissionChecker, long sxpElementId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, sxpElementId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, SXPElement.class.getName(), sxpElementId,
				actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, SXPElement sxpElement,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, sxpElement, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, SXPElement.class.getName(),
				sxpElement.getPrimaryKey(), actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long sxpElementId,
			String actionId)
		throws PortalException {

		return permissionChecker.hasPermission(
			null, SXPElement.class.getName(), sxpElementId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, SXPElement sxpElement,
			String actionId)
		throws PortalException {

		return permissionChecker.hasPermission(
			null, SXPElement.class.getName(), sxpElement.getPrimaryKey(),
			actionId);
	}

	@Override
	public String getModelName() {
		return SXPElement.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _portletResourcePermission;
	}

	@Reference(target = "(resource.name=" + SXPConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

}