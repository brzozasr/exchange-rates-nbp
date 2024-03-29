package models.tables;

import java.time.LocalDate;
import java.util.List;

/**
 * Model kompletnej tabeli kursowej osadzony w modelu {ArrayOfExchangeRatesTable}
 * dla określonego typu tabeli.
 */
public class ExchangeRatesTable {
    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<RateTables> rates;

    /**
     * Konstruktor obiektu ExchangeRatesTable
     *
     * @param table         typ tabeli
     * @param no            numer tabeli
     * @param effectiveDate data publikacji
     * @param rates         lista notowań walut {List&#60;RateTables&#62;}
     */
    public ExchangeRatesTable(String table, String no, LocalDate effectiveDate, List<RateTables> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    /**
     * Pobiera typ tabeli z obiektu ArrayOfExchangeRatesTable
     *
     * @return typ tabeli (np. "A", "B")
     */
    public String getTable() {
        return table;
    }

    /**
     * Pobiera numer tabeli, w której są zamieszczone notowania średnie walut z obiektu ArrayOfExchangeRatesTable
     *
     * @return numer tabeli (np. "090/A/NBP/2012")
     */
    public String getNo() {
        return no;
    }

    /**
     * Pobiera datę publikacji tabeli notowań średnich walut z obiektu ArrayOfExchangeRatesTable
     *
     * @return data publikacji (np. "2012-05-10")
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Pobiera listę kursów poszczególnych walut w tabeli z obiektu ArrayOfExchangeRatesTable
     *
     * @return listę kursów poszczególnych walut w tabeli {List&#60;RateTables&#62;}:<br>
     * country - nazwa kraju<br>
     * symbol - symbol waluty (numeryczny, dotyczy kursów archiwalnych)<br>
     * currency - nazwa waluty (np. "dolar amerykański")<br>
     * code - kod waluty (np. "USD", "EUR")<br>
     * mid - przeliczony kurs średni waluty (np. "3.2735")
     */
    public List<RateTables> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesTable{" +
                "table='" + table + '\'' +
                ", no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", rates=" + rates +
                "}\n";
    }
}
