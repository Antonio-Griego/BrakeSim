package electronicBrake.enums;

public enum StateType
{
  /**
   * Initial state before system has gathered any information about the state.
   */
  NULL,

  /**
   * State when vehicle is in park and the brakes are engaged.
   */
  PARKED_ENGAGED,

  /**
   * State when vehicle is in park and the     brakes are not engaged.
   */
  PARKED_DISENGAGED,

  /**
   * State when vehicle is not in park and the brakes are not engaged.
   */
  NOT_IN_PARK_DISENGAGED,

  /**
   * State when vehicle is not in park and the brakes are engaged fully.
   */
  NOT_IN_PARK_ENGAGED,

  /**
   * State where the brakes are in the process of engaging while the vehicle is driving
   */
  ENGAGING,

  /**
   * State where the alarm is being sounded and the color of the lights changes to orange.
   */
  WARN,

  /**
   * Same thing as WARN except a long press results in an immediate disengage.
   */
  ENGAGING_WARN
}
