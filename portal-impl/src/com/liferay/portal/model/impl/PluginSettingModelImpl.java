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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.PluginSetting;
import com.liferay.portal.kernel.model.PluginSettingModel;
import com.liferay.portal.kernel.model.PluginSettingSoap;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the PluginSetting service. Represents a row in the &quot;PluginSetting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>PluginSettingModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PluginSettingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PluginSettingImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PluginSettingModelImpl
	extends BaseModelImpl<PluginSetting> implements PluginSettingModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a plugin setting model instance should use the <code>PluginSetting</code> interface instead.
	 */
	public static final String TABLE_NAME = "PluginSetting";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"pluginSettingId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"pluginId", Types.VARCHAR},
		{"pluginType", Types.VARCHAR}, {"roles", Types.VARCHAR},
		{"active_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("pluginSettingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("pluginId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pluginType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("roles", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PluginSetting (mvccVersion LONG default 0 not null,pluginSettingId LONG not null primary key,companyId LONG,pluginId VARCHAR(75) null,pluginType VARCHAR(75) null,roles STRING null,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table PluginSetting";

	public static final String ORDER_BY_JPQL =
		" ORDER BY pluginSetting.pluginSettingId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PluginSetting.pluginSettingId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.PluginSetting"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.PluginSetting"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.PluginSetting"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long PLUGINID_COLUMN_BITMASK = 2L;

	public static final long PLUGINTYPE_COLUMN_BITMASK = 4L;

	public static final long PLUGINSETTINGID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PluginSetting toModel(PluginSettingSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PluginSetting model = new PluginSettingImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setPluginSettingId(soapModel.getPluginSettingId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setPluginId(soapModel.getPluginId());
		model.setPluginType(soapModel.getPluginType());
		model.setRoles(soapModel.getRoles());
		model.setActive(soapModel.isActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PluginSetting> toModels(PluginSettingSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PluginSetting> models = new ArrayList<PluginSetting>(
			soapModels.length);

		for (PluginSettingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.PluginSetting"));

	public PluginSettingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _pluginSettingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPluginSettingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pluginSettingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PluginSetting.class;
	}

	@Override
	public String getModelClassName() {
		return PluginSetting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PluginSetting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PluginSetting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PluginSetting, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PluginSetting)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PluginSetting, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PluginSetting, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PluginSetting)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PluginSetting, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PluginSetting, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PluginSetting>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PluginSetting.class.getClassLoader(), PluginSetting.class,
			ModelWrapper.class);

		try {
			Constructor<PluginSetting> constructor =
				(Constructor<PluginSetting>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PluginSetting, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PluginSetting, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PluginSetting, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PluginSetting, Object>>();
		Map<String, BiConsumer<PluginSetting, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PluginSetting, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(
					PluginSetting pluginSetting, Object mvccVersion) {

					pluginSetting.setMvccVersion((Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"pluginSettingId",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getPluginSettingId();
				}

			});
		attributeSetterBiConsumers.put(
			"pluginSettingId",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(
					PluginSetting pluginSetting, Object pluginSettingId) {

					pluginSetting.setPluginSettingId((Long)pluginSettingId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(
					PluginSetting pluginSetting, Object companyId) {

					pluginSetting.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"pluginId",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getPluginId();
				}

			});
		attributeSetterBiConsumers.put(
			"pluginId",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(
					PluginSetting pluginSetting, Object pluginId) {

					pluginSetting.setPluginId((String)pluginId);
				}

			});
		attributeGetterFunctions.put(
			"pluginType",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getPluginType();
				}

			});
		attributeSetterBiConsumers.put(
			"pluginType",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(
					PluginSetting pluginSetting, Object pluginType) {

					pluginSetting.setPluginType((String)pluginType);
				}

			});
		attributeGetterFunctions.put(
			"roles",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getRoles();
				}

			});
		attributeSetterBiConsumers.put(
			"roles",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(PluginSetting pluginSetting, Object roles) {
					pluginSetting.setRoles((String)roles);
				}

			});
		attributeGetterFunctions.put(
			"active",
			new Function<PluginSetting, Object>() {

				@Override
				public Object apply(PluginSetting pluginSetting) {
					return pluginSetting.getActive();
				}

			});
		attributeSetterBiConsumers.put(
			"active",
			new BiConsumer<PluginSetting, Object>() {

				@Override
				public void accept(PluginSetting pluginSetting, Object active) {
					pluginSetting.setActive((Boolean)active);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getPluginSettingId() {
		return _pluginSettingId;
	}

	@Override
	public void setPluginSettingId(long pluginSettingId) {
		_pluginSettingId = pluginSettingId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public String getPluginId() {
		if (_pluginId == null) {
			return "";
		}
		else {
			return _pluginId;
		}
	}

	@Override
	public void setPluginId(String pluginId) {
		_columnBitmask |= PLUGINID_COLUMN_BITMASK;

		if (_originalPluginId == null) {
			_originalPluginId = _pluginId;
		}

		_pluginId = pluginId;
	}

	public String getOriginalPluginId() {
		return GetterUtil.getString(_originalPluginId);
	}

	@JSON
	@Override
	public String getPluginType() {
		if (_pluginType == null) {
			return "";
		}
		else {
			return _pluginType;
		}
	}

	@Override
	public void setPluginType(String pluginType) {
		_columnBitmask |= PLUGINTYPE_COLUMN_BITMASK;

		if (_originalPluginType == null) {
			_originalPluginType = _pluginType;
		}

		_pluginType = pluginType;
	}

	public String getOriginalPluginType() {
		return GetterUtil.getString(_originalPluginType);
	}

	@JSON
	@Override
	public String getRoles() {
		if (_roles == null) {
			return "";
		}
		else {
			return _roles;
		}
	}

	@Override
	public void setRoles(String roles) {
		_roles = roles;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), PluginSetting.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PluginSetting toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PluginSetting>
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
		PluginSettingImpl pluginSettingImpl = new PluginSettingImpl();

		pluginSettingImpl.setMvccVersion(getMvccVersion());
		pluginSettingImpl.setPluginSettingId(getPluginSettingId());
		pluginSettingImpl.setCompanyId(getCompanyId());
		pluginSettingImpl.setPluginId(getPluginId());
		pluginSettingImpl.setPluginType(getPluginType());
		pluginSettingImpl.setRoles(getRoles());
		pluginSettingImpl.setActive(isActive());

		pluginSettingImpl.resetOriginalValues();

		return pluginSettingImpl;
	}

	@Override
	public int compareTo(PluginSetting pluginSetting) {
		long primaryKey = pluginSetting.getPrimaryKey();

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

		if (!(obj instanceof PluginSetting)) {
			return false;
		}

		PluginSetting pluginSetting = (PluginSetting)obj;

		long primaryKey = pluginSetting.getPrimaryKey();

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
		PluginSettingModelImpl pluginSettingModelImpl = this;

		pluginSettingModelImpl._originalCompanyId =
			pluginSettingModelImpl._companyId;

		pluginSettingModelImpl._setOriginalCompanyId = false;

		pluginSettingModelImpl._originalPluginId =
			pluginSettingModelImpl._pluginId;

		pluginSettingModelImpl._originalPluginType =
			pluginSettingModelImpl._pluginType;

		pluginSettingModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PluginSetting> toCacheModel() {
		PluginSettingCacheModel pluginSettingCacheModel =
			new PluginSettingCacheModel();

		pluginSettingCacheModel.mvccVersion = getMvccVersion();

		pluginSettingCacheModel.pluginSettingId = getPluginSettingId();

		pluginSettingCacheModel.companyId = getCompanyId();

		pluginSettingCacheModel.pluginId = getPluginId();

		String pluginId = pluginSettingCacheModel.pluginId;

		if ((pluginId != null) && (pluginId.length() == 0)) {
			pluginSettingCacheModel.pluginId = null;
		}

		pluginSettingCacheModel.pluginType = getPluginType();

		String pluginType = pluginSettingCacheModel.pluginType;

		if ((pluginType != null) && (pluginType.length() == 0)) {
			pluginSettingCacheModel.pluginType = null;
		}

		pluginSettingCacheModel.roles = getRoles();

		String roles = pluginSettingCacheModel.roles;

		if ((roles != null) && (roles.length() == 0)) {
			pluginSettingCacheModel.roles = null;
		}

		pluginSettingCacheModel.active = isActive();

		return pluginSettingCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PluginSetting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PluginSetting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PluginSetting, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PluginSetting)this));
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
		Map<String, Function<PluginSetting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PluginSetting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PluginSetting, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PluginSetting)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PluginSetting>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _pluginSettingId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _pluginId;
	private String _originalPluginId;
	private String _pluginType;
	private String _originalPluginType;
	private String _roles;
	private boolean _active;
	private long _columnBitmask;
	private PluginSetting _escapedModel;

}