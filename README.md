# exchange-rates-nbp API for Java [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.brzozasr/exchange-rates-nbp/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.brzozasr/exchange-rates-nbp) [![javadoc](https://javadoc.io/badge2/com.github.brzozasr/exchange-rates-nbp/javadoc.svg)](https://javadoc.io/doc/com.github.brzozasr/exchange-rates-nbp)
Exchange rates and gold quotations NBP (Narodowy Bank Polski, National Bank of Poland) API
***
### Apache Maven
```apache maven
<dependency>
  <groupId>com.github.brzozasr</groupId>
  <artifactId>exchange-rates-nbp</artifactId>
  <version>1.0.0</version>
</dependency>
```
### Gradle Groovy DSL
```gradle
dependencies {
   implementation 'com.github.brzozasr:exchange-rates-nbp:1.0.0'
}
```
### Scala SBT
```scala stb
libraryDependencies += "com.github.brzozasr" % "exchange-rates-nbp" % "1.0.0"
```
***
## Examples:
Middle exchange rates of foreign currencies – table A (multi currency tables, last 30)
```java
try {
         ArrayOfExchangeRatesTable arrayERT = new TableA().lastTopCountTables(30);

         for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
              System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
              System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
              System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
              for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                 System.out.println(
                      // applies to archive exchange rates, it could return null value
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                      // applies to archive exchange rates, it could return null value
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
               }
            }
      } catch (IOException e) {
          e.printStackTrace();
      }
```
Middle exchange rates of foreign currencies – table A (multi currency table from a specific date)
```java
try {
         ArrayOfExchangeRatesTable arrayERT = new TableA().publishedOnDateTable(LocalDate.of(2010, 2, 25));
         for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
             System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
             System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
             System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
             for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                 System.out.println(
                       // it could return null value
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                       // it could return null value
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                       // it could return null value
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
             }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
```
Middle exchange rates of foreign currencies – table A (for single currency, from January 2, 2002 to the current date)
```java
try {
            ExchangeRatesSeries ers = new TableA().currencyExchangeRate(CurrencyCodeTableA.USD);

            System.out.println("== Example no 1 ====================================================");
            for (int i = 0; i < ers.getRates().size(); i++) {
                System.out.println(ers.getRates().get(i).getNo() +
                        " - " + ers.getRates().get(i).getEffectiveDate() +
                        " - " + ers.getRates().get(i).getMid());
            }

            System.out.println("== Example no 2 ====================================================");
            for(Rate element: ers.getRates()) {
                System.out.println(element.getNo() +
                        " -- " + element.getEffectiveDate() +
                        " -- " + element.getMid());
            }

            System.out.println("== Example no 3 ====================================================");
            ers.getRates().forEach(
                    element -> System.out.println(element.getNo() +
                            " --- " + element.getEffectiveDate() +
                            " --- " + element.getMid()));

        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (currently valid table)
```java
try {
            ArrayOfExchangeRatesTable arrayERT = new TableB().currentTable();

            for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (tables published in a date range)
```java
try {
            ArrayOfExchangeRatesTable arrayERT = new TableB().publishedOnDateRangeTables(
                    LocalDate.of(2003, 2, 25),
                    LocalDate.of(2003, 5, 20));
            for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (currently valid exchange rates for single currency)
```java
try {
          ExchangeRatesSeries exchangeRatesSeries = new TableB().currentExchangeRate(CurrencyCodeTableB.RUB);
          System.out.println(exchangeRatesSeries.getTable());
          System.out.println(exchangeRatesSeries.getCountry());
          System.out.println(exchangeRatesSeries.getSymbol());
          System.out.println(exchangeRatesSeries.getCurrency());
          System.out.println(exchangeRatesSeries.getCode());
          System.out.println(exchangeRatesSeries.getRates().get(0).getNo()
                  + " <-> " + exchangeRatesSeries.getRates().get(0).getEffectiveDate() +
                  " <-> " + exchangeRatesSeries.getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (for single currency, from January 2, 2002 to the current date)
```java
try {
        ExchangeRatesSeries exchangeRatesSeries = new TableB().currencyExchangeRate(CurrencyCodeTableB.EGP);

        System.out.println("== Example no 1 ====================================================");
        for (int i = 0; i < exchangeRatesSeries.getRates().size(); i++) {
            System.out.println(exchangeRatesSeries.getRates().get(i).getNo()
                    + " <-> " + exchangeRatesSeries.getRates().get(i).getEffectiveDate()
                    + " <-> " + exchangeRatesSeries.getRates().get(i).getMid());
        }

        System.out.println("== Example no 2 ====================================================");
        for (Rate element : exchangeRatesSeries.getRates()) {
            System.out.println(element.getNo() +
                    " -- " + element.getEffectiveDate() +
                    " -- " + element.getMid());
        }

        System.out.println("== Example no 3 ====================================================");
        exchangeRatesSeries.getRates().forEach(
                element -> System.out.println(element.getNo() +
                        " --- " + element.getEffectiveDate() +
                        " --- " + element.getMid()));

    } catch (IOException e) {
        e.printStackTrace();
    }
```
Buy and sell prices of foreign currencies – table C
```java
try {
            ArrayOfExchangeRatesTableC arrayOfExchangeRatesTableC = new TableC().publishedOnDateRangeTables(
                    LocalDate.of(2015, 7, 1),
                    LocalDate.of(2015, 9, 30));
            for (int i = 0; i < arrayOfExchangeRatesTableC.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getTradingDate());
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(
                            // it could return null value
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                            // it could return null value
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                            // it could return null value
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getBid() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getAsk());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```
