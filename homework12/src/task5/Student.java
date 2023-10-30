package task5;

class Student {
    private String firstName;
    private String lastName;
    private String group;
    private int score = 0;

    public Student(String firstName, String lastName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getGroup() {
        return group;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}

