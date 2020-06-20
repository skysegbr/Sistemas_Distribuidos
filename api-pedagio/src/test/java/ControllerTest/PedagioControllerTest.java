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

    @Autowired
    private TransponderService transponderService;
    @Autowired
    private CameraService cameraService;

    @Test
    public void save() throws Exception {

        long qtd = 10;

        transponderService.deleteAll();
        for ( int i = 1 ; i <= qtd ; i++){
            transponderService.sendTagRabbit(new TransponderEntity("tag"+i, "232323"+i, "30/12/2020 20:20:20"));
        }

        Thread.sleep(5000);

        cameraService.deleteAll();
        for ( int i = 1 ; i <= qtd ; i++){
            cameraService.sendImageRabbit(new CameraEntity(i, "teste".getBytes()));
        }
    }

}
