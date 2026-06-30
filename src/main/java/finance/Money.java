package finance;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(long amount, String currency) {
    @Override
    public String toString() {
        return "%d%s".formatted(amount, currency);
    }

    public Money plus(Money m2) {
        if (this.currency().equals(m2.currency())) {
            return new Money(this.amount + m2.amount(), m2.currency());
        } else  {
            throw new IllegalArgumentException("both monies must have same currency");
        }
    }
}

//public class Money {
//
//    private long amount;
//    private String currency;
//    public Money(long amount, String currency) {
//        this.amount = amount;
//        this.currency = currency;
//    }
//
//    public long getAmount() {
//        return this.amount;
//    }
//
//    public String getCurrency(){
//        return this.currency;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if  (obj instanceof Money money) {
//            return this.amount == money.amount && currency.equals(money.currency);
//        } else
//            return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(amount, currency);
//    }
//
//    @Override
//    public String toString() {
//        return "%d%s".formatted(this.amount, this.currency);
//
//    }
//}
