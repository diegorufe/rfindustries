import { ResponseFetch } from "../beans/core/ResponseFetch";
import { ResponseMethod } from "../beans/core/ResponseMethod";
import { HttpMethod } from "../constants/core/HttpMethod";
import { ResponseStatus } from "../constants/core/ResponseStatus";
import { isNotNull } from "./CommonUtils";
import { applyFunctionWithHandlerError } from "./ErrorUtils";
import { isNotEmpty } from "./StringUtils";

function getHeaders() {
  let headers = new Headers();
  //let usserLogged = getUserLogged();

  headers.append("Content-Type", "application/json");
  headers.append("Accept", "application/json");

  // TODO get token
  const token = "";

  if (isNotEmpty(token)) {
    headers.append("Authorization", "Bearer " + token);
  }

  return headers;
}

export async function fetchRequest(
  url: string,
  method: HttpMethod,
  body: any
): Promise<ResponseMethod> {
  const options: any = {
    method: method,
    headers: getHeaders(),
  };

  if (isNotNull(body)) {
    options.body = body;
  }

  const responseMethod: ResponseMethod = await applyFunctionWithHandlerError(
    async () => {
      const responseFetch = new ResponseFetch();
      const response = await fetch(new Request(url, options));
      responseFetch.status = response.status;

      if (responseFetch.status == 200 || responseFetch.status == 201) {
        responseFetch.data = await response.json();
      }

      return responseFetch;
    }
  );

  if (isNotNull(responseMethod.data)) {
    const responseFetch: ResponseFetch = responseMethod.data;
    responseMethod.data = undefined;
    responseMethod.status = ResponseStatus.WRONG;
    responseMethod.httpStatus = responseFetch.status;

    if (
      isNotNull(responseFetch) &&
      (responseFetch.status == 200 || responseFetch.status == 201)
    ) {
      responseMethod.status = ResponseStatus.SUCCESS;
      responseMethod.data = responseFetch.data;
    }
  }

  return responseMethod;
}

export async function postRequest(
  url: string,
  body: any
): Promise<ResponseMethod> {
  return await fetchRequest(url, HttpMethod.POST, body);
}

export async function putRequest(
  url: string,
  body: any
): Promise<ResponseMethod> {
  return await fetchRequest(url, HttpMethod.PUT, body);
}

export async function deleteRequest(
  url: string,
  body: any
): Promise<ResponseMethod> {
  return await fetchRequest(url, HttpMethod.DELETE, body);
}
