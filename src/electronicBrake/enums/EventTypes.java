package electronicBrake.enums;

public enum  EventTypes
{
  /**
   * Returned when the vehicle is in park.
   */
  PARKED,
  /**
   * Returned when the vehicle is not in park.
   */
  NOT_PARKED,
  /**
   * Returned when a short press is registered.
   */
  SHORT_PRESS,
  /**
   * Returned when a long press is registered.
   */
  LONG_PRESS,
  /**
   * Returned when button is not being pressed
   */
  RELEASED,
  /**
   * Returned when the engagement status is at 100%.
   */
  ENGAGED,
  /**
   * Returned when the engagement status is at 0%.
   */
  DISENGAGED
}
