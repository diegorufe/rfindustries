import { isNotNull, isNull } from "../../lib";

describe("testing CommonUtils", () => {
  test("Is null or undefined is true", () => {
    expect(isNull(null)).toBe(true);
    expect(isNull(undefined)).toBe(true);
  });

  test("Is null or undefined is false", () => {
    expect(isNull("as")).toBe(false);
  });

  test("Is not null or undefined is true", () => {
    expect(isNotNull("asd")).toBe(true);
  });

  test("Is not null or undefined is false", () => {
    expect(isNotNull(null)).toBe(false);
    expect(isNotNull(undefined)).toBe(false);
  });
});
