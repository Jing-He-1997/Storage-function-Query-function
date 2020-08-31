package stage2;

public class Messier {

	private String number;
	private double ra;
	private double decl;
	private double magn;
	private double distance;
	private String constellation;
	private String decription;
	
	public Messier() {
		
	}
	
	public Messier(String number,double ra,double decl,double magn,double distance,String constellation,String decription) {
		
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setRa(double ra) {
		this.ra = ra;
	}

	public double getRa() {
		return ra;
	}

	public void setDecl(double decl) {
		this.decl = decl;
	}

	public double getDecl() {
		return decl;
	}

	public void setMagn(double magn) {
		this.magn = magn;
	}

	public double getMagn() {
		return magn;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setDescription(String description) {
		this.decription = description;
	}

	public String getDescription() {
		return decription;
	}

}
