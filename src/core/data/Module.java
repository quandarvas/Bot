package core.data;

public enum Module
{
    Basic("Наберите команду /start чтобы узнать больше!", Commands.Start.getCode()),
    Quiz("Пиши /startquiz чтобы проиграть в викторину!\n", Commands.Quiz.getCode()),
    Chat("Пиши /startchat зайти в анонимный чат!\n", Commands.Chat.getCode()),
    Calendar("Пиши /startcalendar чтобы зайти в календарь!", Commands.Calendar.getCode());

    private String prompt;
    private String button;

    Module(String prompt, String button)
    {
        this.prompt = prompt;
        this.button = button;
    }

    public String getPrompt()
    {
        return this.prompt;
    }

    public String getButton()
    {
        return this.button;
    }
}