import com.pccw.data.migration.Application;
import com.pccw.data.migration.entity.ams.AmsUser;
import com.pccw.data.migration.entity.ars.ArsUser;
import com.pccw.data.migration.entity.pas.PasUser;
import com.pccw.data.migration.handler.IntegrationUserHandler;
import com.pccw.data.migration.service.ams.AmsUserService;
import com.pccw.data.migration.service.ars.ArsUserService;
import com.pccw.data.migration.service.pas.PasUserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Created by Jim@80992399 on 2020-07-27 18:04
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class )
public class Test {

    @Resource
    AmsUserService amsUserService;
    @Resource
    ArsUserService arsUserService;
    @Resource
    IntegrationUserHandler userHandler;
    @Resource
    PasUserService pasUserService;

    public static void main(String[] arr){
        System.out.println("--------------------------------- Junit test ---------------------------------");
        System.out.println("--------------------------------- Junit test ---------------------------------");
    }

    @org.junit.Test
    public void testinsertArsUserInfoToAms(){
        System.out.println("--------------------------------- Junit test ---------------------------------");
        //userHandler.insertArsUserInfoToAms();
        //userHandler.insertPasUserInfoToAms();
        System.out.println("--------------------------------- Junit test ---------------------------------");
    }

    @org.junit.Test
    public void testFindAllUser(){
        System.out.println("--------------------------------- Junit test ---------------------------------");
        List<AmsUser> users = amsUserService.getUserList("A");
        for (AmsUser user : users) {
            System.out.println(user.toString());
        }
        //System.out.println("--------------------------------- Junit test ---------------------------------");
        List<ArsUser> userList = arsUserService.findAll();
        for (ArsUser arsUser : userList) {
            System.out.println(arsUser.toString());
        }
        List<PasUser> pasUserList = pasUserService.findAll();
        for (PasUser pasUser : pasUserList) {
            System.out.println(pasUser.toString());
        }
        System.out.println("--------------------------------- Junit test ---------------------------------");
    }

    @org.junit.Test
    public void testFindPasAllUser(){
        System.out.println("--------------------------------- Junit test ---------------------------------");
        List<PasUser> pasUserList = pasUserService.findAll();
        for (PasUser pasUser : pasUserList) {
            System.out.println(pasUser.toString());
        }
        System.out.println("--------------------------------- Junit test ---------------------------------");
    }
}
