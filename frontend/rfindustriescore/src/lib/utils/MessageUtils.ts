import { Message } from "../beans/core/Message";
import { ResponseMethod } from "../beans/core/ResponseMethod";


export function addMessageResponseMethod(response: ResponseMethod, message: Message){
    let messages: Message[] = [];
    if(!(message.level in response.messages)){
        response.messages[message.level] = [];
    }
    messages =  response.messages[message.level];

    messages.push(message);
}