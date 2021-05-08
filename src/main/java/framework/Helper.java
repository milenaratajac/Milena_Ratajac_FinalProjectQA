package framework;

public class Helper {
    public static int getRandomInteger (){
            return (int)(Math.random () * 1000);
    }
    public static String GenerateTittle (){
        return "Fashion -" + getRandomInteger();
    }
    public static String GenerateUrl (){
        return "www.zara.com";
    }
}
