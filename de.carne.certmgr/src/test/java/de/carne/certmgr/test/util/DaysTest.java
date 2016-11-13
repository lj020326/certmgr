/*
 * Copyright (c) 2015-2016 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.certmgr.test.util;

import java.time.Period;

import org.junit.Assert;
import org.junit.Test;

import de.carne.certmgr.util.Days;
import de.carne.certmgr.util.DaysI18N;

/**
 * Test {@link Days} class functionality.
 */
public class DaysTest {

	/**
	 * Test {@link Days} functions.
	 */
	@Test
	public void testDays() {
		DaysI18N.formatSTR_DAYS(0);

		Days t1Day = new Days(1);
		Days t30Days = new Days(30);
		Days t365Days = new Days(365);

		Assert.assertEquals(t1Day.count(), 1);
		Assert.assertEquals(t30Days.count(), 30);
		Assert.assertEquals(t365Days.count(), 365);
		Assert.assertEquals(t1Day.period().getDays(), 1);
		Assert.assertEquals(t1Day.period().getMonths(), 0);
		Assert.assertEquals(t1Day.period().getYears(), 0);
		Assert.assertEquals(t30Days.period().getDays(), 0);
		Assert.assertEquals(t30Days.period().getMonths(), 1);
		Assert.assertEquals(t30Days.period().getYears(), 0);
		Assert.assertEquals(t365Days.period().getDays(), 0);
		Assert.assertEquals(t365Days.period().getMonths(), 0);
		Assert.assertEquals(t365Days.period().getYears(), 1);
		Assert.assertEquals(t1Day.toLocalizedString(), "1 day(s)");
		Assert.assertEquals(t30Days.toLocalizedString(), "1 month(s)");
		Assert.assertEquals(t365Days.toLocalizedString(), "1 year(s)");

		Days t1DPeriod = new Days(Period.parse("P1D"));
		Days t1MPeriod = new Days(Period.parse("P1M"));
		Days t1YPeriod = new Days(Period.parse("P1Y"));

		Assert.assertEquals(t1DPeriod, t1Day);
		Assert.assertEquals(t1MPeriod, t30Days);
		Assert.assertEquals(t1YPeriod, t365Days);

		Assert.assertTrue(t30Days.compareTo(t1Day) > 0);
		Assert.assertTrue(t30Days.compareTo(t30Days) == 0);
		Assert.assertTrue(t30Days.compareTo(t365Days) < 0);
	}

}