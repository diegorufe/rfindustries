import { cssVars } from "../../lib/index"

describe("testing StyleUtils", () => {
    test("Genearete css vars true", () => {
        const result = cssVars()

        expect(result.includes("root")).toBe(false);
    });


});
