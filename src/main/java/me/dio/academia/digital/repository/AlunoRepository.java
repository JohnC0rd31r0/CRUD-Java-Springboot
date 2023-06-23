package me.dio.academia.digital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>{
	
	//O corpo do método deve seguir o seguinte padrão ->
	// findBy -> Acao a ser feito
	// DataDeNascimento -> Variavel da classe Aluno -> Parametro utilizado na acao
	List<Aluno>findByDataDeNascimento(LocalDate dataDeNascimento);
}
