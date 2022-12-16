import { MenuItem } from "../../beans/core/MenuItem";
import { isNotNull } from "../../utils/CommonUtils";
import { addClassName, createDiv } from "../../utils/DomUtils";
import { cssMenuItemComponent } from "../../utils/StyleUtils";
import { BaseHTMLElement } from "../core/BaseHTMLElement";

export class MenuItemComponent extends BaseHTMLElement {
  menuItem: MenuItem;
  forceOpen: boolean;
  menuItemComponentChidls?: HTMLElement;
  open: boolean = false;

  constructor(menuItem: MenuItem, forceOpen: boolean) {
    super();
    this.menuItem = menuItem;
    this.forceOpen = forceOpen;
  }

  renderHtml(): void {
    const menuItemComponent = createDiv();
    addClassName(menuItemComponent, "MenuItemComponent");

    const menuItemComponentLabel = createDiv();
    addClassName(menuItemComponentLabel, "MenuItemComponentLabel");
    menuItemComponentLabel.innerText = this.menuItem.label;

    this.menuItemComponentChidls = createDiv();
    addClassName(this.menuItemComponentChidls, "MenuItemComponentChidls");

    this.renderMenuItems();

    this.appendChild(menuItemComponent);
  }

  private async renderMenuItems() {
    this.menuItemComponentChidls!.innerHTML = "";

    if (
      (this.open || this.forceOpen) &&
      isNotNull(this.menuItem.menuItems) &&
      this.menuItem.menuItems.length > 0
    ) {
      this.menuItem.menuItems.forEach((child) => {
        const menuItemComponentChild = createDiv();
        addClassName(menuItemComponentChild, "MenuItemComponentChild");

        menuItemComponentChild.onclick = () => {
          this.clickMenuItemChild(child);
        };

        const menuItemComponentChildLabel = createDiv();
        addClassName(
          menuItemComponentChildLabel,
          "MenuItemComponentChildLabel"
        );
        menuItemComponentChild.appendChild(menuItemComponentChildLabel);

        menuItemComponentChildLabel.innerText = child.label;

        this.menuItemComponentChidls!.append(menuItemComponentChild);
      });
    }
  }

  private async clickMenuItemChild(menuItem: MenuItem) {
    if (menuItem.key) {
      // TODO
    }
  }

  renderCss(): void {
    this.innerHTML = cssMenuItemComponent();
  }
}

if (customElements) {
  customElements.define("menuitem-component", MenuItemComponent);
}
