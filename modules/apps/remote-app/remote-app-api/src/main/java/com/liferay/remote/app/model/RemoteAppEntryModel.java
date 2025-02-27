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

package com.liferay.remote.app.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the RemoteAppEntry service. Represents a row in the &quot;RemoteAppEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.remote.app.model.impl.RemoteAppEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.remote.app.model.impl.RemoteAppEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RemoteAppEntry
 * @generated
 */
@ProviderType
public interface RemoteAppEntryModel
	extends BaseModel<RemoteAppEntry>, ContainerModel, LocalizedModel,
			MVCCModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a remote app entry model instance should use the {@link RemoteAppEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this remote app entry.
	 *
	 * @return the primary key of this remote app entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this remote app entry.
	 *
	 * @param primaryKey the primary key of this remote app entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this remote app entry.
	 *
	 * @return the mvcc version of this remote app entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this remote app entry.
	 *
	 * @param mvccVersion the mvcc version of this remote app entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this remote app entry.
	 *
	 * @return the uuid of this remote app entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this remote app entry.
	 *
	 * @param uuid the uuid of this remote app entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the remote app entry ID of this remote app entry.
	 *
	 * @return the remote app entry ID of this remote app entry
	 */
	public long getRemoteAppEntryId();

	/**
	 * Sets the remote app entry ID of this remote app entry.
	 *
	 * @param remoteAppEntryId the remote app entry ID of this remote app entry
	 */
	public void setRemoteAppEntryId(long remoteAppEntryId);

	/**
	 * Returns the company ID of this remote app entry.
	 *
	 * @return the company ID of this remote app entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this remote app entry.
	 *
	 * @param companyId the company ID of this remote app entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this remote app entry.
	 *
	 * @return the user ID of this remote app entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this remote app entry.
	 *
	 * @param userId the user ID of this remote app entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this remote app entry.
	 *
	 * @return the user uuid of this remote app entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this remote app entry.
	 *
	 * @param userUuid the user uuid of this remote app entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this remote app entry.
	 *
	 * @return the user name of this remote app entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this remote app entry.
	 *
	 * @param userName the user name of this remote app entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this remote app entry.
	 *
	 * @return the create date of this remote app entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this remote app entry.
	 *
	 * @param createDate the create date of this remote app entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this remote app entry.
	 *
	 * @return the modified date of this remote app entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this remote app entry.
	 *
	 * @param modifiedDate the modified date of this remote app entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the custom element cssur ls of this remote app entry.
	 *
	 * @return the custom element cssur ls of this remote app entry
	 */
	@AutoEscape
	public String getCustomElementCSSURLs();

	/**
	 * Sets the custom element cssur ls of this remote app entry.
	 *
	 * @param customElementCSSURLs the custom element cssur ls of this remote app entry
	 */
	public void setCustomElementCSSURLs(String customElementCSSURLs);

	/**
	 * Returns the custom element html element name of this remote app entry.
	 *
	 * @return the custom element html element name of this remote app entry
	 */
	@AutoEscape
	public String getCustomElementHTMLElementName();

	/**
	 * Sets the custom element html element name of this remote app entry.
	 *
	 * @param customElementHTMLElementName the custom element html element name of this remote app entry
	 */
	public void setCustomElementHTMLElementName(
		String customElementHTMLElementName);

	/**
	 * Returns the custom element ur ls of this remote app entry.
	 *
	 * @return the custom element ur ls of this remote app entry
	 */
	@AutoEscape
	public String getCustomElementURLs();

	/**
	 * Sets the custom element ur ls of this remote app entry.
	 *
	 * @param customElementURLs the custom element ur ls of this remote app entry
	 */
	public void setCustomElementURLs(String customElementURLs);

	/**
	 * Returns the i frame url of this remote app entry.
	 *
	 * @return the i frame url of this remote app entry
	 */
	@AutoEscape
	public String getIFrameURL();

	/**
	 * Sets the i frame url of this remote app entry.
	 *
	 * @param iFrameURL the i frame url of this remote app entry
	 */
	public void setIFrameURL(String iFrameURL);

	/**
	 * Returns the name of this remote app entry.
	 *
	 * @return the name of this remote app entry
	 */
	public String getName();

	/**
	 * Returns the localized name of this remote app entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this remote app entry
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this remote app entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this remote app entry. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this remote app entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this remote app entry
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this remote app entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this remote app entry
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this remote app entry.
	 *
	 * @return the locales and localized names of this remote app entry
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this remote app entry.
	 *
	 * @param name the name of this remote app entry
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this remote app entry in the language.
	 *
	 * @param name the localized name of this remote app entry
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this remote app entry in the language, and sets the default locale.
	 *
	 * @param name the localized name of this remote app entry
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this remote app entry from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this remote app entry
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this remote app entry from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this remote app entry
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the type of this remote app entry.
	 *
	 * @return the type of this remote app entry
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this remote app entry.
	 *
	 * @param type the type of this remote app entry
	 */
	public void setType(String type);

	/**
	 * Returns the container model ID of this remote app entry.
	 *
	 * @return the container model ID of this remote app entry
	 */
	@Override
	public long getContainerModelId();

	/**
	 * Sets the container model ID of this remote app entry.
	 *
	 * @param containerModelId the container model ID of this remote app entry
	 */
	@Override
	public void setContainerModelId(long containerModelId);

	/**
	 * Returns the container name of this remote app entry.
	 *
	 * @return the container name of this remote app entry
	 */
	@Override
	public String getContainerModelName();

	/**
	 * Returns the parent container model ID of this remote app entry.
	 *
	 * @return the parent container model ID of this remote app entry
	 */
	@Override
	public long getParentContainerModelId();

	/**
	 * Sets the parent container model ID of this remote app entry.
	 *
	 * @param parentContainerModelId the parent container model ID of this remote app entry
	 */
	@Override
	public void setParentContainerModelId(long parentContainerModelId);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public RemoteAppEntry cloneWithOriginalValues();

}