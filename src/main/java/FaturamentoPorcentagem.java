import java.util.ArrayList;
import java.util.List;

public class FaturamentoPorcentagem {
    public static void main(String[] args) {

        //Calcular porcentagem dos estados
        final List<AuxiliaryClass> values = new ArrayList<>();
        values.add(new AuxiliaryClass("SP", 67.83643));
        values.add(new AuxiliaryClass("RJ", 36.67866));
        values.add(new AuxiliaryClass("MG", 29.22988));
        values.add(new AuxiliaryClass("ES", 27.16548));
        values.add(new AuxiliaryClass("Outros", 19.84953));

        double sumValues = values.stream()
                .map(AuxiliaryClass::getValues)
                .reduce(Double::sum)
                .get();

        values.get(0).setValues((values.get(0).getValues()/sumValues) * 100);
        values.get(1).setValues((values.get(1).getValues()/sumValues) * 100);
        values.get(2).setValues((values.get(2).getValues()/sumValues) * 100);
        values.get(3).setValues((values.get(3).getValues()/sumValues) * 100);
        values.get(4).setValues((values.get(4).getValues()/sumValues) * 100);

        values.stream()
                .map(t -> t.getStates() + " - " + String.format("%.2f%%", t.getValues()) + "\n")
                .forEach(System.out::println);
    }
}

class AuxiliaryClass {

    private String states;
    private double values;

    public AuxiliaryClass(String states, double values) {
        this.states = states;
        this.values = values;
    }

    public String getStates() {
        return states;
    }

    public double getValues() {
        return values;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public void setValues(double values) {
        this.values = values;
    }
}

