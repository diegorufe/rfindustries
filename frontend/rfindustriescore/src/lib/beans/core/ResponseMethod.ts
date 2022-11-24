import { ResponseStatus } from "../../constants/core/ResponseStatus";
import { Message } from "./Message";


export class ResponseMethod{
    data? : any;
    status: ResponseStatus = ResponseStatus.SUCCESS;
    err?: Error;
    messages: {[key: string]:Message[]} = {}
}