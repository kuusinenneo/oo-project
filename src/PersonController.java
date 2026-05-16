public class PersonController {

    private PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    public void addPerson(String firstName, String lastName, int age) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("name cant be empty");
            return;
        }
        if (age <= 0 || age > 150) {
            System.out.println("age is not valid");
            return;
        }
        Person p = new Person(firstName, lastName, age);
        repo.add(p);
    }

    public MyList<Person> getAllPersons() {
        return repo.findAll();
    }

    public Person getPersonById(int id) {
        return repo.findById(id);
    }

    public void updatePerson(int id, String firstName, String lastName, int age) {
        Person p = repo.findById(id);
        if (p == null) {
            System.out.println("person not found");
            return;
        }
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        repo.update(p);
    }

    public void deletePerson(int id) {
        repo.delete(id);
    }
}
