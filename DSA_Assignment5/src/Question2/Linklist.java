package Question2;

public class Linklist {
    private Employee head;
    private Employee sorted;

    public Linklist() {
        this.head = null;
    }

    public void add(String name, double salary, int age) {
        if (this.head == null) {
            this.head = new Employee(name, salary, age);
        } else {
            Employee headReference = this.head;
            while (headReference.getNext() != null) {
                headReference = headReference.getNext();
            }
            headReference.setNext(new Employee(name, salary, age));
        }
    }

    public void sort() {
        if (this.head == null) {
            System.out.println("Empty Linklist");
        } else {
            sorted = null;
            boolean flag = false;
            Employee headReference = this.head;
            while (headReference != null) {
                Employee next = headReference.getNext();
                if (sorted == null
                        || sorted.getSalary() > headReference.getSalary()) {
                  headReference.setNext(sorted); 
                  sorted = headReference; 
                }else if(sorted.getSalary() == headReference.getSalary()){
                    sortAge(headReference);
                }else {
                    Employee current = sorted;
                    while (current.getNext() != null&& 
                            current.getNext().getSalary() < headReference.getSalary()) {
                        current = current.getNext();
                    }
                        
                    if ( current.getNext() != null && current.getNext().getSalary() == headReference
                            .getSalary()) {
                        Employee temporary = current.getNext();
                        while (temporary.getNext() != null
                                && temporary.getNext().getAge() < headReference.getAge()
                                && current.getNext().getSalary() == headReference.getSalary())
                            temporary = temporary.getNext();
                        
                        headReference.setNext(temporary.getNext());
                        temporary.setNext(headReference);
                    }
                    else{
                         headReference.setNext(current.getNext());
                    current.setNext(headReference);
                    }
                }
                headReference = next;
            }
            head = sorted;
        }
    }

    void sortAge(Employee headReference){
        if(sorted.getAge() >= headReference.getAge()){
          headReference.setNext(sorted); 
          sorted = headReference;
      }
      else{
          Employee current = sorted;
          while (current.getNext() != null&& 
                  current.getNext().getAge() < headReference.getAge() && 
                  current.getNext().getSalary() == headReference.getSalary()) {
              current = current.getNext();
          }
          headReference.setNext(current.getNext());
          current.setNext(headReference);
      }
    }
    public void showLinklist() {

        if (this.head == null) {
            System.out.println("Empty Linklist");
        } else {
            Employee headReference = this.head;
            System.out.println(headReference);
            do {
                System.out.println(headReference.getName() + " "
                        + headReference.getSalary() + " "
                        + headReference.getAge());
                headReference = headReference.getNext();
            } while (headReference != null);
        }
    }
}
