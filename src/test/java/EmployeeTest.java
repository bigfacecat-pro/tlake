import com.the.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class EmployeeTest {
    @Test
    public void getName(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service= (EmployeeService) context.getBean("employeeServiceImpl");
        HashMap<String,String> records= service.getEmployeeByID("tldj001");
        System.out.println(records);
    }
    @Test
    public void getList(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service= (EmployeeService) context.getBean("employeeServiceImpl");
        List<HashMap<String,String>> records= service.getEmployeeByKeyword("王");
        System.out.println(records);
    }
}
