package Demo;

import Cargos.Cargo;
import Cargos.CargoFactory;
import Cargos.Factory.MaterialArgs;
import Cargos.Factory.PeopleArgs;
import Persons.Client;
import Persons.Employee;
import Persons.Factory.ClientArgs;
import Persons.Factory.EmployeeArgs;
import Persons.Person;
import Persons.PersonFactory;
import TransportCompany.TransportCompany;
import Vehicles.VEHICLE_TYPE;
import Vehicles.Vehicle;
import utility.CATEGORY;
import utility.TRANSPORT_TYPE;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.*;

public class SimpleDemo {

    public static List<Employee> createEmployees() {
        List<Employee> firstRowOFEmployees = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            EmployeeArgs employeeArgs = new EmployeeArgs("employee" + i, BigDecimal.TEN.add(BigDecimal.valueOf(i)), CATEGORY.B);
            Employee employee = PersonFactory.getInstance().createPerson(employeeArgs);
            firstRowOFEmployees.add(employee);
        }

        List<Employee> SecondRowOFEmployees = new ArrayList<>();
        for (int i = 3; i < 6; i++) {
            EmployeeArgs employeeArgs = new EmployeeArgs("employee" + i, BigDecimal.TEN.add(BigDecimal.valueOf(i)), CATEGORY.C);
            Employee employee = PersonFactory.getInstance().createPerson(employeeArgs);
            SecondRowOFEmployees.add(employee);
        }

        List<Employee> ThirdRowOFEmployees = new ArrayList<>();
        for (int i = 6; i < 9; i++) {
            EmployeeArgs employeeArgs = new EmployeeArgs("employee" + i, BigDecimal.TEN.add(BigDecimal.valueOf(i)), CATEGORY.D);
            Employee employee = PersonFactory.getInstance().createPerson(employeeArgs);
            ThirdRowOFEmployees.add(employee);
        }

        List<Employee> result = new ArrayList<>(firstRowOFEmployees);
        result.addAll(SecondRowOFEmployees);
        result.addAll(ThirdRowOFEmployees);

        return result;
    }

    public static List<Vehicle> createVehicles() {
        List<Vehicle> first = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Vehicle vehicle = new Vehicle.VehiclesBuilder()
                    .transportType(TRANSPORT_TYPE.PRODUCT)
                    .withMaximumCapacity(2000)
                    .withCategory(CATEGORY.B)
                    .withPricePerKm(BigDecimal.valueOf(60.0))
                    .vehiclesType(VEHICLE_TYPE.CAR)
                    .build();
            first.add(vehicle);
        }
        for (int i = 0; i < 3; i++) {
            Vehicle vehicle = new Vehicle.VehiclesBuilder()
                    .transportType(TRANSPORT_TYPE.PRODUCT)
                    .withMaximumCapacity(5000)
                    .withCategory(CATEGORY.C)
                    .withPricePerKm(BigDecimal.valueOf(80.0))
                    .vehiclesType(VEHICLE_TYPE.TRUCK)
                    .build();
            first.add(vehicle);
        }
        for (int i = 0; i < 3; i++) {
            Vehicle vehicle = new Vehicle.VehiclesBuilder()
                    .transportType(TRANSPORT_TYPE.PASSENGER)
                    .withMaximumCapacity(25)
                    .withCategory(CATEGORY.D)
                    .withPricePerKm(BigDecimal.valueOf(100.0))
                    .vehiclesType(VEHICLE_TYPE.BUS)
                    .build();
            first.add(vehicle);
        }
        for (int i = 0; i < 3; i++) {
            Vehicle vehicle = new Vehicle.VehiclesBuilder()
                    .transportType(TRANSPORT_TYPE.PASSENGER)
                    .withMaximumCapacity(4)
                    .withCategory(CATEGORY.D)
                    .withPricePerKm(BigDecimal.valueOf(200.0))
                    .vehiclesType(VEHICLE_TYPE.TANK)
                    .build();
            first.add(vehicle);
        }
        for (int i = 0; i < 3; i++) {
            Vehicle vehicle = new Vehicle.VehiclesBuilder()
                    .transportType(TRANSPORT_TYPE.PRODUCT)
                    .withMaximumCapacity(1000)
                    .withCategory(CATEGORY.B)
                    .withPricePerKm(BigDecimal.valueOf(65.0))
                    .vehiclesType(VEHICLE_TYPE.BANICHARKA)
                    .build();
            first.add(vehicle);
        }
        return first;
    }

    public static List<Client> createClients() {
        //first create cargos.
        Queue<Cargo> cargos = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            MaterialArgs materialArgs = new MaterialArgs(150);
            Cargo cargo = CargoFactory.getInstance().createCargo(materialArgs);
            cargos.add(cargo);
        }
        //add Persons
        List<Person> peoples = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            peoples.add(PersonFactory.getInstance()
                    .createPerson(new EmployeeArgs()));
        }

        for (int i = 0; i < 3; i++) {
            PeopleArgs materialArgs = new PeopleArgs(peoples);
            Cargo cargo = CargoFactory.getInstance().createCargo(materialArgs);
            cargos.add(cargo);
        }

        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Client client = PersonFactory.getInstance().createPerson(new ClientArgs("client" + i, BigDecimal.valueOf(1000000.0), cargos.poll()));
            clients.add(client);
        }

        return clients;
    }

    public static void main(String[] args) {
        TransportCompany myCompany = new TransportCompany.TransportCompanyBuilder().build();

        List<Employee> employees = createEmployees();

        for (Employee employee : employees) {
            myCompany.addEmployee(employee);
        }

        List<Vehicle> vehicles = createVehicles();

        for (Vehicle vehicle : vehicles) {
            myCompany.addVehicle(vehicle);
        }

        List<Client> clients = createClients();

        Queue<Client> clients1 = new LinkedList<>(clients);
        Date begin1 = new GregorianCalendar(2012, Calendar.FEBRUARY, 11).getTime();
        Date end1 = new GregorianCalendar(2012, Calendar.FEBRUARY, 12).getTime();

        myCompany.assignTransport(begin1, end1, clients1.poll(), true, 100);

        Date begin2 = new GregorianCalendar(2012, Calendar.FEBRUARY, 13).getTime();
        Date end2 = new GregorianCalendar(2012, Calendar.FEBRUARY, 14).getTime();

        myCompany.assignTransport(begin2, end2, clients1.poll(), true, 32);

        Date begin3 = new GregorianCalendar(2012, Calendar.FEBRUARY, 15).getTime();
        Date end3 = new GregorianCalendar(2012, Calendar.FEBRUARY, 17).getTime();

        myCompany.assignTransport(begin3, end3, clients1.poll(), true, 45);

        Date begin4 = new GregorianCalendar(2012, Calendar.FEBRUARY, 18).getTime();
        Date end4 = new GregorianCalendar(2012, Calendar.FEBRUARY, 19).getTime();

        myCompany.assignTransport(begin4, end4, clients1.poll(), true, 78);

        Date begin5 = new GregorianCalendar(2012, Calendar.FEBRUARY, 20).getTime();
        Date end5 = new GregorianCalendar(2012, Calendar.FEBRUARY, 21).getTime();

        myCompany.assignTransport(begin5, end5, clients1.poll(), true, 12);

        Date begin6 = new GregorianCalendar(2012, Calendar.FEBRUARY, 23).getTime();
        Date end6 = new GregorianCalendar(2012, Calendar.FEBRUARY, 24).getTime();

        myCompany.assignTransport(begin6, end6, clients1.poll(), true, 42);

        Date begin7 = new GregorianCalendar(2012, Calendar.FEBRUARY, 23).getTime();
        Date end7 = new GregorianCalendar(2012, Calendar.FEBRUARY, 24).getTime();

        myCompany.assignTransport(begin7, end7, clients1.poll(), true, 42);

        System.out.println(myCompany.reportSumOfMadeTransports() + "\n");
        System.out.println(myCompany.timesEmployeesDrove() + "\n");
        System.out.println(myCompany.reportHowManyTransportsHaveBeenMade() + "\n");
        System.out.println(myCompany.earningsOnPeriod(begin3, end7) + "\n");
        System.out.println(myCompany.earningsOnPeriodFromEmployee(begin1, end1, employees.get(employees.size() - 1)) + "\n");

        File LocationToWrite = Paths.get("src/main/resources/dummySerialisation.ser").toFile();
        System.out.println("Writing transports to: \"src/main/resources/dummySerialisation.ser\" ");
        System.out.println(myCompany.writeTransportsToFile(LocationToWrite));

        System.out.println("\nReading transports from: \"src/main/resources/dummySerialisation.ser\" ");
        System.out.println(myCompany.readTransportsFromFile(LocationToWrite));
    }
}
