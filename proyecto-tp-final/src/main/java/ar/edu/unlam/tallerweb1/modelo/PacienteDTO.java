package ar.edu.unlam.tallerweb1.modelo;

	public class PacienteDTO {
	private Paciente paciente;
	private Plan plan;
	private String intensidad;
	private boolean excluirCarne;
	private boolean excluirLacteos;
	private boolean aptoHipertenso;
	private boolean aptoCeliaco;
	private String [] alimentosExcluidos;
	private String [] enfermedadesPadecidas;
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public String getIntensidad() {
		return intensidad;
	}
	public void setIntensidad(String intensidad) {
		this.intensidad = intensidad;
	}
	public boolean isExcluirCarne() {
		return excluirCarne;
	}
	public void setExcluirCarne(boolean excluirCarne) {
		this.excluirCarne = excluirCarne;
	}
	public boolean isExcluirLacteos() {
		return excluirLacteos;
	}
	public void setExcluirLacteos(boolean excluirLacteos) {
		this.excluirLacteos = excluirLacteos;
	}
	public boolean isAptoHipertenso() {
		return aptoHipertenso;
	}
	public void setAptoHipertenso(boolean aptoHipertenso) {
		this.aptoHipertenso = aptoHipertenso;
	}
	public boolean isAptoCeliaco() {
		return aptoCeliaco;
	}
	public void setAptoCeliaco(boolean aptoCeliaco) {
		this.aptoCeliaco = aptoCeliaco;
	}
	public String[] getAlimentosExcluidos() {
		return alimentosExcluidos;
	}
	public void setAlimentosExcluidos(String[] alimentosExcluidos) {
		this.alimentosExcluidos = alimentosExcluidos;
	}
	public String[] getEnfermedadesPadecidas() {
		return enfermedadesPadecidas;
	}
	public void setEnfermedadesPadecidas(String[] enfermedadesPadecidas) {
		this.enfermedadesPadecidas = enfermedadesPadecidas;
	}


}
