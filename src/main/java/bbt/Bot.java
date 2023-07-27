package bbt;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    // TODO: create config file to move the bot's token and username there
    private final String USERNAME = "argBlueBot";
    private final String TOKEN = "6388572442:AAGduSp5jCGQObKNv5hMNtoH2jpCJ16J87s";

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message
        if (update.hasMessage()) {

            long chatId = update.getMessage().getChatId();

            String response = CommandHandler.processMessage(update);

            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(chatId);
            message.setText(response);

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
