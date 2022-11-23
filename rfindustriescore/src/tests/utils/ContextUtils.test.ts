import { addLocaleResource, getAppContext } from "../../lib";

describe("testing ContextUtils", () => {
  test("Locale addded to be Hello | Hola. Locales: en, es", () => {
    addLocaleResource([
      { en: { test: { hello: "Hello" } } },
      { es: { test: { hello: "Hola" } } },
    ]);
    const appContext = getAppContext();
    expect(appContext.i18nLocales["en"]["test"]["hello"]).toBe("Hello");
    expect(appContext.i18nLocales["es"]["test"]["hello"]).toBe("Hola");
  });
});
