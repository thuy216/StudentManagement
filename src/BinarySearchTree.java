public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Add a new student
    void add(Student student) {
        root = insertRec(root, student);
    }

    Node insertRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }
        if (student.ID < root.student.ID)
            root.left = insertRec(root.left, student);
        else if (student.ID > root.student.ID)
            root.right = insertRec(root.right, student);
        return root;
    }

    // Search for a student by ID
    Student search(int id) {
        return searchRec(root, id);
    }

    Student searchRec(Node root, int id) {
        if (root == null || root.student.ID == id)
            return root == null ? null : root.student;

        if (id < root.student.ID)
            return searchRec(root.left, id);

        return searchRec(root.right, id);
    }

    // Edit a student by ID
    boolean edit(int id, String newName, double newGrade) {
        Student student = search(id);
        if (student != null) {
            student.name = newName;
            student.grade = newGrade;
            return true;
        }
        return false;
    }

    // Delete a student by ID
    boolean delete(int id) {
        if (search(id) == null) {
            return false; // Student not found
        }
        root = deleteRec(root, id);
        return true; // Deletion successful
    }

    Node deleteRec(Node root, int id) {
        if (root == null)
            return root;
        if (id < root.student.ID)
            root.left = deleteRec(root.left, id);
        else if (id > root.student.ID)
            root.right = deleteRec(root.right, id);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.student = minValue(root.right);
            root.right = deleteRec(root.right, root.student.ID);
        }
        return root;
    }

    Student minValue(Node root) {
        Student minStudent = root.student;
        while (root.left != null) {
            minStudent = root.left.student;
            root = root.left;
        }
        return minStudent;
    }

    // In-order traversal (to display all students)
    void inorderTraversal() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.student);
            inorderRec(root.right);
        }
    }

    // Convert tree to array for sorting
    Student[] toArray() {
        Student[] students = new Student[getSize()];
        fillArray(root, students, new int[] {0}); // Using int array as mutable index
        return students;
    }

    int getSize() {
        return getSizeRec(root);
    }

    int getSizeRec(Node root) {
        if (root == null) return 0;
        return 1 + getSizeRec(root.left) + getSizeRec(root.right);
    }

    void fillArray(Node root, Student[] students, int[] index) {
        if (root != null) {
            fillArray(root.left, students, index);
            students[index[0]++] = root.student;
            fillArray(root.right, students, index);
        }
    }

    // Bubble Sort
    void bubbleSort() {
        Student[] list = toArray();
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].grade < list[j + 1].grade) {
                    Student temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by grade (Bubble Sort):");
        for (Student s : list) {
            System.out.println(s);
        }
    }

//Quicksort
    void quickSortByID() {
        Student[] list = toArray();
        quickSortRecByID(list, 0, list.length - 1);
        System.out.println("Students sorted by ID (Quick Sort - Descending Order):");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private void quickSortRecByID(Student[] list, int low, int high) {
        if (low < high) {
            int pi = partitionByID(list, low, high);
            quickSortRecByID(list, low, pi - 1);
            quickSortRecByID(list, pi + 1, high);
        }
    }

    private int partitionByID(Student[] list, int low, int high) {
        int pivot = list[high].ID;  // Use ID for comparison
        int i = (low - 1);

        // Sort in ascending order (less than pivot comes before)
        for (int j = low; j < high; j++) {
            if (list[j].ID < pivot) {  // Change to ascending order
                i++;
                Student temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        Student temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;

        return i + 1;
    }

}
