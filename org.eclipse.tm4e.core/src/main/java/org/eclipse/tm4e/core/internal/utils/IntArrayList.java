/**
 * Copyright (c) 2026 Angelo ZERR and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.tm4e.core.internal.utils;

import java.util.Arrays;

/**
 * A primitive int list that avoids boxing overhead of {@code List<Integer>}.
 */
public final class IntArrayList {

	private int[] buf;
	private int size;

	public IntArrayList() {
		this(16);
	}

	public IntArrayList(final int initialCapacity) {
		buf = new int[initialCapacity];
	}

	public void add(final int value) {
		if (size == buf.length) {
			buf = Arrays.copyOf(buf, size << 1);
		}
		buf[size++] = value;
	}

	public int get(final int index) {
		return buf[index < 0 ? size + index : index];
	}

	public void set(final int index, final int value) {
		buf[index < 0 ? size + index : index] = value;
	}

	public int last() {
		return buf[size - 1];
	}

	public void removeLast(final int count) {
		size -= count;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int[] toArray() {
		return Arrays.copyOf(buf, size);
	}
}
