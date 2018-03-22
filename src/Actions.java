public class Actions
{
  private class BrakeControl{}
  private class AlarmNotifiaction{}
  private class LEDNotification{}

  public enum ActionType
  {
    FULL_ENGAGE, FULL_DISENGAGE, GRADUAL_ENGAGE, RED, BLUE, ORANGE, PLAY_TONE
  }

  private final BrakeControl brakeControl;
  private final AlarmNotifiaction alarmNotifiaction;
  private final LEDNotification ledNotification;

  Actions(final BrakeControl brakeControl,
          final AlarmNotifiaction alarmNotifiaction,
          final LEDNotification ledNotification)
  {
    this.brakeControl = brakeControl;
    this.alarmNotifiaction = alarmNotifiaction;
    this.ledNotification = ledNotification;
  }

  public void execute(final ActionType actionType)
  {
    if (actionType == ActionType.FULL_ENGAGE) fullEngage();
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
  }

  private void fullDisengage()
  {
  }

  private void gradualEngage()
  {
  }

  private void red()
  {
  }

  private void blue()
  {
  }

  private void orange()
  {
  }

  private void playTone()
  {
  }
}
