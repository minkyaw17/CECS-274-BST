import java.util.Scanner;

// Min Kyaw
// CECS 274 - 05
// Prog # 6 - BST
// Nov 21, 2019

public class Main {

    public static void main(String[] args) {

        BST myTree = new BST();
        Scanner in = new Scanner(System.in);

        while (true) {
            myTree.display();
            System.out.println();
            myTree.print();
            System.out.printf("\nTree Height: %d", myTree.getHeight());

            if (myTree.isEmpty()) {
                System.out.println("\nNo Root: Tree is Empty");
            }
            else if (!myTree.isEmpty()){
                System.out.printf("\nTree root: %d", myTree.getRoot());
            }

            System.out.printf("\nTree Count: %d", myTree.getCount());
            System.out.println("\n(A)dd item (R)emove item (E)mpty tree (D)efault tree (Q)uit");
            System.out.println();
            System.out.println("Enter Choice: ");
            String input = in.next();

            if (input.equals("a") || input.equals("A")) {
                System.out.println("Enter integer to add to tree: ");
                String input_2 = in.next();
                myTree.add(Integer.parseInt(input_2));
            }
            else if (input.equals("r") || input.equals("R")) {
                System.out.println("Enter integer to remove from the tree: ");
                String input_3 = in.next();
                myTree.remove(Integer.parseInt(input_3));
            }
            else if (input.equals("e") || input.equals("E")) {
                myTree.emptyTree();
            }
            else if (input.equals("d") || input.equals("D")) {
                myTree.add(500);
                myTree.add(205);
                myTree.add(750);
                myTree.add(150);
                myTree.add(250);
                myTree.add(604);
                myTree.add(834);
                myTree.add(120);
                myTree.add(187);
                myTree.add(230);
                myTree.add(402);
                myTree.add(570);
                myTree.add(691);
                myTree.add(794);
                myTree.add(925);
                myTree.add(102);
                myTree.add(134);
                myTree.add(169);
                myTree.add(201);
                myTree.add(210);
                myTree.add(235);
                myTree.add(263);
                myTree.add(410);
                myTree.add(562);
                myTree.add(583);
                myTree.add(621);
                myTree.add(699);
                myTree.add(775);
                myTree.add(799);
                myTree.add(852);
                myTree.add(960);
            }

            else if (input.equals("q") || input.equals("Q")) {
                break;
            }

            else {
                System.out.println("Invalid Input.");
            }
        }
    }
}

