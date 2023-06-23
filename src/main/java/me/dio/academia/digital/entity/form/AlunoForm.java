package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {
	//NotBlank - Não pode ser vazio, apenas para caracteres 
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validateValue} precisa estar entre {min} e {max} caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@CPF(message = "'${validateValue}' é invalido!") //CPF validador
	private String cpf;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validateValue} precisa estar entre {min} e {max} caracteres.")
	private String bairro;
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Past(message = "Data '${validateValue} é inválida'") //Anottation que permite apenas data no passado
	private LocalDate dataDeNascimento;
	
	public String getNome(){
		return nome;
	}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
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
}
