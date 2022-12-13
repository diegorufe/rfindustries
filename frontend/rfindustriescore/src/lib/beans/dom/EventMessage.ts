import { EventType } from "../../constants/dom/EventType";

export class EventMessage<T> {
  type: EventType;
  data?: T;

  constructor(type: EventType, data?: T) {
    this.type = type;
    this.data = data;
  }
}
