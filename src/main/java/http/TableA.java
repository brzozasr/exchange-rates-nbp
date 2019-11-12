package http;

import enumtypes.CurrencyCodeTableA;
import exceptions.NBPDataException;
import models.rates.ExchangeRatesSeries;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static http.ReadHttpData.readJsonToString;
import static http.ReadJSON.readArrayOfExchangeRatesTable;
import static http.ReadJSON.readExchangeRatesSeries;

/**
 * Linki do kursów średnich walut obcych w złotych określonych w § 2 pkt 1 i 2 uchwały Nr 51/2002
 * Zarządu Narodowego Banku Polskiego z dnia 23 września 2002 r. w sprawie sposobu wyliczania
 * i ogłaszania bieżących kursów walut obcych (Dz. Urz. NBP z 2017 r. poz. 15).
 * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.,
 */
public class TableA {

    /*
     * Aktualnie obowiązująca tabela kursów typu A
     *
     * @return String w formie json
     * @throws IOException input / output exception
     */
    public String currentTable() throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/?format=json";
        return readJsonToString(link);
    }

    /*
     * Seria ostatnich {topCount} tabel kursów typu A
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 67)
     * @return String w formie json
     * @throws IOException input / output exception
     */
    public ArrayOfExchangeRatesTable lastTopCountTables(int topCount) throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/a/last/" + topCount + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Tabela kursów typu A opublikowana w dniu dzisiejszym (albo brak danych)
     *
     * @return String w formie json
     * @throws IOException input / output exception
     */
    public String tablePublishedToday() throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/today/?format=json";
        return readJsonToString(link);
    }

    /*
     * Tabela kursów typu A opublikowana w dniu {date} (albo brak danych)
     *
     * @param date data w formacie rrrr-MM-dd (standard ISO 8601)
     * @return String w formie json
     * @throws IOException input / output exception
     */
    public String tablePublishedOnDate(LocalDate date) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/" + formatDate + "/?format=json";
        return readJsonToString(link);
    }

    /*
     * Seria tabel kursów typu A opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych),
     * (limit dni 93)
     *
     * @param startDate data w formacie rrrr-MM-dd (standard ISO 8601)
     * @param endDate   data w formacie rrrr-MM-dd (standard ISO 8601)
     * @return String w formie json
     * @throws IOException input / output exception
     */
    public String tablesPublishedOnDateRange(LocalDate startDate, LocalDate endDate) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        return readJsonToString(link);
    }

    /**
     * Aktualnie obowiązujący kurs waluty {currencyCode} z tabeli kursów typu A
     *
     * @param currencyCodeTableA enum CurrencyCode (np. usd, gbp, chf)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output wyjątek (exception)
     */
    public ExchangeRatesSeries currentExchangeRate(CurrencyCodeTableA currencyCodeTableA) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} kursów waluty {currencyCode} z tabeli kursów typu A
     *
     * @param currencyCodeTableA enum CurrencyCode (np. usd, gbp, chf)
     * @param topCount     liczba określająca maksymalną liczność zwracanej serii danych
     *                     (limit wyników 255)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output wyjątek (exception)
     */
    public ExchangeRatesSeries lastTopCountExchangeRate(CurrencyCodeTableA currencyCodeTableA, int topCount) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/last/" + topCount + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }
}