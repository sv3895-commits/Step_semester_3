class Scorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int answersRecorded;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answersRecorded < totalQuestions) {
            results[answersRecorded] = correct;
            answersRecorded++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Practice2_QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}