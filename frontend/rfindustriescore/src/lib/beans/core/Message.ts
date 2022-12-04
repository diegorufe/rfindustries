import { MessageLevel } from "../../constants/core/MessageLevel";

export class Message {
  text: string;
  level: MessageLevel;
  textSupport?: string;

  constructor(text: string, level: MessageLevel, textSupport?: string) {
    this.text = text;
    this.level = level;
    this.textSupport = textSupport;
  }
}
