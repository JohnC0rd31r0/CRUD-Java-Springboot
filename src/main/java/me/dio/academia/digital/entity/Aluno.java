package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Não permite a criacao de construtor vazio
@AllArgsConstructor //Gera um construtor com todos os atributos
@Entity //Anotacao para definir a classe como uma entidade, será criada uma tabela alunos no db
@javax.persistence.Table(name = "tb_alunos") //Definindo o nome da tabela como alunos
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Aluno {

	@Id //Definindo o ID como chave primária no db
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gerando um valor a cada novo obj aluno para a coluna id
  private Long id;

  public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<AvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

private String nome;

  @Column(unique= true)
  private String cpf;

  public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //Criando relacao entre a tabela alunos e AvalicaoFisica de um para muitos
  //FetchType.LAZY informa que ao dar um get no objeto aluno, não deve ser retornado a avalicaoFisica, endpoint especifico para isso
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
