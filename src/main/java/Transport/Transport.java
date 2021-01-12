package Transport;

import Cargos.Cargo;
import Cargos.CargoNecessaryInformation;
import Persons.Client;
import Persons.Employee;
import Persons.Factory.ClientArgs;
import Persons.Factory.EmployeeArgs;
import Persons.PersonFactory;
import Vehicles.Vehicle;
import utility.FeeCalculation.GenericFeeCalculator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Mutable class. A {@code Transport} consists of logical information for
 * transporting cargo from date x to date y with given destination z.
 * <p>
 * It contains information for the vehicle and driver who are going to do
 * the delivery, necessary information about the cargo itself, the client
 * who gave the cargo and the price for the certain delivery.
 * </p>
 *
 * <p>
 * Class contains an inner builder who is recommended for use upon creating objects.
 * For additional use there is an constructor with arguments.
 * </p>
 *
 * <p>
 * Class uses {@link utility.FeeCalculation.FeeCalculator} instance for calculation the cost evaluation.
 * To have the necessary information {@link utility.FeeCalculation.FeeCalculator}
 * uses {@link CargoNecessaryInformation}.
 * </p>
 *
 * @author Vladislav Zlatanov
 */
public class Transport implements java.io.Serializable {
    /**
     * The starting date of the transport
     */
    private Date dateOfBegin;
    /**
     * The ending date of the transport
     */
    private Date dateOfEnd;
    /**
     * Travel destination for the desired location measured in km
     */
    private double destination; //in km
    /**
     * Client who ordered the transportation
     */
    private Client client;
    /**
     * Required information from the cargo for the transportation.
     */
    private CargoNecessaryInformation cargoToBeTransported;
    /**
     * Flags if the client payed the transport or not.
     */
    private boolean isPayed;

    /**
     * Price required for the transport.
     */
    private BigDecimal priceForTransport;

    /**
     * Driver who is going to init. the transportation.
     */
    private Employee driver;

    /**
     * Vehicle which is going to be used for the transportation
     */
    private Vehicle vehicle;


    /**
     * No argument constructor intended to be used from builder.
     */
    private Transport() {
        dateOfBegin = null;
        dateOfEnd = null;
        destination = 0.0;
        client = null;
        cargoToBeTransported = null;
        isPayed = false;
        priceForTransport = null;
        driver = null;
    }

    /**
     * Arg constructor intended to be used as an alternative option.
     * *Not recommended*.
     */
    public Transport(Date dateOfBegin, Date dateOfEnd, double destination, Client client, boolean isPayed, Employee driver, Vehicle vehicle) {
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
        this.destination = destination;
        this.client = client;
        this.cargoToBeTransported = client.getCargo();
        this.priceForTransport = calculateTransportPrice();
        this.driver = driver;
        this.vehicle = vehicle;
        this.isPayed = isPayed;
    }


    /**
     * @return Beginning date of the transportation,
     */
    public Date getDateOfBegin() {
        return dateOfBegin;
    }

    /**
     * Sets the date of begin.
     *
     * @param dateOfBegin date to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setDateOfBegin(Date dateOfBegin) {
        if (Objects.isNull(dateOfBegin)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.dateOfBegin = dateOfBegin;
    }

    /**
     * @return @return Ending date of the transportation
     */
    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    /**
     * Sets the date of ending.
     *
     * @param dateOfEnd date to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setDateOfEnd(Date dateOfEnd) {
        if (Objects.isNull(dateOfEnd)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.dateOfEnd = dateOfEnd;
    }

    /**
     * @return Destination in km to the desired location.
     */
    public double getDestination() {
        return destination;
    }

    /**
     * Sets the destination to an location
     *
     * @param destination destination to be set.
     */
    public void setDestination(double destination) {
        this.destination = destination;
    }

    /**
     * @return Client who required the transportation.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client who wants the transportation.
     *
     * @param client client to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setClient(Client client) {
        if (Objects.isNull(client)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.client = client;
    }

    /**
     * @return Cargo that is going to be transported.
     */
    public Cargo getCargoToBeTransported() {
        return (Cargo) cargoToBeTransported;
    }

    /**
     * Sets the cargo which will be transported.
     *
     * @param cargoToBeTransported cargo to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setCargoToBeTransported(Cargo cargoToBeTransported) {
        if (Objects.isNull(cargoToBeTransported)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.cargoToBeTransported = cargoToBeTransported;
    }

    /**
     * @return If the transportation is payed.
     */
    public boolean isPayed() {
        return isPayed;
    }

    /**
     * Sets the flag for payment
     *
     * @param payed boolean to be set.
     */
    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    /**
     * @return Price for the transportation.
     */
    public BigDecimal getPriceForTransport() {
        return priceForTransport;
    }

    /**
     * Sets the price for the transportation.
     *
     * @param priceForTransport price to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setPriceForTransport(BigDecimal priceForTransport) {
        if (Objects.isNull(priceForTransport)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.priceForTransport = priceForTransport;
    }

    /**
     * @return Driver who is going to do the transportation.
     */
    public Employee getDriver() {
        return driver;
    }

    /**
     * Sets the driver that is going to do the transport.
     *
     * @param driver driver to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setDriver(Employee driver) {
        if (Objects.isNull(driver)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.driver = driver;
    }

    /**
     * @return vehicle that is going to be used for the transportation.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets the vehicle that is going to be used for the transport
     *
     * @param vehicle vehicle to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setVehicle(Vehicle vehicle) {
        if (Objects.isNull(vehicle)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.vehicle = vehicle;
    }

    /**
     * Compare this {@code Transport} with the specified {@code Object } for equality.
     *
     * @param o {@code Object} to which this {@code Transport} is to be compared.
     * @return {@code true} if the specified {@code Object} is a {@code Transport}
     * which values are equal to {@code Transport}'s
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.destination, destination) == 0 &&
                isPayed == transport.isPayed &&
                Objects.equals(dateOfBegin, transport.dateOfBegin) &&
                Objects.equals(dateOfEnd, transport.dateOfEnd) &&
                Objects.equals(client, transport.client) &&
                Objects.equals(cargoToBeTransported, transport.cargoToBeTransported) &&
                Objects.equals(priceForTransport, transport.priceForTransport) &&
                Objects.equals(driver, transport.driver) &&
                Objects.equals(vehicle, transport.vehicle);
    }

    /**
     * Returns the hash code for this {@code Transport}.
     *
     * @return hash code for this {@code Transport}
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateOfBegin, dateOfEnd, destination, client, cargoToBeTransported, isPayed, priceForTransport, driver, vehicle);
    }

    /**
     * @return the string representation of this {@code Transport}.
     */
    @Override
    public String toString() {
        return "Transport{" +
                "dateOfBegin=" + dateOfBegin +
                ", dateOfEnd=" + dateOfEnd +
                ", destination=" + destination +
                ", client=" + client +
                ", cargoToBeTransported=" + cargoToBeTransported +
                ", isPayed=" + isPayed +
                ", priceForTransport=" + priceForTransport +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                '}';
    }

    /**
     * Method evaluates the specific price per kilometer using an singleton instance of
     * {@code GenericFeeCalculator} which implements {@code FeeCalculator} with arguments
     * from {@code CargoNecessaryInformation} then it is saved to a {@code BigDecimal}.
     * Then, the result from {@code GenericFeeCalculator} is multiplied with the total distance
     * and returns the result as {@code BigDecimal}.
     *
     * @return The price for this {@code Transport}
     * @see GenericFeeCalculator
     * @see utility.FeeCalculation.FeeCalculator
     * @see CargoNecessaryInformation
     */
    protected BigDecimal calculateTransportPrice() {
        BigDecimal pricePerKm = GenericFeeCalculator.getInstance().calculateFee(getCargoToBeTransported());
        BigDecimal km = BigDecimal.valueOf(getDestination());
        return km.multiply(pricePerKm);
    }

    /**
     * A {@code TransportBuilder} is an inner static class which adopts the builder design pattern.
     * <p>
     * Class is designed to be used from {@code Transport}.
     * </p>
     * Class contains identical properties with {@code Transport}.
     *
     * @see Transport
     */
    public static class TransportBuilder {
        private Date dateOfBegin;
        private Date dateOfEnd;
        private double destination = 0; //in km
        private Client client;
        private Cargo cargoToBeTransported;
        private boolean isPayed;

        private BigDecimal priceForTransport;

        private Employee driver;
        private Vehicle vehicle;

        /**
         * @param transportStartDate parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withDateOfBegin(Date transportStartDate) {
            if (Objects.isNull(transportStartDate)) {
                this.dateOfBegin = new Date();
            }
            this.dateOfBegin = transportStartDate;
            return this;
        }

        /**
         * @param transportEndDate parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withDateOfEnd(Date transportEndDate) {
            if (Objects.isNull(transportEndDate)) {
                this.dateOfEnd = new Date();
                return this;
            }
            this.dateOfEnd = transportEndDate;
            return this;
        }

        /**
         * @param destination parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withDestination(double destination) {

            this.destination = destination;
            return this;
        }

        /**
         * @param client parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withClient(Client client) {
            if (Objects.isNull(client)) {
                this.client = PersonFactory.getInstance()
                        .createPerson(new ClientArgs());
                return this;
            }
            this.client = client;
            return this;
        }

        /**
         * Method sets the cargo information from the client and sets it to it's own property.
         * <p></p>
         * Method intended for inner use only.
         */
        protected void withCargo() {
            this.cargoToBeTransported = this.client.getCargo();
        }

        /**
         * @param cargo parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withCargo(Cargo cargo) {
            this.cargoToBeTransported = cargo;
            return this;
        }

        /**
         * @param priceForTransport parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withPriceForTransport(BigDecimal priceForTransport) {
            this.priceForTransport = priceForTransport;
            return this;
        }

        /**
         * @param isPayed parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder isPayed(boolean isPayed) {
            this.isPayed = isPayed;
            return this;
        }

        /**
         * @param vehicle parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withVehicle(Vehicle vehicle) {
            if (Objects.isNull(vehicle)) {
                this.vehicle = new Vehicle.VechicleBuilder().build();
                return this;
            }
            this.vehicle = vehicle;
            return this;
        }

        /**
         * @param driver parameter to be set to property.
         * @return this {@code TransportBuilder}
         */
        public TransportBuilder withDriver(Employee driver) {
            if (Objects.isNull(driver)) {
                this.driver = PersonFactory.getInstance().createPerson(new EmployeeArgs());
                return this;
            }
            this.driver = driver;
            return this;
        }

        /**
         * Method builds a new instance of type {@code Transport}
         * <p>
         * Method uses default constructor for {@code Transporter} to create an empty instance,
         * Then it fills it with it's personal properties which is happening directly since {@code TransportBuilder}
         * is an inner class of {@code Transport} and can access directly private fields.
         * </p>
         * Upon creation of the instance, there is a check if price for the transport is {@code null}, due it's optional.
         * If it's not, newly created instance calls it's price evaluation method.
         *
         * @return complete object of {@code Transport}
         */
        public Transport build() {
            Transport transport = new Transport();

            if (Objects.isNull(client)) {
                client = PersonFactory.getInstance()
                        .createPerson(new ClientArgs());
            }
            if (this.cargoToBeTransported == null && this.client != null) {
                this.withCargo();
            }
            if (Objects.isNull(dateOfBegin)) {
                dateOfBegin = new Date();
            }
            if (Objects.isNull(dateOfEnd)) {
                dateOfEnd = new Date();
            }
            if (Objects.isNull(vehicle)) {
                vehicle = new Vehicle.VechicleBuilder().build();
            }
            if (Objects.isNull(driver)) {
                driver = PersonFactory.getInstance().createPerson(new EmployeeArgs());
            }

            transport.dateOfBegin = this.dateOfBegin;
            transport.dateOfEnd = this.dateOfEnd;
            transport.destination = this.destination;
            transport.client = this.client;
            transport.cargoToBeTransported = this.cargoToBeTransported;
            transport.priceForTransport = this.priceForTransport;
            transport.isPayed = this.isPayed;
            transport.vehicle = this.vehicle;
            transport.driver = this.driver;
            if (priceForTransport == null) {
                transport.priceForTransport = transport.calculateTransportPrice();
            }

            return transport;
        }

    }

}
