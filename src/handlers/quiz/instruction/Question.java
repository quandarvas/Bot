package handlers.quiz.instruction;

import core.data.Message;
import core.instruction.BaseInstruction;
import handlers.quiz.QuizData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.apache.logging.log4j.core.impl.ThrowableFormatOptions.FILE_NAME;

public class Question extends BaseInstruction
{
    private ArrayList<QuizData> questions = new ArrayList<QuizData>();

    public Question()
    {
        List<String> lines = null;
        try
        {
            lines = Files.readAllLines(Paths.get("C:\\Users\\haski\\Documents\\Code\\Java\\Bot\\src\\handlers\\quiz\\instruction\\questions.txt"), StandardCharsets.UTF_8);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        for(String line: lines){
            questions.add(parseLine(line));
        }
    }

    public QuizData parseLine(String line)
    {
        var paths = line.split("/");
        return new QuizData(paths[0], paths[1]);
    }

    @Override
    public void execute(Message msg)
    {
        var question = questions.get(new Random().nextInt(questions.size()));
        msg.user.data.put("quiz", question);
        msg.result = question.question;
        msg.done = true;
    }
}