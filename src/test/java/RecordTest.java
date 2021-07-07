import com.the.Util.TimeUtil;
import com.the.pojo.WorkRecord;
import com.the.service.RecordService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class RecordTest {
    @Test
    public void employeeLogin(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        RecordService service= (RecordService) context.getBean("recordServiceImpl");
        WorkRecord record=new WorkRecord(TimeUtil.getDate(),"tldj001",2,TimeUtil.getClock());
        int res= service.employeeLogin(record);
        System.out.println(res);
    }
    @Test
    public void employeeLogout(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        RecordService service= (RecordService) context.getBean("recordServiceImpl");
        int res= service.employeeLogout("tldj001");
        System.out.println(res);
    }



    @Test
    public void getRecord(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        RecordService service= (RecordService) context.getBean("recordServiceImpl");
        List<HashMap<String,String>> records= service.queryPeriodByEmpID();
        System.out.println(records);
    }
    @Test
    public void getRecords(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        RecordService service= (RecordService) context.getBean("recordServiceImpl");
        List<HashMap<String,String>> records= service.queryPeriodByEmpID("0",TimeUtil.getDate());
        System.out.println(records);
    }
    @Test
    public void getName(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        RecordService service= (RecordService) context.getBean("recordServiceImpl");
        List<HashMap<String,String>> map= service.queryNameByScenicID(1);
        System.out.println(map);
    }
}
