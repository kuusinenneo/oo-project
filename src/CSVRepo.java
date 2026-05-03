import java.io.*;

public class CSVRepo implements PersonRepository {

    private String filePath;
    private MyList<Person> list = new MyLinkedList<>();

    public CSVRepo(String filePath) {
        this.filePath = filePath;
        loadData();
    }

    private void loadData() {
        list.clear();
        File f = new File(filePath);
        if (!f.exists()) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) continue;
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String first = parts[1].trim();
                String last = parts[2].trim();
                int age = Integer.parseInt(parts[3].trim());
                list.add(new Person(id, first, last, age));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("error reading file: " + e.getMessage());
        }
    }

    private void saveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("id,firstName,lastName,age");
            writer.newLine();
            for (int i = 0; i < list.size(); i++) {
                Person p = list.get(i);
                writer.write(p.getId() + "," + p.getFirstName() + "," + p.getLastName() + "," + p.getAge());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("error saving file: " + e.getMessage());
        }
    }

    public void add(Person person) {
        list.add(person);
        saveData();
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
                saveData();
                return;
            }
        }
        System.out.println("person not found");
    }

    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                saveData();
                return;
            }
        }
        System.out.println("person not found");
    }
}
