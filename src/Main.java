import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree studentTree = new BinarySearchTree();
        int choice = 0;

        do {
            try {
                System.out.println("1. Add student");
                System.out.println("2. Edit student");
                System.out.println("3. Delete student");
                System.out.println("4. Sort students by grade (Bubble Sort)");
                System.out.println("5. Search student by ID");
                System.out.println("6. Sort students by grade (Quick Sort)");
                System.out.println("7. Display all students");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        int id = -1;
                        String name = "";
                        double grade = -1;

                        while (true) {
                            try {
                                System.out.print("Enter student ID: ");
                                id = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) {
                                System.out.println("Error: Invalid ID! Please enter a valid integer.");
                                sc.nextLine();
                            }
                        }
                        while (true) {
                            try {
                                System.out.print("Enter student name: ");
                                name = sc.nextLine();

                                if (name.matches("\\d+")) {
                                    throw new IllegalArgumentException("Name cannot be a number!");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        while (true) {
                            try {
                                System.out.print("Enter student grade: ");
                                grade = sc.nextDouble();
                                sc.nextLine();

                                if (grade < 0 || grade > 10) {
                                    System.out.println("Invalid grade! Must be between 0 and 10.");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error: Invalid grade! Please enter a valid number.");
                                sc.nextLine();
                            }
                        }
                        studentTree.add(new Student(id, name, grade));
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        int editId;
                        String newName;
                        double newGrade;
                        while (true) {
                            try {
                                System.out.print("Enter student ID to edit: ");
                                editId = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) {
                                System.out.println("Error: Invalid ID! Please enter a valid integer.");
                                sc.nextLine();
                            }
                        }
                        while (true) {
                            try {
                                System.out.print("Enter new name: ");
                                newName = sc.nextLine();

                                if (newName.matches("\\d+")) {
                                    throw new IllegalArgumentException("Name cannot be a number!");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        while (true) {
                            try {
                                System.out.print("Enter new grade: ");
                                newGrade = sc.nextDouble();
                                sc.nextLine();

                                if (newGrade < 0 || newGrade > 10) {
                                    System.out.println("Invalid grade! Must be between 0 and 10.");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error: Invalid grade! Please enter a valid number.");
                                sc.nextLine();
                            }
                        }
                        if (studentTree.edit(editId, newName, newGrade)) {
                            System.out.println("Student updated successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 3:
                        int deleteId;
                        while (true) {
                            try {
                                System.out.print("Enter student ID to delete: ");
                                deleteId = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) {
                                System.out.println("Error: Invalid ID! Please enter a valid integer.");
                                sc.nextLine();
                            }
                        }
                        if (studentTree.delete(deleteId)) {
                            System.out.println("Student deleted successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 4:

                        try {
                            studentTree.bubbleSort();
                        } catch (Exception e) {
                            System.out.println("Error: An error occurred while sorting students.");
                        }
                        break;

                    case 5:
                        int searchId;
                        while (true) {
                            try {
                                System.out.print("Enter student ID to search: ");
                                searchId = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) {
                                System.out.println("Error: Invalid ID! Please enter a valid integer.");
                                sc.nextLine();
                            }
                        }
                        Student foundStudent = studentTree.search(searchId);
                        if (foundStudent != null) {
                            System.out.println("Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 6:
                        try {
                            studentTree.quickSortByID();
                        } catch (Exception e) {
                            System.out.println("Error: An error occurred while sorting students.");
                        }
                        break;


                    case 7:
                        try {
                            System.out.println("All students:");
                            studentTree.inorderTraversal();
                        } catch (Exception e) {
                            System.out.println("Error: An error occurred while displaying students.");
                        }
                        break;

                    case 8:
                        System.out.println("Exiting program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please choose a valid option.");
                sc.nextLine();
            }
        } while (choice != 8);

        sc.close();
    }
}
