package utils;

import model.ECategory;
import model.ERole;
import model.Product;
import model.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static utils.ValidateUtils.getLong;

public class FileUtils {
    public static void readFileProduct(List<Product> products, String fileName){
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] items = line.split(",");
                long id = Long.parseLong(items[0]);
                String name = items[1];
                String description = items[2];
                float price = Float.parseFloat(items[3]);

                long userId = Long.parseLong(items[4]);

                List<User> users = new ArrayList<>();
                readFileUser(users, Config.PATH_FILE_NAME_USER);

                User user = null;
                for(User us : users){
                    if(us.getId() == userId){
                        user = us;
                        break;
                    }
                }

                String category = items[5];
                ECategory eCategory = ECategory.getBy(category);

                LocalDate createAt = DateUtils.parse(items[6]);


                Product p = new Product(id, name, description,price,user,eCategory, createAt);
                products.add(p);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writeFile(List<Product> products, String fileName){
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for(Product p : products){
                bufferedWriter.write(p + "\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean checkFileExists(String fileName){
        File file = new File(fileName);
        return file.exists();
    }

    public static void readFileUser(List<User> users, String fileName){
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] infoUs = line.split(",");
                long id = Long.parseLong(infoUs[0]);
                String name = infoUs[1];
                String psw = infoUs[2];

                ERole eRole = ERole.getBy(infoUs[3]);

                User user = new User(id, name, psw, eRole);
                users.add(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
