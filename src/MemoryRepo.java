public class MemoryRepo implements PersonRepository {

    private MyList<Person> list = new MyArrayList<>();

    public void add(Person person) {
        list.add(person);
    }

    public MyList<Person> findAll() {
        return list;
    }

    public Person findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }


    public void update(Person person) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == person.getId()) {
                list.set(i, person);
                return;
            }
        }
        System.out.println("person not found");
    }

    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                return;
            }
        }
        System.out.println("person not found");
    }
}
