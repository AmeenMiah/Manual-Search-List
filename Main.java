import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // Generate Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean addAtFront = true;
        boolean easyMode = true;
        boolean isinClosed = false;
        boolean ifValues = false;
        
        ArrayList<Character> letters = new ArrayList<Character>();
        ArrayList<Character> closed = new ArrayList<Character>();
        ArrayList<Character> fringe = new ArrayList<Character>();
        ArrayList<Node> fringeNode = new ArrayList<Node>();
        ArrayList<Node> closedNode = new ArrayList<Node>();
        ArrayList<Node> fringeNode2 = new ArrayList<Node>();
        ArrayList<Character> fringe2 = new ArrayList<Character>();
        //Ask if the user wants to add at the front or back of the fringe
        System.out.println("Do you want to add at the front or back of the fringe? (Enter 1 for front or 2 for back)");
        int add = input.nextInt();
        if (add == 1) {
            addAtFront = true;
        }
        else if (add == 2) {
            addAtFront = false;
        }
        else {
            System.out.println("Incorrect input. It should be 1 or 2");
        }

        //Ask if the user wants to add in easy mode or hard mode
        System.out.println("Do you want to add in easy mode or hard mode? (Enter 1 for easy or 2 for hard)");
        int mode = input.nextInt();
        if (mode == 1) {
            easyMode = true;
        }
        else if (mode == 2) {
            easyMode = false;
        }
        else {
            System.out.println("Incorrect input. It should be 1 or 2");
        }

        //Ask if the user wants to add a value or a letter
        System.out.println("Do you want to add a value or a letter? (Enter 1 for value or 2 for letter)");
        int valueOrLetter = input.nextInt();
        if (valueOrLetter == 1) {
            ifValues = true;
        }
        else if (valueOrLetter == 2) {
            ifValues = false;
        }
        else {
            System.out.println("Incorrect input. It should be 1 or 2");
        }
        do {
            

        
            //Add a value to the fringe
            if (ifValues) {
                if (easyMode) {
                    if (!isinClosed) {
                        System.out.println("Enter how many to add: ");
                        int number = input.nextInt();

                        for (int i = 0; i < number; i++) {
                            System.out.println("Enter a heuristic/uniform/a* search value: ");
                            int value1 = input.nextInt();
                            System.out.println("Enter the path: ");
                            String letters1 = input.next();
                            char letter = letters1.charAt(letters1.length()-1);
                            Node node = new Node(value1, letter, letters1);
                            fringeNode.add(node);
                        }
                        //Sort the values in ascending order
                        for (int i = 0; i < fringeNode.size(); i++) {
                            for (int j = i + 1; j < fringeNode.size(); j++) {
                                if (fringeNode.get(i).getValue() > fringeNode.get(j).getValue()) {
                                    Node temp = fringeNode.get(i);
                                    fringeNode.set(i, fringeNode.get(j));
                                    fringeNode.set(j, temp);
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Skipped since the letter was already in the closed list");
                    }
                }
            }

            if (easyMode && !ifValues)
                {   
                    if (!isinClosed) {
                        System.out.println("Enter how many to add: ");
                        int number = input.nextInt();



                        for (int i = 0; i < number; i++) {
                            System.out.println("Enter a letter: ");
                            char letter = input.next().charAt(0);
                            letters.add(letter);

                        }
                        //Sort the letters alphabetically
                        for (int i = 0; i < letters.size(); i++) {
                            for (int j = i + 1; j < letters.size(); j++) {
                                if (letters.get(i) > letters.get(j)) {
                                    char temp = letters.get(i);
                                    letters.set(i, letters.get(j));
                                    letters.set(j, temp);
                                }
                            }
                        }

                        //Add the letters alphabetically to the fringe
                        for (int i = letters.size()-1; i >= 0; i--) {
                            if (addAtFront)
                            {
                                fringe.add(0, letters.get(i));
                            }
                            else
                            {
                                fringe.add(letters.get(i));
                            }
                        }
                        System.out.println("The letters are: " + letters);

                        //Delete all current letters
                        letters.clear();
                       
                    }
                    else
                    {
                        System.out.println("Skipped since the letter was already in the closed list");
                    }
                }
                else if (!easyMode && !ifValues)
                {
                    System.out.println("Enter how many to add: ");
                    int number = input.nextInt();

                    if(!isinClosed && number > 0) {


                        for (int i = 0; i < number; i++) {
                            System.out.println("Enter a letter: ");
                            char letter = input.next().charAt(0);
                            letters.add(letter);

                        }

                        for (int i = letters.size()-1; i >= 0; i--) {
                            if (addAtFront)
                            {
                                fringe.add(0, letters.get(i));
                            }
                            else
                            {
                                fringe.add(letters.get(i));
                            }
                        }
                        
                        //Delete current letters
                        letters.clear();
                    }
                    else
                    {
                        System.out.println("Incorrect input. It should be 0 since the letter was already in the closed list");
                    }
                }
                
                if (!ifValues)
                {
                    //Print the fringe
                    System.out.println("The fringe is: " + fringe);

                    //Print the closed list
                    System.out.println("The closed list is: " + closed);
                }
                else
                {
                    //Print the fringe
                    System.out.print("The fringe is: ");
                    for (Node a : fringeNode) {
                        if (a.equals(fringeNode.get(0)))
                            System.out.print("[" + a.getLetters() + " (" + a.getValue() + ")");
                        else
                            System.out.print(", " + a.getLetters() + " (" + a.getValue() + ")");
                    }
                    if (fringeNode.isEmpty())
                        System.out.print("[]");
                    else
                        System.out.print("]");
                    System.out.println();
                    //Print the closed list
                    System.out.print("The closed list is: ");
                    for (Node a : closedNode) {
                        if (a.equals(closedNode.get(0)))
                            System.out.print("[" + a.getLetters() + " (" + a.getValue() + ")");
                        else
                            System.out.print(", " + a.getLetters() + " (" + a.getValue() + ")");
                    }
                    if (closedNode.isEmpty())
                        System.out.print("[]");
                    else
                        System.out.print("]");
                }
                
                System.out.println("\n");
                //Delete the top of the fringe
                if (!ifValues) {
                     if (fringe.get(0) == 'G') {
                        System.out.println("The goal has been found");
                        break;
                    }
                    else if (fringe.isEmpty()) {
                        System.out.println("The goal has not been found");
                    }

                    char top = fringe.get(0);
                    fringe.remove(0);
                    fringe2.add(top);
                    System.out.println("The top of the fringe is: " + top + " and has been removed from the fringe list");

                    //Check if the top of the fringe is in the closed list
                    isinClosed = false;
                    for (char a : closed) {
                        if (a == top) {
                            isinClosed = true;
                        }
                    }
                    //Add the top of the fringe to the closed list
                    if (!isinClosed) {
                        closed.add(top);
                        if (easyMode)
                            System.out.println("The top of the fringe is: " + top + " and has been added to the closed list");
                    }

                   
                }
                else {

                    if (fringeNode.get(0).getLetter() == 'G') {
                        System.out.println("The goal has been found");
                        break;
                    }
                    else if (fringeNode.isEmpty()) {
                        System.out.println("The goal has not been found");
                    }

                    Node top = fringeNode.get(0);
                    fringeNode.remove(0);
                    fringeNode2.add(top);
                    System.out.println("The top of the fringe is: " + top.getLetter() + " and has been removed from the fringe list");

                    //Check if the top of the fringe is in the closed list
                    isinClosed = false;
                    for (Node a : closedNode) {
                        if (a.getLetter() == top.getLetter()) {
                            isinClosed = true;
                        }
                    }
                    //Add the top of the fringe to the closed list
                    if (!isinClosed) {
                        closedNode.add(top);
                        if (easyMode)
                            System.out.println("The top of the fringe is: " + top.getLetter() + " and has been added to the closed list");
                    }


                }
        } while (!fringe.isEmpty() || !isinClosed); 

        if (ifValues)
        {
            System.out.println("The path to the goal is: " + fringeNode2.get(fringeNode2.size()-1).getLetters());
            System.out.println("The cost of the path is: " + fringeNode2.get(fringeNode2.size()-1).getValue());

            //Print the fringe
            System.out.print("The fringe is: ");
            for (Node a : fringeNode) {
                if (a.equals(fringeNode.get(0)))
                    System.out.print("[" + a.getLetters() + " (" + a.getValue() + ")");
                else
                    System.out.print(", " + a.getLetters() + " (" + a.getValue() + ")");
            }

            if (fringeNode.isEmpty())
                System.out.print("[]");
            else
                System.out.print("]");

            System.out.println();
            //Print the closed list
            System.out.print("The closed list is: ");
            for (Node a : closedNode) {
                if (a.equals(closedNode.get(0)))
                    System.out.print("[" + a.getLetters() + " (" + a.getValue() + ")");
                else
                    System.out.print(", " + a.getLetters() + " (" + a.getValue() + ")");
            }
            if (closedNode.isEmpty())
                System.out.print("[]");
            else
                System.out.print("]");
        }
        else
        {
            System.out.println("The path to the goal is: " + fringe2.get(fringe2.size()-1));

            //Print the fringe
            System.out.println("The fringe is: " + fringe2);

            //Print the closed list
            System.out.println("The closed list is: " + closed);
        }
        input.close();
    }
}


