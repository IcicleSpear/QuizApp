package QuestionBank;

public class Question {
    private int qno;             // Question number
    private String question;     // The question text
    private String[] options;    // Array of options (4 options)
    private String correctAnswer; // Correct answer

    // Constructor
    public Question(int qno, String question, String[] options, String correctAnswer) {
        this.qno = qno;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters and Setters
    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Q" + qno + ": " + question + "\n");
        sb.append("Options: \n");
        for (int i = 0; i < options.length; i++) {
            sb.append((char) ('A' + i) + ". " + options[i] + "\n");
        }
        sb.append("Correct Answer: " + correctAnswer);
        return sb.toString();
    }
}
