import {
  addMessageResponseMethod,
  Message,
  MessageLevel,
  ResponseMethod,
} from "../../lib";

describe("testing MessageUtils", () => {
  test("Add message to response method", () => {
    const response: ResponseMethod<any> = new ResponseMethod();
    addMessageResponseMethod(
      response,
      new Message("SUCCESS", MessageLevel.SUCCESS)
    );
    addMessageResponseMethod(
      response,
      new Message("ERROR", MessageLevel.ERROR)
    );

    expect(response.messages[MessageLevel.SUCCESS][0].level).toBe(
      MessageLevel.SUCCESS
    );
    expect(response.messages[MessageLevel.ERROR][0].level).toBe(
      MessageLevel.ERROR
    );

    expect(response.messages[MessageLevel.SUCCESS][0].text).toBe(
      MessageLevel.SUCCESS
    );
    expect(response.messages[MessageLevel.ERROR][0].text).toBe(
      MessageLevel.ERROR
    );
  });
});
