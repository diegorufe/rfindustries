import { MenuItem } from "../../beans/core/MenuItem";
import { isNotNull, isNull } from "../../utils/CommonUtils";
import { getAppContext } from "../../utils/ContextUtils";
import { addClassName, createDiv, createInputText } from "../../utils/DomUtils";
import { isNotEmpty } from "../../utils/StringUtils";
import { cssMenuComponent } from "../../utils/StyleUtils";
import { BaseHTMLElement } from "../core/BaseHTMLElement";
import { MenuItemComponent } from "./MenuItemComponent";

export class MenuComponent extends BaseHTMLElement {
  menuComponentItems?: HTMLElement;
  menuItems: MenuItem[] = [];
  searchMenuItems: MenuItem[] = [];
  searchingMenu: boolean = false;

  renderHtml(): void {
    const context = getAppContext();
    const menuComponent = createDiv();
    addClassName(menuComponent, "MenuComponent");

    const menuComponentSearch = createDiv();
    addClassName(menuComponentSearch, "MenuComponentSearch");
    menuComponent.appendChild(menuComponentSearch);

    const menuComponentSearchInput = createInputText();
    addClassName(menuComponentSearchInput, "MenuComponentSearchInput");
    menuComponentSearch.appendChild(menuComponentSearchInput);

    menuComponentSearchInput.setAttribute(
      "placeholder",
      context.translate("rf.search")
    );
    menuComponentSearchInput.onkeyup = this.search;

    this.menuComponentItems = createDiv();
    addClassName(this.menuComponentItems, "MenuComponentItems");
    menuComponent.appendChild(this.menuComponentItems);

    this.renderFirstMenuItems();

    this.appendChild(menuComponent);
  }

  private search(event: any): void {
    const text = event.target.value;

    if (this.menuItems.length > 0) {
      const context = getAppContext();
      if (isNotNull(text) && isNotEmpty(text)) {
        this.searchMenuItems = context.loaderMenu.searchInMenu(
          this.menuItems,
          text
        );
        this.searchingMenu = true;
      } else {
        this.searchMenuItems = { ...this.menuItems };
        this.searchingMenu = false;
      }

      this.renderMenuItems();
    }
  }

  private async renderFirstMenuItems() {
    const context = getAppContext();
    this.menuItems = await context.loaderMenu.findMenuItems();
    if (isNull(this.menuItems)) {
      this.menuItems = [];
      this.searchMenuItems = { ...this.menuItems };
    }
    this.renderMenuItems();
  }

  private async renderMenuItems() {
    this.menuComponentItems!.innerHTML = "";

    if (isNotNull(this.searchMenuItems) && this.searchMenuItems.length > 0) {
      this.searchMenuItems.forEach((menuItem) => {
        this.menuComponentItems!.appendChild(
          new MenuItemComponent(menuItem, this.searchingMenu)
        );
      });
    }
  }

  renderCss(): void {
    this.innerHTML = cssMenuComponent();
  }
}

if (customElements) {
  customElements.define("menu-component", MenuComponent);
}
