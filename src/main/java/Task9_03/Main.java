package Task9_03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input class name:");
        String className = scanner.nextLine();

        try {
            Class classHandle = Class.forName(className);
            System.out.println("Info about class" + className+ ".\n");
            if(classHandle.isPrimitive()){
                System.out.println("Class "+className+" is primitive.");
            }else{
                System.out.println("Class '"+className+"' isn't primitive.");
            }
            if(classHandle.isInterface()){
                System.out.println("Class "+className+" is interface.");
            }else{
                System.out.println("Class '"+className+"' isn't interface.");
            }
            if(classHandle.isArray()){
                System.out.println("Class "+className+" is an array.");
            }else{
                System.out.println("Class '"+className+"' isn't an array.");
            }

            System.out.println("\nPublic reflection fields:");
            Field[] fields=classHandle.getFields();
            for(Field f: fields){
                System.out.print("\tName: "+f.getName());
                System.out.println("\tType: "+f.getType().getName());
            }
            System.out.println("\nAll modifiers reflection fields:");
            fields=classHandle.getDeclaredFields();
            for(Field f: fields){
                System.out.print("\tName: "+f.getName());
                System.out.println("\tType: "+f.getType().getName());
            }

            System.out.println("\nConstructors:");
            Constructor[] constructors = classHandle.getConstructors();
            for(Constructor c: constructors){
                System.out.print("\tName: "+c.getName());
            }

            System.out.println("\nPublic methods: ");
            Method[] methods = classHandle.getMethods();
            for(Method m: methods){
                System.out.print("\tName: "+m.getName());
                System.out.println("\t\t\tReturn value: "+m.getReturnType().getName());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
