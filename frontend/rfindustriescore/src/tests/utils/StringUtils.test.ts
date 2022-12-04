import { isEmpty, isNotEmpty } from "../../lib";

describe("testing StringUtils", () => {
  test("Is empty is true", () => {
    expect(isEmpty("")).toBe(true);
    expect(isEmpty(undefined)).toBe(true);
  });

  test("Is empty is false", () => {
    expect(isEmpty("Test")).toBe(false);
  });

  test("Is not empty is true", () => {
    expect(isNotEmpty("TEST")).toBe(true);
  });

  test("Is not empty is false", () => {
    expect(isNotEmpty("")).toBe(false);
    expect(isNotEmpty(undefined)).toBe(false);
  });
});
