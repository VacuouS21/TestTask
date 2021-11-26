import com.example.sweater.repositories.UserRep;
import com.example.sweater.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


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