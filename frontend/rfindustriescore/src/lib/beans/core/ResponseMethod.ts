import { ResponseStatus } from "../../constants/core/ResponseStatus";
import { Message } from "./Message";

export class ResponseMethod<T> {
  data?: T;
  status: ResponseStatus = ResponseStatus.SUCCESS;
  error?: Error;
  messages: { [key: string]: Message[] } = {};
  httpStatus: number = 0;
}
