import com.the.service.RecordService;
import com.the.service.ScenicService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class ScenicTest {
    @Test
    public void getScenic(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        ScenicService service= (ScenicService) context.getBean("scenicServiceImpl");
        List<HashMap<String,String>> res= service.getScenic();
        System.out.println(res);
    }
}
