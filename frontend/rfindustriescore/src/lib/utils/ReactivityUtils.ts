import { isNotNull } from "./CommonUtils";
import { getAppContext } from "./ContextUtils";

export function setReactiveData(target: any, data: any) {
  const context = getAppContext();
  if (isNotNull(context.reactivity)) {
    context.reactivity?.setReactiveData(target, data);
  }
}

export function initReactivityObject<T>(target: T): T {
  const context = getAppContext();
  if (isNotNull(context.reactivity)) {
    target = context.reactivity!.initReactivityObject(target);
  }
  return target;
}
