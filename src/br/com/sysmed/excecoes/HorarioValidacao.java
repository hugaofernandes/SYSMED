package br.com.sysmed.excecoes;

public enum HorarioValidacao {

	OPERACAO_BEM_SUCEDIDA(0, "Horario � valido"), 
	ERRO(1, "nao fa�a o que vc fez");

	private final int codigo;
	private final String descicao;

	public int getCodigo() {
		return codigo;
	}

	public String getDescicao() {
		return descicao;
	}

	private HorarioValidacao (int codigo, String descicao) {
		this.codigo = codigo;
		this.descicao = descicao;
	}

	@Override
	public String toString() {
		return this.codigo + ": " + this.descicao;
	}
}
