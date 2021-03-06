import com.the.Util.TimeUtil;
import com.the.pojo.WorkRecord;
import com.the.service.EmployeeRecordService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class RecordTest {
    @Test
    public void employeeLogin(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRecordService service= (EmployeeRecordService) context.getBean("employeeRecordServiceImpl");
        WorkRecord record=new WorkRecord(TimeUtil.getDate(),"tldj001",2,TimeUtil.getClock());
        int res= service.employeeLogin(record);
        System.out.println(res);
    }
    @Test
    public void employeeLogout(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRecordService service= context.getBean("employeeRecordServiceImpl", EmployeeRecordService.class);
        int res= service.employeeLogout("tldj001");
        System.out.println(res);
    }



    @Test
    public void getRecord(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRecordService service= (EmployeeRecordService) context.getBean("employeeRecordServiceImpl");
        List<HashMap<String,String>> records= service.queryPeriod(TimeUtil.getDate(),TimeUtil.getDate());
        System.out.println(records);
    }
    @Test
    public void getRecords(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRecordService service= (EmployeeRecordService) context.getBean("employeeRecordServiceImpl");
        List<HashMap<String,String>> records= service.queryPeriod("0",TimeUtil.getDate());
        System.out.println(records);
    }
    @Test
    public void getSingleRecords(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRecordService service= (EmployeeRecordService) context.getBean("employeeRecordServiceImpl");
        List<HashMap<String,String>> records= service.querySingleEmployee("tldj001");
        System.out.println(records);
    }
    @Test
    public void getName(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRecordService service= (EmployeeRecordService) context.getBean("employeeRecordServiceImpl");
        List<HashMap<String,String>> map= service.queryNameByScenicID(1);
        System.out.println(map);
    }
}
