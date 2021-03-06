/*
 * Copyright (c) 2015-2018 Holger de Carne and contributors, All Rights Reserved.
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
package de.carne.certmgr.jfx.preferences;

import java.io.IOException;

import de.carne.certmgr.jfx.store.UserPreferences;
import de.carne.jfx.stage.StageController;
import javafx.scene.control.Dialog;

/**
 * Preferences dialog.
 */
public class PreferencesDialog extends Dialog<UserPreferences> {

	private PreferencesDialog(PreferencesController controller) {
		setResultConverter(controller);
	}

	/**
	 * Load the preferences dialog.
	 *
	 * @param owner The stage controller owning this dialog.
	 * @return The constructed controller which is bound to the newly created dialog.
	 * @throws IOException if an I/O error occurs during dialog loading.
	 */
	public static PreferencesController load(StageController owner) throws IOException {
		return owner.loadDialog((c) -> new PreferencesDialog(c), PreferencesController.class);
	}

}
