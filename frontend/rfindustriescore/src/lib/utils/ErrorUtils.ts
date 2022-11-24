import { Message } from "../beans/core/Message";
import { ResponseMethod } from "../beans/core/ResponseMethod";
import { MessageLevel } from "../constants/core/MessageLevel";
import { ResponseStatus } from "../constants/core/ResponseStatus";
import { isNotNull } from "./CommonUtils";
import { addMessageResponseMethod } from "./MessageUtils";




export function getResponseMethodFromException(exception?: Error) : ResponseMethod {
    const response = new ResponseMethod();

    if(isNotNull(exception)){
        response.err = exception;
        response.status = ResponseStatus.WRONG;

        if(isNotNull(exception?.message)){
            addMessageResponseMethod(response, new Message(exception!.message, MessageLevel.ERROR, exception?.stack))
        }
    }


    return response;
}

