package handlers.chat.instructions;

import core.IO;
import core.command.Command;
import core.data.Module;
import core.data.*;
import handlers.chat.Chat;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Exit implements Command
{
    private ConcurrentLinkedQueue<User> searchingUsers;

    Exit(ConcurrentLinkedQueue<User> searchingUsers)
    {
        this.searchingUsers = searchingUsers;
    }

    @Override
    public CommandInfo getInfo()
    {
        return CommandInfo.Exit;
    }

    @Override
    public void execute(Message msg, User user, IO chat)
    {
        user.setModule(Module.Basic);

        searchingUsers.remove(user);
        ((Chat)chat).disconnect(user);
        var answer = new Answer(msg.getId(), "Вы вышли из чата");
        answer.getButtons().add(CommandInfo.Start.getEmoji());
        chat.out(answer);
    }
}
