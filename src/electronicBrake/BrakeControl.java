package electronicBrake;

import VirtualDevices.BrakeController;

/**
 * Acts as an interface between the VirtualDevices.BrakeController virtual device provided by the EHBS Simulation and the EHBS itself.
 */

public class BrakeControl
{
  private final BrakeController brakeController;
  private double force;
  private boolean engaged;
  
  
  /**
   * Initializes BrakeControl class. Saves the BrakeController object passed to it, and polls brakeController for the
   * initial force being applied to the brakes and the sets the engagement status accordingly.  If the brakes are not
   * fully engaged or disengaged at initialization, the system disengages them entirely.
   * @param brakeController
   */
  public BrakeControl(BrakeController brakeController)
  {
    this.brakeController = brakeController;
    
    if(brakeController.getBrakeStatus() == BrakeController.BrakeStatus.FULLY_ENGAGED)
    {
      setForce(1);
    }
    
    else if(brakeController.getBrakeStatus() == BrakeController.BrakeStatus.DISENGAGED)
    {
      setForce(0);
    }
    
    else
    {
      setForce(0);
    }
  }
  
  /**
   * Sets the local values of the force being applied and the engagement status.
   * Applies that force to the brakes through the brakeController
   * @param force
   */
  public void setForce(double force)
  {
    if(force >= 1)
    {
      force = 1;
      engaged = true;
    }
    
    if(force <= 0)
    {
      force = 0;
      engaged = false;
    }
    
    this.force = force;
    brakeController.applyForce(force);
  }
  
  /**
   * Returns the value of the force being applied to the brakes
   * @return
   */
  public double getForce()
  {
    return force;
  }
  
  /**
   * Returns whether or not the brakes are currently engaged
   * @return
   */
  public boolean isEngaged()
  {
    return engaged;
  }
}
