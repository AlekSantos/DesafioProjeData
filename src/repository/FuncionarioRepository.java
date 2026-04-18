package repository;
import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public List<Funcionario> getTodos() {
        return funcionarios;
    }

    public void removerPorNome(String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }
}
