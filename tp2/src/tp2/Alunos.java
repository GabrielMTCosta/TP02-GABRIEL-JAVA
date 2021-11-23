package tp1;

public class Alunos {
	String nomecaps;
	float av1;
	float av2;
	
	public Alunos() {
	}
	
	public Alunos(String nomecaps, float av1, float av2){
		this.nomecaps = nomecaps;
		this.av1 = av1;
		this.av2 = av2;
	}
	public void setAluno(String nomecaps) {
		this.nomecaps = nomecaps;
	}
	public void setAv1(float av1) {
		this.av1 = av1;
	}
	public void setAv2(float av2) {
		this.av2 = av2;
	}
	
	public String pegaAluno() {
		return nomecaps;
	}
	
	public float pegaAv1() {
		return av1;
	}
	
	public float pegaAv2() {
		return av2;
	}
}
