package fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard;

import fr.esgi.quentinrouville.use_case.error.infrastructure.SecurityCodeValidationException;

import java.util.Objects;

public final class CardSecurityCode {
    private final String securityCode;

    private CardSecurityCode(String securityCode) {
        if(!securityCodeIsValid(securityCode)) {
            throw new SecurityCodeValidationException();
        }
        this.securityCode = securityCode;
    }

    public static CardSecurityCode of(String securityCode) {
        return new CardSecurityCode(securityCode);
    }

    private boolean securityCodeIsValid(String securityCode) {
        return securityCode.matches("^[0-9]{3}$");
    }

    @Override
    public String toString() {
        return securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardSecurityCode)) return false;
        CardSecurityCode that = (CardSecurityCode) o;
        return securityCode.equals(that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityCode);
    }
}
