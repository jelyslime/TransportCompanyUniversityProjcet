package Vehicles;


import utility.CATEGORY;

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
    final int vehicleId = VechiclesIdCounterSingleton.getInstance().counter.incrementAndGet();
    private CATEGORY categoryRequired;
    private BigDecimal pricePerKm;
    private VEHICLE_TRANSPORT_TYPE transportType;
    private VEHICLE_TYPE vehicleType;
    private double maximumCapacity;

    /**
     * Private no-args constructor guarantees no "empty" instances of class will be created.
     */
    private Vehicle() {
        this.categoryRequired = CATEGORY.B;
        pricePerKm = new BigDecimal("0.0");
        this.maximumCapacity = 0.0;
        transportType = VEHICLE_TRANSPORT_TYPE.PASSENGER;
        vehicleType = VEHICLE_TYPE.BANICHARKA;
    }

    /**
     * @return transport type of current object
     * @see VEHICLE_TRANSPORT_TYPE
     */
    public VEHICLE_TRANSPORT_TYPE getTransportType() {
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
     * @see VEHICLE_TRANSPORT_TYPE
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
     *
     * @return Necessary category to use vehicle.
     * @see CATEGORY
     */
    public CATEGORY getCategoryRequired() {
        return categoryRequired;
    }

    /**
     *
     * @return price for kilometer.
     */
    public BigDecimal getPricePerKm() {
        return pricePerKm;
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
     * @see Vehicle
     */
    public static class VechicleBuilder {
        private CATEGORY categoryRequired;
        private BigDecimal pricePerKm;
        private VEHICLE_TRANSPORT_TYPE transportType;
        private VEHICLE_TYPE vehicleType;
        private double maximumCapacity;

        /**
         * Sets object local property to the one from the parameter.
         * @param category Category necessary to drive current vehicle.
         * @return this
         * @see CATEGORY
         */
        public VechicleBuilder withCategory(CATEGORY category) {
            this.categoryRequired = category;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         * @param transportType Type being transported with current vehicle.
         * @return this
         * @see VEHICLE_TRANSPORT_TYPE
         */
        public VechicleBuilder transportType(VEHICLE_TRANSPORT_TYPE transportType) {
            this.transportType = transportType;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         * @param vehicleType Type of current vehicle.
         * @return this
         * @see VEHICLE_TYPE
         */
        public VechicleBuilder vechicleType(VEHICLE_TYPE vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         * @param capacity Capacity of current vehicle.
         * @return this
         */
        public VechicleBuilder withMaximumCapacity(double capacity) {
            this.maximumCapacity = capacity;
            return this;
        }

        /**
         * Sets object local property to the one from the parameter.
         * @param price Price for travelling per km.
         * @return this
         * @see BigDecimal
         */
        public VechicleBuilder withPricePerKm(BigDecimal price) {
            this.pricePerKm = price;
            return this;
        }

        /**
         * Builds and returns instance of Vehicle
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
