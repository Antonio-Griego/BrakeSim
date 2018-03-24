package electronicBrake;

import VirtualDevices.BrakeButton;
import VirtualDevices.VehicleElectronics;
import electronicBrake.enums.EventTypes;

/**
 * Created by Antonio on 3/23/18.
 *
 * Dummy class so that I can continue working on the Controller (EBS) module.
 * Please replace this class with the working module.
 */
public class Events
{
  BrakeControl brakeControl;
  BrakeButton brakebutton;
  VehicleElectronics vehicleElectronics;
  // PressHandler pressHandler;
  // GearHandler gearHandler;

  public Events(BrakeControl brakeControl,
                BrakeButton brakeButton,
                VehicleElectronics vehicleElectronics)
  {
    this.brakeControl = brakeControl;
    this.brakebutton = brakeButton;
    this.vehicleElectronics = vehicleElectronics;
  }

  public boolean didEventOccur(EventTypes event)
  {
    return (Math.random() < 0.5);
  }
}
