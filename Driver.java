import java.util.Objects;

public class Driver {
    public static void main(String[] args) {
        SalesPerson[] salesPeople = new SalesPerson[6];

        salesPeople[0] = new SalesPerson("100");
        salesPeople[1] = new SalesPerson("101");
        salesPeople[2] = new SalesPerson("102");

        salesPeople[0].setSalesHistory(new Sales("A100", 300.00, 10));
        salesPeople[0].setSalesHistory(new Sales("A200", 1000.00, 2));
        salesPeople[1].setSalesHistory(new Sales("A300", 2550.40, 10));

        System.out.println(salesPeople[2].getId() + ";");
        System.out.println(salesPeople[0].getCount() + ";");
        System.out.println(salesPeople[1].getSalesHistory(0).getValue() + ";");
        System.out.println(salesPeople[0].calcTotalSales() + ";");
    }

    public String highest(SalesPerson[] salesPeople) {
        int index = 0;
        for (int i = 1; i < salesPeople.length; i++) {
            if (salesPeople[i].calcTotalSales() > salesPeople[index].calcTotalSales()) {
                index = i;
            }
        }
        return salesPeople[index].getId();
    }

    public void addSales(Sales s, String id, SalesPerson[] salesPeople) {
        for (SalesPerson salesPerson : salesPeople) {
            if (Objects.equals(salesPerson.getId(), id)) {
                salesPerson.setSalesHistory(s);
                break;
            }
        }
    }
}