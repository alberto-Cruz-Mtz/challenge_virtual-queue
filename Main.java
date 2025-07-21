import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reto: Simulación de cola de atención prioritaria");

        Person person1 = new Person("Persona 1", 30, false);
        Person person2 = new Person("Adulto Mayor 1", 70, false);
        Person person3 = new Person("Adulto Mayor 2", 60, true);
        Person person4 = new Person("Joven discapacitado", 25, true);

        QueueManager queueManager = new QueueManager();
        queueManager.addPerson(person1);
        queueManager.addPerson(person2);
        queueManager.addPerson(person3);
        queueManager.addPerson(person4);
        System.out.println();
        queueManager.processQueue();
    }
}

// Implementar la clase Person aquí (reto)
record Person(String name, int age, boolean hasDisability) {
}

// Implementar la clase QueueManager aquí (reto)
class QueueManager {

    public QueueManager() {
        this.priorityQueue = new LinkedList<>();
        this.regularQueue = new LinkedList<>();
    }

    private final Queue<Person> priorityQueue;
    private final Queue<Person> regularQueue;


    public void addPerson(Person person) {
        if (person.age() >= 60 || person.hasDisability()) {
            priorityQueue.offer(person);
        } else {
            regularQueue.offer(person);
        }
        System.out.println(person.name() + " acaba de ser agregado a la cola");
    }

    public void processQueue() {
        Person person;
        while (!priorityQueue.isEmpty()) {
            person = priorityQueue.poll();
            System.out.println(person.name() + " esta siendo atendido");
        }

        while (!regularQueue.isEmpty()) {
            person = regularQueue.poll();
            System.out.println(person.name() + " esta siendo atendido");
        }
        System.out.println("Ya no hay mas personas por atender");
    }
}
