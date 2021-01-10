package TransportCompany;

import Persons.Client;
import Persons.Employee;
import Transport.Transport;
import Vehicles.Vehicle;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//TODO ADD JAVADOCS AND UNIT TESTS

public class TransportCompany implements Comparable<TransportCompany> {
    private String companyName;
    private List<Vehicle> vehicles;
    private List<Employee> employees;
    private Map<Transport, Client> transports;

    private BigDecimal earnings;

    private List<Client> clients;

    public TransportCompany(String companyName, List<Vehicle> vehicles, List<Employee> employees, Map<Transport, Client> transports, BigDecimal earnings, List<Client> clients) {
        this.companyName = companyName;
        this.vehicles = vehicles;
        this.employees = employees;
        this.transports = transports;
        this.earnings = earnings;
        this.clients = clients;
    }

    public boolean delete() {
        setCompanyName("");
        getTransports().clear();
        getVehicles().clear();
        getClients().clear();
        getEmployees().clear();
        setEarnings(BigDecimal.ZERO);
        return true;
    }

    public boolean deleteVehicle(Vehicle vehicleToBeRemoved) {
        int position = getVehicles().indexOf(vehicleToBeRemoved);

        if (position == -1) {
            return false;
        }

        setVehicles(getVehicles()
                .stream()
                .filter(vehicle -> !vehicle.equals(vehicleToBeRemoved))
                .collect(Collectors.toList()));
        return true;
    }

    public boolean deleteClient(Client clientToBeRemoved) {
        int position = getClients().indexOf(clientToBeRemoved);

        if (position == -1) {
            return false;
        }

        setClients(getClients()
                .stream()
                .filter(client -> !client.equals(clientToBeRemoved))
                .collect(Collectors.toList()));
        return true;
    }

    public boolean deleteEmployee(Employee employeeToBeRemoved) {
        int position = getEmployees().indexOf(employeeToBeRemoved);

        if (position == -1) {
            return false;
        }

        setEmployees(getEmployees()
                .stream()
                .filter(employee -> !employee.equals(employeeToBeRemoved))
                .collect(Collectors.toList()));
        return true;
    }

    public boolean deleteTransport(Transport transport) {
        if (getTransports().containsKey(transport)) {
            return false;
        }

        getTransports().remove(transport);
        return true;
    }

    public boolean changeName(String newName) {
        if (getCompanyName().equals(newName)) {
            return false;
        }
        setCompanyName(newName);
        return true;
    }

    public boolean decreaseEarnings(BigDecimal valueToDecrease) {
        if (getEarnings().subtract(valueToDecrease).compareTo(BigDecimal.ZERO) > 0) {
            return false;
        }
        setEarnings(getEarnings().subtract(valueToDecrease));
        return true;
    }

    public boolean addTransport(Transport transport) {
        if (getTransports().containsKey(transport)) {
            return false;
        }
        getTransports().put(transport, transport.getClient());
        return true;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (getVehicles().contains(vehicle)) {
            return false;
        }
        getVehicles().add(vehicle);
        return true;
    }

    public boolean addEmployee(Employee employee) {
        if (getEmployees().contains(employee)) {
            return false;
        }
        getEmployees().add(employee);
        return true;
    }

    public boolean addClient(Client client) {
        if (getClients().contains(client)) {
            return false;
        }
        getClients().add(client);
        return true;
    }

    public void increaseEarnings(BigDecimal valueToIncrease) {
        setEarnings(getEarnings().add(valueToIncrease));
    }

    public boolean isClientInObligation(Client client) {
        Set<Map.Entry<Transport, Client>> entries = getTransports().entrySet();

        for (Map.Entry<Transport, Client> entry : entries) {
            if (entry.getValue().equals(client)) {
                if (entry.getKey().isPayed() == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Employee> sortEmployee() {
        List<Employee> employees = getEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getCategory))
                .collect(Collectors.toList());
        return employees;
    }

    public List<Transport> sortTransports() {
        List<Transport> transports = getTransports().entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .sorted(Comparator.comparing(Transport::getDestination))
                .collect(Collectors.toList());

        return transports;
    }

    public boolean writeTransportsToFile(File file) {

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
          writer.writeObject(this.getTransports());
          return true;
        } catch (IOException e) {
            return false;
        }

    }

    public List<Transport> readTransportsFromFile(File file) {
        List<Transport> list = new ArrayList<>();
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream (file))){
            list = (List<Transport>)reader.readObject();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            return list;
        }
    }

    public boolean readAndWriteTransportsToCompany(File file){
        List<Transport> list = this.readTransportsFromFile(file);
        if (list.isEmpty()){
            return false;
        }

        for (Transport transport : list) {
            this.getTransports().putIfAbsent(transport,transport.getClient());
        }
        return true;
    }

    public String reportHowManyTransportsHaveBeenMade(){
        Date date = new Date();

        List<Transport> transports = this.getTransports()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfEnd().before(date))
                .collect(Collectors.toList());

        return "All transports made to current date: " + Integer.valueOf(transports.size()).toString();
    }

    public String reportSumOfMadeTransports(){
        Date date = new Date();

        BigDecimal money = this.getTransports()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfEnd().before(date))
                .map(transport -> transport.getPriceForTransport())
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        return "Money earned from transports made to current date: " + money;
    }


    public String timesEmployeesDrove(){
        Map<Employee,Integer> map = this.getEmployees()
                .stream()
                .collect(Collectors.toMap(Function.identity(),this::timesDrove));

        StringBuilder result = new StringBuilder();
        Set<Map.Entry<Employee,Integer>> entries = map.entrySet();

        result.append("Times employees drove\n");

        for (Map.Entry<Employee, Integer> entry : entries) {
            String str = String.format("Employee %s : %s trips.\n",
                    entry.getKey().getName(),entry.getValue());
            result.append(str);
        }


        return result.toString();
    }

    public String earningsOnPeriod(Date begin, Date end){
        BigDecimal money = this.getTransports()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfBegin().after(begin) && transport.getDateOfEnd().before(end))
                .map(moneyToSum -> moneyToSum.getPriceForTransport())
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        return String.format("Earnings made between %s and %s are %s",begin,end,money);
    }

    public String earningsOnPeriodFromEmployee(Date begin, Date end,Employee employee){
        BigDecimal money = this.getTransports()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfBegin().after(begin) && transport.getDateOfEnd().before(end))
                .filter(transport -> transport.getDriver().equals(employee))
                .map(moneyToSum -> moneyToSum.getPriceForTransport())
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        return String.format("Earnings made between %s and %s from employee %s are %s",begin,end,employee.getName(),money);
    }

    private int timesDrove(Employee employee){
        long times = this.getTransports()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDriver().equals(employee))
                .count();

        return (int) times;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<Transport, Client> getTransports() {
        return transports;
    }

    public void setTransports(Map<Transport, Client> transports) {
        this.transports = transports;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportCompany that = (TransportCompany) o;
        return Objects.equals(companyName, that.companyName) &&
                Objects.equals(vehicles, that.vehicles) &&
                Objects.equals(employees, that.employees) &&
                Objects.equals(transports, that.transports) &&
                Objects.equals(earnings, that.earnings) &&
                Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, vehicles, employees, transports, earnings, clients);
    }

    @Override
    public int compareTo(TransportCompany o) {
        int lv1 = this.getCompanyName().compareTo((o.getCompanyName()));

        if (lv1 == 0) {
            return this.getEarnings().compareTo(o.getEarnings());
        } else {
            return lv1;
        }
    }
}
