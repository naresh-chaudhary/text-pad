package com.cypher.neo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Naresh Kumar
 *
 */
public class Main {

	public static void main(String args[]) {
		TextPad textPad = new TextPadInMemoryImpl();

		displayChoices();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int choice = 0;
			try {
				choice = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid integer choice");
				continue;
			}
			if (choice == 10) {
				System.out.println("Program Exited.");
				break;
			} else if (choice == 1) {
				System.out.println("Text Pad Contents:");
				textPad.display();
			} else if (choice == 2) {
				System.out.println(" Enter space separated n (starting line no)and m (ending line no)");
				int n = sc.nextInt();
				int m = sc.nextInt();
				System.out.println("Text Pad Contents from line " + n + "to line" + m + ":");
				textPad.display(n, m);
			} else if (choice == 3) {
				System.out.println("Enter space separated line no. and text");
				int lineNo = sc.nextInt();
				String text = sc.nextLine();
				text = text.trim();
				List<Character> row = new ArrayList<>();
				for (int i = 0; i < text.length(); i++) {
					row.add(text.charAt(i));
				}
				textPad.insert(lineNo, row);

			} else if (choice == 4) {
				System.out.println("Enter line no. to delete");
				int lineNo = sc.nextInt();
				textPad.delete(lineNo);

			} else if (choice == 5) {
				System.out.println("Enter space separated n(starting line) and m(ending line)\n"
						+ " to delete from line n to line m");
				int n = sc.nextInt();
				int m = sc.nextInt();
				textPad.delete(n, m);
			} else if (choice == 6) {
				System.out.println("Enter space separated n(starting line) and m(ending line)\n to copy to clipboard");
				int n = sc.nextInt();
				int m = sc.nextInt();
				textPad.copy(n, m);
			} else if (choice == 7) {
				System.out.println("Enter line no. where you need to paste the clipboard content");
				int lineNo = sc.nextInt();
				textPad.paste(lineNo);
			} else if (choice == 8) {
				System.out.println("This feature is under development. Lazy programmer :P ");
			} else if (choice == 9) {
				System.out.println("This feature is under development. Lazy programmer :P");
			}

			displayChoices();
		}
	}

	private static void displayChoices() {
		System.out.println("********************************************************************************");
		System.out.println("TEXT PAD");
		System.out.println("** NOTE: 0 based indexing is used. **");
		System.out.println("Choose from below options:");
		System.out.println("* 1. display() – to display the entire text pad contents \n"
				+ " * 2. display(n, m) – to display from line n to m \n"
				+ " * 3. insert(n, text) – to insert text at line n \n" + " * 4.  delete(n) – delete line n\n"
				+ " * 5. delete(n, m) – delete from line n to m\n"
				+ " * 6. copy(n, m) – copy contents from line n to m to clipboard \n"
				+ " * 7. paste(n) – paste contents from clipboard to line n \n" + " * 8. undo() – undo last command \n"
				+ " * 9. redo() – redo last command " + "* 10. exit()");
		System.out.println("********************************************************************************");
	}
}
