public class ByteBuddyExampleMain {
    public static void main(String[] args) throws Exception {
        String returnVal = (new Robot()).greetUser("John");
        System.out.println("return value: " + returnVal);
    }
}