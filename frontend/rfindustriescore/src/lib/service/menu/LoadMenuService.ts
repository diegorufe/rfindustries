import { MenuItem } from "../../beans/core/MenuItem";
import { LoadMenu } from "../../features/LoadMenu";
import { getMenuItems } from "../../utils/SessionUtils";

export class LoadMenuService implements LoadMenu {
  async findMenuItems(): Promise<MenuItem[]> {
    return getMenuItems();
  }

  searchInMenu(menuItems: MenuItem[], text: string): MenuItem[] {
    const arrayMenuItems: MenuItem[] = [];

    for (const menuItem of menuItems) {
      if (this.containsTextMenuItem(text, menuItem)) {
        arrayMenuItems.push(menuItem);
      }
    }

    return arrayMenuItems;
  }

  private containsTextMenuItem(text: string, menuItem: MenuItem): boolean {
    const textUpper: string = text.toUpperCase();
    let containsMenu: boolean =
      menuItem.label.toUpperCase().includes(textUpper) ||
      menuItem.hashtags.toUpperCase().includes(textUpper);

    if (!containsMenu && menuItem.menuItems.length > 0) {
      for (const child of menuItem.menuItems) {
        if (this.containsTextMenuItem(text, child)) {
          containsMenu = true;
          break;
        }
      }
    }

    return containsMenu;
  }
}
