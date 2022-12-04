import {
  getResponseMethodFromException,
  isNull,
  MessageLevel,
  ResponseMethod,
  ResponseStatus,
} from "../../lib";
import { applyFunctionWithHandlerError } from "../../lib/utils/ErrorUtils";

describe("testing ErrorUtils", () => {
  test("Get response from expcetion status SUCCESS", () => {
    const response: ResponseMethod = getResponseMethodFromException(undefined);
    expect(response.status).toBe(ResponseStatus.SUCCESS);
    expect(isNull(response.error)).toBe(true);
  });

  test("Get response from expcetion status WRONG", () => {
    const response: ResponseMethod = getResponseMethodFromException(
      new Error("TEST")
    );
    expect(response.status).toBe(ResponseStatus.WRONG);
    expect(isNull(response.error)).toBe(false);
    expect(response.messages[MessageLevel.ERROR][0].text).toBe("TEST");
  });

  test("Apply toUpper success response method", async () => {
    function toUpper(text: string): string {
      return text.toUpperCase();
    }
    const response: ResponseMethod = await applyFunctionWithHandlerError(() => {
      return toUpper("test");
    });
    expect(response.data).toBe("TEST");
  });

  test("Apply toUpper async success response method", async () => {
    async function toUpper(text: string): Promise<string> {
      return text.toUpperCase();
    }
    const response: ResponseMethod = await applyFunctionWithHandlerError(() => {
      return toUpper("test");
    });
    expect(response.data).toBe("TEST");
  });

  test("Apply toUpper error response method", async () => {
    function toUpper(_text: string): string {
      throw new Error("TEST");
    }
    const response: ResponseMethod = await applyFunctionWithHandlerError(() => {
      return toUpper("test");
    });
    expect(response.error?.message).toBe("TEST");
  });

  test("Apply toUpper async error response method", async () => {
    async function toUpper(_text: string): Promise<string> {
      throw new Error("TEST");
    }
    const response: ResponseMethod = await applyFunctionWithHandlerError(() => {
      return toUpper("test");
    });
    expect(response.error?.message).toBe("TEST");
  });
});
