package www.test.java;

import java.util.Scanner;

interface Computer{
    public void buyComputer();
}
class Macbook implements Computer{

    @Override
    public void buyComputer() {
        System.out.println("买一台Macbook!");
    }
}
class Lenovo implements Computer{

    @Override
    public void buyComputer() {
        System.out.println("买一台lenovo电脑");
    }
}

class ComputerFactory{
    private ComputerFactory(){};
    public static Computer getInstance(String className){
        Computer computer = null;
        try {
            Class<Computer> cls = (Class<Computer>) Class.forName(className);
            computer = cls.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return computer;
    }
}
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Computer computer = ComputerFactory.getInstance(str);
        computer.buyComputer();

    }
}
