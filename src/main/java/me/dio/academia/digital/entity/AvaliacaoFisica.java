package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;

@Data //Cria getters e setters 
@NoArgsConstructor //Não permite a criacao de construtor vazio
@AllArgsConstructor //Gera um construtor com todos os atributos
@Entity //Anotacao para definir a classe como uma entidade, será criada uma tabela alunos no db
@javax.persistence.Table(name = "tb_avaliacoes") //Definindo o nome da tabela como alunos
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AvaliacaoFisica{

  public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public LocalDateTime getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}
	public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY	)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL) //Anotacao que define que toda alteracao 
  //feita em AvaliacaoFisica será refletida em aluno
  @JoinColumn(name = "aluno_id") //Coluna que vai conter as foreignKeys (chaves estrangeiras)
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual")
  private double peso;
  @Column(name = "altura_atual")
  private double altura;

}
