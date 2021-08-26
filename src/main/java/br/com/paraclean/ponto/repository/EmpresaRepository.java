package br.com.paraclean.ponto.repository;

import br.com.paraclean.ponto.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
}
