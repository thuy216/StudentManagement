class Student {
    int ID;
    String name;
    double grade;
    String rank;

    public Student(int ID, String name, double grade) {
        this.ID = ID;
        this.name = name;
        this.grade = grade;
        this.rank = calculateRank();
    }

    private String calculateRank() {
        if (grade >= 9.0 && grade <= 10.0) return "Excellent";
        if (grade >= 7.5 && grade < 9.0) return "Very Good";
        if (grade >= 6.5 && grade < 7.5) return "Good";
        if (grade >= 5.0 && grade < 6.5) return "Medium";
        if (grade >= 0 && grade < 5.0) return "Fail";
        return "Invalid";
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Grade: " + grade + ", Rank: " + rank;
    }
}


