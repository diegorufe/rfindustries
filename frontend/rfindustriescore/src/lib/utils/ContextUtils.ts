import { AppContext } from "../beans/context/AppContext";
import { URLKeyParams } from "../constants/core/URLKeyParams";
import { ModuleLoader } from "../features/ModuleLoader";
import { isNotNull } from "./CommonUtils";

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

export function loadAppContext(modules: ModuleLoader[]) {
  modules.forEach((module) => {
    module.loadI18n();
    module.loadLazyComponents();
  });

  const url = new URL(window.location.href);
  const key: string | null = url.searchParams.get(URLKeyParams.KEY);

  if (isNotNull(key)) {
    APP_CONTEXT.frameles = true;
    APP_CONTEXT.key = key as string;
  }
}

export async function loadComponentByKey(key: string): Promise<any> {
  let component: any = null;
  if (key in APP_CONTEXT.lazyComponents) {
    const functionLoadComponent = APP_CONTEXT.lazyComponents[key];
    // TODO handler error and show component error
    component = await functionLoadComponent();
  }

  return component;
}
