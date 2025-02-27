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

import ClayLoadingIndicator from '@clayui/loading-indicator';
import React, {useEffect, useState} from 'react';

export function getLiferayJsModule(moduleUrl) {
	return new Promise((resolve, reject) => {
		Liferay.Loader.require(
			moduleUrl,
			(jsModule) => resolve(jsModule.default || jsModule),
			(error) => reject(error)
		);
	});
}

export function getFakeJsModule() {
	return new Promise((resolve) => {
		setTimeout(
			() =>
				resolve(() => (
					<div className="custom-component">
						fakely fetched component
					</div>
				)),
			3000
		);
	});
}

export const getJsModule = Liferay.Loader?.require
	? getLiferayJsModule
	: getFakeJsModule;

export const fetchedJsModules = [];

export function getComponentByModuleUrl(url) {
	return new Promise((resolve, reject) => {
		const foundModule = fetchedJsModules.find((cr) => cr.url === url);
		if (foundModule) {
			resolve(foundModule.component);
		}

		return getJsModule(url)
			.then((fetchedComponent) => {
				fetchedJsModules.push({
					component: fetchedComponent,
					url,
				});

				return resolve(fetchedComponent);
			})
			.catch(reject);
	});
}

export function useLiferayModule(
	moduleUrl,
	LoadingComponent = ClayLoadingIndicator
) {
	const [Component, updateComponent] = useState(
		moduleUrl ? LoadingComponent : null
	);

	useEffect(() => {
		if (moduleUrl) {
			getComponentByModuleUrl(moduleUrl).then((module) => {
				updateComponent(() => module);
			});
		}
	}, [moduleUrl]);

	return Component;
}
