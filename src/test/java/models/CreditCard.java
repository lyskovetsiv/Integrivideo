package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreditCard {

    private String cardNumber;
    private String cardMonth;
    private String cardYear;
    private String cardHolderName;
}
