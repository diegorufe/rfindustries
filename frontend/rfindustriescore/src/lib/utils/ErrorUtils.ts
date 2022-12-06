import { Message } from "../beans/core/Message";
import { ResponseMethod } from "../beans/core/ResponseMethod";
import { MessageLevel } from "../constants/core/MessageLevel";
import { ResponseStatus } from "../constants/core/ResponseStatus";
import { isNotNull } from "./CommonUtils";
import { addMessageResponseMethod } from "./MessageUtils";

export function getResponseMethodFromException<T>(
  exception?: Error
): ResponseMethod<T> {
  const response: ResponseMethod<T> = new ResponseMethod();

  if (isNotNull(exception)) {
    response.error = exception;
    response.status = ResponseStatus.WRONG;

    if (isNotNull(exception?.message)) {
      addMessageResponseMethod(
        response,
        new Message(exception!.message, MessageLevel.ERROR, exception?.stack)
      );
    }
  }

  return response;
}

export async function applyFunctionWithHandlerError(fn: Function) {
  let response = new ResponseMethod();
  try {
    let result = fn.apply(fn, arguments);
    if (isNotNull(result)) {
      if (
        typeof result.then === "function" &&
        typeof result.catch === "function"
      ) {
        try {
          response.data = await result;
        } catch (exception) {
          response = getResponseMethodFromException(exception as Error);
        }
      } else {
        response.data = result;
      }
    }
  } catch (exception) {
    response = getResponseMethodFromException(exception as Error);
  }
  return response;
}
