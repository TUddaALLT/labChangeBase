/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeno;

/**
 *
 * @author 84352
 */
public class Manage {

    Validate validate = new Validate();

    public int otherBaseToDec(String other, int base) {
        int result = 0;
        String hex = "0123456789ABCDEF";
        other = other.toUpperCase();
        for (int i = 0; i < other.length(); i++) {
            result += hex.indexOf(other.charAt(i)) * Math.pow(base, other.length() - 1 - i);
        }
        return result;
    }

    public String decToOtherBase(int dec, int base) {
        String result = "";
        String hex = "0123456789ABCDEF";
        while (dec > 0) {
            result = hex.charAt(dec % base) + result;
            dec= dec/base;
        }
        return result;
    }

    public void changeBase(String mess, int base) {
        int toBase = validate.getBaseNo(mess + " To", "Base is not exist. Re-enter: (ex: 2|10|16)");
        String valueChange = validate.getValueNo("Enter value need to convert: ", "Wrong Format Base " , base);
        int tempValue = otherBaseToDec(valueChange, base);
        String result = decToOtherBase(tempValue, toBase);
        System.out.println(valueChange + " From base " + base+ " to base " + toBase + " is : " + result);
    }

    public void menu() {
        do {
            System.out.println("1. From Binary (Base 2)");
            System.out.println("2. From Decimal (Base 10)");
            System.out.println("3. From Hexa (Base 16)");
            System.out.println("4. Exit");
            int choice = validate.checkIntLimit(1, 4, "Enter your choice: ", "Must be 1->4");
            switch (choice) {
                case 1:
                    changeBase("Convert From Binary", 2);
                    break;
                case 2:
                    changeBase("Convert From Decimal", 10);
                    break;
                case 3:
                    changeBase("Convert From Hexa", 16);
                    break;
                case 4:
                    return;

            }
        } while (true);

    }
}
