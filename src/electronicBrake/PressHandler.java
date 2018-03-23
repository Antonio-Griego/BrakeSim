import PhysicalDrivers.BrakeButtonDriver;
import VirtualDevices.BrakeButton;

/**
 * This class keeps track of button presses.
 */

public class PressHandler
{
  public enum PressType
  {
    SHORT, LONG, RELEASED
  }
  
  private final BrakeButton brakeButton;
  private PressType pressType;
  private long start;
  
  /**
   * Creates the PressHandler with a BrakeButton virtual device from the simulation
   * @param brakeButton
   */
  public PressHandler(BrakeButton brakeButton)
  {
    this.brakeButton = brakeButton;
    pressType = PressType.RELEASED;
    updatePressType();
  }
  
  /**
   * Updates the current press type and then returns it.
   * @return
   */
  public PressType getPressType()
  {
    updatePressType();
    return pressType;
  }
  
  /**
   * Keeps track of the amount of time the button has been pressed for and sets the press type to Long press for press time greater than
   * or equal to 4 seconds, short press for shorter than 4 seconds and Released for the button not being pressed at all.
   */
  private void updatePressType()
  {
    if(brakeButton.getPosition() == BrakeButtonDriver.Position.DOWN)
    {
      if(pressType == PressType.RELEASED)
      {
        pressType = PressType.SHORT;
        start = System.currentTimeMillis();
      }
      
      else if(pressType == PressType.SHORT && System.currentTimeMillis()-start >= 4000)
      {
        pressType = PressType.LONG;
      }
    }
    
    else
    {
      pressType = PressType.RELEASED;
      start = 0;
    }
  }
}
