import { AppContext } from "../beans/context/AppContext";

const APP_CONTEXT = new AppContext();

export function getAppContext(): AppContext {
  return APP_CONTEXT;
}

export function changeLocale(locale: string) {
  APP_CONTEXT.locale = locale;
}

export function addLocaleResource(locales: any[]) {
  if (locales.length > 0) {
    locales.forEach((localeResource) => {
      for (let locale in localeResource) {
        let mapValuesLocaleContext: any = {};
        if (!(locale in APP_CONTEXT.i18nLocales)) {
          APP_CONTEXT.i18nLocales[locale] = mapValuesLocaleContext;
        }
        mapValuesLocaleContext = APP_CONTEXT.i18nLocales[locale];
        for (let key in localeResource[locale]) {
          mapValuesLocaleContext[key] = localeResource[locale][key];
          break;
        }
      }
    });
  }
}
