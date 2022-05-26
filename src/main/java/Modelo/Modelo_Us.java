package Modelo;
/**
 * Modelo para trabar sobre los cambops de DB
 * @author silva
 *
 */
public class Modelo_Us {
	private int id;
	private String Nombre_pila;
	private String Apellido_paterno;
	private String Apellido_materno;
	private String Servicio;
	private int Fecha_nacimiento;
	private String Plan;
	private String Estatus;
	/**
	 *  parametros representados para trabajaar  en  todo el proyecto 
	 * @param id
	 * @param nombre_pila
	 * @param apellido_paterno
	 * @param apellido_materno
	 * @param servicio
	 * @param fecha_nacimiento
	 * @param plan
	 * @param estatus
	 */
	public Modelo_Us(int id, String nombre_pila, String apellido_paterno, String apellido_materno, String servicio,
			int fecha_nacimiento, String plan, String estatus) {
		super();
		this.id = id;
		Nombre_pila = nombre_pila;
		Apellido_paterno = apellido_paterno;
		Apellido_materno = apellido_materno;
		Servicio = servicio;
		Fecha_nacimiento = fecha_nacimiento;
		Plan = plan;
		Estatus = estatus;
	}
	
	public Modelo_Us() {
	}
/**
 * se implementan getters y setters para llamarlos desde cualquier proceso 
 * 
 *
 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_pila() {
		return Nombre_pila;
	}

	public void setNombre_pila(String nombre_pila) {
		Nombre_pila = nombre_pila;
	}

	public String getApellido_paterno() {
		return Apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		Apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return Apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		Apellido_materno = apellido_materno;
	}

	public String getServicio() {
		return Servicio;
	}

	public void setServicio(String servicio) {
		Servicio = servicio;
	}

	public int getFecha_nacimiento() {
		return Fecha_nacimiento;
	}

	public void setFecha_nacimiento(int fecha_nacimiento) {
		Fecha_nacimiento = fecha_nacimiento;
	}

	public String getPlan() {
		return Plan;
	}

	public void setPlan(String plan) {
		Plan = plan;
	}

	public String getEstatus() {
		return Estatus;
	}

	public void setEstatus(String estatus) {
		Estatus = estatus;
	}

	@Override
	public String toString() {
		return "Modelo_Us [id=" + id + ", Nombre_pila=" + Nombre_pila + ", Apellido_paterno=" + Apellido_paterno
				+ ", Apellido_materno=" + Apellido_materno + ", Servicio=" + Servicio + ", Fecha_nacimiento="
				+ Fecha_nacimiento + ", Plan=" + Plan + ", Estatus=" + Estatus + "]";
	}
	
	
	
	
	
}
