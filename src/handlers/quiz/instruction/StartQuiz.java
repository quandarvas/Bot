package handlers.quiz.instruction;

import core.IO;
import core.data.*;
import core.command.Command;
import core.data.Module;

public class StartQuiz implements Command
{
    @Override
    public CommandInfo getInfo() {
        return CommandInfo.Quiz;
    }

    @Override
    public void execute(Message msg, User user, IO parent)
    {
        var result = "Вы вошли в викторину!\nВыход: /exit";
        user.setModule(Module.Quiz);
        var answer = new Answer(user.getId(), result);
        answer.getButtons().add(CommandInfo.Exit.getEmoji());
        parent.out(answer);
        parent.in(new Message(msg.getId(), "question"));
    }
}
