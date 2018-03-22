import PhysicalDrivers.LEDNotificationDriver;

public class Actions
{
  // start mock, delete during integration
  private class AlarmNotification{}
  private class LEDNotification{}
  private class SignalSender
  {
    SignalSender(AlarmNotification a, LEDNotification n){}
    void play(){}
    void setColor(LEDNotificationDriver.Color color){}
  }
  private class BrakeControl
  {
    void setForce(final double f){}
    double getForce(){return 0;}
    boolean isEngaged(){return false;}
  }
  // end mock


  /**
   * Enumeration of every possible action type
   *
   * Individual actions are derived from incoming events in combination with current state.
   */
  public enum ActionType
  {
    FULL_ENGAGE, FULL_DISENGAGE, GRADUAL_ENGAGE, RED, BLUE, ORANGE, PLAY_TONE
  }

  /**
   * Max force that is accepted by {@link BrakeControl}.
   */
  // The max brake force in Car.Constants is 10000, though the documentation specifies 1 as max,
  // assuming a conversion happens somewhere.
  private final static double MAX_BRAKE_FORCE = 1d;

  /**
   * Increment by which current braking force is increased in the event of a {@code ActionType.GRADUAL_ENGAGE}
   * action.
   */
  private final static double BRAKE_FORCE_INCREMENT = MAX_BRAKE_FORCE / 300d;

  /**
   * Min force that is accepted by {@link BrakeControl}
   */
  private final static double MIN_BRAKE_FORCE = 0d;

  private final BrakeControl brakeControl;
  private final SignalSender signalSender;

  Actions(final BrakeControl brakeControl,
          final AlarmNotification alarmNotifiaction,
          final LEDNotification ledNotification)
  {
    this.brakeControl = brakeControl;
    this.signalSender = new SignalSender(alarmNotifiaction, ledNotification);
  }

  /**
   * Execute device operations associated with specified action.
   *
   * @param actionType Action who's meaning will be interpreted and triggered in relevant component.
   */
  public void execute(final ActionType actionType)
  {
    if      (actionType == ActionType.FULL_ENGAGE) fullEngage();
    else if (actionType == ActionType.FULL_DISENGAGE) fullDisengage();
    else if (actionType == ActionType.GRADUAL_ENGAGE) gradualEngage();
    else if (actionType == ActionType.RED) red();
    else if (actionType == ActionType.BLUE) blue();
    else if (actionType == ActionType.ORANGE) orange();
    else if (actionType == ActionType.PLAY_TONE) playTone();
    else throw new UnsupportedOperationException("Attempt to execute unsupported ActionType");
  }

  private void fullEngage()
  {
    brakeControl.setForce(MAX_BRAKE_FORCE);
  }

  private void fullDisengage()
  {
    brakeControl.setForce(MIN_BRAKE_FORCE);
  }

  private void gradualEngage()
  {
    final double newForce = brakeControl.getForce() + BRAKE_FORCE_INCREMENT;
    brakeControl.setForce(newForce);
  }

  private void red()
  {
    signalSender.setColor(LEDNotificationDriver.Color.RED);
  }

  private void blue()
  {
    signalSender.setColor(LEDNotificationDriver.Color.BLUE);
  }

  private void orange()
  {
    signalSender.setColor(LEDNotificationDriver.Color.ORANGE);
  }

  private void playTone()
  {
    signalSender.play();
  }
}
