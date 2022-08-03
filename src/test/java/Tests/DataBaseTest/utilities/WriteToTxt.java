package Tests.DataBaseTest.utilities;

import Tests.DataBaseTest.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {

    public static void saveUsers(String fileName, List <User> users){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<users.size(); i++) {
                writer.append(users.get(i).getId() + "," + users.get(i).getFirst_name() + "," +users.get(i).getMiddle_name()
                        + "," + users.get(i).getLast_name() + "," +users.get(i).getEmail() +"," + users.get(i).getZip_code()+","
                        + users.get(i).getIs_verified() + "," +users.get(i).getPhone() + "," +users.get(i).getLat() + "," +users.get(i).getLng()+",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

      public static void saveTitle(String fileName, String title){
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
                writer.append(title);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
