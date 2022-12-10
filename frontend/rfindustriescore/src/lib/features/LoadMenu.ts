import { MenuItem } from "../beans/core/MenuItem";

export interface LoadMenu {
  findMenuItems(): Promise<MenuItem[]>;
  searchInMenu(menuItems: MenuItem[], text: string): MenuItem[];
}
