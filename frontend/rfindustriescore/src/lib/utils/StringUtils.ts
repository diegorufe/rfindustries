import { isNotNull } from "./CommonUtils";

export function isNotEmpty(data?: string) {
  return isNotNull(data) && data?.trim() != "";
}

export function isEmpty(data?: string) {
  return !isNotEmpty(data);
}
