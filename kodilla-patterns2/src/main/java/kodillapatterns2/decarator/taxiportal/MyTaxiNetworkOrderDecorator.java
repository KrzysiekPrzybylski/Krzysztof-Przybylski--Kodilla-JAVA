package kodillapatterns2.decarator.taxiportal;

import java.math.BigDecimal;

public class MyTaxiNetworkOrderDecorator extends AbstractTaxiOrderDecorator{
    protected MyTaxiNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(30));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by MyTaxi Network";
    }
}
