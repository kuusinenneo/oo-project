public interface PersonRepository {

    void add(Person person);

    MyList<Person> findAll();

    Person findById(int id);

    void update(Person person);

    void delete(int id);
}
