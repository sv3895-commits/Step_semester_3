import java.util.Random;
import java.util.Scanner;
public class RockPaperScissor{
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    static String getComputerMove(Random random) {
        int choice = random.nextInt(3);
        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
    static String formatMove(String move) {
        move = move.toLowerCase();
        if (move.equals("rock")) {
            return "Rock";
        } else if (move.equals("paper")) {
            return "Paper";
        } else if (move.equals("scissors")) {
            return "Scissors";
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) +
                             " - Enter Rock, Paper, or Scissors: ");
                             String playerMove = formatMove(sc.nextLine());
            while (playerMove.equals("")) {
                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMove = formatMove(sc.nextLine());
            }
            String computerMove = getComputerMove(random);
            String result = playRound(playerMove, computerMove);
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        System.out.println();
        System.out.println("Final Summary");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    (i + 1),
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.println("-----------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);
        sc.close();
    }
}
