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

package com.liferay.portal.workflow.kaleo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.model.KaleoActionModel;

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
 * The base model implementation for the KaleoAction service. Represents a row in the &quot;KaleoAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>KaleoActionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoActionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoActionImpl
 * @generated
 */
@ProviderType
public class KaleoActionModelImpl
	extends BaseModelImpl<KaleoAction> implements KaleoActionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo action model instance should use the <code>KaleoAction</code> interface instead.
	 */
	public static final String TABLE_NAME = "KaleoAction";

	public static final Object[][] TABLE_COLUMNS = {
		{"kaleoActionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"kaleoClassName", Types.VARCHAR},
		{"kaleoClassPK", Types.BIGINT}, {"kaleoDefinitionId", Types.BIGINT},
		{"kaleoNodeName", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"executionType", Types.VARCHAR},
		{"script", Types.CLOB}, {"scriptLanguage", Types.VARCHAR},
		{"scriptRequiredContexts", Types.VARCHAR}, {"priority", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("kaleoActionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("kaleoClassName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kaleoClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoNodeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("executionType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("script", Types.CLOB);
		TABLE_COLUMNS_MAP.put("scriptLanguage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("scriptRequiredContexts", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table KaleoAction (kaleoActionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoClassName VARCHAR(200) null,kaleoClassPK LONG,kaleoDefinitionId LONG,kaleoNodeName VARCHAR(200) null,name VARCHAR(200) null,description STRING null,executionType VARCHAR(20) null,script TEXT null,scriptLanguage VARCHAR(75) null,scriptRequiredContexts STRING null,priority INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table KaleoAction";

	public static final String ORDER_BY_JPQL =
		" ORDER BY kaleoAction.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY KaleoAction.priority ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoAction"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoAction"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoAction"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long EXECUTIONTYPE_COLUMN_BITMASK = 2L;

	public static final long KALEOCLASSNAME_COLUMN_BITMASK = 4L;

	public static final long KALEOCLASSPK_COLUMN_BITMASK = 8L;

	public static final long KALEODEFINITIONID_COLUMN_BITMASK = 16L;

	public static final long PRIORITY_COLUMN_BITMASK = 32L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoAction"));

	public KaleoActionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kaleoActionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKaleoActionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kaleoActionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KaleoAction.class;
	}

	@Override
	public String getModelClassName() {
		return KaleoAction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KaleoAction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KaleoAction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoAction, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((KaleoAction)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KaleoAction, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KaleoAction, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(KaleoAction)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<KaleoAction, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KaleoAction, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, KaleoAction>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			KaleoAction.class.getClassLoader(), KaleoAction.class,
			ModelWrapper.class);

		try {
			Constructor<KaleoAction> constructor =
				(Constructor<KaleoAction>)proxyClass.getConstructor(
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

	private static final Map<String, Function<KaleoAction, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<KaleoAction, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<KaleoAction, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<KaleoAction, Object>>();
		Map<String, BiConsumer<KaleoAction, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<KaleoAction, ?>>();

		attributeGetterFunctions.put(
			"kaleoActionId",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getKaleoActionId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoActionId",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object kaleoActionId) {

					kaleoAction.setKaleoActionId((Long)kaleoActionId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object groupId) {
					kaleoAction.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object companyId) {
					kaleoAction.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object userId) {
					kaleoAction.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object userName) {
					kaleoAction.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object createDate) {
					kaleoAction.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object modifiedDate) {

					kaleoAction.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"kaleoClassName",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getKaleoClassName();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoClassName",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object kaleoClassName) {

					kaleoAction.setKaleoClassName((String)kaleoClassName);
				}

			});
		attributeGetterFunctions.put(
			"kaleoClassPK",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getKaleoClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoClassPK",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object kaleoClassPK) {

					kaleoAction.setKaleoClassPK((Long)kaleoClassPK);
				}

			});
		attributeGetterFunctions.put(
			"kaleoDefinitionId",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getKaleoDefinitionId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoDefinitionId",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object kaleoDefinitionId) {

					kaleoAction.setKaleoDefinitionId((Long)kaleoDefinitionId);
				}

			});
		attributeGetterFunctions.put(
			"kaleoNodeName",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getKaleoNodeName();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoNodeName",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object kaleoNodeName) {

					kaleoAction.setKaleoNodeName((String)kaleoNodeName);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object name) {
					kaleoAction.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object description) {

					kaleoAction.setDescription((String)description);
				}

			});
		attributeGetterFunctions.put(
			"executionType",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getExecutionType();
				}

			});
		attributeSetterBiConsumers.put(
			"executionType",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object executionType) {

					kaleoAction.setExecutionType((String)executionType);
				}

			});
		attributeGetterFunctions.put(
			"script",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getScript();
				}

			});
		attributeSetterBiConsumers.put(
			"script",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object script) {
					kaleoAction.setScript((String)script);
				}

			});
		attributeGetterFunctions.put(
			"scriptLanguage",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getScriptLanguage();
				}

			});
		attributeSetterBiConsumers.put(
			"scriptLanguage",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object scriptLanguage) {

					kaleoAction.setScriptLanguage((String)scriptLanguage);
				}

			});
		attributeGetterFunctions.put(
			"scriptRequiredContexts",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getScriptRequiredContexts();
				}

			});
		attributeSetterBiConsumers.put(
			"scriptRequiredContexts",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(
					KaleoAction kaleoAction, Object scriptRequiredContexts) {

					kaleoAction.setScriptRequiredContexts(
						(String)scriptRequiredContexts);
				}

			});
		attributeGetterFunctions.put(
			"priority",
			new Function<KaleoAction, Object>() {

				@Override
				public Object apply(KaleoAction kaleoAction) {
					return kaleoAction.getPriority();
				}

			});
		attributeSetterBiConsumers.put(
			"priority",
			new BiConsumer<KaleoAction, Object>() {

				@Override
				public void accept(KaleoAction kaleoAction, Object priority) {
					kaleoAction.setPriority((Integer)priority);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getKaleoActionId() {
		return _kaleoActionId;
	}

	@Override
	public void setKaleoActionId(long kaleoActionId) {
		_kaleoActionId = kaleoActionId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
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
	public String getKaleoClassName() {
		if (_kaleoClassName == null) {
			return "";
		}
		else {
			return _kaleoClassName;
		}
	}

	@Override
	public void setKaleoClassName(String kaleoClassName) {
		_columnBitmask |= KALEOCLASSNAME_COLUMN_BITMASK;

		if (_originalKaleoClassName == null) {
			_originalKaleoClassName = _kaleoClassName;
		}

		_kaleoClassName = kaleoClassName;
	}

	public String getOriginalKaleoClassName() {
		return GetterUtil.getString(_originalKaleoClassName);
	}

	@Override
	public long getKaleoClassPK() {
		return _kaleoClassPK;
	}

	@Override
	public void setKaleoClassPK(long kaleoClassPK) {
		_columnBitmask |= KALEOCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalKaleoClassPK) {
			_setOriginalKaleoClassPK = true;

			_originalKaleoClassPK = _kaleoClassPK;
		}

		_kaleoClassPK = kaleoClassPK;
	}

	public long getOriginalKaleoClassPK() {
		return _originalKaleoClassPK;
	}

	@Override
	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}

	@Override
	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
	}

	@Override
	public String getKaleoNodeName() {
		if (_kaleoNodeName == null) {
			return "";
		}
		else {
			return _kaleoNodeName;
		}
	}

	@Override
	public void setKaleoNodeName(String kaleoNodeName) {
		_kaleoNodeName = kaleoNodeName;
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
		_name = name;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getExecutionType() {
		if (_executionType == null) {
			return "";
		}
		else {
			return _executionType;
		}
	}

	@Override
	public void setExecutionType(String executionType) {
		_columnBitmask |= EXECUTIONTYPE_COLUMN_BITMASK;

		if (_originalExecutionType == null) {
			_originalExecutionType = _executionType;
		}

		_executionType = executionType;
	}

	public String getOriginalExecutionType() {
		return GetterUtil.getString(_originalExecutionType);
	}

	@Override
	public String getScript() {
		if (_script == null) {
			return "";
		}
		else {
			return _script;
		}
	}

	@Override
	public void setScript(String script) {
		_script = script;
	}

	@Override
	public String getScriptLanguage() {
		if (_scriptLanguage == null) {
			return "";
		}
		else {
			return _scriptLanguage;
		}
	}

	@Override
	public void setScriptLanguage(String scriptLanguage) {
		_scriptLanguage = scriptLanguage;
	}

	@Override
	public String getScriptRequiredContexts() {
		if (_scriptRequiredContexts == null) {
			return "";
		}
		else {
			return _scriptRequiredContexts;
		}
	}

	@Override
	public void setScriptRequiredContexts(String scriptRequiredContexts) {
		_scriptRequiredContexts = scriptRequiredContexts;
	}

	@Override
	public int getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(int priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), KaleoAction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoAction toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, KaleoAction>
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
		KaleoActionImpl kaleoActionImpl = new KaleoActionImpl();

		kaleoActionImpl.setKaleoActionId(getKaleoActionId());
		kaleoActionImpl.setGroupId(getGroupId());
		kaleoActionImpl.setCompanyId(getCompanyId());
		kaleoActionImpl.setUserId(getUserId());
		kaleoActionImpl.setUserName(getUserName());
		kaleoActionImpl.setCreateDate(getCreateDate());
		kaleoActionImpl.setModifiedDate(getModifiedDate());
		kaleoActionImpl.setKaleoClassName(getKaleoClassName());
		kaleoActionImpl.setKaleoClassPK(getKaleoClassPK());
		kaleoActionImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoActionImpl.setKaleoNodeName(getKaleoNodeName());
		kaleoActionImpl.setName(getName());
		kaleoActionImpl.setDescription(getDescription());
		kaleoActionImpl.setExecutionType(getExecutionType());
		kaleoActionImpl.setScript(getScript());
		kaleoActionImpl.setScriptLanguage(getScriptLanguage());
		kaleoActionImpl.setScriptRequiredContexts(getScriptRequiredContexts());
		kaleoActionImpl.setPriority(getPriority());

		kaleoActionImpl.resetOriginalValues();

		return kaleoActionImpl;
	}

	@Override
	public int compareTo(KaleoAction kaleoAction) {
		int value = 0;

		if (getPriority() < kaleoAction.getPriority()) {
			value = -1;
		}
		else if (getPriority() > kaleoAction.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof KaleoAction)) {
			return false;
		}

		KaleoAction kaleoAction = (KaleoAction)obj;

		long primaryKey = kaleoAction.getPrimaryKey();

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
		KaleoActionModelImpl kaleoActionModelImpl = this;

		kaleoActionModelImpl._originalCompanyId =
			kaleoActionModelImpl._companyId;

		kaleoActionModelImpl._setOriginalCompanyId = false;

		kaleoActionModelImpl._setModifiedDate = false;

		kaleoActionModelImpl._originalKaleoClassName =
			kaleoActionModelImpl._kaleoClassName;

		kaleoActionModelImpl._originalKaleoClassPK =
			kaleoActionModelImpl._kaleoClassPK;

		kaleoActionModelImpl._setOriginalKaleoClassPK = false;

		kaleoActionModelImpl._originalKaleoDefinitionId =
			kaleoActionModelImpl._kaleoDefinitionId;

		kaleoActionModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoActionModelImpl._originalExecutionType =
			kaleoActionModelImpl._executionType;

		kaleoActionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoAction> toCacheModel() {
		KaleoActionCacheModel kaleoActionCacheModel =
			new KaleoActionCacheModel();

		kaleoActionCacheModel.kaleoActionId = getKaleoActionId();

		kaleoActionCacheModel.groupId = getGroupId();

		kaleoActionCacheModel.companyId = getCompanyId();

		kaleoActionCacheModel.userId = getUserId();

		kaleoActionCacheModel.userName = getUserName();

		String userName = kaleoActionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoActionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoActionCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoActionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoActionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoActionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoActionCacheModel.kaleoClassName = getKaleoClassName();

		String kaleoClassName = kaleoActionCacheModel.kaleoClassName;

		if ((kaleoClassName != null) && (kaleoClassName.length() == 0)) {
			kaleoActionCacheModel.kaleoClassName = null;
		}

		kaleoActionCacheModel.kaleoClassPK = getKaleoClassPK();

		kaleoActionCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoActionCacheModel.kaleoNodeName = getKaleoNodeName();

		String kaleoNodeName = kaleoActionCacheModel.kaleoNodeName;

		if ((kaleoNodeName != null) && (kaleoNodeName.length() == 0)) {
			kaleoActionCacheModel.kaleoNodeName = null;
		}

		kaleoActionCacheModel.name = getName();

		String name = kaleoActionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoActionCacheModel.name = null;
		}

		kaleoActionCacheModel.description = getDescription();

		String description = kaleoActionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoActionCacheModel.description = null;
		}

		kaleoActionCacheModel.executionType = getExecutionType();

		String executionType = kaleoActionCacheModel.executionType;

		if ((executionType != null) && (executionType.length() == 0)) {
			kaleoActionCacheModel.executionType = null;
		}

		kaleoActionCacheModel.script = getScript();

		String script = kaleoActionCacheModel.script;

		if ((script != null) && (script.length() == 0)) {
			kaleoActionCacheModel.script = null;
		}

		kaleoActionCacheModel.scriptLanguage = getScriptLanguage();

		String scriptLanguage = kaleoActionCacheModel.scriptLanguage;

		if ((scriptLanguage != null) && (scriptLanguage.length() == 0)) {
			kaleoActionCacheModel.scriptLanguage = null;
		}

		kaleoActionCacheModel.scriptRequiredContexts =
			getScriptRequiredContexts();

		String scriptRequiredContexts =
			kaleoActionCacheModel.scriptRequiredContexts;

		if ((scriptRequiredContexts != null) &&
			(scriptRequiredContexts.length() == 0)) {

			kaleoActionCacheModel.scriptRequiredContexts = null;
		}

		kaleoActionCacheModel.priority = getPriority();

		return kaleoActionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KaleoAction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<KaleoAction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoAction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((KaleoAction)this));
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
		Map<String, Function<KaleoAction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KaleoAction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoAction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((KaleoAction)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, KaleoAction>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _kaleoActionId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _kaleoClassName;
	private String _originalKaleoClassName;
	private long _kaleoClassPK;
	private long _originalKaleoClassPK;
	private boolean _setOriginalKaleoClassPK;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private String _kaleoNodeName;
	private String _name;
	private String _description;
	private String _executionType;
	private String _originalExecutionType;
	private String _script;
	private String _scriptLanguage;
	private String _scriptRequiredContexts;
	private int _priority;
	private long _columnBitmask;
	private KaleoAction _escapedModel;

}