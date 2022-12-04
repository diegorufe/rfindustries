import { Message } from "./Message";

export class BodyResponseRequest<T> {
  data?: T;
  messages: { [key: string]: Message[] } = {};
  token?: string;
  userPreferences: any;
}
