package electronicBrake;

import Resources;
import javafx.scene.media.AudioClip;

// This class sends signals to the external interface
//   LEDNotification when called upon from the actions class.
public class SignalSender
{
// AudioClip variable to pass to the external interface
//   AlarmNotification to play. It is set upon class
//   initialization with the sound from the resources folder.
  private AudioClip sound;

// Sets the sound variable to the sound located in the
//   resources folder upon initialization.
  public SignalSender()
  {
    sound = new AudioClip("Resources/Bell.wav");
  }

// This method is invoked from the actions class.
// It takes no arguments, when called, it calls 
//   the method playSound from the external interface
//   AlarmNotification with the argument specifying 
//   the sound to play. 
  public void play()
  {
    audioSystem.playSound(sound);
    return;
  }

// This method is invoked from the actions class.
// It takes one argument, a color.
// It calls the light method from the external 
//   interface LEDNotification with the color passed
//   from actions as the argument, then returns.
  public void setColor(Color color)
  {
    ledNotification.light(color);
    return;
  }
}
