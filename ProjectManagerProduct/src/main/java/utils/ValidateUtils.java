package utils;

import java.util.Scanner;

public class ValidateUtils {

    public static Scanner sc = new Scanner(System.in);
    public static int getNumberMinMax(String str, int min, int max) throws IndexOutOfBoundsException {
        System.out.println(str);
        int num;
        try {
            num = Integer.parseInt(sc.nextLine());
            if (num < min || num > max) {
                System.err.println("Chọn từ khoảng " + min + " và " + max);
                return getNumberMinMax(str, min, max);
            }
            return num;
        } catch (Exception e) {
            System.err.println("Không đúng định dạng");
            return getNumberMinMax(str, min, max);
        }
    }

    public static String getString(String str) {
        try {
            System.out.println(str);
            String data = sc.nextLine();
            if (data.equals("")) {
                throw new Exception();
            }
            return data;
        } catch (Exception e) {
            System.err.println("Dữ liệu không đúng kiểu \n Vui lòng nhập lại: ");
            return getString(str);
        }
    }

    public static int getNumber(String str) {
        try {
            return Integer.parseInt(getString(str));
        } catch (Exception e) {
            System.err.println("Dữ liệu không đúng kiểu \n Vui lòng nhập lại:");
            return getNumber(str);
        }
    }

    public static float getFloat(String str) {
        try {
            return Float.parseFloat(getString(str));
        } catch (Exception e) {
            System.err.println("Dữ liệu không đúng kiểu \n Vui lòng nhập lại:");
            return getFloat(str);
        }
    }

    public static long getLong(String str) {
        try {
            return Long.parseLong(getString(str));
        } catch (Exception e) {
            System.err.println("Dữ liệu không đúng kiểu \n Vui lòng nhập lại:");
            return getLong(str);
        }
    }
}
