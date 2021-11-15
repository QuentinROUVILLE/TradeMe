package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.domain.services.PaymentMethodService;
import fr.esgi.quentinrouville.common.domain.services.RegisterService;
import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.CreditCardPayment;

public class App
{
    public static void main( String[] args )
    {
        RegisterService registerService = new RegisterService();
        PaymentMethodService paymentMethodService = new PaymentMethodService();

        Member me = registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "password");

        me.setPaymentMethod(new CreditCardPayment("1234567890123456", "11/21", "123", "M QUENTIN ROUVILLE"));

        paymentMethodService.ProcessPayment(me.getMemberId(), 49.99);
    }
}
