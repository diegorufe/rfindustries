import { AppContext } from "../beans/context/AppContext";
import { URLKeyParams } from "../constants/core/URLKeyParams";
import { ModuleLoader } from "../features/ModuleLoader";
import { I18nEn } from "../i18n/en/Locale";
import { isNotNull } from "./CommonUtils";
import { addMessageEventListener } from "./MessageEventUtils";

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
  addLocaleResource([I18nEn]);

  modules.forEach((module) => {
    module.loadI18n();
    module.loadLazyComponents();
  });

  const url = new URL(window.location.href);
  const key: string | null = url.searchParams.get(URLKeyParams.KEY);
  const tab: string | null = url.searchParams.get(URLKeyParams.TAB);

  if (isNotNull(key)) {
    APP_CONTEXT.frameles = true;
    APP_CONTEXT.key = key as string;
    APP_CONTEXT.tabKey = tab as string;
  }

  // If application isnt frameles add listener postMessages
  if (!APP_CONTEXT.frameles) {
    addMessageEventListener();
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
