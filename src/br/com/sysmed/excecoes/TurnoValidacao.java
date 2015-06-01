package br.com.sysmed.excecoes;

public enum TurnoValidacao {
	
	OPERACAO_BEM_SUCEDIDA(0, "Horario � valido"), 
	ERRO_HORAS_IGUAIS(1, "A hora final � igual a hora inicial"), 
	ERRO(2, "nao fa�a o que vc fez");

	private final int codigo;
	private final String descicao;

	public int getCodigo() {
		return codigo;
	}

	public String getDescicao() {
		return descicao;
	}

	private TurnoValidacao(int codigo, String descicao) {
		this.codigo = codigo;
		this.descicao = descicao;
	}

	@Override
	public String toString() {
		return this.codigo + ": " + this.descicao;
	}
}