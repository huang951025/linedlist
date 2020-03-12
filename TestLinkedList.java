/**
Author: Wei Wen Huang
Date: 2019/11/1
class: Data Structures
describe: rewrite 7# and add #11 add a method remove item by name

*/

import java.util.Scanner;

public class TestLinkedList {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>();

		Scanner input = new Scanner(System.in);

		int choice, givenPosition;

		String item;

		boolean success;

		System.out.println("0. exit");

		System.out.println("1. add item to the end of the list");

		System.out.println("2. add item to a specific location in the list");

		System.out.println("3. remove from a specific location");

		System.out.println("4. clear the list");

		System.out.println("5. replace an item in the list");

		System.out.println("6. get an entry from the list");

		System.out.println("7. check if a specific item exists");

		System.out.println("8. get list size");

		System.out.println("9. check if list is empty");

		System.out.println("10. check if list if full");
		
		System.out.println("11. remove a entry by name");

		System.out.print("Enter a choice:");

		choice = input.nextInt();

		while (choice != 0) {

			switch (choice) {

			case 1: // add at the end

				System.out.print("Enter an item: ");

				item = input.next();

//success = list.add(item);

				list.add(item);

//if (success)

				list.printList();

//else

// System.out.println(item + " could not be added");

				break;

			case 2: // add to a specific location

				System.out.print("Enter a location and an item: ");

				givenPosition = input.nextInt();

				item = input.next();

// success = list.add(givenPosition, item);

				if (list.add(givenPosition, item)) {

					list.printList();

				}

				else {

					System.out.println(item + " could not be added");

				}

				break;

			case 3: // remove from a specific location

				System.out.print("Enter a location to be removed: ");

				givenPosition = input.nextInt();

				item = list.remove(givenPosition);

				if (item != null) {

					System.out.println(item + " is removed");

					list.printList();

				}

				else {

					System.out.println("could not remove from the list");

				}

				break;

			case 4: // clear the list

				list.clear();

				break;

			case 5: // replace

				System.out.print("Enter a location and an item: ");

				givenPosition = input.nextInt();

				item = input.next();

				success = list.replace(givenPosition, item);

				if (success) {

					System.out.println(item + " replaced from the list");

					list.printList();

				}

				else {

					System.out.println(item + " could not be replaced");

				}

				break;

			case 6: // get an entry

				System.out.print("Enter a location: ");

				givenPosition = input.nextInt();

				item = list.getEntry(givenPosition);

				System.out.println("position " + givenPosition + " is " + item);

				list.printList();

				break;

			case 7: // contains

				System.out.print("Enter an item to be searched: ");

				item = input.next();

				success = list.seek(item);

				if (success) {

					System.out.println(item + " exists in the list");

				}

				else {

					System.out.println(item + " does not exist");

					list.printList();

				}

				break;

			case 8: // get length

				System.out.println("The list has " + list.getLength() + " items");

				break;

			case 9: // isEmpty

				if (list.isEmpty()) {

					System.out.println("The list is empty.");

				}

				else {

					System.out.println("This list is not empty.");

				}

				break;

			case 10: // isFull

				if (list.isFull()) {

					System.out.println("The list is full.");

				}

				else {

					System.out.println("This list is not full.");

				}

				break;
				
			case 11: // remove by name
				
				System.out.print("Enter an item: ");
				item = input.next();
				list.removeItemByName(item);

				
				list.printList();
				
				break;
			}

			System.out.println("0. exit");

			System.out.println("1. add item to the end of the list");

			System.out.println("2. add item to a specific location in the list");

			System.out.println("3. remove from a specific location");

			System.out.println("4. clear the list");

			System.out.println("5. replace an item in the list");

			System.out.println("6. get an entry from the list");

			System.out.println("7. check if a specific item exists");

			System.out.println("8. get list size");

			System.out.println("9. check if list is empty");

			System.out.println("10. check if list if full");
			
			System.out.println("11. remove a entry by name");

			System.out.print("Enter a choice:");
			
			

			choice = input.nextInt();

		}

	}

}