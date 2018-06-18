/**
 * 
 */
package com.cypher.neo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Naresh Kumar
 *
 */
public class TextPadInMemoryImpl implements TextPad {

	private List<List<Character>> textPad = new LinkedList<>();
	private List<List<Character>> copyBuffer = new LinkedList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#display()
	 */
	@Override
	public void display() {

		textPad.stream().forEach(line -> {

			for (Character c : line) {
				System.out.print(c);
			}
			System.out.println();
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#display(int, int)
	 */
	@Override
	public void display(int fromLine, int toLine) {

		for (int i = fromLine; i <= toLine; i++) {
			for (Character c : textPad.get(i)) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#insert(int, java.lang.String)
	 */
	@Override
	public void insert(int lineNo, List<Character> text) {
		textPad.add(lineNo, text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#delete(int)
	 */
	@Override
	public void delete(int lineNo) {
		try {
			textPad.remove(lineNo);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Can't perform delete operation at this line no.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#delete(int, int)
	 */
	@Override
	public void delete(int fromLine, int toLine) {

		for (int i = fromLine; i <= toLine; i++)
			textPad.remove(fromLine);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#copy(int, int)
	 */
	@Override
	public void copy(int fromLine, int toLine) {
		if (fromLine < 0 || toLine > textPad.size() - 1) {
			System.out.println("Invalid Line Numbers");

		} else {
			copyBuffer.clear();
			for (int i = fromLine; i <= toLine; i++) {
				copyBuffer.add(textPad.get(i));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#paste(int)
	 */
	@Override
	public void paste(int toLine) {
		// assuming that one can paste till the lastLine + 1(new line at the end).
		if (toLine > textPad.size()) {
			System.out.println("Invalid line no to do paste operation");
		} else {
			textPad.addAll(toLine, copyBuffer);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.TextPad#redo()
	 */
	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
