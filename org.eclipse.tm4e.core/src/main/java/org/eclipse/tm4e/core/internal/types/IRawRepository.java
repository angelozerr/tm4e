/**
 * Copyright (c) 2015-2017 Angelo ZERR.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Initial code from https://github.com/microsoft/vscode-textmate/
 * Initial copyright Copyright (C) Microsoft Corporation. All rights reserved.
 * Initial license: MIT
 *
 * Contributors:
 * - Microsoft Corporation: Initial code, written in TypeScript, licensed under MIT license
 * - Angelo Zerr <angelo.zerr@gmail.com> - translation and adaptation to Java
 */
package org.eclipse.tm4e.core.internal.types;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.tm4e.core.internal.grammar.RawRepository;
import org.eclipse.tm4e.core.internal.parser.PropertySettable;

/**
 * @see <a href=
 *      "https://github.com/microsoft/vscode-textmate/blob/88baacf1a6637c5ec08dce18cea518d935fcf0a0/src/rawGrammar.ts">
 *      github.com/microsoft/vscode-textmate/blob/main/src/rawGrammar.ts</a>
 */
public interface IRawRepository {

	static IRawRepository merge(@Nullable final IRawRepository... sources) {
		final var merged = new RawRepository();
		for (final var source : sources) {
			if (source == null)
				continue;
			source.putEntries(merged);
		}
		return merged;
	}

	void putEntries(PropertySettable<IRawRule> target);

	@Nullable
	IRawRule getRule(String name);

	IRawRule getBase();

	IRawRule getSelf();

	void setSelf(IRawRule raw);

	void setBase(IRawRule base);
}
