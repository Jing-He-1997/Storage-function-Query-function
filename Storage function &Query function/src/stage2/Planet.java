package stage2;

public class Planet {

	private String name;
	private double ra;
	private double decl;
	private double magn;
	private double distance;
	private double albedo;
	
	public Planet() {
		
	}
	
	public Planet(String name,double ra,double decl,double magn,double distance,double albedo) {
		
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRa(Double ra) {
		this.ra = ra;
	}

	public Double getRa() {
		return ra;
	}

	public void setDecl(Double decl) {
		this.decl = decl;
	}

	public Double getDecl() {
		return decl;
	}

	public void setMagn(Double magn) {
		this.magn = magn;
	}

	public Double getMagn() {
		return magn;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getDistance() {
		return distance;
	}

	public void setAlbedo(double albedo) {
		this.albedo = albedo;
	}

	public double getAlbedo() {
		return albedo;
	}

}
