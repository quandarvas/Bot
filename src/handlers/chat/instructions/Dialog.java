package handlers.chat.instructions;

import core.IIO;
import core.data.Message;
import core.data.User;
import core.instruction.BaseInstruction;

public class Dialog extends BaseInstruction
{
    @Override
    public void execute(Message msg, IIO handler)
    {
        var user = msg.user.data.get("chat");
        if (user != null)
        {
            var answer = new Message((User)user);
            answer.result = msg.text;
            handler.out(answer);
        }
    }
}