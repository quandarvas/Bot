package handlers.quiz.instruction;

import core.command.BaseCommandsSet;
import handlers.quiz.data.QuizData;

import java.util.List;

public class QuizInstructionsSet extends BaseCommandsSet
{
    public QuizInstructionsSet(List<QuizData> questions)
    {
        super(new Check());
        register(new Exit());
        register(new Question(questions));
    }
}
