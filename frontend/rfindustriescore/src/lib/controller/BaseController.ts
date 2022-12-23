import { StatePage } from "../constants/view/StatePage";
import { StatePageValue } from "../constants/view/StatePageValue";
import { initReactivityObject } from "../utils/ReactivityUtils";

export abstract class BaseController {
  statePageValue: StatePageValue = initReactivityObject(new StatePageValue());
  oldStatePage: StatePage = StatePage.LIST;

  async changeStatePage(newStatePage: StatePage) {
    this.oldStatePage = this.statePageValue.statePage;

    let changed: boolean = false;

    switch (newStatePage) {
      case StatePage.LIST:
        changed = await this.actionPageStatesList();
        break;

      case StatePage.ADD:
        changed = await this.actionPageStatesAdd();
        break;

      case StatePage.EDIT:
        changed = await this.actionPageStatesEdit();
        break;

      case StatePage.READ:
        changed = await this.actionPageStatesRead();
        break;

      case StatePage.CUSTOM:
        changed = await this.actionPageStatesCustom();
        break;

      case StatePage.REPORT:
        changed = await this.actionPageStatesReport();
        break;

      case StatePage.DELETE:
        changed = await this.actionPageStatesDelete();
        break;
    }

    if (changed) {
      if (
        this.oldStatePage != StatePage.LIST &&
        newStatePage == StatePage.DELETE
      ) {
        newStatePage = StatePage.LIST;
      }
      this.statePageValue.statePage = newStatePage;
    }
  }

  async actionPageStatesList(): Promise<boolean> {
    return true;
  }

  async actionPageStatesRead(): Promise<boolean> {
    return true;
  }

  async actionPageStatesEdit(): Promise<boolean> {
    return true;
  }

  async actionPageStatesAdd(): Promise<boolean> {
    return true;
  }

  async actionPageStatesDelete(): Promise<boolean> {
    return true;
  }

  async actionPageStatesReport(): Promise<boolean> {
    return true;
  }

  async actionPageStatesCustom(): Promise<boolean> {
    return true;
  }

  isStatePage(statePage: StatePage): boolean {
    return this.statePageValue.statePage == statePage;
  }

  isStatePageList(): boolean {
    return this.isStatePage(StatePage.LIST);
  }

  isStatePageRead(): boolean {
    return this.isStatePage(StatePage.READ);
  }

  isStatePageEdit(): boolean {
    return this.isStatePage(StatePage.EDIT);
  }

  isStatePageAdd(): boolean {
    return this.isStatePage(StatePage.ADD);
  }

  isStatePageDelete(): boolean {
    return this.isStatePage(StatePage.DELETE);
  }

  isStatePageCustom(): boolean {
    return this.isStatePage(StatePage.CUSTOM);
  }

  isStatePageReport(): boolean {
    return this.isStatePage(StatePage.REPORT);
  }

  isStatePageCrud(): boolean {
    return (
      this.isStatePageRead() ||
      this.isStatePageAdd() ||
      this.isStatePageDelete()
    );
  }
}
