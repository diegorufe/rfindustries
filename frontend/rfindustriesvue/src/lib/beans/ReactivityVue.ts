import { Reactivity } from "rfindustriescore";
import { reactive } from "vue";

export class ReactivityVue implements Reactivity {
  setReactiveData(target: any, data: any): void {
    // TODO remove all data target and set new
    Object.assign(target, data);
  }

  initReactivityObject<T>(target: T): T {
    return reactive(target as Object) as T;
  }
}
