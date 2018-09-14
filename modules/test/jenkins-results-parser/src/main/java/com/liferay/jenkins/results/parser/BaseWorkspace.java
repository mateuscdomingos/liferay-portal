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

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseWorkspace implements Workspace {

	@Override
	public void addJenkinsWorkbench(String jenkinsGitHubURL) {
		if (!JenkinsResultsParserUtil.isCINode()) {
			return;
		}

		if (jenkinsGitHubURL == null) {
			return;
		}

		Workbench workbench = WorkbenchFactory.newWorkbench(
			jenkinsGitHubURL, "master");

		if (!(workbench instanceof JenkinsWorkbench)) {
			throw new RuntimeException("Invalid workbench " + workbench);
		}

		_jenkinsWorkbench = (JenkinsWorkbench)workbench;
	}

	@Override
	public JenkinsWorkbench getJenkinsWorkbench() {
		return _jenkinsWorkbench;
	}

	@Override
	public void setUp() {
		setUp(null);
	}

	@Override
	public void setUp(Job job) {
		checkoutLocalGitBranches();

		if (job != null) {
			setGitRepositoryJobProperties(job);
		}

		writeGitRepositoryPropertiesFiles();
	}

	@Override
	public void tearDown() {
		cleanupLocalGitBranches();
	}

	protected void setUpJenkinsWorkbench() {
		if (_jenkinsWorkbench != null) {
			_jenkinsWorkbench.setUp();
		}
	}

	protected void checkoutLocalGitBranch(LocalGitBranch localGitBranch) {
		System.out.println();
		System.out.println("##");
		System.out.println("## " + localGitBranch.toString());
		System.out.println("##");
		System.out.println();

		GitWorkingDirectory gitWorkingDirectory =
			localGitBranch.getGitWorkingDirectory();

		gitWorkingDirectory.createLocalGitBranch(localGitBranch, true);

		gitWorkingDirectory.checkoutLocalGitBranch(localGitBranch);

		gitWorkingDirectory.reset("--hard " + localGitBranch.getSHA());

		gitWorkingDirectory.clean();

		gitWorkingDirectory.displayLog();
	}

	protected abstract void checkoutLocalGitBranches();

	protected void cleanupLocalGitBranch(LocalGitBranch localGitBranch) {
		if (localGitBranch == null) {
			return;
		}

		System.out.println();
		System.out.println("##");
		System.out.println("## " + localGitBranch.toString());
		System.out.println("##");
		System.out.println();

		GitWorkingDirectory gitWorkingDirectory =
			localGitBranch.getGitWorkingDirectory();

		LocalGitBranch upstreamLocalGitBranch =
			gitWorkingDirectory.getLocalGitBranch(
				gitWorkingDirectory.getUpstreamBranchName());

		gitWorkingDirectory.checkoutLocalGitBranch(upstreamLocalGitBranch);

		gitWorkingDirectory.reset("--hard " + localGitBranch.getSHA());

		gitWorkingDirectory.clean();

		gitWorkingDirectory.displayLog();
	}

	protected abstract void cleanupLocalGitBranches();

	protected abstract void setGitRepositoryJobProperties(Job job);

	protected void tearDownJenkinsWorkbench() {
		if (_jenkinsWorkbench != null) {
			_jenkinsWorkbench.tearDown();
		}
	}

	protected abstract void writeGitRepositoryPropertiesFiles();

	private JenkinsWorkbench _jenkinsWorkbench;

}