package handlers.quiz.instruction;

import core.IO;
import core.data.*;
import core.command.Command;

public class Exit implements Command
{
    @Override
    public void execute(Message msg, User user, IO parent)
    {
        user.setState(State.Basic);
        var answer = new Answer(msg.getId(), "Вы вышли из викторины");
        answer.addButton(Emoji.Start.getCode());
        parent.out(answer);
    }
}
