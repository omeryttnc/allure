package Tests.DataBaseTest.utilities;

import Tests.DataBaseTest.model.User;
import config.TestResultLoggerExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//@SpringBootTest
@SpringBootApplication
@ExtendWith(TestResultLoggerExtension.class)
@Execution(ExecutionMode.CONCURRENT)
public class ReadTxt {

    public static List<User> returnAllUserData(String filename){
        List<User> all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                User user = new User();
                user.setId(Integer.parseInt(line.split(",")[0]));
                user.setFirst_name(line.split(",")[1]);
                user.setMiddle_name(line.split(",")[2]);
                user.setLast_name(line.split(",")[3]);
                user.setEmail(line.split(",")[4]);
                user.setZip_code(Integer.parseInt(line.split(",")[5]));
                user.setIs_verified(Integer.parseInt(line.split(",")[6]));
                user.setPhone(line.split(",")[7]);
                user.setLat(line.split(",")[8]);
                user.setLng(line.split(",")[9]);
                line = br.readLine();
                all.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }
    public static List<String> returnUserFullName(String filename){
        List<String> fullNameList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                fullNameList.add(line.split(",")[1] + " " + line.split(",")[2] + " " + line.split(",")[3] );
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fullNameList;
    }
    public static String returntitle(String filename){
       String fullNameList = "";
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                fullNameList=(line );
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fullNameList;
    }
}
