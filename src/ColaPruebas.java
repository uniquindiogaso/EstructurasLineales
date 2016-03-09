import edu.uniquindio.gaso.ed.cola.Cola;

public class ColaPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola<Integer> cola = new Cola<Integer>();
		
		cola.enqueve(1);
		cola.enqueve(2);
		cola.enqueve(3);
		
		cola.dequeve();
		cola.dequeve();

	}

}
