import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HospitalTest {

    @Test
    public void test() throws Exception{
        ArrayList datos = new ArrayList();

        datos.add("José,Consulta General");
        datos.add("Paola, A,");
        datos.add("Miguel, Apendicitis,A");

        Hospital h = new Hospital();
        h.setDatos(datos);
        h.manejoHospital();

    }

}