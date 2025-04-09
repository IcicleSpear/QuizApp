package Main;
import QuestionBank.Question; 
import MemberData.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Question");
            System.out.println("2. Remove Question");
            System.out.println("3. Add Member");
            System.out.println("4. Show All Members");
            System.out.println("5. Start Quiz");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Question
                    System.out.print("Enter Question Number: ");
                    int qno = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Question Text: ");
                    String questionText = scanner.nextLine();

                    String[] options = new String[4];
                    System.out.println("Enter 4 options:");
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Option " + (char) ('A' + i) + ": ");
                        options[i] = scanner.nextLine();
                    }

                    System.out.print("Enter Correct Answer: ");
                    String correctAnswer = scanner.nextLine();

                    // Create a new Question object and add it to the ArrayList
                    Question newQuestion = new Question(qno, questionText, options, correctAnswer);
                    questions.add(newQuestion);
                    System.out.println("Question added successfully!");
                    break;

                case 2:
                    // Remove Question
                    System.out.print("Enter Question Number to remove: ");
                    int removeQno = scanner.nextInt();
                    boolean found = false;

                    for (int i = 0; i < questions.size(); i++) {
                        if (questions.get(i).getQno() == removeQno) {
                            questions.remove(i);
                            System.out.println("Question removed successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Question with number " + removeQno + " not found.");
                    }
                    break;

                case 3:
                    // Add a Member
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    // Create a new Member object and add it to the ArrayList
                    Member newMember = new Member(memberId, name, age);
                    members.add(newMember);
                    System.out.println("Member added successfully!");
                    break;

                case 4:
                    // Show all Members
                    if (members.isEmpty()) {
                        System.out.println("No members found.");
                    } else {
                        System.out.println("\nAll Members:");
                        for (Member m : members) {
                            System.out.println(m);
                        }
                    }
                    break;

                case 5:
                    //Start Quiz
                    System.out.print("Enter Member ID to start quiz: ");
                    int startQuizMemberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean memberFound = false;

                    for (Member m : members) {
                        if (m.getMemberId() == startQuizMemberId) {
                            memberFound = true;
                            startQuiz(m, questions, scanner);
                            break;
                        }
                    }

                    if (!memberFound) {
                        System.out.println("Member with ID " + startQuizMemberId + " not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 6);

        // Display all questions before exiting
        System.out.println("\nAll Questions:");
        for (Question q : questions) {
            System.out.println(q);
        }

        scanner.close();
    }

    private static void startQuiz(Member member, ArrayList<Question> questions, Scanner scanner) {
        if (questions.isEmpty()) {
            System.out.println("No questions available for the quiz.");
            return;
        }

        List<Question> shuffledQuestions = new ArrayList<>(questions);
        Collections.shuffle(shuffledQuestions);

        int score = 0;
        List<String> userAnswers = new ArrayList<>();

        System.out.println("\nQuiz started for " + member.getName() + "!");

        for (int i = 0; i < Math.min(3, shuffledQuestions.size()); i++) {
            Question q = shuffledQuestions.get(i);
            System.out.println("\n" + (i + 1) + ". " + q.getQuestion());
            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((char) ('A' + j) + ". " + options[j]);
            }

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toLowerCase();
            userAnswers.add(userAnswer);

            if (userAnswer.equals(q.getCorrectAnswer().toLowerCase())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer is " + q.getCorrectAnswer());
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println(member.getName() + "'s score: " + score + " out of " + Math.min(3, shuffledQuestions.size()));
        System.out.println("Your answers : " + userAnswers);
    }
}