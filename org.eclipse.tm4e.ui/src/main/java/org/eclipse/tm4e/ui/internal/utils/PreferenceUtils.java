/**
 * Copyright (c) 2015-2017 Angelo ZERR.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.tm4e.ui.internal.utils;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.tm4e.ui.TMUIPlugin;
import org.eclipse.tm4e.ui.internal.preferences.PreferenceConstants;

public final class PreferenceUtils {

	private static final String E4_CSS_PREFERENCE_NAME = "org.eclipse.e4.ui.css.swt.theme"; //$NON-NLS-1$
	private static final String EDITORS_PREFERENCE_NAME = "org.eclipse.ui.editors"; //$NON-NLS-1$

	public static boolean isDebugGenerateTest() {
		return Boolean.parseBoolean(Platform.getDebugOption(TMUIPlugin.PLUGIN_ID + "/debug/log/GenerateTest"));
	}

	public static boolean isDebugThrowError() {
		return Boolean.parseBoolean(Platform.getDebugOption(TMUIPlugin.PLUGIN_ID + "/debug/log/ThrowError"));
	}

	/**
	 * Get e4 preferences store
	 *
	 * @return preferences store
	 */
	@Nullable
	public static IEclipsePreferences getE4PreferenceStore() {
		return InstanceScope.INSTANCE.getNode(E4_CSS_PREFERENCE_NAME);
	}

	/**
	 * Get Id of the current eclipse theme
	 *
	 * @return themeIf of the current eclipse theme
	 */
	@Nullable
	public static String getE4PreferenceCSSThemeId() {
		final IEclipsePreferences preferences = getE4PreferenceStore();
		return preferences != null ? preferences.get(PreferenceConstants.E4_THEME_ID, null) : null;
	}

	/**
	 * Get editors preferences store
	 *
	 * @return preferences store
	 */
	@Nullable
	public static IEclipsePreferences getEditorsPreferenceStore() {
		return InstanceScope.INSTANCE.getNode(EDITORS_PREFERENCE_NAME);
	}

	/**
	 * Get TM4E preferences store
	 *
	 * @return preferences store
	 */
	@Nullable
	public static IPreferenceStore getTM4EPreferencesStore() {
		final var plugin = TMUIPlugin.getDefault();
		return plugin == null ? null : plugin.getPreferenceStore();
	}

	private PreferenceUtils() {
	}
}
