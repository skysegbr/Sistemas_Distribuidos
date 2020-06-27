package ControllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import br.com.pedagio.MyApplication;
import br.com.pedagio.model.CameraEntity;
import br.com.pedagio.model.TransponderEntity;
import br.com.pedagio.service.CameraService;
import br.com.pedagio.service.TransponderService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class PedagioControllerTest {

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    @Autowired
    private TransponderService transponderService;
    @Autowired
    private CameraService cameraService;

    @Test
    public void save() throws Exception {

        long qtd = 20;
        cameraService.deleteAll();
        transponderService.deleteAll();
        //Thread.sleep(2000);


        for (int i = 1; i <= qtd ; i++){
            transponderService.sendTagRabbit(
                new TransponderEntity("tag" + i, "232323" + i, "30/12/2020 20:20:20")
            );
            cameraService.sendImageRabbit(new CameraEntity(i, "teste".getBytes()));
            System.out.println("tag" + i);
        }

        //Thread.sleep(5000);
        //hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d")
        



        for (int i = 1 ; i < qtd ; i++){
            cameraService.sendImageRabbit(new CameraEntity(i, "teste".getBytes()));
        }
    }

}
