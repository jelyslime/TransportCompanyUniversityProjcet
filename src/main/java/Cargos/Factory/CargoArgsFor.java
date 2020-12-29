package Cargos.Factory;

import Cargos.Cargo;

/**
 * Interface serve as an markup interface for cargo factory
 *
 * @param <T> interface is tied to T, the compiler can infer the rest when choosing what to build in factory.
 *
 *            <p>
 * @see Cargos.CargoFactory Concreate factory that uses interface.
 * </p>
 * @see MaterialArgs Excample of interface implementaiton.
 */
public interface CargoArgsFor<T extends Cargo> {

}
