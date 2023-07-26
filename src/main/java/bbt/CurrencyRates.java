package bbt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyRates {
    @JsonProperty("oficial")
    private CurrencyValues oficialValues;
    @JsonProperty("blue")
    private CurrencyValues blueValues;
    @JsonProperty("oficial_euro")
    private CurrencyValues oficialEuroValues;
    @JsonProperty("blue_euro")
    private CurrencyValues blueEuroValues;
    @JsonProperty("last_update")
    private String lastUpdate;

    // Getters
    public CurrencyValues getOficialValues() {
        return oficialValues;
    }

    public CurrencyValues getBlueValues() {
        return blueValues;
    }

    public CurrencyValues getOficialEuroValues() {
        return oficialEuroValues;
    }

    public CurrencyValues getBlueEuroValues() {
        return blueEuroValues;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }


    // Inner class to hold currency values
    public static class CurrencyValues {
        @JsonProperty("value_avg")
        private double valueAvg;
        @JsonProperty("value_sell")
        private double valueSell;
        @JsonProperty("value_buy")
        private double valueBuy;

        // Getters
        public double getValueAvg() {
            return valueAvg;
        }

        public double getValueSell() {
            return valueSell;
        }

        public double getValueBuy() {
            return valueBuy;
        }
    }
}
