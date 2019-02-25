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

package com.liferay.headless.foundation.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.headless.foundation.dto.v1_0.Creator;
import com.liferay.headless.foundation.dto.v1_0.Role;
import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.net.URL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public abstract class BaseRoleResourceTestCase {

	@Before
	public void setUp() throws Exception {
		testGroup = GroupTestUtil.addGroup();

		_resourceURL = new URL(
			"http://localhost:8080/o/headless-foundation/v1.0");
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testGetMyUserAccountRolesPage() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testGetRolesPage() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testGetRole() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testGetUserAccountRolesPage() throws Exception {
			Assert.assertTrue(true);
	}

	protected void assertResponseCode(int expectedResponseCode, Http.Response actualResponse) {
		Assert.assertEquals(expectedResponseCode, actualResponse.getResponseCode());
	}

	protected Page<Role> invokeGetMyUserAccountRolesPage(
				Long myUserAccountId,Pagination pagination)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/my-user-accounts/{my-user-account-id}/roles", myUserAccountId));

				return _outputObjectMapper.readValue(HttpUtil.URLtoString(options), new TypeReference<Page<RoleImpl>>() {});
	}

	protected Http.Response invokeGetMyUserAccountRolesPageResponse(
				Long myUserAccountId,Pagination pagination)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/my-user-accounts/{my-user-account-id}/roles", myUserAccountId));

			HttpUtil.URLtoString(options);

			return options.getResponse();
	}
	protected Page<Role> invokeGetRolesPage(
				Pagination pagination)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/roles", pagination));

				return _outputObjectMapper.readValue(HttpUtil.URLtoString(options), new TypeReference<Page<RoleImpl>>() {});
	}

	protected Http.Response invokeGetRolesPageResponse(
				Pagination pagination)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/roles", pagination));

			HttpUtil.URLtoString(options);

			return options.getResponse();
	}
	protected Role invokeGetRole(
				Long roleId)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/roles/{role-id}", roleId));

				return _outputObjectMapper.readValue(HttpUtil.URLtoString(options), RoleImpl.class);
	}

	protected Http.Response invokeGetRoleResponse(
				Long roleId)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/roles/{role-id}", roleId));

			HttpUtil.URLtoString(options);

			return options.getResponse();
	}
	protected Page<Role> invokeGetUserAccountRolesPage(
				Long userAccountId,Pagination pagination)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/user-accounts/{user-account-id}/roles", userAccountId));

				return _outputObjectMapper.readValue(HttpUtil.URLtoString(options), new TypeReference<Page<RoleImpl>>() {});
	}

	protected Http.Response invokeGetUserAccountRolesPageResponse(
				Long userAccountId,Pagination pagination)
			throws Exception {

			Http.Options options = _createHttpOptions();

			options.setLocation(_resourceURL + _toPath("/user-accounts/{user-account-id}/roles", userAccountId));

			HttpUtil.URLtoString(options);

			return options.getResponse();
	}

	protected void assertEquals(Role role1, Role role2) {
		Assert.assertTrue(role1 + " does not equal " + role2, equals(role1, role2));
	}

	protected void assertEquals(List<Role> roles1, List<Role> roles2) {
		Assert.assertEquals(roles1.size(), roles2.size());

		for (int i = 0; i < roles1.size(); i++) {
			Role role1 = roles1.get(i);
			Role role2 = roles2.get(i);

			assertEquals(role1, role2);
	}
	}

	protected void assertEqualsIgnoringOrder(List<Role> roles1, List<Role> roles2) {
		Assert.assertEquals(roles1.size(), roles2.size());

		for (Role role1 : roles1) {
			boolean contains = false;

			for (Role role2 : roles2) {
				if (equals(role1, role2)) {
					contains = true;

					break;
	}
	}

			Assert.assertTrue(roles2 + " does not contain " + role1, contains);
	}
	}

	protected boolean equals(Role role1, Role role2) {
		if (role1 == role2) {
			return true;
	}

		return false;
	}

	protected Role randomRole() {
		return new RoleImpl() {
			{

						dateCreated = RandomTestUtil.nextDate();
						dateModified = RandomTestUtil.nextDate();
						description = RandomTestUtil.randomString();
						id = RandomTestUtil.randomLong();
						name = RandomTestUtil.randomString();
						roleType = RandomTestUtil.randomString();
	}
		};
	}

	protected Group testGroup;

	protected static class RoleImpl implements Role {

	public String[] getAvailableLanguages() {
				return availableLanguages;
	}

	public void setAvailableLanguages(String[] availableLanguages) {
				this.availableLanguages = availableLanguages;
	}

	@JsonIgnore
	public void setAvailableLanguages(
				UnsafeSupplier<String[], Throwable> availableLanguagesUnsafeSupplier) {

				try {
					availableLanguages = availableLanguagesUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String[] availableLanguages;
	public Creator getCreator() {
				return creator;
	}

	public void setCreator(Creator creator) {
				this.creator = creator;
	}

	@JsonIgnore
	public void setCreator(
				UnsafeSupplier<Creator, Throwable> creatorUnsafeSupplier) {

				try {
					creator = creatorUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Creator creator;
	public Date getDateCreated() {
				return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
				this.dateCreated = dateCreated;
	}

	@JsonIgnore
	public void setDateCreated(
				UnsafeSupplier<Date, Throwable> dateCreatedUnsafeSupplier) {

				try {
					dateCreated = dateCreatedUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Date dateCreated;
	public Date getDateModified() {
				return dateModified;
	}

	public void setDateModified(Date dateModified) {
				this.dateModified = dateModified;
	}

	@JsonIgnore
	public void setDateModified(
				UnsafeSupplier<Date, Throwable> dateModifiedUnsafeSupplier) {

				try {
					dateModified = dateModifiedUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Date dateModified;
	public String getDescription() {
				return description;
	}

	public void setDescription(String description) {
				this.description = description;
	}

	@JsonIgnore
	public void setDescription(
				UnsafeSupplier<String, Throwable> descriptionUnsafeSupplier) {

				try {
					description = descriptionUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String description;
	public Long getId() {
				return id;
	}

	public void setId(Long id) {
				this.id = id;
	}

	@JsonIgnore
	public void setId(
				UnsafeSupplier<Long, Throwable> idUnsafeSupplier) {

				try {
					id = idUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Long id;
	public String getName() {
				return name;
	}

	public void setName(String name) {
				this.name = name;
	}

	@JsonIgnore
	public void setName(
				UnsafeSupplier<String, Throwable> nameUnsafeSupplier) {

				try {
					name = nameUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String name;
	public String getRoleType() {
				return roleType;
	}

	public void setRoleType(String roleType) {
				this.roleType = roleType;
	}

	@JsonIgnore
	public void setRoleType(
				UnsafeSupplier<String, Throwable> roleTypeUnsafeSupplier) {

				try {
					roleType = roleTypeUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String roleType;

	public String toString() {
			StringBundler sb = new StringBundler();

			sb.append("{");

					sb.append("availableLanguages=");

				sb.append(availableLanguages);
					sb.append(", creator=");

				sb.append(creator);
					sb.append(", dateCreated=");

				sb.append(dateCreated);
					sb.append(", dateModified=");

				sb.append(dateModified);
					sb.append(", description=");

				sb.append(description);
					sb.append(", id=");

				sb.append(id);
					sb.append(", name=");

				sb.append(name);
					sb.append(", roleType=");

				sb.append(roleType);

			sb.append("}");

			return sb.toString();
	}

	}

	protected static class Page<T> {

	public Collection<T> getItems() {
			return new ArrayList<>(items);
	}

	public int getItemsPerPage() {
			return itemsPerPage;
	}

	public int getLastPageNumber() {
			return lastPageNumber;
	}

	public int getPageNumber() {
			return pageNumber;
	}

	public int getTotalCount() {
			return totalCount;
	}

	@JsonProperty
	protected Collection<T> items;

	@JsonProperty("pageSize")
	protected int itemsPerPage;

	@JsonProperty
	protected int lastPageNumber;

	@JsonProperty("page")
	protected int pageNumber;

	@JsonProperty
	protected int totalCount;

	}

	private Http.Options _createHttpOptions() {
		Http.Options options = new Http.Options();

		options.addHeader("Accept", "application/json");

		String userNameAndPassword = "test@liferay.com:test";

		String encodedUserNameAndPassword = Base64.encode(userNameAndPassword.getBytes());

		options.addHeader("Authorization", "Basic " + encodedUserNameAndPassword);

		options.addHeader("Content-Type", "application/json");

		return options;
	}

	private String _toPath(String template, Object value) {
		return template.replaceFirst("\\{.*\\}", String.valueOf(value));
	}

	private final static ObjectMapper _inputObjectMapper = new ObjectMapper() {
		{
			setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	};
	private final static ObjectMapper _outputObjectMapper = new ObjectMapper();

	private URL _resourceURL;

}