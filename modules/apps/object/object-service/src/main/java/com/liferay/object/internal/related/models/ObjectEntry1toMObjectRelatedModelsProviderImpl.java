/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.object.internal.related.models;

import com.liferay.object.constants.ObjectRelationshipConstants;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.related.models.ObjectRelatedModelsProvider;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Marco Leo
 * @author Brian Wing Shun Chan
 */
public class ObjectEntry1toMObjectRelatedModelsProviderImpl
	implements ObjectRelatedModelsProvider<ObjectEntry> {

	public ObjectEntry1toMObjectRelatedModelsProviderImpl(
		ObjectDefinition objectDefinition,
		ObjectEntryLocalService objectEntryLocalService) {

		_objectEntryLocalService = objectEntryLocalService;

		_className = objectDefinition.getClassName();
		_objectDefinitionId = objectDefinition.getObjectDefinitionId();
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public String getObjectRelationshipType() {
		return ObjectRelationshipConstants.TYPE_ONE_TO_MANY;
	}

	@Override
	public List<ObjectEntry> getRelatedModels(
			long groupId, long objectRelationshipId, long primaryKey, int start,
			int end)
		throws PortalException {

		return _objectEntryLocalService.getOneToManyRelatedObjectEntries(
			groupId, objectRelationshipId, primaryKey, start, end);
	}

	@Override
	public int getRelatedModelsCount(
			long groupId, long objectRelationshipId, long primaryKey)
		throws PortalException {

		return _objectEntryLocalService.getOneToManyRelatedObjectEntriesCount(
			groupId, objectRelationshipId, primaryKey);
	}

	private final String _className;
	private final long _objectDefinitionId;
	private final ObjectEntryLocalService _objectEntryLocalService;

}