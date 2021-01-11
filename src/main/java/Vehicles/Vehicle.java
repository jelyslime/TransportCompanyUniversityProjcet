package Vehicles;


import TransportCompany.TransportCompany;
import utility.CATEGORY;
import utility.TRANSPORT_TYPE;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * All type of vehicles from the perspective of an transporting company.
 * <p>
 * No validation of the parameters "logical" correctness is presented, because parameters as maximum capacity should be checked from the producer.
 * </p>
 *
 * <p>
 * Class adopts builder design pattern with VechicleBuilder inner class.
 *
 * </p>
 *
 * @see VechicleBuilder
 */
public class Vehicle {
    final int vehicleId = VechiclesIdCounterSingleton.getInstance()
            .counter.incrementAndGet(); //auto generated id
    private CATEGORY categoryRequired; //Category required for the vehicle to be driven.
    private BigDecimal pricePerKm; //price per kilometer for driving vehicle.
    private TRANSPORT_TYPE transportType; //type of cargo that vehicle is suited for
    private VEHICLE_TYPE vehicleType; //type of the vehicle.
    private double maximumCapacity; //maximum load capacity.

    /**
     * Private no-args constructor for the use of {@link VechicleBuilder}
     */
    private Vehicle() {

    }

    /**
     * All-args constructor.
     *
     * <P>Not recommended to be used,
     * because it makes code unreadable and there are no
     * null checks for given arguments.</P>
     *
     * <p>For creating instances of {@link Vehicle} use {@link VechicleBuilder}.</p>
     * @param categoryRequired Category required for the vehicle to be driven.
     * @param pricePerKm price per kilometer for driving vehicle.
     * @param transportType type of cargo that vehicle is suited for
     * @param vehicleType type of the vehicle.
     * @param maximumCapacity maximum load capacity.
     */
    public Vehicle(CATEGORY categoryRequired, BigDecimal pricePerKm,
                   TRANSPORT_TYPE transportType, VEHICLE_TYPE vehicleType, double maximumCapacity) {
        this.categoryRequired = categoryRequired;
        this.pricePerKm = pricePerKm;
        this.transportType = transportType;
        this.vehicleType = vehicleType;
        this.maximumCapacity = maximumCapacity;
    }

    /**
     * @return transport type of current object
     * @see TRANSPORT_TYPE
     */
    public TRANSPORT_TYPE getTransportType() {
        return transportType;
    }

    /**
     * @return vechicle type of current object
     * @see VEHICLE_TYPE
     */
    public VEHICLE_TYPE getVehicleType() {
        return vehicleType;
    }

    /**
     * @return maximum capacity of current object
     * Meaning of maximum capacity may vary from small to large value
     * because if VEHICLE_TRANSPORT_TYPE is PERSON it will represent the maximum number of passengers for this vehicle,
     * if it is PRODUCT It will represent the maximum weight that can be uploaded to the vehicle.
     * @see TRANSPORT_TYPE
     */
    public double getMaximumCapacity() {
        return maximumCapacity;
    }

    /**
     * Vehicle id is auto-generated.
     *
     * @return vehicle id
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * @return Necessary category to use vehicle.
     * @see CATEGORY
     */
    public CATEGORY getCategoryRequired() {
        return categoryRequired;
    }

    /**
     * @return price for kilometer.
     */
    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

    public void setCategoryRequired(CATEGORY categoryRequired) {
        if (Objects.isNull(categoryRequired)){
            throw new IllegalArgumentException("Argument is null.");
        }
        this.categoryRequired = categoryRequired;
    }

    public void setPricePerKm(BigDecimal pricePerKm) {
        if (Objects.isNull(pricePerKm)){
            throw new IllegalArgumentException("Argument is null.");
        }
        this.pricePerKm = pricePerKm;
    }

    public void setTransportType(TRANSPORT_TYPE transportType) {
        if (Objects.isNull(transportType)){
            throw new IllegalArgumentException("Argument is null.");
        }
        this.transportType = transportType;
    }

    public void setVehicleType(VEHICLE_TYPE vehicleType) {
        if (Objects.isNull(vehicleType)){
            throw new IllegalArgumentException("Argument is null.");
        }
        this.vehicleType = vehicleType;
    }

    public void setMaximumCapacity(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", categoryRequired=" + categoryRequired +
                ", pricePerKm=" + pricePerKm +
                ", transportType=" + transportType +
                ", vehicleType=" + vehicleType +
                ", maximumCapacity=" + maximumCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId == vehicle.vehicleId &&
                Double.compare(vehicle.maximumCapacity, maximumCapacity) == 0 &&
                categoryRequired == vehicle.categoryRequired &&
                pricePerKm.equals(vehicle.pricePerKm) &&
                transportType == vehicle.transportType &&
                vehicleType == vehicle.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, categoryRequired, pricePerKm, transportType, vehicleType, maximumCapacity);
    }

    /**
     * Builder design pattern for Vehicle class.
     *
     * @see Vehicle
     */
    public static class VechicleBuilder {
        private CATEGORY categoryRequired;
        private BigDecimal pricePerKm;
        private TRANSPORT_TYPE transportType;
        private VEHICLE_TYPE vehicleType;
        private double maximumCapacity;

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param category Category necessary to drive current vehicle.
         * @return this
         * @see CATEGORY
         */
        public VechicleBuilder withCategory(CATEGORY category) {
            if (Objects.isNull(category)){
                this.categoryRequired = CATEGORY.B;
            }
            this.categoryRequired = category;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param transportType Type being transported with current vehicle.
         * @return this
         * @see TRANSPORT_TYPE
         */
        public VechicleBuilder transportType(TRANSPORT_TYPE transportType) {
            if (Objects.isNull(transportType)){
                this.transportType = TRANSPORT_TYPE.PASSENGER;
            }
            this.transportType = transportType;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param vehicleType Type of current vehicle.
         * @return this
         * @see VEHICLE_TYPE
         */
        public VechicleBuilder vechicleType(VEHICLE_TYPE vehicleType) {
            if (Objects.isNull(vehicleType)){
                this.vehicleType = VEHICLE_TYPE.BANICHARKA;
            }
            this.vehicleType = vehicleType;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param capacity Capacity of current vehicle.
         * @return this
         */
        public VechicleBuilder withMaximumCapacity(double capacity) {
            this.maximumCapacity = capacity;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         *
         * @param price Price for travelling per km.
         * @return this
         * @see BigDecimal
         */
        public VechicleBuilder withPricePerKm(BigDecimal price) {
            if (Objects.isNull(price)){
                this.pricePerKm = BigDecimal.ZERO;
            }
            this.pricePerKm = price;
            return this;
        }

        /**
         * Builds and returns instance of Vehicle
         *
         * @return vehicle
         * @see Vehicle
         */
        public Vehicle build() {
            Vehicle vehicle = new Vehicle();

            vehicle.vehicleType = this.vehicleType;
            vehicle.categoryRequired = this.categoryRequired;
            vehicle.pricePerKm = this.pricePerKm;
            vehicle.transportType = this.transportType;
            vehicle.maximumCapacity = this.maximumCapacity;

            return vehicle;
        }

    }
}
