package com.example.recap;

class QuestionLibrary {

    private final String mQuestions [] = {
         "I've been feeling optimistic about the future",
         "I've been feeling useful",
         "I've been feeling relaxed",
         "I've been feeling interested in other people",
         "I've had energy to spare",
         "I've been dealing with problems well",
         "I've been thinking clearly",
         "I've been feeling good about myself",
         "I've been feeling close to other people",
         "I've been feeling confident",
         "I've been able to make up my mind about things",
         "I've been feeling loved",
         "I've been feeling interested in new things",
         "I've been feeling cheerful"
    };

    public String getQuestion(int a) {
        return mQuestions[a];
    }

    public int getQuestionListLength() {
        return mQuestions.length;
    }
}
