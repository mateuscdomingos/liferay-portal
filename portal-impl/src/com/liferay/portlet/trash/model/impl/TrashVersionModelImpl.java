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

package com.liferay.portlet.trash.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.trash.kernel.model.TrashVersion;
import com.liferay.trash.kernel.model.TrashVersionModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TrashVersion service. Represents a row in the &quot;TrashVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TrashVersionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrashVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrashVersionImpl
 * @generated
 */
@ProviderType
public class TrashVersionModelImpl
	extends BaseModelImpl<TrashVersion> implements TrashVersionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a trash version model instance should use the <code>TrashVersion</code> interface instead.
	 */
	public static final String TABLE_NAME = "TrashVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"versionId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"entryId", Types.BIGINT}, {"classNameId", Types.BIGINT},
		{"classPK", Types.BIGINT}, {"typeSettings", Types.CLOB},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("versionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table TrashVersion (versionId LONG not null primary key,companyId LONG,entryId LONG,classNameId LONG,classPK LONG,typeSettings TEXT null,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table TrashVersion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY trashVersion.versionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY TrashVersion.versionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.trash.kernel.model.TrashVersion"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.trash.kernel.model.TrashVersion"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.trash.kernel.model.TrashVersion"),
		true);

	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	public static final long ENTRYID_COLUMN_BITMASK = 4L;

	public static final long VERSIONID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.trash.kernel.model.TrashVersion"));

	public TrashVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _versionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _versionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TrashVersion.class;
	}

	@Override
	public String getModelClassName() {
		return TrashVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TrashVersion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TrashVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TrashVersion, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TrashVersion)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TrashVersion, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TrashVersion, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TrashVersion)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TrashVersion, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TrashVersion, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TrashVersion>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TrashVersion.class.getClassLoader(), TrashVersion.class,
			ModelWrapper.class);

		try {
			Constructor<TrashVersion> constructor =
				(Constructor<TrashVersion>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<TrashVersion, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TrashVersion, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TrashVersion, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TrashVersion, Object>>();
		Map<String, BiConsumer<TrashVersion, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TrashVersion, ?>>();

		attributeGetterFunctions.put(
			"versionId",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getVersionId();
				}

			});
		attributeSetterBiConsumers.put(
			"versionId",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(
					TrashVersion trashVersion, Object versionId) {

					trashVersion.setVersionId((Long)versionId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(
					TrashVersion trashVersion, Object companyId) {

					trashVersion.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"entryId",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"entryId",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(TrashVersion trashVersion, Object entryId) {
					trashVersion.setEntryId((Long)entryId);
				}

			});
		attributeGetterFunctions.put(
			"classNameId",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getClassNameId();
				}

			});
		attributeSetterBiConsumers.put(
			"classNameId",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(
					TrashVersion trashVersion, Object classNameId) {

					trashVersion.setClassNameId((Long)classNameId);
				}

			});
		attributeGetterFunctions.put(
			"classPK",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"classPK",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(TrashVersion trashVersion, Object classPK) {
					trashVersion.setClassPK((Long)classPK);
				}

			});
		attributeGetterFunctions.put(
			"typeSettings",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getTypeSettings();
				}

			});
		attributeSetterBiConsumers.put(
			"typeSettings",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(
					TrashVersion trashVersion, Object typeSettings) {

					trashVersion.setTypeSettings((String)typeSettings);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<TrashVersion, Object>() {

				@Override
				public Object apply(TrashVersion trashVersion) {
					return trashVersion.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<TrashVersion, Object>() {

				@Override
				public void accept(TrashVersion trashVersion, Object status) {
					trashVersion.setStatus((Integer)status);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getVersionId() {
		return _versionId;
	}

	@Override
	public void setVersionId(long versionId) {
		_versionId = versionId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getEntryId() {
		return _entryId;
	}

	@Override
	public void setEntryId(long entryId) {
		_columnBitmask |= ENTRYID_COLUMN_BITMASK;

		if (!_setOriginalEntryId) {
			_setOriginalEntryId = true;

			_originalEntryId = _entryId;
		}

		_entryId = entryId;
	}

	public long getOriginalEntryId() {
		return _originalEntryId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TrashVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TrashVersion toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TrashVersion>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TrashVersionImpl trashVersionImpl = new TrashVersionImpl();

		trashVersionImpl.setVersionId(getVersionId());
		trashVersionImpl.setCompanyId(getCompanyId());
		trashVersionImpl.setEntryId(getEntryId());
		trashVersionImpl.setClassNameId(getClassNameId());
		trashVersionImpl.setClassPK(getClassPK());
		trashVersionImpl.setTypeSettings(getTypeSettings());
		trashVersionImpl.setStatus(getStatus());

		trashVersionImpl.resetOriginalValues();

		return trashVersionImpl;
	}

	@Override
	public int compareTo(TrashVersion trashVersion) {
		long primaryKey = trashVersion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrashVersion)) {
			return false;
		}

		TrashVersion trashVersion = (TrashVersion)obj;

		long primaryKey = trashVersion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TrashVersionModelImpl trashVersionModelImpl = this;

		trashVersionModelImpl._originalEntryId = trashVersionModelImpl._entryId;

		trashVersionModelImpl._setOriginalEntryId = false;

		trashVersionModelImpl._originalClassNameId =
			trashVersionModelImpl._classNameId;

		trashVersionModelImpl._setOriginalClassNameId = false;

		trashVersionModelImpl._originalClassPK = trashVersionModelImpl._classPK;

		trashVersionModelImpl._setOriginalClassPK = false;

		trashVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TrashVersion> toCacheModel() {
		TrashVersionCacheModel trashVersionCacheModel =
			new TrashVersionCacheModel();

		trashVersionCacheModel.versionId = getVersionId();

		trashVersionCacheModel.companyId = getCompanyId();

		trashVersionCacheModel.entryId = getEntryId();

		trashVersionCacheModel.classNameId = getClassNameId();

		trashVersionCacheModel.classPK = getClassPK();

		trashVersionCacheModel.typeSettings = getTypeSettings();

		String typeSettings = trashVersionCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			trashVersionCacheModel.typeSettings = null;
		}

		trashVersionCacheModel.status = getStatus();

		return trashVersionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TrashVersion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TrashVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TrashVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TrashVersion)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TrashVersion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TrashVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TrashVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TrashVersion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TrashVersion>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _versionId;
	private long _companyId;
	private long _entryId;
	private long _originalEntryId;
	private boolean _setOriginalEntryId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _typeSettings;
	private int _status;
	private long _columnBitmask;
	private TrashVersion _escapedModel;

}