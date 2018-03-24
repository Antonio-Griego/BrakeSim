package electronicBrake;

import Car.Gear;
import VirtualDevices.BrakeButton;
import VirtualDevices.VehicleElectronics;
import electronicBrake.enums.EventTypes;
import electronicBrake.PressHandler;
import electronicBrake.GearHandler;
import electronicBrake.BrakeControl;

/**
 * Created by caleb on 3/23/2018.
 */
public class Events {
    private BrakeControl brakeControl;
    private PressHandler pressHandler;
    private GearHandler gearHandler;
    public Events(BrakeControl brakeControl, BrakeButton brakeButton, VehicleElectronics vehicleElectronics){
        this.brakeControl = brakeControl;
        this.pressHandler = new PressHandler(brakeButton);
        this.gearHandler = new GearHandler(vehicleElectronics);
    }
    public boolean didEventOccur(EventTypes event){
        switch(event)
        {
            case PARKED:
                return isParked();
            case NOT_PARKED:
                return isNotParked();
            case SHORT_PRESS:
                return isShortPress();
            case LONG_PRESS:
                return isLongPressed();
            case RELEASED:
                return isReleased();
            case ENGAGED:
                return isEngaged();
            case DISENGAGED:
                return isDisengaged();
            default:
                return false;
        }
    }

    private boolean isParked(){
        if(gearHandler.getGear() == Gear.PARK) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isNotParked(){
        if(gearHandler.getGear() != Gear.PARK) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isShortPress(){
        if(pressHandler.getPressType() == PressHandler.PressType.SHORT) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isLongPressed(){
        if(pressHandler.getPressType() == PressHandler.PressType.LONG) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isReleased(){
        if(pressHandler.getPressType() == PressHandler.PressType.RELEASED) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isEngaged(){
        return brakeControl.isEngaged();
    }
    private boolean isDisengaged(){
        return !brakeControl.isEngaged();
    }
}
