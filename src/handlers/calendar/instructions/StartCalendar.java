package handlers.calendar.instructions;

import core.IO;
import core.command.Command;
import core.data.*;
import core.data.Module;

public class StartCalendar implements Command
{
    @Override
    public CommandInfo getInfo()
    {
        return CommandInfo.Calendar;
    }

    @Override
    public void execute(Message msg, User user, IO parent)
    {
        var result = new StringBuilder();
        result.append("Вы вошли в календарь!\n");
        result.append("Сегодняшний праздник /checkholiday\n");
        result.append("Чтобы установить праздник напиши /setevent\n");
        result.append("Выход: /exit");

        user.setModule(Module.Calendar);
        var answer = new Answer(user.getId(), result.toString());
        answer.getButtons().add(CommandInfo.CheckHoliday.getEmoji());
        answer.getButtons().add(CommandInfo.SetEvent.getEmoji());
        answer.getButtons().add(CommandInfo.Exit.getEmoji());
        parent.out(answer);
    }
}
