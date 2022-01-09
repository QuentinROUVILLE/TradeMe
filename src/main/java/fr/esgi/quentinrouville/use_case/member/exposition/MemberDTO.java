package fr.esgi.quentinrouville.use_case.member.exposition;

import fr.esgi.quentinrouville.use_case.member.domain.EmailAddress;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.Password;
import fr.esgi.quentinrouville.use_case.member.domain.PaymentMethod;

public final class MemberDTO {
    public final MemberId id;
    public final String lastName;
    public final String firstName;
    public final EmailAddress email;
    public final Password password;
    public final PaymentMethod paymentMethod;

    private MemberDTO(MemberId id, String lastName, String firstName, EmailAddress email, Password password, PaymentMethod paymentMethod) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.paymentMethod = paymentMethod;
    }

    public static MemberDTO of(MemberId id, String lastName, String firstName, EmailAddress email, Password password, PaymentMethod paymentMethod) {
        return new MemberDTO(id, lastName, firstName, email, password, paymentMethod);
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email=" + email +
                ", password=" + password +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
