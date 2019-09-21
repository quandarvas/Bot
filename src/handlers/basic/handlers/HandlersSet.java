package handlers.basic.handlers;

import core.set.BaseSet;
import core.IIO;
import handlers.quiz.Quiz;

import java.io.IOException;

public class HandlersSet extends BaseSet<String, IIO>
{
    public HandlersSet(IIO handler)
    {
        super();
        register(new Quiz(handler));
    }

    public void register(IIO obj)
    {
        var key = obj.getClass().getSimpleName().toLowerCase();
        super.register(key, obj);
    }
}
