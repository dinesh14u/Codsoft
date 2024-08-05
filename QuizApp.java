import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    static String[] questions = {
        "What is the capital of France?",
        "What is 2 + 2?",
        "What is the color of the sky?"
    };

    static String[][] options = {
        {"1. Paris", "2. London", "3. Rome", "4. Berlin"},
        {"1. 3", "2. 4", "3. 5", "4. 6"},
        {"1. Blue", "2. Green", "3. Red", "4. Yellow"}
    };

    static int[] answers = {1, 2, 1}; // Correct answers (indexing starts from 1)
    static int score = 0;
    static int currentQuestion = 0;
    static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz!");

        while (currentQuestion < questions.length) {
            displayQuestion(currentQuestion);
            startTimer(scanner);
        }

        System.out.println("Quiz completed! Your final score is: " + score);
        scanner.close();
    }

    public static void displayQuestion(int questionIndex) {
        System.out.println(questions[questionIndex]);
        for (String option : options[questionIndex]) {
            System.out.println(option);
        }
    }

    public static void startTimer(Scanner scanner) {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                nextQuestion();
            }
        };
        timer.schedule(task, 10000); // 10 seconds timer

        System.out.print("Your answer (1-4): ");
        int userAnswer = scanner.nextInt();
        timer.cancel();

        if (userAnswer == answers[currentQuestion]) {
            score++;
        }

        nextQuestion();
    }

    public static void nextQuestion() {
        currentQuestion++;
        if (currentQuestion < questions.length) {
            displayQuestion(currentQuestion);
            Scanner scanner = new Scanner(System.in);
            startTimer(scanner);
        }
    }
}