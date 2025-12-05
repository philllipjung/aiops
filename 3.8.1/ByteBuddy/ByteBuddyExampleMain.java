public class ByteBuddyExampleMain {

    public static void main(String[] args) throws Exception {

        Class<?> type = new ByteBuddy()
                .redefine(Robot.class)
                .visit(Advice.to(MyAdvices.class).on(ElementMatchers.isMethod()))
                .make()
                .load(ClassLoadingStrategy.BOOTSTRAP_LOADER, ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        
      // use java reflection to invoke the method
        String returnVal = (String)type.getDeclaredMethod("greetUser", String.class).invoke(type.getDeclaredConstructor().newInstance(), "John");
        System.out.println("return value: " + returnVal);
    }
}