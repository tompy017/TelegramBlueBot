package bbt;

import org.telegram.telegrambots.meta.api.objects.Update;

public class CommandHandler {

    // process incoming message and generates a reply
    public static String processMessage(Update update) {

        //check if the update has a message and the message has text
        if (update.getMessage().hasText()) {

            String apiUrl = "https://api.bluelytics.com.ar/v2/latest";
            String receivedMsg = update.getMessage().getText();     // user message
            //long chatId = update.getMessage().getChatId();

            if (receivedMsg.startsWith("/start") || receivedMsg.startsWith("/help")) {
                return menuCommands();

            } else if (receivedMsg.startsWith("/dolar")) {
                JsonAPIClient client = new JsonAPIClient(apiUrl);
                JsonToCurrencyRates converter = new JsonToCurrencyRates();
                CurrencyRates rates = converter.jsonToCurrencyRates(client.getJsonAsString());

                return dolarRatesReply(rates);

            } else if (receivedMsg.startsWith("/euro")) {
                JsonAPIClient client = new JsonAPIClient(apiUrl);
                JsonToCurrencyRates converter = new JsonToCurrencyRates();
                CurrencyRates rates = converter.jsonToCurrencyRates(client.getJsonAsString());

                return euroRatesReply(rates);

            } else {
                return "Unknown command\n" + menuCommands();
            }


        } else {
            return "Unknown msg type\n" + menuCommands();
        }
    }



    private static String dolarRatesReply(CurrencyRates currencyRates) {

        StringBuilder response = new StringBuilder();

        response.append("\t*** DOLAR ***\n");

        response.append("Oficial COMPRA: $").append(
                currencyRates.getOficialValues().getValueBuy())
                .append("\n");

        response.append("Oficial VENTA: $").append(
                currencyRates.getOficialValues().getValueSell())
                .append("\n");

        response.append("Blue COMPRA: $").append(
                currencyRates.getBlueValues().getValueBuy())
                .append("\n");

        response.append("Blue VENTA: $").append(
                currencyRates.getBlueValues().getValueSell())
                .append("\n\n");


        return response.toString();
    }

    public static String euroRatesReply(CurrencyRates currencyRates) {

        StringBuilder response = new StringBuilder();

        response.append("\t*** EURO ***\n");

        response.append("Oficial COMPRA: $").append(
                currencyRates.getOficialEuroValues().getValueBuy())
                .append("\n");

        response.append("Oficial VENTA: $").append(
                currencyRates.getOficialEuroValues().getValueSell())
                .append("\n");

        response.append("Blue COMPRA: $").append(
                currencyRates.getBlueEuroValues().getValueBuy())
                .append("\n");

        response.append("Blue VENTA: $").append(
                currencyRates.getBlueEuroValues().getValueSell())
                .append("\n\n");

        return response.toString();
    }

    public static String menuCommands() {
        return "/dolar para obtener la cotizacion oficial y blue del dólar\n" +
                "/euro para obtener la cotizacion oficial y blue del EURO";
    }
}
