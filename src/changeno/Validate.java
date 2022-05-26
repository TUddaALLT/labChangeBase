/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeno;

import java.util.Scanner;

/**
 *
 * @author 84352
 */
public class Validate {
    Scanner scanner = new Scanner(System.in);

    public int checkIntLimit(int min, int max, String mess, String error) {
        while (true) {
            try {
                System.out.println(mess);
                int n = Integer.parseInt(scanner.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println(error);
            }
        }
    }

    public int getBaseNo(String mess, String err) {
        while (true) {
            try {
                System.out.println(mess);
                int n = Integer.parseInt(scanner.nextLine());
                if (n != 2 && n != 10 && n != 16) {
                    throw new NumberFormatException();
                } else {
                    return n;
                }

            } catch (NumberFormatException ex) {
                System.err.println(err);
            }
        }
    }

    public String getValueNo(String mess, String err, int base) {
        while (true) {
            try {
                System.out.println(mess);
                String value = scanner.nextLine();
                switch (base) {
                    case 2:
                        if (value.matches("^[0-1]{1,}$")) {
                            return value;
                        }
                        break;
                    case 10:
                        if (value.matches("^[0-9]{1,}$")) {
                            return value;
                        }
                        break;
                    case 16:
                        if (value.matches("^[0-9A-Fa-f]{1,}$")) {
                            return value;
                        }
                        break;

                }
                System.out.println(err);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

}
