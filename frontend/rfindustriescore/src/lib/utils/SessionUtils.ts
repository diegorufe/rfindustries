import { MenuItem } from "../beans/core/MenuItem";
import { SessionKeyStorage } from "../constants/core/SessionKeyStorage";
import { isNotNull } from "./CommonUtils";

export function getMenuItems(): MenuItem[] {
  let menuItems: MenuItem[] = [];

  const resultSessionStorage: string | null = sessionStorage.getItem(
    SessionKeyStorage.MENU_ITEMS
  );

  if (isNotNull(resultSessionStorage)) {
    menuItems = JSON.parse(resultSessionStorage as string);
  }

  return menuItems;
}

export function setMenuItems(menuItems: MenuItem[]): void {
  sessionStorage.setItem(
    SessionKeyStorage.MENU_ITEMS,
    JSON.stringify(menuItems)
  );
}

export function clearSession() {
  sessionStorage.clear();
}
