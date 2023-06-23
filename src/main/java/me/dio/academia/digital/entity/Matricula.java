package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Cria getters e setters 
@NoArgsConstructor //Não permite a criacao de construtor vazio
@AllArgsConstructor //Gera um construtor com todos os atributos
@Entity //Anotacao para definir a classe como uma entidade, será criada uma tabela alunos no db
@javax.persistence.Table(name = "tb_matriculas") //Definindo o nome da tabela como alunos
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Matricula {
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public LocalDateTime getDataDaMatricula() {
		return dataDaMatricula;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
