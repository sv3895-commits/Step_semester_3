import java.util.*;

abstract class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer,
             String studentAnswer,
             double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class MCQQuestion extends Question {
    MCQQuestion(String correct,
                String student,
                double points) {
        super(correct, student, points);
    }

    double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion extends Question {
    TFQuestion(String correct,
               String student,
               double points) {
        super(correct, student, points);
    }

    double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correct,
                  String student,
                  double points) {
        super(correct, student, points);
    }

    double grade() {
        String[] keywords =
                correctAnswer.split(",");

        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase()
                    .contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class Practice4_QuestionGrader {

    static String[] getQuotedParts(String line) {
        ArrayList<String> parts = new ArrayList<>();

        boolean inside = false;
        String current = "";

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                if (inside) {
                    parts.add(current);
                    current = "";
                }

                inside = !inside;
            } else if (inside) {
                current += c;
            }
        }

        return parts.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type =
                    line.substring(0, line.indexOf(" "));

            String[] parts = getQuotedParts(line);

            double points =
                    Double.parseDouble(
                            line.substring(
                                    line.lastIndexOf(" ") + 1));

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(
                        parts[1], parts[2], points);
            } else if (type.equals("TF")) {
                question = new TFQuestion(
                        parts[1], parts[2], points);
            } else {
                question = new EssayQuestion(
                        parts[1], parts[2], points);
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n",
                    type, score);

            total += score;
        }

        System.out.printf(
                "Total Score: %.2f%n", total);
    }
}
