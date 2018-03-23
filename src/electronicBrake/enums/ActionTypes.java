package electronicBrake.enums;

public enum ActionTypes
{
  /**
   * Should result in full engagement of Brake Actuator.
   */
  FULL_ENGAGE,
  /**
   * Should result in disengagement Brake Actuator virtual component to 0.
   */
  FULL_DISENGAGE,
  /**
   * Should result in the brakes being engaged by 1/300 in order to
   * achieve a stopping time of at most 5 seconds if brakes are fully disengaged.
   */
  GRADUAL_ENGAGE,
  /**
   * Should turn halo light red.
   */
  RED,
  /**
   * Should turn halo light blue.
   */
  BLUE,
  /**
   * Should turn halo light orange.
   */
  ORANGE,
  /**
   * Plays tone from speaker
   */
  PLAY_TONE
}
