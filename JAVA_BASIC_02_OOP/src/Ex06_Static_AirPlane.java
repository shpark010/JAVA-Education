import kr.or.kosa.AirPlane;

public class Ex06_Static_AirPlane {

	public static void main(String[] args) {
//		AirPlane air1 = new AirPlane();
//		air1.createAirPlane(101, "대한항공");
//		
//		AirPlane air2 = new AirPlane();
//		air1.createAirPlane(102, "아시아나");
//		
//		air2.viewAmount();
		
		AirPlane air1 = new AirPlane(707, "대한항공");
		air1.confirm();
		air1.viewAmount();		
		
		AirPlane air2 = new AirPlane(708, "아시아나항공");
		air2.confirm();
		air2.viewAmount();
	}

}
