import { getAppContext } from "rfindustriescore";
import { ReactivityVue } from "../beans/ReactivityVue";

export function setReactivityFeature(): void {
  const context = getAppContext();
  context.reactivity = new ReactivityVue();
}
