import { MenuItem } from "../beans/core/MenuItem";

interface LoadMenu {
  findMenuItems(): Promise<MenuItem[]>;
  searchInMenu(menuItems: MenuItem[], text: string): MenuItem[];
}

export type { LoadMenu };
