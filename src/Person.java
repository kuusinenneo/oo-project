public class Person {
    private static int nextId = 1;

    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.id = nextId;
        nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return id + " " + firstName + " " + lastName + " age: " + age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 25);
        Person p2 = new Person("Jane", "Smith", 30);

        System.out.println(p1);
        System.out.println(p2);

        p1.setAge(26);
        p1.setFirstName("Johnny");
        System.out.println("after update: " + p1);

        System.out.println("p1 id: " + p1.getId());
        System.out.println("p2 id: " + p2.getId());
    }
}