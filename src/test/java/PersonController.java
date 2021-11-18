import com.example.sweater.UserRep;
import com.example.sweater.UserService;
import com.example.sweater.models.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/*@MockBean
  MyRepository myRepository;

  @Test
  void testMy() {
    MyService myService = new MyService();
    int size = myService.findAll().size();
    Assertions.assertEquals(0, size);
  }*/
@RunWith(SpringRunner.class)
public class PersonController {
    @Mock
    UserRep myRepository;

    @Test
    public void testMy() {

        UserService myService = new UserService(myRepository);


        int size = myService.getUsers().size();
        Assertions.assertEquals(0, size);
    }
}