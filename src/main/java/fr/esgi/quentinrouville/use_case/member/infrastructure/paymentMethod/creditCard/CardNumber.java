package fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard;

import fr.esgi.quentinrouville.use_case.error.infrastructure.CardNumberValidationException;

import java.util.Objects;

public final class CardNumber
{
    private final String number;

    private CardNumber(String number)
    {
        if(!numberIsValid(number)){
            throw new CardNumberValidationException();
        }
        this.number = number;
    }

    public static CardNumber of(String number)
    {
        return new CardNumber(number);
    }

    public boolean numberIsValid(String number)
    {
        return number.matches("^[0-9]{16}$");
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardNumber)) return false;
        CardNumber that = (CardNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
