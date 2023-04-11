import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) throws IOException {

        //Faturamento de uma distribuidora
        var valuesJson = new FaturamentoDistribuidora()
                .jsonObject("C:\\Users\\Isaac\\Downloads\\dados.json");
        //Para testar, mudar o endereco onde se encontra o arquivo com os dados em json

        var valuesDiffZero = valuesJson.stream()
                .filter(t -> t.getValor() != 0)
                .toList();

        System.out.println("Menor valor de faturamento ocorrido em um dia do mes:\n" +
                valuesDiffZero.stream()
                        .min(Comparator.comparingDouble(PropertysData::getValor))
                        .get()
                        .getValor());

        System.out.println("Maior valor de faturamento ocorrido em um dia do mes:\n" +
                valuesDiffZero.stream()
                        .max(Comparator.comparingDouble(PropertysData::getValor))
                        .get()
                        .getValor());

        var average = valuesDiffZero.stream().map(PropertysData::getValor).reduce(Double::sum).get()/valuesDiffZero.size();
        System.out.println("Numero de dias no mes em que o valor de faturamento diario foi superior a media mensal:\n" +
                valuesDiffZero.stream()
                        .filter(t -> t.getValor() > average)
                        .count());
    }
}

class FaturamentoDistribuidora {
    public List<PropertysData> jsonObject(String file) throws IOException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(file);
        //tive que baixar o arquivo e arrumar o json que estava como list, por isso nao consumi pela web

        AuxiliaryPropertyClass auxiliaryPropertyClass = gson
                .fromJson(fileReader, AuxiliaryPropertyClass.class);

        return auxiliaryPropertyClass.value;
    }
}

class AuxiliaryPropertyClass {
    List<PropertysData> value;
}

class PropertysData {
    private int dia;
    private double valor;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
