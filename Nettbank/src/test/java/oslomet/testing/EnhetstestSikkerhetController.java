package oslomet.testing.Sikkerhet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.testing.DAL.BankRepository;

import javax.servlet.http.HttpSession;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestSikkerhetController {
    @InjectMocks
    private SikkerhetController sikkerhetController;

    @Mock
    private BankRepository repository;

    @Mock
    private HttpSession session;
}
    Map<String,Object> attributes = new HashMap<String,Object>();

    doAnswer(new Answer<Object>(){
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            String key = (String) invocation.getArguments()[0];
            return attributes.get(key);
        }
    }).when(session).getAttribute(anyString());

        doAnswer(new Answer<Object>(){
@Override
public Object answer(InvocationOnMock invocation) throws Throwable {
        String key = (String) invocation.getArguments()[0];
        Object value = invocation.getArguments()[1];
        attributes.put(key, value);
        return null;
        }
        }).when(session).setAttribute(anyString(), any());
@Test
public void loggeInnValid(){
    //arrange
String personnummer = "12345678911";
String passord = "administrator"
        when(bankRepository.sjekkLoggInn(personnummer, passord)).thenReturn("ok");
//act
    String resultat = sikkerhetController.sjekkLoggInn(personnummer, passord);
    //assert
    assertEquals("ok", resultat);
}
@Test
public void loggUtValid(){
    //arrange
session.setAttribute("innlogget", "12345678901");
//act
    sikkerhetController.loggUt();
    String resultat= (String)session.getAttribute("innlogget");

    //asert
    assertNull(resultat);
}
@Test
public void loggetInnAdmin(){
    //arange
String bruker = "admin";
String passord = "1234";
session.setAttribute("innlogget", bruker);

//act
    String result = sikkerhetController.loggInnAdmin();
    //assert
    assertEquals("logget Inn", result);
}
@Test
public void IkkeLoggetInnAdmin(){
    //arange
   session.setAttribute("innLogget","null");
   //act
   sikkerhetController.loggUt();
   String result = (String) session.getAttribute("innlogget");
  //assert
    assertNull(result);
}