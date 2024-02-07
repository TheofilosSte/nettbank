package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.BankController;
import oslomet.testing.DAL.BankRepository;
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
public class EnhetstestBankController {

    @InjectMocks
    // denne skal testes
    private BankController bankController;

    @Mock
    // denne skal Mock'es
    private BankRepository repository;

    @Mock
    // denne skal Mock'es
    private Sikkerhet sjekk;
    @Test
    public void hentTransaksjoner_loggetInn(){
        //arrange
        List<Transaksjon> allTransaksjoner = new ArrayList<>();
        Transaksjon transaksjon1 = (21, "34", 232423.745, "3434445","435345","3523234","345345345");
        Transaksjon transaksjon2 = (261, "374", 2632423.745, "34344445","4335345","35223234","3453453455");
        allTransaksjoner.add(transaksjon1);
        allTransaskjoner.add(transaksjon2);
        when(sjekk.loggetInn()).thenReturn(personnummer);

        when(repository.hentTransaksjoner(anyString())).thenReturn(allTransaksjoner);
        //act
        Transaksjon action = bankController.hentTransaksjoner();
        //assert
        assertEquals(allTransaksjoner, action);


    }
    @Test
    public void hentTransaksjoner_ikkeLoggetInn();
    //arrange
    when(sjekk.loggetInn()).thenReturn(null);
    //act
    Transaksjon action = bankController.hentTransaksjoner();
    //assert
    assertNull(action);

    @Test
    public void hentKundeInfo_loggetInn() {

        // arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn("01010110523");

        when(repository.hentKundeInfo(anyString())).thenReturn(enKunde);

        // act
        Kunde resultat = bankController.hentKundeInfo();

        // assert
        assertEquals(enKunde, resultat);
    }

    @Test
    public void hentKundeInfo_IkkeloggetInn() {

        // arrange
        when(sjekk.loggetInn()).thenReturn(null);

        //act
        Kunde resultat = bankController.hentKundeInfo();

        // assert
        assertNull(resultat);
    }

    @Test
    public void hentKonti_LoggetInn()  {
        // arrange
        List<Konto> konti = new ArrayList<>();
        Konto konto1 = new Konto("105010123456", "01010110523",
                720, "Lønnskonto", "NOK", null);
        Konto konto2 = new Konto("105010123456", "12345678901",
                1000, "Lønnskonto", "NOK", null);
        konti.add(konto1);
        konti.add(konto2);

        when(sjekk.loggetInn()).thenReturn("01010110523");

        when(repository.hentKonti(anyString())).thenReturn(konti);

        // act
        List<Konto> resultat = bankController.hentKonti();

        // assert
        assertEquals(konti, resultat);
    }

    @Test
    public void hentKonti_IkkeLoggetInn()  {
        // arrange

        when(sjekk.loggetInn()).thenReturn(null);

        // act
        List<Konto> resultat = bankController.hentKonti();

        // assert
        assertNull(resultat);
    }
    @Test
    public void hentSaldi_loggetInn(){
        //arrange
        List<Konto> kontoen = new ArrayList<>();
        Konto konto1 = ("123456", "34343434", 205000, "spare", "nok", new ArrayList<>());
        Konto konto2 = ("453434", "78787878", 608000, "lønn", "nok", new ArrayList<>());
        Kontoen.add(konto1);
        Kontoen.add(konto2);
        when(sjekk.loggetInn()).thenReturn("123456");
        when(repository.hentSaldi(anyString())).thenReturn(kontoen);
        //act
        List<konto> result = bankController.hentSaldi();
        //assert
        assertEquals(kontoen, result);

    }
    @Test
    public void hentSaldi_ikkeLoggetInn(){
        //arrange
        when(sjekk.loggetInn()).thenReturn(null);
        //act
        List<Konto> result = bankController.hentSaldi();
        //assert
        assertNull(result);
    }
    @Test
    public void registrerBetaling_fullfort(){
        //arrange
        Transaksjon betaling = new Transaksjon(232, "23434", 500000, "04.10.2023", "hei",
                "3434", "4334545");

        when(db.update(anyString())).thenReturn(232);
        when(repository.registrerBetaling(anyString())).thenReturn(betaling);
        //act
        Transaksjon result = bankController.registrerBetaling();
        //assert
        assertEquals(betaling, result);
    }
    @Test
    public void registrerBetaling_ikkeFullfort(){
        //arrange
        when(db.update(anyString())).thenReturn(null);
        //act
        Transaksjon result = bankController.registrerBetaling();
        //assert
        assertNull(result);
    }
    @Test
    public void hentBetaling_fullfort(){
        //arrange
        List<Transaksjon> betallinger = new ArrayList<>();
        Transaksjon betalling1 = (21, "34", 232423.745, "3434445","435345","3523234","345345345");
        Transaksjon betalling2 = (261, "374", 2632423.745, "34344445","4335345","35223234","3453453455");
        betallinger.add(betalling1);
        betallinger.add(betalling2);
        when(sjekk.loggetInn()).thenReturn(personnummer);
        when(repository.hentbetallinger(anyString())).thenReturn(betallinger);
    }
    @Test
    public void hentBetaling_ikkeFullfort() {
        //arrange
        when(sjekk.loggetInn()).thenReturn(null);
        //act
        Transaksjon result = bankController.hentBetaling();
        //assert
        assertNull(result);
    }
    @Test
    public void utfortBetalingen(){
        //arrange
        Transaksjon enTransaksjon = new Transaksjon;

        //when(sjekk.loggetInn()).thenReturn("33");
        when(db.query(anyString(), any(), any(), any(), any(), any(), any(),"1" )).thenReturn(enTransaksjon);
        when(repository.hentBetaling(anyString())).thenReturn();
        //act
        Transaksjon result = bankController.hentBetaling();
        //assert
        assertEquals(kontoen, result);
    }
    @Test
    public void ikke_UtfortBetalingen(){
        //arrange
        when(db.query(anyString(), any(),any(), any(), any(), any(), any())).thenReturn(null);
        //act
        Transaksjon result = bankController.registrerBetaling();
        //assert
        assertNull(result);
}