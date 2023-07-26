package bbt;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToCurrencyRates {

    public CurrencyRates jsonToCurrencyRates (String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CurrencyRates currencyRates = objectMapper.readValue(json, CurrencyRates.class);

            return currencyRates;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
