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

/**
 * Mutable class. A {@code TransportCompany} consists of logical information for
 * transport company.
 * <p>
 * It contains information for the vehicles owned by the company, employees who work in the company,
 * transportation queries from clients, list of clients who work with current company and
 * earnings made by the company.
 * </p>
 *
 * <p>
 * Class contains an inner builder who is recommended for use upon creating objects.
 * For additional use there is an constructor with arguments.
 * </p>
 *
 * @author Vladislav Zlatanov
 */
public class TransportCompany implements Comparable<TransportCompany> {
    private String companyName;
    private List<Vehicle> vehicles;
    private List<Employee> employees;
    private Map<Transport, Client> transports;

    private BigDecimal earnings;

    private List<Client> clients;

    /**
     * All-args constructor.
     *
     * <P>Not recommended to be used,
     * because it makes code unreadable and there are no
     * null checks for given arguments.</P>
     *
     * <p>For creating instances of {@link TransportCompany} use {@link TransportCompanyBuilder}.</p>
     *
     * @param companyName Name of the company.
     * @param vehicles    {@link Vehicle}s owned by the company.
     * @param employees   {@link Employee}s who work in the company.
     * @param transports  {@link Transport}s queried to company.
     * @param earnings    Earnings made by company.
     * @param clients     {@link Client}s who work with company.
     */
    public TransportCompany(String companyName, List<Vehicle> vehicles, List<Employee> employees,
                            Map<Transport, Client> transports, BigDecimal earnings, List<Client> clients) {
        this.companyName = companyName;
        this.vehicles = vehicles;
        this.employees = employees;
        this.transports = transports;
        this.earnings = earnings;
        this.clients = clients;
    }

    /**
     * Private no-args constructor for the use of {@link TransportCompanyBuilder}
     */
    private TransportCompany() {

    }

    /**
     * Clears all information stored in this.
     */
    public void delete() {
        setCompanyName("");
        getTransportsLikeMap().clear();
        getVehicles().clear();
        getClients().clear();
        getEmployees().clear();
        setEarnings(BigDecimal.ZERO);
    }

    /**
     * Removes vehicle from vehicles list.
     *
     * @param vehicleToBeRemoved {@link Vehicle} which will be removed from list.
     * @return true if vehicle is removed from list/false if vehicle was not in list, thus it was not removed from list.
     */
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

    /**
     * Removes client from clients list.
     *
     * @param clientToBeRemoved {@link Client} which will be removed from list.
     * @return true if {@link Client} is removed from list/false if {@link Client} was not in list, thus it was not removed from list.
     */
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

    /**
     * Removes employee from employees list.
     *
     * @param employeeToBeRemoved {@link Employee} which will be removed from list.
     * @return true if {@link Employee} is removed from list/
     * false if {@link Employee} was not in list, thus it was not removed from list.
     */
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

    /**
     * Removes transport from transport list.
     *
     * @param transport {@link Transport} which will be removed from list.
     * @return true if {@link Transport}  is removed from list/
     * false if {@link Transport}  was not in list, thus it was not removed from list.
     */
    public boolean deleteTransport(Transport transport) {
        if (getTransportsLikeMap().containsKey(transport)) {
            return false;
        }

        getTransportsLikeMap().remove(transport);
        return true;
    }

    /**
     * Changes name of company.
     *
     * @param newName name which will be removed from list.
     * @return true if name is changed /
     * false if newName is same as the current name.
     */
    public boolean changeName(String newName) {
        if (getCompanyName().equals(newName)) {
            return false;
        }
        setCompanyName(newName);
        return true;
    }

    /**
     * Decreases earnings with the value given as parameter.
     *
     * @param valueToDecrease value to subtract with.
     * @return true if value is decreased/false if
     * subtraction will made earnings to negative value.
     */
    public boolean decreaseEarnings(BigDecimal valueToDecrease) {
        if (getEarnings().subtract(valueToDecrease).compareTo(BigDecimal.ZERO) > 0) {
            return false;
        }
        setEarnings(getEarnings().subtract(valueToDecrease));
        return true;
    }

    /**
     * Adds transport to transport list.
     *
     * @param transport {@link Transport} which will be added to list.
     * @return true if {@link Transport}  is added from list/
     * false if {@link Transport}  was already in list.
     */
    public boolean addTransport(Transport transport) {
        if (getTransportsLikeMap().containsKey(transport)) {
            return false;
        }
        getTransportsLikeMap().put(transport, transport.getClient());
        return true;
    }

    /**
     * Adds vehicle to vehicles list.
     *
     * @param vehicle {@link Vehicle} which will be added to list.
     * @return true if {@link Vehicle}  is added from list/
     * false if {@link Vehicle}  was already in list.
     */
    public boolean addVehicle(Vehicle vehicle) {
        if (getVehicles().contains(vehicle)) {
            return false;
        }
        getVehicles().add(vehicle);
        return true;
    }

    /**
     * Adds employee to employees list.
     *
     * @param employee {@link Employee} which will be added to list.
     * @return true if {@link Employee}  is added from list/
     * false if {@link Employee}  was already in list.
     */
    public boolean addEmployee(Employee employee) {
        if (getEmployees().contains(employee)) {
            return false;
        }
        getEmployees().add(employee);
        return true;
    }

    /**
     * Adds client to clients list.
     *
     * @param client {@link Client} which will be added to list.
     * @return true if {@link Client}  is added from list/
     * false if {@link Client}  was already in list.
     */
    public boolean addClient(Client client) {
        if (getClients().contains(client)) {
            return false;
        }
        getClients().add(client);
        return true;
    }

    /**
     * Increases earnings with the value given as parameter.
     *
     * @param valueToIncrease value to add.
     */
    public void increaseEarnings(BigDecimal valueToIncrease) {
        setEarnings(getEarnings().add(valueToIncrease));
    }

    /**
     * Method checks if an client is in obligation.
     *
     * <p>Obligation means that a client have queried an transportation/s but haven't payed it yet.</p>
     *
     * @param client {@link Client} to be checked for obligation
     * @return true if {@link Client} is in obligation/false if {@link Client} is not in obligation.
     */
    public boolean isClientInObligation(Client client) {
        Set<Map.Entry<Transport, Client>> entries = getTransportsLikeMap().entrySet();

        for (Map.Entry<Transport, Client> entry : entries) {
            if (entry.getValue().equals(client)) {
                if (entry.getKey().isPayed() == false) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Sorts employee list of this company by salary then by category
     *
     * @return Sorted list of {@link Employee}s
     */
    public List<Employee> sortEmployee() {
        List<Employee> employees = getEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getCategory))
                .collect(Collectors.toList());
        return employees;
    }

    /**
     * Sorts transport list of this company by destination
     *
     * @return Sorted list of {@link Transport}s
     */
    public List<Transport> sortTransports() {
        List<Transport> transports = getTransportsLikeMap().entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .sorted(Comparator.comparing(Transport::getDestination))
                .collect(Collectors.toList());

        return transports;
    }

    /**
     * Writes transport list to given {@link File}
     *
     * @param file {@link File} to be written to.
     * @return true if transports are written/ false if writing was not
     * successful.
     */
    public boolean writeTransportsToFile(File file) {

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
            writer.writeObject(this.getTransportsLikeMap());
            return true;
        } catch (IOException e) {
            //log exception.
            return false;
        }

    }

    /**
     * Reads transports from given {@link File}
     *
     * <p>Method returns empty list if reading was not successful</p>
     *
     * @param file {@link File} to be read from.
     * @return list of transports read from file.
     */
    public List<Transport> readTransportsFromFile(File file) {
        List<Transport> list = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Transport>) reader.readObject();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            return list;
        }
    }

    /**
     * Method reads transports from file and writes them to personal list.
     *
     * <p>Method will skip transports who are already in the list.</p>
     *
     * @param file {@link File} to be read from.
     * @return true if any data was written to list/ false if no date was written.
     */
    public boolean readAndWriteTransportsToCompany(File file) {
        List<Transport> list = this.readTransportsFromFile(file);
        if (list.isEmpty()) {
            return false;
        }

        for (Transport transport : list) {
            this.getTransportsLikeMap().putIfAbsent(transport, transport.getClient());
        }
        return true;
    }

    /**
     * Reports how many transports were made from the first transport to the current date.
     *
     * @return report as {@link String}
     */
    public String reportHowManyTransportsHaveBeenMade() {
        Date date = new Date();

        List<Transport> transports = this.getTransportsLikeMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfEnd().before(date))
                .collect(Collectors.toList());

        return "All transports made to current date: " + Integer.valueOf(transports.size()).toString();
    }

    /**
     * Reports how many money were made from transport from the first transport to the current date.
     *
     * @return report as {@link String}
     */
    public String reportSumOfMadeTransports() {
        Date date = new Date();

        BigDecimal money = this.getTransportsLikeMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfEnd().before(date))
                .map(transport -> transport.getPriceForTransport())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Money earned from transports made to current date: " + money;
    }

    /**
     * Reports how many times an employee was assigned to execute an transport.
     *
     * @return report as {@link String}
     */
    public String timesEmployeesDrove() {
        Map<Employee, Integer> map = this.getEmployees()
                .stream()
                .collect(Collectors.toMap(Function.identity(), this::timesDrove));

        StringBuilder result = new StringBuilder();
        Set<Map.Entry<Employee, Integer>> entries = map.entrySet();

        result.append("Times employees drove\n");

        for (Map.Entry<Employee, Integer> entry : entries) {
            String str = String.format("Employee %s : %s trips.\n",
                    entry.getKey().getName(), entry.getValue());
            result.append(str);
        }


        return result.toString();
    }

    /**
     * Reports earnings made for a period
     *
     * @param begin {@link Date} from where period begins
     * @param end   {@link Date} from where period ends
     * @return report as {@link String}
     */
    public String earningsOnPeriod(Date begin, Date end) {
        BigDecimal money = this.getTransportsLikeMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfBegin().after(begin) && transport.getDateOfEnd().before(end))
                .map(moneyToSum -> moneyToSum.getPriceForTransport())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return String.format("Earnings made between %s and %s are %s", begin, end, money);
    }

    /**
     * Reports earnings made for a period from specific {@link Employee}
     *
     * @param begin    {@link Date} from where period begins
     * @param end      {@link Date} from where period ends
     * @param employee {@link Employee} to be checked for.
     * @return report as {@link String}
     */
    public String earningsOnPeriodFromEmployee(Date begin, Date end, Employee employee) {
        BigDecimal money = this.getTransportsLikeMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDateOfBegin().after(begin) && transport.getDateOfEnd().before(end))
                .filter(transport -> transport.getDriver().equals(employee))
                .map(moneyToSum -> moneyToSum.getPriceForTransport())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return String.format("Earnings made between %s and %s from employee %s are %s", begin, end, employee.getName(), money);
    }

    /**
     * Method is only for inner use.
     * <p>Method calculates how many an {@link Employee} drove an transport</p>
     *
     * @param employee {@link Employee} to check.
     * @return times employee drove.
     */
    private int timesDrove(Employee employee) {
        long times = this.getTransportsLikeMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .filter(transport -> transport.getDriver().equals(employee))
                .count();

        return (int) times;
    }

    /**
     * Auto-generated getter
     *
     * @return the name of the company
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Auto-generated setter.
     *
     * @param companyName new company name.
     */
    public void setCompanyName(String companyName) {
        if (Objects.isNull(companyName)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.companyName = companyName;
    }

    /**
     * Auto-generated getter
     *
     * @return List of owned vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Auto-generated setter.
     *
     * @param vehicles new company vehicles list.
     */
    public void setVehicles(List<Vehicle> vehicles) {
        if (Objects.isNull(vehicles)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.vehicles = vehicles
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Auto-generated getter
     *
     * @return List of employees who work in the company.
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Auto-generated setter.
     *
     * @param employees new company employees list.
     */
    public void setEmployees(List<Employee> employees) {
        if (Objects.isNull(employees)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.employees = employees
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Auto-generated getter
     *
     * @return transports.
     */
    private Map<Transport, Client> getTransportsLikeMap() {
        return transports;
    }

    /**
     * Getter for transport list.
     *
     * @return transports.
     */
    public List<Transport> getTransports() {
        List<Transport> transports = getTransportsLikeMap().entrySet()
                .stream()
                .map(transportClientEntry -> transportClientEntry.getKey())
                .collect(Collectors.toList());

        return transports;
    }

    public void setTransports(List<Transport> transports) {
        if (Objects.isNull(transports)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        Map<Transport, Client> map = transports
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), Transport::getClient));

        setTransportsAsMap(map);
    }

    /**
     * Auto-generated setter.
     *
     * @param transports transports map.
     */
    private void setTransportsAsMap(Map<Transport, Client> transports) {
        this.transports = transports;
    }

    /**
     * Auto-generated getter
     *
     * @return earnings made by company.
     */
    public BigDecimal getEarnings() {
        return earnings;
    }

    /**
     * Auto-generated setter.
     *
     * @param earnings new company earnings.
     */
    public void setEarnings(BigDecimal earnings) {
        if (Objects.isNull(earnings)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.earnings = earnings;
    }

    /**
     * Auto-generated getter
     *
     * @return the list of clients working with this company.
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Auto-generated setter.
     *
     * @param clients new list of clients working with this company.
     */
    public void setClients(List<Client> clients) {
        if (Objects.isNull(clients)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.clients = clients
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Auto-generated equals
     *
     * @param o object to check for equality with this.
     * @return true if objects are equal, false if objects are not equal.
     */
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

    /**
     * Auto-generated hashcode.
     *
     * @return an hashcode for this.
     */
    @Override
    public int hashCode() {
        return Objects.hash(companyName, vehicles, employees, transports, earnings, clients);
    }

    /**
     * Method compares this object with parameter.
     * <p>
     * First the name of this and that is compared, then earnings of this and o are compared.
     *
     * <p>First comparison is by {@link String}'s natural comparing</p>
     * <p>Second comparison is by {@link BigDecimal}'s natural comparing</p>
     *
     * @param o object to compare with this.
     * @return 1 if this is bigger, 0 if this is equal with o,-1 if o is bigger.
     */
    @Override
    public int compareTo(TransportCompany o) {
        int lv1 = this.getCompanyName().compareTo((o.getCompanyName()));

        if (lv1 == 0) {
            return this.getEarnings().compareTo(o.getEarnings());
        } else {
            return lv1;
        }
    }

    /**
     * Auto-generated toString.
     *
     * @return {@link String} representation of {@link TransportCompany}
     */
    @Override
    public String toString() {
        return "TransportCompany{" +
                "companyName='" + companyName + '\'' +
                ", vehicles=" + vehicles +
                ", employees=" + employees +
                ", transports=" + transports +
                ", earnings=" + earnings +
                ", clients=" + clients +
                '}';
    }

    /**
     * Builder design pattern for Vehicle class.
     *
     * @see TransportCompany
     */
    public static class TransportCompanyBuilder {
        private String withCompanyName;
        private List<Vehicle> withVehicles;
        private List<Employee> withEmployees;
        private Map<Transport, Client> withTransports;

        private BigDecimal withEarnings;

        private List<Client> withClients;

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param companyName name of the company.
         * @return this.
         */
        public TransportCompanyBuilder withCompanyName(String companyName) {
            this.withCompanyName = companyName;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param vehicles List of {@link Vehicle} owned by company
         * @return this.
         */
        public TransportCompanyBuilder withVehicles(List<Vehicle> vehicles) {
            this.withVehicles = vehicles
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param employees List of {@link Employee} who work for the company.
         * @return this.
         */
        public TransportCompanyBuilder withEmployees(List<Employee> employees) {
            this.withEmployees = employees
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param transports List of {@link Transport} queried for company.
         * @return this.
         */
        public TransportCompanyBuilder withTransports(List<Transport> transports) {
            this.withTransports = transports
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toMap(Function.identity(), Transport::getClient));

            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param transports Map of {@link Transport} and
         *                   {@link Client} who asked the {@link Transport}.
         * @return this.
         */
        public TransportCompanyBuilder withTransports(Map<Transport, Client> transports) {
            this.withTransports = transports;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param earnings Earnings made by company.
         * @return this.
         */
        public TransportCompanyBuilder withEarnings(BigDecimal earnings) {
            this.withEarnings = earnings;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param clients List of {@link Client} who work with company.
         * @return this.
         */
        public TransportCompanyBuilder withClients(List<Client> clients) {
            this.withClients = clients
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            return this;
        }

        /**
         * Builds and returns instance of {@link TransportCompany}
         *
         * @return new instance of {@link TransportCompany} with parameter inside {@link TransportCompanyBuilder}
         * @see TransportCompany
         */
        public TransportCompany build() {
            TransportCompany transportCompany = new TransportCompany();

            if (Objects.isNull(withCompanyName)) {
                transportCompany.companyName = "";
            } else {
                transportCompany.companyName = this.withCompanyName;
            }

            if (Objects.isNull(withVehicles)) {
                transportCompany.vehicles = new ArrayList<>();
            } else {
                transportCompany.vehicles = this.withVehicles;
            }

            if (Objects.isNull(withEmployees)) {
                transportCompany.employees = new ArrayList<>();
            } else {
                transportCompany.employees = this.withEmployees;
            }

            if (Objects.isNull(withTransports)) {
                transportCompany.transports = new HashMap<>();
            } else {
                transportCompany.transports = this.withTransports;
            }

            if (Objects.isNull(withEarnings)) {
                transportCompany.earnings = BigDecimal.ZERO;
            } else {
                transportCompany.earnings = this.withEarnings;
            }

            if (Objects.isNull(withClients)) {
                transportCompany.clients = new ArrayList<>();
            } else {
                transportCompany.clients = this.withClients;
            }

            return transportCompany;
        }
    }
}
