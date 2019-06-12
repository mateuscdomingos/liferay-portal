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

package com.liferay.wsrp.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.wsrp.model.WSRPProducer;
import com.liferay.wsrp.model.WSRPProducerModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the WSRPProducer service. Represents a row in the &quot;WSRP_WSRPProducer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>WSRPProducerModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WSRPProducerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WSRPProducerImpl
 * @generated
 */
@ProviderType
public class WSRPProducerModelImpl
	extends BaseModelImpl<WSRPProducer> implements WSRPProducerModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wsrp producer model instance should use the <code>WSRPProducer</code> interface instead.
	 */
	public static final String TABLE_NAME = "WSRP_WSRPProducer";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"wsrpProducerId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"version", Types.VARCHAR},
		{"portletIds", Types.VARCHAR}, {"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("wsrpProducerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("portletIds", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table WSRP_WSRPProducer (uuid_ VARCHAR(75) null,wsrpProducerId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,version VARCHAR(75) null,portletIds STRING null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table WSRP_WSRPProducer";

	public static final String ORDER_BY_JPQL =
		" ORDER BY wsrpProducer.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY WSRP_WSRPProducer.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.wsrp.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.wsrp.model.WSRPProducer"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.wsrp.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.wsrp.model.WSRPProducer"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.wsrp.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.wsrp.model.WSRPProducer"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long NAME_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.wsrp.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.wsrp.model.WSRPProducer"));

	public WSRPProducerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _wsrpProducerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWsrpProducerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wsrpProducerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WSRPProducer.class;
	}

	@Override
	public String getModelClassName() {
		return WSRPProducer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<WSRPProducer, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<WSRPProducer, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WSRPProducer, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((WSRPProducer)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<WSRPProducer, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<WSRPProducer, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(WSRPProducer)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<WSRPProducer, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<WSRPProducer, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, WSRPProducer>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			WSRPProducer.class.getClassLoader(), WSRPProducer.class,
			ModelWrapper.class);

		try {
			Constructor<WSRPProducer> constructor =
				(Constructor<WSRPProducer>)proxyClass.getConstructor(
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

	private static final Map<String, Function<WSRPProducer, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<WSRPProducer, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<WSRPProducer, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<WSRPProducer, Object>>();
		Map<String, BiConsumer<WSRPProducer, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<WSRPProducer, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(WSRPProducer wsrpProducer, Object uuid) {
					wsrpProducer.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"wsrpProducerId",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getWsrpProducerId();
				}

			});
		attributeSetterBiConsumers.put(
			"wsrpProducerId",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(
					WSRPProducer wsrpProducer, Object wsrpProducerId) {

					wsrpProducer.setWsrpProducerId((Long)wsrpProducerId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(WSRPProducer wsrpProducer, Object groupId) {
					wsrpProducer.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(
					WSRPProducer wsrpProducer, Object companyId) {

					wsrpProducer.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(
					WSRPProducer wsrpProducer, Object createDate) {

					wsrpProducer.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(
					WSRPProducer wsrpProducer, Object modifiedDate) {

					wsrpProducer.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(WSRPProducer wsrpProducer, Object name) {
					wsrpProducer.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"version",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"version",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(WSRPProducer wsrpProducer, Object version) {
					wsrpProducer.setVersion((String)version);
				}

			});
		attributeGetterFunctions.put(
			"portletIds",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getPortletIds();
				}

			});
		attributeSetterBiConsumers.put(
			"portletIds",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(
					WSRPProducer wsrpProducer, Object portletIds) {

					wsrpProducer.setPortletIds((String)portletIds);
				}

			});
		attributeGetterFunctions.put(
			"lastPublishDate",
			new Function<WSRPProducer, Object>() {

				@Override
				public Object apply(WSRPProducer wsrpProducer) {
					return wsrpProducer.getLastPublishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			new BiConsumer<WSRPProducer, Object>() {

				@Override
				public void accept(
					WSRPProducer wsrpProducer, Object lastPublishDate) {

					wsrpProducer.setLastPublishDate((Date)lastPublishDate);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getWsrpProducerId() {
		return _wsrpProducerId;
	}

	@Override
	public void setWsrpProducerId(long wsrpProducerId) {
		_wsrpProducerId = wsrpProducerId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_version = version;
	}

	@Override
	public String getPortletIds() {
		if (_portletIds == null) {
			return "";
		}
		else {
			return _portletIds;
		}
	}

	@Override
	public void setPortletIds(String portletIds) {
		_portletIds = portletIds;
	}

	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(WSRPProducer.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), WSRPProducer.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WSRPProducer toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, WSRPProducer>
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
		WSRPProducerImpl wsrpProducerImpl = new WSRPProducerImpl();

		wsrpProducerImpl.setUuid(getUuid());
		wsrpProducerImpl.setWsrpProducerId(getWsrpProducerId());
		wsrpProducerImpl.setGroupId(getGroupId());
		wsrpProducerImpl.setCompanyId(getCompanyId());
		wsrpProducerImpl.setCreateDate(getCreateDate());
		wsrpProducerImpl.setModifiedDate(getModifiedDate());
		wsrpProducerImpl.setName(getName());
		wsrpProducerImpl.setVersion(getVersion());
		wsrpProducerImpl.setPortletIds(getPortletIds());
		wsrpProducerImpl.setLastPublishDate(getLastPublishDate());

		wsrpProducerImpl.resetOriginalValues();

		return wsrpProducerImpl;
	}

	@Override
	public int compareTo(WSRPProducer wsrpProducer) {
		int value = 0;

		value = getName().compareTo(wsrpProducer.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WSRPProducer)) {
			return false;
		}

		WSRPProducer wsrpProducer = (WSRPProducer)obj;

		long primaryKey = wsrpProducer.getPrimaryKey();

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
		WSRPProducerModelImpl wsrpProducerModelImpl = this;

		wsrpProducerModelImpl._originalUuid = wsrpProducerModelImpl._uuid;

		wsrpProducerModelImpl._originalGroupId = wsrpProducerModelImpl._groupId;

		wsrpProducerModelImpl._setOriginalGroupId = false;

		wsrpProducerModelImpl._originalCompanyId =
			wsrpProducerModelImpl._companyId;

		wsrpProducerModelImpl._setOriginalCompanyId = false;

		wsrpProducerModelImpl._setModifiedDate = false;

		wsrpProducerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WSRPProducer> toCacheModel() {
		WSRPProducerCacheModel wsrpProducerCacheModel =
			new WSRPProducerCacheModel();

		wsrpProducerCacheModel.uuid = getUuid();

		String uuid = wsrpProducerCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			wsrpProducerCacheModel.uuid = null;
		}

		wsrpProducerCacheModel.wsrpProducerId = getWsrpProducerId();

		wsrpProducerCacheModel.groupId = getGroupId();

		wsrpProducerCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			wsrpProducerCacheModel.createDate = createDate.getTime();
		}
		else {
			wsrpProducerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wsrpProducerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wsrpProducerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		wsrpProducerCacheModel.name = getName();

		String name = wsrpProducerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			wsrpProducerCacheModel.name = null;
		}

		wsrpProducerCacheModel.version = getVersion();

		String version = wsrpProducerCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			wsrpProducerCacheModel.version = null;
		}

		wsrpProducerCacheModel.portletIds = getPortletIds();

		String portletIds = wsrpProducerCacheModel.portletIds;

		if ((portletIds != null) && (portletIds.length() == 0)) {
			wsrpProducerCacheModel.portletIds = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			wsrpProducerCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			wsrpProducerCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return wsrpProducerCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<WSRPProducer, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<WSRPProducer, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WSRPProducer, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((WSRPProducer)this));
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
		Map<String, Function<WSRPProducer, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<WSRPProducer, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WSRPProducer, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((WSRPProducer)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, WSRPProducer>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _wsrpProducerId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _version;
	private String _portletIds;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private WSRPProducer _escapedModel;

}