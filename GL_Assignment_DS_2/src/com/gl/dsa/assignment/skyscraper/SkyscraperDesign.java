/***Author Prateek Singh
 * 
***/


package com.gl.dsa.assignment.skyscraper;
import java.util.*;

public class SkyscraperDesign {

	public static Queue<Integer> floor_size = new LinkedList<>();
	public static PriorityQueue<Integer> sorted_floor_size = new PriorityQueue<Integer>(Collections.reverseOrder());
	public static Stack<Integer> floor_stack = new Stack<Integer>();

	// Sort a stack using another stack
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int currentData = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
				stack.push(tempStack.pop());
			}
			tempStack.push(currentData);
		}
		return tempStack;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the total no of floors in the building");
		try (Scanner sc = new Scanner(System.in)) {
			int no_of_floors = sc.nextInt();
			for (int i = 0; i < no_of_floors; i++) {
				System.out.println("enter the floor size given on day : " + (i + 1));
				int element = sc.nextInt();
				floor_size.add(element);
				sorted_floor_size.add(element);

			}
			int i = 1;
			while (!floor_size.isEmpty()) {
				System.out.println("Day: " + i);
				int element = floor_size.poll();
				floor_stack.push(element);

				Stack<Integer> tempStack = new Stack<Integer>();
				tempStack.addAll(floor_stack);
				floor_stack = sortStack(tempStack);

				if (element == sorted_floor_size.peek()) {

					while (!floor_size.contains(sorted_floor_size.peek()) && !sorted_floor_size.isEmpty()) {

						if (floor_size.isEmpty()) {

							if (!floor_stack.empty()) {
								int stack_item = floor_stack.pop();
								sorted_floor_size.remove(stack_item);
								System.out.print(stack_item);
							}

						} else if (sorted_floor_size.peek() == floor_stack.peek()) {
							int stack_item = floor_stack.pop();
							sorted_floor_size.remove(stack_item);
							System.out.print(stack_item);
						}

					}
					System.out.println();

				} else {
					System.out.println();
				}
				i++;
			}

		}

	}

}


