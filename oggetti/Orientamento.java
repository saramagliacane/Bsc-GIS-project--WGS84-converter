package oggetti;

/**
 * Questo file specifica l'orientamento della superficie di riferimento rispetto
 * a quella del WGS84.
 *
 */
public class Orientamento {
	
	double translation_xy;
	double translation_yz;
	double translation_xz;
	double rotation_x;
	double rotation_y;
	double rotation_z;
	double refactor;
	
	/**
	 * Costruttore standard senza rotazioni della superficie di riferimento
	 * @param translation_xy traslazione del piano xy
	 * @param translation_yz traslazione del piano yz
	 * @param translation_xz traslazione del piano xz
	 */
	public Orientamento(double translation_yz, double translation_xz, double translation_xy) {
		this.translation_xy = translation_xy;
		this.translation_yz = translation_yz;
		this.translation_xz = translation_xz;
		this.rotation_x = 0;
		this.rotation_y = 0;
		this.rotation_z = 0;
		this.refactor = 0;
	}
	
	/**
	 * Costruttore completo con rotazioni.
	 * @param translation_xy traslazione del piano xy
	 * @param translation_yz traslazione del piano yz
	 * @param translation_xz traslazione del piano xz
	 * @param rotation_xy rotazione sull'asse x
	 * @param rotation_xz rotazione sull'asse y
	 * @param rotation_yz rotazione sull'asse z
	 */
	public Orientamento(double translation_yz, double translation_xz, double translation_xy, 
			double refactor) {
		this.translation_xy = translation_xy;
		this.translation_yz = translation_yz;
		this.translation_xz = translation_xz;
		this.refactor = refactor;
	}
	
	/**
	 * Costruttore completo con rotazioni.
	 * @param translation_xy traslazione del piano xy
	 * @param translation_yz traslazione del piano yz
	 * @param translation_xz traslazione del piano xz
	 * @param rotation_xy rotazione sull'asse x
	 * @param rotation_xz rotazione sull'asse y
	 * @param rotation_yz rotazione sull'asse z
	 * @param refactor rifattorizzazione
	 */
	
	public Orientamento(double translation_yz, double translation_xz, double translation_xy, 
			double refactor, double rotation_x, double rotation_y, double rotation_z) {
		this.translation_xy = translation_xy;
		this.translation_yz = translation_yz;
		this.translation_xz = translation_xz;
		this.rotation_x = rotation_x;
		this.rotation_y = rotation_y;
		this.rotation_z = rotation_z;
		this.refactor = refactor;
	}
	
	/**
	 * centro: nel centro di massa della terra
	 * asse Z: passante per il polo Nord, come definito dal BIH nel 1984
	 * asse X: passante per il meridiano di Greenwich, come definito dal BIH nel 1984
	 * asse Y: scelto in modo da dare una terna destrorsa, ovvero tale che un osservatore posto lungo l'asse Z veda l'asse X sovrapporsi a Y con moto antiorario, il che pone Y in Asia.
	 */
	public static final Orientamento WGS84 = new Orientamento(0,0,0);
	
	/**
	 * Elissoide Internazionale Hayford con orientamento medio europeo.
	 */
	public static final Orientamento ED50 = new Orientamento(-87,-98,-121);
	
	public static final Orientamento ITA40 = new Orientamento(-104.1,-49.1,-9.9,-11.68,0.971,-2.917,0.714);

	public double getTranslation_xy() {
		return translation_xy;
	}

	public double getTranslation_yz() {
		return translation_yz;
	}

	public double getTranslation_xz() {
		return translation_xz;
	}

	public double getRotation_x() {
		return rotation_x;
	}

	public double getRotation_y() {
		return rotation_y;
	}

	public double getRotation_z() {
		return rotation_z;
	}

	public double getRefactor() {
		return refactor;
	}
	
}
