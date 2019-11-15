package models.rates;

import java.util.List;

/**
 * Model kursów walut udostępniony jako kurs (lub seria kursów) pojedynczej waluty
 * dla określonego typu tabeli oraz symbolu waluty.
 */
public class ExchangeRatesSeries {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public ExchangeRatesSeries(String table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public ExchangeRatesSeries(List<Rate> rates) {
        this.rates = rates;
    }

    /**
     * Pobiera typ tabeli z obiektu ExchangeRatesSeries
     *
     * @return typ tabeli (np. "A", "B")
     */
    public String getTable() {
        return table;
    }

    /**
     * Pobiera nazwę waluty z obiektu ExchangeRatesSeries
     *
     * @return nazwa waluty (np. "dolar amerykański" lub z kursów archiwalnych "USA")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Pobiera trzyliterowy kod waluty (standard ISO 4217) z obiektu ExchangeRatesSeries
     *
     * @return kod waluty (np. "USD", "EUR")
     */
    public String getCode() {
        return code;
    }

    /**
     * Pobiera serię danych z notowań kursów walut z obiektu ExchangeRatesSeries
     *
     * @return listę kursów {List&#60;Rate&#62;} poszczególnych walut:<br>
     * no – numer tabeli<br>
     * effectiveDate – data publikacji<br>
     * mid – przeliczony kurs średni waluty
     */
    public List<Rate> getRates() {
        return rates;
    }

    //TODO usunąć
    @Override
    public String toString() {
        return "table: " + table + "\n" +
                "currency: " + currency + "\n" +
                "code: " + code + "\n" +
                "rates: " + rates + "\n";
    }
}
