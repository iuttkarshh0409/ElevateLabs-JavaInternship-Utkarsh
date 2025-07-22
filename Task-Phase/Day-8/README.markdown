# 🎓 Java Console Quiz Application

A command-line based **Java Quiz Application** built in **Java** to test fundamental Java programming knowledge. This interactive quiz presents 7 multiple-choice questions with randomized order, scores user responses, and provides detailed feedback. Developed as part of the **Elevate Labs Java Developer Internship** to practice object-oriented programming and user input handling.

---

## 💻 Features

- ✅ **Dynamic Quiz**: Presents 7 Java-related questions in random order.
- ✅ **Scoring System**: Awards +1 for correct answers, -1 for incorrect answers.
- ✅ **Question Display**: Shows questions with four numbered options.
- ✅ **Input Validation**: Ensures valid numeric inputs (1–4) for answers.
- ✅ **Feedback**: Displays correct/incorrect status and the correct answer for wrong responses.
- ✅ **Result Analysis**: Provides a score and personalized feedback based on performance.
- ✅ **Retry Option**: Allows users to retry the quiz if their score is ≤4.
- ✅ **Graceful Exit**: Terminates with a thank-you message.

---

## 🛠️ Tools & Technologies

- **Language**: Java 17
- **IDE**: Visual Studio Code
- **Interface**: Terminal (Command Line Interface)
- **Key Libraries**: `java.util` (`ArrayList`, `Scanner`, `Collections`)
- **Exception Handling**: `NumberFormatException` for invalid numeric inputs

---

## 📂 Project Structure

```
QuizApp
├── QuizApp.java  # Main Java application with Question class and quiz logic
└── README.md     # Project documentation
```

### 📌 Classes
- **Question**: Represents a quiz question with text, options, and the correct answer.
- **QuizApp**: Main class managing quiz logic, user interaction, and scoring.

---

## 🔍 How It Works

- **Question Loading**: Loads 7 predefined Java-related questions with four options each, randomized using `Collections.shuffle()`.
- **Quiz Execution**: Displays each question, prompts for an answer (1–4), and validates input.
- **Scoring**: Increments score (+1) for correct answers, decrements (-1) for incorrect ones, and shows the correct answer for wrong responses.
- **Results**: Displays final score out of 7.
- **Analysis**: Provides feedback based on score (e.g., "Solid understanding" for 7, "Revisit basics" for low scores).
- **Retry Option**: Offers to restart the quiz if the score is ≤4.
- **Menu Interaction**: Fully command-line driven with robust input validation.

---

## ✅ Key Features & Improvements

| Feature/Improvement            | Description                                              |
|-------------------------------|----------------------------------------------------------|
| Randomized Questions          | Shuffles questions for varied quiz experiences           |
| Input Validation              | Ensures answers are numeric and within 1–4                |
| Scoring System                | +1 for correct, -1 for incorrect with immediate feedback |
| Personalized Analysis          | Tailored feedback based on score ranges                   |
| Retry Option                  | Allows retry for scores ≤4 to encourage improvement      |
| User-Friendly Messages        | Clear prompts, error messages, and correct answer display |
| OOP Design                    | Uses `Question` class for modular question management     |

---

## 🚀 Sample Execution

```
-----       Welcome to the Java Console Quiz Application       -----

This is a basic-to-intermediate level CLI-based Java quiz consisting of 7 questions designed to test your understanding of fundamental Java programming concepts.
Take this quiz to quickly assess your knowledge and build confidence with the language.

Quiz Rules:
+1 for each correct answer
-1 for each incorrect answer
All questions must be attempted
Each question carries equal weight (1 mark each)

---   Questions Set   ---

< Java does not support which type of inheritance? >
[1] Single
[2] Multiple
[3] Multi-level
[4] Hybrid

Pick your answer (1-4): 2
Bravo! Correct Answer...

< What is default value of boolean data type in Java? >
[1] null
[2] true
[3] false
[4] not-defined

Pick your answer (1-4): 1
Oops! Incorrect Answer...
Correct Option: false

=== Quiz Result ===
Your Score: 5 out of 7

=== Smart Analysis ===
Conclusion: Good job! You have a decent grasp on Java fundamentals.
A bit more consistency and you'll master it.

Exiting the application...
```

---

## 📎 Concepts Practiced

- **Object-Oriented Programming**: Encapsulation via the `Question` class and modular quiz logic.
- **Data Structures**: `ArrayList` for storing questions and `List` for options.
- **Randomization**: `Collections.shuffle()` for random question order.
- **Input Validation**: Ensures valid numeric inputs using `Scanner` and `NumberFormatException`.
- **User Interaction**: Command-line interface with clear prompts and feedback.
- **Defensive Programming**: Handles empty inputs, invalid numbers, and out-of-range options.

---

## 🔐 Edge Case Handling

| Case                              | Behavior                                              |
|-----------------------------------|-------------------------------------------------------|
| Empty answer input                | Rejected with "Option cannot be blank"                |
| Non-numeric answer                | Rejected with "Enter numeric input only"              |
| Answer outside 1–4                | Rejected with "Choose only between the available options" |
| Low score (≤4)                    | Offers retry option to improve performance            |
| All questions answered correctly   | Congratulatory message with no retry prompt           |

---

## 🙌 Author

**Utkarsh Dubey**  
*Java Developer Intern @ Elevate Labs*  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 GitHub: [iuttkarshh0409](https://github.com/iuttkarshh0409)  
📧 Email: dubeyutkarsh101@gmail.com

---

## 📝 License

This project is open-source and free to use for educational and personal projects.