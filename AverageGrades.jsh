int[] average_grades(int[][] grades, int[] weights) {
    int[] averageGrades = new int[grades.length];
    int sum = 0;
    for (int i = 0; i < grades.length; i++) {
        for (int j = 0; j < grades[i].length; j++) {
            sum += grades[i][j] * weights[j];
        }
        averageGrades[i] = sum / 100;
        sum = 0;
    }
    return averageGrades;
}

int[][] grades = {{51, 83, 28}, {0, 38, 95}};
int[] weights = {30, 40, 30};

int[] result = average_grades(grades, weights);

for (int grade : result) {
    System.out.println(grade);
}