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

package com.liferay.commerce.tax.engine.fixed.internal.upgrade.v2_0_0;

import com.liferay.commerce.tax.engine.fixed.internal.upgrade.v2_0_0.util.CommerceTaxFixedRateAddressRelTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Pei-Jung Lan
 */
public class CommerceTaxFixedRateAddressRelUpgradeProcess
	extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			CommerceTaxFixedRateAddressRelTable.class,
			new AlterColumnName("commerceCountryId", "countryId LONG"),
			new AlterColumnName("commerceRegionId", "regionId LONG"));
	}

}