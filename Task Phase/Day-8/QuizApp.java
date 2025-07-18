import java.util.*;

class Question {
    private final String questionText;
    private final List<String> options;
    private final int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, options.get(i));
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }

    public String getCorrectAnswerText() {
        return options.get(correctOption - 1);
    }
}

public class QuizApp {
    private final List<Question> questions;
    private int score;
    private final Scanner sc;

    public QuizApp() {
        questions = new ArrayList<>();
        sc = new Scanner(System.in);
        score = 0;
    }

    public void loadQuestions() {
        questions.clear();
        questions.add(new Question(
                "< Java does not support which type of inheritance? >",
                Arrays.asList("Single", "Multiple", "Multi-level", "Hybrid"),
                2
        ));
        questions.add(new Question(
                "< Which keyword is used to inherit a class in Java? >",
                Arrays.asList("this", "super", "extends", "implements"),
                3
        ));
        questions.add(new Question(
                "< The programming language Java is - ? >",
                Arrays.asList("Statically-typed", "Dynamically-typed", "Both", "None of the Above"),
                1
        ));
        questions.add(new Question(
                "< What makes java platform-independent?  >",
                Arrays.asList("JDK", "JRE", "JVM", "Java-Bytecode"),
                4
        ));
        questions.add(new Question(
                "< What is standard size (in bytes) of integer data type in Java? >",
                Arrays.asList("4", "3", "2", "1"),
                1
        ));
        questions.add(new Question(
                "< What is default value of boolean data type in Java? >",
                Arrays.asList("null", "true", "false", "not-defined"),
                2
        ));
        questions.add(new Question(
                "< In Java, data members and member functions are wrapped up into a single entity called? >",
                Arrays.asList("Variable", "Structure", "Package", "Class"),
                4
        ));
        Collections.shuffle(questions); //Randomize order
    }

    public void startQuiz() {
        System.out.println("-----       Welcome to the Java Console Quiz Application       -----\n");

        System.out.println("This is a basic-to-intermediate level CLI-based Java quiz consisting of 7 questions designed to test your understanding of fundamental Java programming concepts.");
        System.out.println("Take this quiz to quickly assess your knowledge and build confidence with the language.\n");

        System.out.println("Quiz Rules:");
        System.out.println("\n+1 for each correct answer");
        System.out.println("-1 for each incorrect answer");
        System.out.println("All questions must be attempted");
        System.out.println("Each question carries equal weight (1 mark each)\n");

        System.out.println("\n---   Questions Set   ---\n");

        for (Question q : questions) {
            q.displayQuestion();
            int userAnswer = getUserAnswer();
            if (q.isCorrect(userAnswer)) {
                System.out.println("Bravo! Correct Answer...");
                score++;
            } else {
                System.out.println("Oops! Incorrect Answer...");
                System.out.println("Correct Option: " + q.getCorrectAnswerText()); //shows correct option
                score--;
            }
        }
    }

    private int getUserAnswer() {
        while (true) {
            System.out.print("\nPick your answer (1-4): ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: Option cannot be blank!\nNote: Please choose one of the options.");
                continue;
            }

            try {
                int answer = Integer.parseInt(input);
                if (answer >= 1 && answer <= 4) return answer;
                System.out.println("Error: Choose only between the available options (1-4)");
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numeric input only!!");
            }
        }
    }

    private void showResults() {
        System.out.println("\n=== Quiz Result ===");
        System.out.println("Your Score: " + score + " out of " + questions.size());
    }

    private void showAnalysis() {
        System.out.println("\n=== Smart Analysis ===");
        switch (score) {
            case 7 -> System.out.println("Conclusion: You have a solid understanding of fundamental concepts.\nKeep grinding...You have a bright future ahead!\n\nExiting the application...");
            case 5, 6 -> System.out.println("Conclusion: Good job! You have a decent grasp on Java fundamentals.\nA bit more consistency and you'll master it.\n\nExiting the application...");
            case 3, 4 -> System.out.println("Conclusion: You're halfway there.\nRevisit core concepts and practice a little more.");
            case 1, 2 -> System.out.println("Conclusion: You seem to be struggling with basics.\nTime to go back to Java foundations and revise properly.");
            case 0 -> System.out.println("Conclusion: Don’t worry! Everyone starts somewhere.\nBegin with beginner-friendly Java tutorials and build up gradually.");
            default -> System.out.println("Conclusion: You have performed very poorly!\nBut remember there is always a room for betterment.");
        }

        if (score <= 4) {
            System.out.print("\nWould you like to retry the quiz to improve your score? (y/n): ");
            String retry = sc.nextLine().trim().toLowerCase();
            if (retry.equals("y")) {
                score = 0;
                loadQuestions();  //Reload and reshuffle
                startQuiz();
                showResults();
                showAnalysis();
            } else exitApp();
        }
    }

    public void exitApp(){
        System.out.println("\nThank you for participating in the quiz.\nKeep practicing and improving!\n\nExiting the application...");
    }

    public static void main(String[] args) {
        QuizApp app = new QuizApp();
        app.loadQuestions();
        app.startQuiz();
        app.showResults();
        app.showAnalysis();
    }
}
