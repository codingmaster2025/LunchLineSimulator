import java.util.Scanner;
import java.util.*;

public class LunchLineSimulator {

	public static void main(String[] args) throws Exception {

		boolean menu = true;
		String selection;
		StudentLine realityA = new StudentLine();
		StudentLine realityB = new StudentLine();

		int world = 0;

		System.out.println(
				"Welcome to the Middle School where you are the master of the lunch line, and you may subject your angsty kids to whatever form of culinary torture best fits your mood. You are in Reality A.");

		do {

			System.out.println("Menu:");
			System.out.println("	A) Add a student to the line at the end");
			System.out.println("	C) Have a new student cut a friend");
			System.out.println("	T) Have two students trade places");
			System.out.println("	B) Have the bully remove a student");
			System.out.println("	U) Update a student's money amount");
			System.out.println("	S) Serve a student");
			System.out.println("	P) Print the current reality's lunch line");
			System.out.println("	S) Serve a student");
			System.out.println("	O) Switch to the other reality");
			System.out.println("	E) Check if the realities are equal");
			System.out.println("	D) Duplicate this reality into the other reality");
			System.out.println("	Q) Quit middle school and move on to real life.");

			Scanner in = new Scanner(System.in);
			System.out.println("Please select an option:");
			selection = in.next();

			switch (selection.toUpperCase()) {
			case "Q":
				menu = false;
				System.out.print(
						"You are now leaving the Middle School Lunch Line Simulator. We congratulate you on your decision to do something more productive with your time.");
				break;

			case "A": {

				String name = "";
				double money;

				System.out.print("Please enter student name:");
				name += in.nextLine();
				name += in.nextLine();

				System.out.println("Please enter money amount:");
				money = in.nextDouble();

				Student a = new Student(name, money);

				if (world == 0) {
					realityA.addStudent(-1, a);

					System.out.println(a.getName() + " has been added to the line in position " + realityA.numStudents()
							+ ", " + a.getName() + " has $" + a.getMoney());
					System.out.println();

				} else {
					realityB.addStudent(-1, a);

					System.out.println(a.getName() + " has been added to the line in position " + realityA.numStudents()
							+ ", " + a.getName() + " has $" + a.getMoney());
					System.out.println();

				}
				break;

			}

			case "O": {
				if (world == 1) {
					world = 0;
					System.out.println("You are in Reality A. I reject your reality and substitute my own");
				} else {
					world = 1;
					System.out.println("You are in Reality B. I reject your reality and substitute my own");
				}
				break;
			}

			case "P": {
				if (world == 0) {
					System.out.println("Lunch Line in Reality A:");
					System.out.print(realityA);
				} else {
					System.out.println("Lunch Line in Reality B:");
					System.out.print(realityB);
				}
				break;
			}
			case "D": {
				if (world == 0) {
					realityB = (StudentLine) realityA.clone();
					System.out.println("Reality A has been copied into Really B");
				} else {
					realityA = (StudentLine) realityB.clone();
					System.out.println("Reality B has been copied into Really A");
				}

				break;
			}
			case "T": {
				int s1, s2;

				System.out.println("Please enter student1 index:");
				s1 = in.nextInt();
				System.out.println("Please enter student2 index:");
				s2 = in.nextInt();

				if (world == 0) {
					realityA.swapStudent(s1 - 1, s2 - 1);
					System.out.println(realityA.getStudent(s2 - 1).getName() + " has traded places with "
							+ (realityA.getStudent(s1 - 1).getName()) + ".");

				} else {
					realityB.swapStudent(s1 - 1, s2 - 1);
					System.out.println(realityB.getStudent(s2 - 1).getName() + " has traded places with "
							+ (realityB.getStudent(s1 - 1).getName()) + ".");

				}

				break;
			}

			case "E": {
				if (realityA.equals(realityB))
					System.out.println("The realities are equal.");
				else
					System.out.println("The realities are not equal.");

				break;
			}

			case "U": {
				int index;
				double newMoney;

				System.out.println("Please enter student index:");
				index = in.nextInt();

				System.out.println("Please enter new money amount:");
				newMoney = in.nextDouble();

				if (world == 0) {
					realityA.getStudent(index - 1).setMoney(newMoney);

				} else {
					realityB.getStudent(index - 1).setMoney(newMoney);

				}

				break;
			}

			case "B": {
				int index1;

				System.out.println("Please enter student index:");
				index1 = in.nextInt();
				index1--;

				if (world == 0) {

					Student a = realityA.getStudent(index1);
					realityA.removeStudent(index1);

					System.out.println("The bully has stolen " + a.getName() + "'s lunch money, and " + a.getName()
							+ " has left, feeling hangry.");

				} else {

					Student a = realityB.getStudent(index1);
					realityB.removeStudent(index1);

					System.out.println("The bully has stolen " + a.getName() + "'s lunch money, and " + a.getName()
							+ " has left, feeling hangry.");
				}

				break;

			}

			case "S": {

				if (world == 0) {

					System.out.println(realityA.getStudent(0).getName()
							+ " has been served today's special: Bouncy \"Chicken?\" Nuggets. We hope he lives to see another day!");

					realityA.removeStudent(0);

				} else {
					System.out.println(realityB.getStudent(0).getName()
							+ " has been served today's special: Bouncy \"Chicken?\" Nuggets. We hope he lives to see another day!");

					realityB.removeStudent(0);

				}
				break;

			}

			case "C": {

				String name = "";
				double money;
				int index;

				System.out.print("Please enter student name:");
				name += in.nextLine();
				name += in.nextLine();

				System.out.println("Please enter money amount:");
				money = in.nextDouble();

				System.out.println("Please enter position:");
				index = in.nextInt();

				Student a = new Student(name, money);
				if (world == 0) {

					System.out.println(a.getName() + " has cut " + realityA.getStudent(index).getName()
							+ "and is now in position " + index + ", " + a.getName() + " has $" + a.getMoney());
					System.out.println();

					realityA.addStudent((index - 1), a);

				} else {

					System.out.println(a.getName() + " has cut " + realityB.getStudent(index).getName()
							+ "and is now in position " + index + ", " + a.getName() + " has $" + a.getMoney());
					System.out.println();
					realityB.addStudent((index - 1), a);

				}

			}

			}
		} while (menu);

	}

}
