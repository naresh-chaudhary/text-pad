/**
 * 
 */
package com.cypher.neo;

import java.util.ArrayList;
import java.util.List;

/**
 * display() – to display the entire content <br>
 * display(n, m) – to display from line n to m <br>
 * insert(n, text) – to insert text at line n <br>
 * delete(n) – delete line n<br>
 * delete(n, m) – delete from line n to m<br>
 * copy(n, m) – copy contents from line n to m to clipboard <br>
 * paste(n) – paste contents from clipboard to line n <br>
 * undo() – undo last command <br>
 * redo() – redo last command <br>
 * 
 * @author Naresh Kumar
 *
 */

public interface TextPad {
	/**
	 * to display the entire content
	 */
	void display();

	/**
	 * to display from line fromLine to toLine
	 * 
	 * 
	 * @param fromLine
	 * @param toLine
	 */
	void display(int fromLine, int toLine);

	/**
	 * to insert text at line lineNo
	 * 
	 * @param lineNo
	 * @param text
	 */
	void insert(int lineNo, List<Character> text);

	/**
	 * delete line lineNo
	 * 
	 * @param lineNo
	 */
	void delete(int lineNo);

	/**
	 * delete line fromLine to toLine
	 * 
	 * @param fromLine
	 * @param toLine
	 */
	void delete(int fromLine, int toLine);

	/**
	 * copy contents from line fromLine to toLine to clipboard
	 * 
	 * @param fromLine
	 * @param toLine
	 */
	void copy(int fromLine, int toLine);

	/**
	 * paste contents from clipboard to toLine
	 * 
	 * @param toLine
	 */
	void paste(int toLine);

	/**
	 * undo last command
	 */
	void undo();

	/**
	 * redo last command
	 */
	void redo();
}
