/**
 *  Copyright (c) 2015-2017 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * This code is an translation of code copyrighted by https://github.com/chjj/marked, and initially licensed under MIT.
 *
 * Contributors:
 *  - https://github.com/chjj/marked: Initial code, written in JavaScript, licensed under MIT license
 *  - Angelo Zerr <angelo.zerr@gmail.com> - translation and adaptation to Java
 */
package org.eclipse.tm4e.markdown.marked;

public interface IRenderer {

	void code(String code, String lang, boolean escaped);

	void blockquote(String quote);

	void html(String html);

	void heading(String text, int level, String raw);

	void hr();

	void list(String body, boolean ordered);

	void listitem(String text);

	void startParagraph();
	
	void endParagraph();

	void table(String header, String body);

	void tablerow(String content);

	void tablecell(String content, String flags);

	void startEm();
	
	void endEm();
	
	void startStrong();
	
	void endStrong();
	
	void codespan(String text);

	void br();

	void del(String text);

	void link(String href, String title, String text);

	void image(String href, String title, String text);

	void text(String text);

	

}
