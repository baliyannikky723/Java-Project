import java.util.ArrayList;

 abstract class Employee1 {
    private int id;
    private String name;

    public Employee1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculatesalary();

    @Override
    public String toString() {
        return "Employee [name = " + name + " , id = " + id + " , salary = " + calculatesalary() + "]";
    }
}

class fulltimeemployee extends Employee1 {
    private double monthlysalary;

    public fulltimeemployee(String name, int id, double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    public double calculatesalary() {
        return monthlysalary;
    }
}
     class parttimeemployee extends Employee1{
        private int hoursworked;
        private int hourlyrate;

        public parttimeemployee(String name , int id , int hoursworked , int hourlyrate){
            super(name , id);
            this.hoursworked = hoursworked;
            this.hourlyrate = hourlyrate;
        }

        public  double calculatesalary(){
            return hoursworked*hourlyrate;
        }
    }

    class PyrollSystem {
        private ArrayList<Employee1> employelist;

        public PyrollSystem() {
            employelist = new ArrayList<>();
        }

        public void addemploye(Employee1 employe) {
            employelist.add(employe);
        }

        public void removeemploye(int id) {
            Employee1 employeToremove = null;
            for (Employee1 employee : employelist) {
                if (employee.getId() == id) {
                    employeToremove = employee;
                    break;
                }
            }
            if (employeToremove != null) {
                employelist.remove(employeToremove);
            }
        }
        public void displayemploye(){
            for(Employee1 employee : employelist){
                System.out.println(employee);
            }
        }
    }

public class Employee {
    public static void main(String[] args) {
        PyrollSystem payrollsystem = new PyrollSystem();
        fulltimeemployee emp1 = new fulltimeemployee("Vikas", 1, 700000);
        parttimeemployee emp2 = new parttimeemployee("Rohan", 2, 40, 100);

        payrollsystem.addemploye(emp1);
        payrollsystem.addemploye(emp2);
        System.out.println("Initial Employee Details :");
        payrollsystem.displayemploye();
        System.out.println("Remove Employee");
        payrollsystem.removeemploye(2);
        System.out.println("Remaining Employee");
        payrollsystem.displayemploye();

    }
}