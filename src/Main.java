import model.Funcionario;
import repository.FuncionarioRepository;
import service.AcaoService;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FuncionarioRepository repo = new FuncionarioRepository();
        AcaoService service = new AcaoService();

        // 3.1 - Inserir via função (armazenando na lista interna do Repository)
        repo.adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        repo.adicionarFuncionario(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        repo.adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        repo.adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        repo.adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        repo.adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        repo.adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        repo.adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        repo.adicionarFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        repo.adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover João
        repo.removerPorNome("João");

        // Execução das Ações via Service
        System.out.println("--- 3.3 Lista Atualizada ---");
        service.imprimirFuncionarios(repo.getTodos());

        System.out.println("\n--- 3.4 Aplicando 10% de aumento ---");
        service.darAumento(repo.getTodos(), 10);

        System.out.println("--- Lista Atualizada Após o aumento ---");
        service.imprimirFuncionarios(repo.getTodos());

        System.out.println("\n--- 3.6 Funcionários por Função ---");
        service.imprimirAgrupadoPorFuncao(repo.getTodos());

        System.out.println("\n--- 3.8 Aniversariantes (10 e 12) ---");
        service.imprimirAniversariantes(repo.getTodos(), 10, 12);

        System.out.println("\n--- 3.9 Funcionário Mais Velho ---");
        service.imprimirMaisVelho(repo.getTodos());

        System.out.println("\n--- 3.10 Ordem Alfabética ---");
        service.imprimirOrdemAlfabetica(repo.getTodos());

        System.out.println("\n--- 3.11 Total Salários ---");
        service.imprimirTotalSalarios(repo.getTodos());

        System.out.println("\n--- 3.12 Quantidade de Salários Mínimos ---");
        service.imprimirQtdSalariosMinimos(repo.getTodos(), new BigDecimal("1212.00"));
    }
}