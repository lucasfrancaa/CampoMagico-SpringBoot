package br.com.campomagico.sistema.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.campomagico.sistema.model.Cargo;

@Repository
public interface Cargos extends JpaRepository<Cargo, Long> {

}
