package bbt;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Bot extends TelegramLongPollingBot {
    private String username;
    private String token;

    public Bot() {
        loadConfig();
    }

    // Load configuration from config.properties file
    private void loadConfig() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);

            this.username = properties.getProperty("bot.username");
            this.token = properties.getProperty("bot.token");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading config file");
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message
        if (update.hasMessage()) {

            long chatId = update.getMessage().getChatId();
            String response = CommandHandler.processMessage(update);

            // Create a SendMessage object with mandatory fields
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(response);

            try {
                execute(message); // Send the reply
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
