import { LoadMenu } from "../../features/LoadMenu";
import { Reactivity } from "../../features/Reactivity";
import { LoadMenuService } from "../../service/menu/LoadMenuService";
import { isNotNull, isNull } from "../../utils/CommonUtils";

export class AppContext {
  i18nLocales: { [key: string]: { [key: string]: any } } = {};
  locale: string = "en";
  loaderMenu: LoadMenu = new LoadMenuService();
  frameles: boolean = false;
  key?: string;
  lazyComponents: { [key: string]: Function } = {};
  reactivity?: Reactivity;

  translate(key: string, data?: any[]): string {
    const keys = key.split(".");
    let result = key;
    let valueLocale: any = this.i18nLocales[this.locale];

    for (const keyKeys of keys) {
      valueLocale = this.valueLocale(keyKeys, valueLocale);

      if (isNull(valueLocale)) {
        valueLocale = undefined;
        break;
      }
    }

    if (isNotNull(valueLocale)) {
      result = valueLocale;

      // Si tenemos datos pasados como parámetros reemplazamos en la cadena
      if (isNotNull(data) && data!.length > 0) {
        for (let i = 0; i < data!.length; i++) {
          result = result.replace(`{${i}}`, data![i]);
        }
      }
    }

    return result;
  }

  private valueLocale(key: string, valueLocales: any): string | undefined {
    let result = undefined;

    if (isNotNull(valueLocales) && key in valueLocales) {
      result = valueLocales[key];
    }

    return result;
  }
}
