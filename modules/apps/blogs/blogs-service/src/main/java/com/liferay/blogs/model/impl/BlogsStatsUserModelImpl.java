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

package com.liferay.blogs.model.impl;

import com.liferay.blogs.model.BlogsStatsUser;
import com.liferay.blogs.model.BlogsStatsUserModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the BlogsStatsUser service. Represents a row in the &quot;BlogsStatsUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BlogsStatsUserModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlogsStatsUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlogsStatsUserImpl
 * @generated
 */
public class BlogsStatsUserModelImpl
	extends BaseModelImpl<BlogsStatsUser> implements BlogsStatsUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a blogs stats user model instance should use the <code>BlogsStatsUser</code> interface instead.
	 */
	public static final String TABLE_NAME = "BlogsStatsUser";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"statsUserId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"entryCount", Types.INTEGER},
		{"lastPostDate", Types.TIMESTAMP},
		{"ratingsTotalEntries", Types.INTEGER},
		{"ratingsTotalScore", Types.DOUBLE},
		{"ratingsAverageScore", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statsUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entryCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPostDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ratingsTotalEntries", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("ratingsTotalScore", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("ratingsAverageScore", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table BlogsStatsUser (mvccVersion LONG default 0 not null,statsUserId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,entryCount INTEGER,lastPostDate DATE null,ratingsTotalEntries INTEGER,ratingsTotalScore DOUBLE,ratingsAverageScore DOUBLE)";

	public static final String TABLE_SQL_DROP = "drop table BlogsStatsUser";

	public static final String ORDER_BY_JPQL =
		" ORDER BY blogsStatsUser.entryCount DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY BlogsStatsUser.entryCount DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ENTRYCOUNT_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LASTPOSTDATE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public BlogsStatsUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _statsUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatsUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statsUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BlogsStatsUser.class;
	}

	@Override
	public String getModelClassName() {
		return BlogsStatsUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BlogsStatsUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlogsStatsUser, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BlogsStatsUser)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BlogsStatsUser, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BlogsStatsUser, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BlogsStatsUser)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BlogsStatsUser, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BlogsStatsUser, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BlogsStatsUser>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BlogsStatsUser.class.getClassLoader(), BlogsStatsUser.class,
			ModelWrapper.class);

		try {
			Constructor<BlogsStatsUser> constructor =
				(Constructor<BlogsStatsUser>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<BlogsStatsUser, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BlogsStatsUser, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BlogsStatsUser, Object>>();
		Map<String, BiConsumer<BlogsStatsUser, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BlogsStatsUser, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", BlogsStatsUser::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<BlogsStatsUser, Long>)BlogsStatsUser::setMvccVersion);
		attributeGetterFunctions.put(
			"statsUserId", BlogsStatsUser::getStatsUserId);
		attributeSetterBiConsumers.put(
			"statsUserId",
			(BiConsumer<BlogsStatsUser, Long>)BlogsStatsUser::setStatsUserId);
		attributeGetterFunctions.put("groupId", BlogsStatsUser::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<BlogsStatsUser, Long>)BlogsStatsUser::setGroupId);
		attributeGetterFunctions.put("companyId", BlogsStatsUser::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BlogsStatsUser, Long>)BlogsStatsUser::setCompanyId);
		attributeGetterFunctions.put("userId", BlogsStatsUser::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<BlogsStatsUser, Long>)BlogsStatsUser::setUserId);
		attributeGetterFunctions.put(
			"entryCount", BlogsStatsUser::getEntryCount);
		attributeSetterBiConsumers.put(
			"entryCount",
			(BiConsumer<BlogsStatsUser, Integer>)BlogsStatsUser::setEntryCount);
		attributeGetterFunctions.put(
			"lastPostDate", BlogsStatsUser::getLastPostDate);
		attributeSetterBiConsumers.put(
			"lastPostDate",
			(BiConsumer<BlogsStatsUser, Date>)BlogsStatsUser::setLastPostDate);
		attributeGetterFunctions.put(
			"ratingsTotalEntries", BlogsStatsUser::getRatingsTotalEntries);
		attributeSetterBiConsumers.put(
			"ratingsTotalEntries",
			(BiConsumer<BlogsStatsUser, Integer>)
				BlogsStatsUser::setRatingsTotalEntries);
		attributeGetterFunctions.put(
			"ratingsTotalScore", BlogsStatsUser::getRatingsTotalScore);
		attributeSetterBiConsumers.put(
			"ratingsTotalScore",
			(BiConsumer<BlogsStatsUser, Double>)
				BlogsStatsUser::setRatingsTotalScore);
		attributeGetterFunctions.put(
			"ratingsAverageScore", BlogsStatsUser::getRatingsAverageScore);
		attributeSetterBiConsumers.put(
			"ratingsAverageScore",
			(BiConsumer<BlogsStatsUser, Double>)
				BlogsStatsUser::setRatingsAverageScore);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@Override
	public long getStatsUserId() {
		return _statsUserId;
	}

	@Override
	public void setStatsUserId(long statsUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statsUserId = statsUserId;
	}

	@Override
	public String getStatsUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatsUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatsUserUuid(String statsUserUuid) {
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@Override
	public int getEntryCount() {
		return _entryCount;
	}

	@Override
	public void setEntryCount(int entryCount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_entryCount = entryCount;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalEntryCount() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("entryCount"));
	}

	@Override
	public Date getLastPostDate() {
		return _lastPostDate;
	}

	@Override
	public void setLastPostDate(Date lastPostDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastPostDate = lastPostDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalLastPostDate() {
		return getColumnOriginalValue("lastPostDate");
	}

	@Override
	public int getRatingsTotalEntries() {
		return _ratingsTotalEntries;
	}

	@Override
	public void setRatingsTotalEntries(int ratingsTotalEntries) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ratingsTotalEntries = ratingsTotalEntries;
	}

	@Override
	public double getRatingsTotalScore() {
		return _ratingsTotalScore;
	}

	@Override
	public void setRatingsTotalScore(double ratingsTotalScore) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ratingsTotalScore = ratingsTotalScore;
	}

	@Override
	public double getRatingsAverageScore() {
		return _ratingsAverageScore;
	}

	@Override
	public void setRatingsAverageScore(double ratingsAverageScore) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ratingsAverageScore = ratingsAverageScore;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), BlogsStatsUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BlogsStatsUser toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BlogsStatsUser>
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
		BlogsStatsUserImpl blogsStatsUserImpl = new BlogsStatsUserImpl();

		blogsStatsUserImpl.setMvccVersion(getMvccVersion());
		blogsStatsUserImpl.setStatsUserId(getStatsUserId());
		blogsStatsUserImpl.setGroupId(getGroupId());
		blogsStatsUserImpl.setCompanyId(getCompanyId());
		blogsStatsUserImpl.setUserId(getUserId());
		blogsStatsUserImpl.setEntryCount(getEntryCount());
		blogsStatsUserImpl.setLastPostDate(getLastPostDate());
		blogsStatsUserImpl.setRatingsTotalEntries(getRatingsTotalEntries());
		blogsStatsUserImpl.setRatingsTotalScore(getRatingsTotalScore());
		blogsStatsUserImpl.setRatingsAverageScore(getRatingsAverageScore());

		blogsStatsUserImpl.resetOriginalValues();

		return blogsStatsUserImpl;
	}

	@Override
	public BlogsStatsUser cloneWithOriginalValues() {
		BlogsStatsUserImpl blogsStatsUserImpl = new BlogsStatsUserImpl();

		blogsStatsUserImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		blogsStatsUserImpl.setStatsUserId(
			this.<Long>getColumnOriginalValue("statsUserId"));
		blogsStatsUserImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		blogsStatsUserImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		blogsStatsUserImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		blogsStatsUserImpl.setEntryCount(
			this.<Integer>getColumnOriginalValue("entryCount"));
		blogsStatsUserImpl.setLastPostDate(
			this.<Date>getColumnOriginalValue("lastPostDate"));
		blogsStatsUserImpl.setRatingsTotalEntries(
			this.<Integer>getColumnOriginalValue("ratingsTotalEntries"));
		blogsStatsUserImpl.setRatingsTotalScore(
			this.<Double>getColumnOriginalValue("ratingsTotalScore"));
		blogsStatsUserImpl.setRatingsAverageScore(
			this.<Double>getColumnOriginalValue("ratingsAverageScore"));

		return blogsStatsUserImpl;
	}

	@Override
	public int compareTo(BlogsStatsUser blogsStatsUser) {
		int value = 0;

		if (getEntryCount() < blogsStatsUser.getEntryCount()) {
			value = -1;
		}
		else if (getEntryCount() > blogsStatsUser.getEntryCount()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BlogsStatsUser)) {
			return false;
		}

		BlogsStatsUser blogsStatsUser = (BlogsStatsUser)object;

		long primaryKey = blogsStatsUser.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<BlogsStatsUser> toCacheModel() {
		BlogsStatsUserCacheModel blogsStatsUserCacheModel =
			new BlogsStatsUserCacheModel();

		blogsStatsUserCacheModel.mvccVersion = getMvccVersion();

		blogsStatsUserCacheModel.statsUserId = getStatsUserId();

		blogsStatsUserCacheModel.groupId = getGroupId();

		blogsStatsUserCacheModel.companyId = getCompanyId();

		blogsStatsUserCacheModel.userId = getUserId();

		blogsStatsUserCacheModel.entryCount = getEntryCount();

		Date lastPostDate = getLastPostDate();

		if (lastPostDate != null) {
			blogsStatsUserCacheModel.lastPostDate = lastPostDate.getTime();
		}
		else {
			blogsStatsUserCacheModel.lastPostDate = Long.MIN_VALUE;
		}

		blogsStatsUserCacheModel.ratingsTotalEntries = getRatingsTotalEntries();

		blogsStatsUserCacheModel.ratingsTotalScore = getRatingsTotalScore();

		blogsStatsUserCacheModel.ratingsAverageScore = getRatingsAverageScore();

		return blogsStatsUserCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BlogsStatsUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlogsStatsUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((BlogsStatsUser)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

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
		Map<String, Function<BlogsStatsUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BlogsStatsUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlogsStatsUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BlogsStatsUser)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, BlogsStatsUser>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _statsUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private int _entryCount;
	private Date _lastPostDate;
	private int _ratingsTotalEntries;
	private double _ratingsTotalScore;
	private double _ratingsAverageScore;

	public <T> T getColumnValue(String columnName) {
		Function<BlogsStatsUser, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BlogsStatsUser)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("statsUserId", _statsUserId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("entryCount", _entryCount);
		_columnOriginalValues.put("lastPostDate", _lastPostDate);
		_columnOriginalValues.put("ratingsTotalEntries", _ratingsTotalEntries);
		_columnOriginalValues.put("ratingsTotalScore", _ratingsTotalScore);
		_columnOriginalValues.put("ratingsAverageScore", _ratingsAverageScore);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("statsUserId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("entryCount", 32L);

		columnBitmasks.put("lastPostDate", 64L);

		columnBitmasks.put("ratingsTotalEntries", 128L);

		columnBitmasks.put("ratingsTotalScore", 256L);

		columnBitmasks.put("ratingsAverageScore", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BlogsStatsUser _escapedModel;

}