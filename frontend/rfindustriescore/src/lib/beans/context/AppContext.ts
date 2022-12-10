import { LoadMenu } from "../../features/LoadMenu";
import { LoadMenuService } from "../../service/menu/LoadMenuService";

export class AppContext {
  i18nLocales: { [key: string]: { [key: string]: any } } = {};
  locale: string = "en";
  loaderMenu: LoadMenu = new LoadMenuService();
  frameles: boolean = false;
  key?: string;
  lazyComponents: { [key: string]: Function } = {};
}
