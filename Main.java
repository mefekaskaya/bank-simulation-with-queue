import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	private static Scanner scn;

	static boolean isInt(String s) {
		try {
			int i = Integer.parseInt(s);
			return true;
		} catch (NumberFormatException er)

		{
			System.out.print("Wrong Format\n");
			return false;
		}
	}

	public static void main(String[] args) {

		LinkedList Costumers = new LinkedList();
		scn = new Scanner(System.in);

		Node ahmet = new Node("ahmet", 0);
		Node kazim = new Node("kazim", 1);
		Node ayse = new Node("ayse", 2);
		Node leyla = new Node("leyla", 3);

		Costumers.priorityInsert(kazim);
		Costumers.priorityInsert(ayse);
		Costumers.priorityInsert(ahmet);
		Costumers.priorityInsert(leyla);

		while (true) {
			System.out.print("##########################\n");
			System.out.print("# 1.Add Costumer         #\n");
			System.out.print("# 2.Process a costumer   #\n");
			System.out.print("##########################\n");
			String choice = scn.next();
			if (isInt(choice) == true) {

				if (Integer.valueOf(choice) == 1) {
					System.out.print("Name : ");
					String name = scn.next();

					while (name.matches(".*\\d.*") || name.equals("") || name == null) {
						System.out.println(name + " is not a legal costumer name,please change.\n");
						System.out.print("Name : ");
						name = scn.next();
					}
					System.out.println();
					System.out.print("Priority : ");
					String priority = scn.next();
                
					if(isInt(priority) == true) {
						if(Integer.valueOf(priority) == 3 || Integer.valueOf(priority) == 1 || Integer.valueOf(priority) == 2 || Integer.valueOf(priority) == 0) {
							System.out.println();
							Node newNode = new Node(name, Integer.valueOf(priority));
							Costumers.priorityInsert(newNode);
							Costumers.print();
						}
						else {
							while(Integer.valueOf(priority) > 3 || Integer.valueOf(priority) < 0) {
								System.out.println("Priority value is illegal please choose between 0..3\n");
								System.out.print("Priority : ");
								priority = scn.next();
							}
							System.out.println();
							Node newNode = new Node(name, Integer.valueOf(priority));
							Costumers.priorityInsert(newNode);
							Costumers.print();
						}
					}
					else {
						while(isInt(priority) == false) {
							System.out.println("Priority value is illegal please choose between 0..3\n");
							System.out.print("Priority : ");
							priority = scn.next();
						}
						System.out.println();
						Node newNode = new Node(name, Integer.valueOf(priority));
						Costumers.priorityInsert(newNode);
						Costumers.print();
					}
					
				} else if (Integer.valueOf(choice) == 2) {
					Costumers.remove();
					Costumers.print();
				} else {
					System.out.println("Please choose a character between 1 and 2\n");
				}

			}

		}

	}// end main function

}// end class
