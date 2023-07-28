# TelegramBlueBot
BlueBotTelegram is a Telegram bot that provides the currency exchange rates from Argentina for usd and euro. It fetches the latest rates from the [Bluelytics API](https://bluelytics.com.ar/#!/api) and responds to user commands in Telegram.

## Functionality

BlueBotTelegram supports the following commands:

1. `/start` or `/help`: Display a list of available commands and usage instructions.
2. `/dolar`: Get the official and blue market exchange rates for the US Dollar.
3. `/euro`: Get the official and blue market exchange rates for the Euro.

## Credits

- **Bluelytics API**: The currency exchange rates are fetched from the [Bluelytics API](https://bluelytics.com.ar/#!/api).

- **GitHub Tutorial**: The bot is built using the [TelegramBots API](https://github.com/rubenlagus/TelegramBots) by [rubenlagus](https://github.com/rubenlagus).


## Dependencies

The bot is built using Java and relies on the following dependencies:

- `org.telegram.telegrambots:telegrambots:6.7.0`: The TelegramBots API for interacting with Telegram.
- `com.fasterxml.jackson.core:jackson-databind:2.12.5`: For JSON data processing.
- (Add any other dependencies you have used in your project)


### License

BlueBotTelegram is open-source and licensed under the [MIT LICENSE](LICENSE)