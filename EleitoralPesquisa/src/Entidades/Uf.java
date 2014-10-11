package Entidades;

public enum Uf {
	
	AC("AC"),
	AL("AL"),
	AM("AM"),
	AP("AP"),
	BA("BA"),
	CE("CE"),
	DF("DF"),
	ES("ES"),
	GO("GO"),
	MA("MA"),
	MG("MG"),
	MS("MS"),
	MT("MT"),
	PA("PA"),
	PB("PB"),
	PE("PE"),
	PI("PI"),
	PR("PR"),
	RJ("RJ"),
	RN("RN"),
	RO("RO"),
	RR("RR"),
	RS("RS"),
	SC("SC"),
	SE("SE"),
	SP("SP"),
	TO("TO");

	Uf(String uf){
		this.ufDetalhado = uf;
	}
	
	private String ufDetalhado;
	
	public String getUfDetalhado(){
		return ufDetalhado;
	}
}