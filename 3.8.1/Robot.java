public class Robot {
    private String name = "Casper";
    public String greetUser(String name ){
        System.out.println("Inside greetUser method . . . ");
        return "Hello " + name + "! I am " + this.name;
    }
}