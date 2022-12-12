import { isNotNull } from "./CommonUtils";

export function isNotEmpty(data?: string) {
  return isNotNull(data) && data?.trim() != "";
}

export function isEmpty(data?: string) {
  return !isNotEmpty(data);
}

/**
 * Method for generate chr4 unique data
 * @returns unique chr4 data
 */
export function chr4(): string {
  return Math.random().toString(16).slice(-4);
}

/**
 * Method for generate unique id for components with chr4 concatenations
 * @returns unique id with chr4 concatenations
 */
export function uniqueIDChr4(): string {
  return chr4() + chr4() + chr4() + chr4();
}

/**
 * Method for generante unique id with chr4 and iso date
 * @returns unque id wiht chr4 concatenate with today iso date
 */
export function uniqueId() {
  return uniqueIDChr4();
}
