package br.com.campomagico.sistema.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.campomagico.sistema.model.Funcionario;

@Repository
public interface Funcionarios extends JpaRepository<Funcionario, Long> {

}
