import { getResponseMethodFromException, isNull, MessageLevel, ResponseMethod, ResponseStatus } from "../../lib";



describe("testing ErrorUtils", () => {
    test("Get response from expcetion status SUCCESS", () => {
      const response: ResponseMethod = getResponseMethodFromException(undefined);
      expect(response.status).toBe(ResponseStatus.SUCCESS);
      expect(isNull(response.err)).toBe(true);
    });

    test("Get response from expcetion status WRONG", () => {
        const response: ResponseMethod = getResponseMethodFromException(new Error("TEST"));
        expect(response.status).toBe(ResponseStatus.WRONG);
        expect(isNull(response.err)).toBe(false);
        expect(response.messages[MessageLevel.ERROR][0].text).toBe("TEST");
      });
      
  });
  