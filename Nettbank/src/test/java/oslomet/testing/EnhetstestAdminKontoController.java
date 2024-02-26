package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.BankController;
import oslomet.testing.DAL.BankRepository;
import oslomet.testing.DAL.AdminRepository;
import oslomet.testing.Models.Konto;
import oslomet.testing.Models.Kunde;
import oslomet.testing.Sikkerhet.Sikkerhet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestAdminKontoController {

    @InjectMocks
    // denne skal testes
    private AdminKontoController adminKontoController;

    @Mock
    // denne skal Mock'es
    private AdminKontoRepository repository;

    @Mock
    // denne skal Mock'es
    private Sikkerhet sjekk;

    @Test
    public void hentAlleKonto_loggetInn(){
    //arrange
        List<Konto> kontoer = new ArrayList<>();
        Konto konto1 = new Konto("12","56",3434,45,"spare","nok",null);
        Konto konto2 =new Konto("23","57",223,7687,"spare","euro",null);
        kontoer.add(konto1);
        kontoer.add(konto2);
        when(sjekk.loggetInn()).thenReturn("12");
        when(repository.hentAlleKonti(anyString())).thenReturn(kontoer);
        //act
        List<Konto> result = adminKontoController.hentAlleKonti();
        //assert
        assertEquals(result, kontoer);

    }
    @Test
    public void hentAlleKunder_IkkeLoggetInn(){
        //arrange
        when(sjekk.loggetInn()).thenReturn(null);
        //act
        List<Konto> result = adminKontoController.hentAlleKonti();
        //assert
        assertNull(result);

    }
    @Test
    public void registrerKonto_loggetInn(){
        //arrange
        Konto enKonto = new Konto("56","767676",3434,4556,"spare","nok",null);
        when(sjekk.loggetInn()).thenReturn("56");
        when(repository.adminKontoController.registrerKonto()).thenReturn(enKonto);
        //act
        String result = adminKontoController.registrerKonto();
        //assert
        assertEquals(enKonto, result);

    }
    @Test
    public void registrerKonto_ikkeLoggetInn(){
        //arrange
        when(sjekk.loggetInn()).thenreturn(null);
        //act
        String result = adminKontoController.hentAlleKonti();
        //assert
        assertNull(result);
    }
    @Test
    public void endreKonto_loggetInn(){
        //arrange
        Konto enKonto = new Konto("576","7672676",34334,4556,"spare","nok",null);
        when(sjekk.loggetInn()).thenReturn("576");
        when(repository.adminKontoController.endreKonto()).thenReturn(enKonto);
        //act
        String result = adminKontoController.endreKonto();
        //assert
        assertEquals(enKonto, result);
    }
    @Test
    public void endreKonto_ikkeLoggetInn(){
        //arrange
        when(sjekk.loggetInn()).thenreturn(null);
        //act
        String result = adminKontoController.endreKonto();
        //assert
        assertNull(result);
    }
    @Test
    public void slettKonto_loggetInn(){
    //arrange

        Konto enKonto = new Konto("5476","76702676",348334,4556,"spare","nok",null);
    when(sjekk.loggetInn()).thenReturn("5476");
    when(repository.adminKontoController.SlettKonto()).thenReturn(enKonto);
    //act
    String result = adminKontoController.SlettKonto();
    //assert
    assertEquals(enKonto, result);
}
    @Test
    public void slettKonto_ikkeLoggetInn(){
        //arrange
        when(sjekk.loggetInn()).thenreturn(null);
        //act
        String result = adminKontoController.slettKonto();
        //assert
        assertNull(result);

}