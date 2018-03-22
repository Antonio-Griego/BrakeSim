package electronicBrake;

import electronicBrake.enums.ActionTypes;
import electronicBrake.enums.EventTypes;
import electronicBrake.enums.StateType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rules
{
  private Map<StateType,List<EventTypes>> stateEvents = new HashMap<>();
  private Map<StateType,List<ActionTypes>> stateActions = new HashMap<>();

  public Rules()
  {
    createTables();
  }

  private void createTables()
  {
    List<EventTypes> events;
    List<ActionTypes> actions;

    for(StateType state: StateType.values())
    {
      switch (state)
      {
        case NULL:
          events = new ArrayList<>();
          events.add(EventTypes.ENGAGED);
          events.add(EventTypes.DISENGAGED);
          events.add(EventTypes.PARKED);
          events.add(EventTypes.NOT_PARKED);
          stateEvents.put(state, events);
          break;

        case PARKED_ENGAGED:
          events = new ArrayList<>();
          events.add(EventTypes.SHORT_PRESS);
          events.add(EventTypes.NOT_PARKED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.FULL_ENGAGE);
          actions.add(ActionTypes.RED);
          stateActions.put(state,actions);
          break;

        case PARKED_DISENGAGED:
          events = new ArrayList<>();
          events.add(EventTypes.SHORT_PRESS);
          events.add(EventTypes.NOT_PARKED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.FULL_DISENGAGE);
          actions.add(ActionTypes.BLUE);
          stateActions.put(state,actions);
          break;

        case NOT_IN_PARK_ENGAGED:
          events = new ArrayList<>();
          events.add(EventTypes.SHORT_PRESS);
          events.add(EventTypes.LONG_PRESS);
          events.add(EventTypes.PARKED);
          events.add(EventTypes.DISENGAGED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.FULL_ENGAGE);
          actions.add(ActionTypes.RED);
          stateActions.put(state,actions);
          break;

        case NOT_IN_PARK_DISENGAGED:
          events = new ArrayList<>();
          events.add(EventTypes.SHORT_PRESS);
          events.add(EventTypes.PARKED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.FULL_DISENGAGE);
          actions.add(ActionTypes.BLUE);
          stateActions.put(state,actions);
          break;

        case ENGAGING:
          events = new ArrayList<>();
          events.add(EventTypes.SHORT_PRESS);
          events.add(EventTypes.PARKED);
          events.add(EventTypes.ENGAGED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.GRADUAL_ENGAGE);
          actions.add(ActionTypes.ORANGE);
          stateActions.put(state,actions);
          break;

        case ENGAGING_WARN:
          events = new ArrayList<>();
          events.add(EventTypes.LONG_PRESS);
          events.add(EventTypes.RELEASED);
          events.add(EventTypes.PARKED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.ORANGE);
          actions.add(ActionTypes.PLAY_TONE);
          stateActions.put(state,actions);
          break;

        case WARN:
          events = new ArrayList<>();
          events.add(EventTypes.LONG_PRESS);
          events.add(EventTypes.RELEASED);
          events.add(EventTypes.PARKED);
          stateEvents.put(state, events);
          actions = new ArrayList<>();
          actions.add(ActionTypes.ORANGE);
          actions.add(ActionTypes.PLAY_TONE);
          stateActions.put(state,actions);
      }
    }
  }
  public List<EventTypes> getEvents(StateType state)
  {
    return stateEvents.get(state);
  }

  public List<ActionTypes> getActions(StateType state)
  {
    return stateActions.get(state);
  }

  /**
   * Included for testing
   * @return The map of actions.
   */
  protected Map<StateType, List<ActionTypes>> getStateActions()
  {
    return stateActions;
  }

  /**
   * Included for testing
   * @return The map of events.
   */
  protected Map<StateType, List<EventTypes>> getStateEvents()
  {
    return stateEvents;
  }
}
