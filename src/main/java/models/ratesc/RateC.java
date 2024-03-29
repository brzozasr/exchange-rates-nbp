package models.ratesc;

import java.time.LocalDate;

/**
 * Model kursów kupna i sprzedaży walut obcych pojedynczej waluty osadzony w modelu {ExchangeRatesSeriesC}
 * dla tabeli typu C oraz symbolu waluty.
 */
public class RateC {

    private String no;
    private LocalDate effectiveDate;
    private double bid;
    private double ask;

    /**
     * Konstruktor obiektu RateC
     *
     * @param no            numer tabel
     * @param effectiveDate data publikacji
     * @param bid           przeliczony kurs kupna waluty (dotyczy tabeli C)
     * @param ask           przeliczony kurs sprzedaży waluty (dotyczy tabeli C)
     */
    public RateC(String no, LocalDate effectiveDate, double bid, double ask) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.bid = bid;
        this.ask = ask;
    }

    /**
     * Pobiera numer tabeli, w której jest zmieszczone notowanie kursu kupna i sprzedaży waluty z obiektu ExchangeRatesSeriesC
     *
     * @return numer tabeli (np. "064/C/NBP/2016")
     */
    public String getNo() {
        return no;
    }

    /**
     * Pobiera datę publikacji notowania kupna i sprzedaży waluty z obiektu ExchangeRatesSeriesC
     *
     * @return data publikacji (np. "2016-04-04")
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Pobiera przeliczony kurs kupna waluty z obiektu ExchangeRatesSeriesC
     *
     * @return przeliczony kurs kupna waluty (np. "3.8601")
     */
    public double getBid() {
        return bid;
    }

    /**
     * Pobiera przeliczony kurs sprzedaży waluty z obiektu ExchangeRatesSeriesC
     *
     * @return przeliczony kurs sprzedaży waluty (np. "3.9381")
     */
    public double getAsk() {
        return ask;
    }
}
