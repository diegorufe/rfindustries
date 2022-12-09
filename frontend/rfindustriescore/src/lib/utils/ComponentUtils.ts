import { isNotNull } from "./CommonUtils";
import {
  addClassName,
  findElementsByClassNameFirst,
  hasClassName,
  removeClassName,
} from "./DomUtils";

export function openCloseMenu() {
  const menu: Element | undefined =
    findElementsByClassNameFirst("MenuComponent");
  const body: Element | undefined =
    findElementsByClassNameFirst("BodyComponent");
  if (isNotNull(menu) && isNotNull(body)) {
    if (hasClassName(menu!, "MenuComponentHidden")) {
      removeClassName(menu!, "MenuComponentHidden");
      removeClassName(menu!, "BodyComponentFullScreen");
    } else {
      addClassName(menu!, "MenuComponentHidden");
      addClassName(menu!, "BodyComponentFullScreen");
    }
  }
}
