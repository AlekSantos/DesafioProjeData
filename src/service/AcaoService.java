package service;
import model.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class AcaoService {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    // 3.3 - Imprimir Funcionários
    public void imprimirFuncionarios(List<Funcionario> lista) {
        lista.forEach(f -> System.out.printf("Nome: %-10s | Data: %s | Salário: %-12s | Função: %s%n",
                f.getNome(), f.getDataNascimento().format(dtf), nf.format(f.getSalario()), f.getFuncao()));
    }

    // 3.4 - Aumento de Salário
    public void darAumento(List<Funcionario> lista, double percentual) {
        BigDecimal fator = new BigDecimal(1 + (percentual / 100));
        lista.forEach(f -> f.setSalario(f.getSalario().multiply(fator)));
    }

    // 3.5 e 3.6 - Agrupar e Imprimir por Função
    public void imprimirAgrupadoPorFuncao(List<Funcionario> lista) {
        Map<String, List<Funcionario>> map = lista.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        map.forEach((funcao, funcList) -> {
            System.out.println("Função: " + funcao);
            funcList.forEach(f -> System.out.println("  - " + f.getNome()));
        });
    }

    // 3.8 - Aniversariantes meses específicos
    public void imprimirAniversariantes(List<Funcionario> lista, int... meses) {
        List<Integer> mesesList = Arrays.stream(meses).boxed().collect(Collectors.toList());
        lista.stream()
                .filter(f -> mesesList.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> System.out.println(f.getNome() + " faz aniversário em: " + f.getDataNascimento().format(dtf)));
    }

    // 3.9 - Maior Idade
    public void imprimirMaisVelho(List<Funcionario> lista) {
        Funcionario maisVelho = Collections.min(lista, Comparator.comparing(Funcionario::getDataNascimento));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade);
    }

    // 3.10 - Ordem Alfabética
    public void imprimirOrdemAlfabetica(List<Funcionario> lista) {
        lista.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f.getNome()));
    }

    // 3.11 - Total Salários
    public void imprimirTotalSalarios(List<Funcionario> lista) {
        BigDecimal total = lista.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total: " + nf.format(total));
    }

    // 3.12 - Salários Mínimos
    public void imprimirQtdSalariosMinimos(List<Funcionario> lista, BigDecimal valorMinimo) {
        lista.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(valorMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos.");
        });
    }
}