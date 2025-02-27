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

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.delivery.client.dto.v1_0.SitePage;
import com.liferay.headless.delivery.client.pagination.Page;
import com.liferay.layout.page.template.importer.LayoutPageTemplatesImporter;
import com.liferay.layout.page.template.model.LayoutPageTemplateStructure;
import com.liferay.layout.page.template.model.LayoutPageTemplateStructureRel;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureLocalService;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureRelLocalService;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.test.rule.Inject;
import com.liferay.segments.constants.SegmentsEntryConstants;
import com.liferay.segments.model.SegmentsEntry;
import com.liferay.segments.model.SegmentsExperience;
import com.liferay.segments.service.SegmentsEntryLocalService;
import com.liferay.segments.service.SegmentsExperienceLocalService;

import java.io.InputStream;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class SitePageResourceTest extends BaseSitePageResourceTestCase {

	@Override
	@Test
	public void testGetSiteSitePage() throws Exception {
		Layout layout = _addLayout(testGroup.getGroupId());

		String friendlyURL = layout.getFriendlyURL();

		SitePage sitePage = sitePageResource.getSiteSitePage(
			testGroup.getGroupId(), friendlyURL.substring(1));

		Assert.assertNotNull(sitePage);
		Assert.assertEquals(
			layout.getName(LocaleUtil.getDefault()), sitePage.getTitle());
	}

	@Override
	@Test
	public void testGetSiteSitePageExperienceExperienceKey() throws Exception {
		Layout layout = _addLayout(
			testGroup.getGroupId(), true, RandomTestUtil.randomString());

		String friendlyURL = layout.getFriendlyURL();

		SitePage sitePage =
			sitePageResource.getSiteSitePageExperienceExperienceKey(
				testGroup.getGroupId(), friendlyURL.substring(1),
				String.valueOf(SegmentsEntryConstants.ID_DEFAULT));

		Assert.assertNotNull(sitePage);
		Assert.assertNotNull(sitePage.getExperience());
	}

	@Override
	@Test
	public void testGetSiteSitePageExperienceExperienceKeyRenderedPage()
		throws Exception {

		Layout layout = _addLayout(
			testGroup.getGroupId(), true, RandomTestUtil.randomString());

		String friendlyURL = layout.getFriendlyURL();
		SegmentsExperience segmentsExperience = _addSegmentsExperience(
			layout,
			ServiceContextTestUtil.getServiceContext(testGroup.getGroupId()));

		String siteSitePageExperienceExperienceKeyRenderedPage =
			sitePageResource.getSiteSitePageExperienceExperienceKeyRenderedPage(
				testGroup.getGroupId(), friendlyURL.substring(1),
				segmentsExperience.getSegmentsExperienceKey());

		Assert.assertNotNull(siteSitePageExperienceExperienceKeyRenderedPage);
	}

	@Ignore
	@Override
	@Test
	public void testGetSiteSitePageFriendlyUrlPathExperiencesPage()
		throws Exception {

		Layout layout = _addLayout(testGroup.getGroupId());

		String friendlyURL = layout.getFriendlyURL();

		Page<SitePage> page =
			sitePageResource.getSiteSitePageFriendlyUrlPathExperiencesPage(
				testGroup.getGroupId(), friendlyURL.substring(1));

		long originalPageCount = page.getTotalCount();

		_addSegmentsExperience(
			layout,
			ServiceContextTestUtil.getServiceContext(testGroup.getGroupId()));

		page = sitePageResource.getSiteSitePageFriendlyUrlPathExperiencesPage(
			testGroup.getGroupId(), friendlyURL.substring(1));

		Assert.assertEquals(originalPageCount + 1, page.getTotalCount());
	}

	@Override
	@Test
	public void testGetSiteSitePageRenderedPage() throws Exception {
		Layout layout = _addLayout(testGroup.getGroupId());

		String friendlyURL = layout.getFriendlyURL();

		String siteSitePageRenderedPage =
			sitePageResource.getSiteSitePageRenderedPage(
				testGroup.getGroupId(), friendlyURL.substring(1));

		Assert.assertNotNull(siteSitePageRenderedPage);
	}

	@Override
	@Test
	public void testGetSiteSitePagesPage() throws Exception {
		Page<SitePage> sitePagePage = sitePageResource.getSiteSitePagesPage(
			testGroup.getGroupId(), null, null, null, null, null);

		Assert.assertEquals(
			_layoutLocalService.getLayoutsCount(testGroup.getGroupId(), false),
			sitePagePage.getTotalCount());
	}

	@Override
	@Test
	public void testGraphQLGetSiteSitePagesPage() throws Exception {
		Long siteId = testGetSiteSitePagesPage_getSiteId();

		_addLayout(siteId);

		BaseSitePageResourceTestCase.GraphQLField graphQLField =
			new BaseSitePageResourceTestCase.GraphQLField(
				"sitePages",
				HashMapBuilder.<String, Object>put(
					"siteKey", "\"" + siteId + "\""
				).build(),
				new BaseSitePageResourceTestCase.GraphQLField(
					"items", getGraphQLFields()),
				new BaseSitePageResourceTestCase.GraphQLField("page"),
				new BaseSitePageResourceTestCase.GraphQLField("totalCount"));

		JSONObject sitePagesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/sitePages");

		Assert.assertEquals(
			_layoutLocalService.getLayoutsCount(testGroup.getGroupId(), false),
			sitePagesJSONObject.get("totalCount"));
	}

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"title"};
	}

	@Override
	protected SitePage testGetSiteSitePagesPage_addSitePage(
			Long siteId, SitePage sitePage)
		throws Exception {

		Layout layout = _addLayout(siteId, false, sitePage.getTitle());

		sitePage.setDateCreated(layout.getCreateDate());
		sitePage.setDateModified(layout.getModifiedDate());
		sitePage.setDatePublished(layout.getPublishDate());

		String friendlyURL = layout.getFriendlyURL();

		sitePage.setFriendlyUrlPath(friendlyURL.substring(1));

		sitePage.setSiteId(siteId);
		sitePage.setUuid(layout.getUuid());

		return sitePage;
	}

	private Layout _addLayout(long groupId) throws Exception {
		return _addLayout(groupId, false, RandomTestUtil.randomString());
	}

	private Layout _addLayout(
			long groupId, boolean importPageDefinition, String title)
		throws Exception {

		UnicodeProperties unicodeProperties = new UnicodeProperties(true);

		unicodeProperties.put("published", Boolean.TRUE.toString());

		Layout layout = _layoutLocalService.addLayout(
			TestPropsValues.getUserId(), groupId, false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
			HashMapBuilder.put(
				LocaleUtil.getSiteDefault(), title
			).build(),
			RandomTestUtil.randomLocaleStringMap(),
			RandomTestUtil.randomLocaleStringMap(),
			RandomTestUtil.randomLocaleStringMap(),
			RandomTestUtil.randomLocaleStringMap(),
			LayoutConstants.TYPE_CONTENT, unicodeProperties.toString(), false,
			new HashMap<>(), ServiceContextTestUtil.getServiceContext(groupId));

		if (importPageDefinition) {
			String name = PrincipalThreadLocal.getName();

			try {
				PrincipalThreadLocal.setName(TestPropsValues.getUserId());

				ServiceContext serviceContext =
					ServiceContextTestUtil.getServiceContext(
						testGroup.getGroupId());

				ServiceContextThreadLocal.pushServiceContext(serviceContext);

				LayoutPageTemplateStructure layoutPageTemplateStructure =
					_layoutPageTemplateStructureLocalService.
						fetchLayoutPageTemplateStructure(
							testGroup.getGroupId(), layout.getPlid(), true);

				LayoutStructure layoutStructure = LayoutStructure.of(
					layoutPageTemplateStructure.getData(0));

				layoutStructure.addRootLayoutStructureItem();

				_layoutPageTemplatesImporter.importPageElement(
					layout, layoutStructure, layoutStructure.getMainItemId(),
					_read("test-page-element.json"), 0);
			}
			finally {
				PrincipalThreadLocal.setName(name);

				ServiceContextThreadLocal.popServiceContext();
			}
		}

		return layout;
	}

	private SegmentsExperience _addSegmentsExperience(
			Layout layout, ServiceContext serviceContext)
		throws Exception {

		SegmentsEntry segmentsEntry =
			_segmentsEntryLocalService.addSegmentsEntry(
				null,
				HashMapBuilder.put(
					LocaleUtil.getDefault(), RandomTestUtil.randomString()
				).build(),
				null, true, null, User.class.getName(), serviceContext);

		SegmentsExperience segmentsExperience =
			_segmentsExperienceLocalService.addSegmentsExperience(
				segmentsEntry.getSegmentsEntryId(),
				_portal.getClassNameId(Layout.class.getName()),
				layout.getPlid(),
				HashMapBuilder.put(
					LocaleUtil.getDefault(), RandomTestUtil.randomString()
				).build(),
				true, serviceContext);

		LayoutPageTemplateStructure layoutPageTemplateStructure =
			_layoutPageTemplateStructureLocalService.
				fetchLayoutPageTemplateStructure(
					testGroup.getGroupId(), layout.getPlid());

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			_layoutPageTemplateStructureRelLocalService.
				fetchLayoutPageTemplateStructureRel(
					layoutPageTemplateStructure.
						getLayoutPageTemplateStructureId(),
					SegmentsEntryConstants.ID_DEFAULT);

		layoutPageTemplateStructureRel.setSegmentsExperienceId(
			segmentsExperience.getSegmentsExperienceId());

		_layoutPageTemplateStructureRelLocalService.
			updateLayoutPageTemplateStructureRel(
				layoutPageTemplateStructureRel);

		return segmentsExperience;
	}

	private String _read(String fileName) throws Exception {
		Class<?> clazz = getClass();

		InputStream inputStream = clazz.getResourceAsStream(
			"dependencies/" + fileName);

		return StringUtil.read(inputStream);
	}

	@Inject
	private LayoutLocalService _layoutLocalService;

	@Inject
	private LayoutPageTemplatesImporter _layoutPageTemplatesImporter;

	@Inject
	private LayoutPageTemplateStructureLocalService
		_layoutPageTemplateStructureLocalService;

	@Inject
	private LayoutPageTemplateStructureRelLocalService
		_layoutPageTemplateStructureRelLocalService;

	@Inject
	private Portal _portal;

	@Inject
	private SegmentsEntryLocalService _segmentsEntryLocalService;

	@Inject
	private SegmentsExperienceLocalService _segmentsExperienceLocalService;

}