public class Main {

    public static void main(String[] args) {
        PersonRepository repo = new MemoryRepo();
        PersonController controller = new PersonController(repo);
        CLI cli = new CLI(controller);
        cli.start();
    }
}