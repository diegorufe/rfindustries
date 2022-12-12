import { TagName } from "../constants/dom/TagName";
import { isNotNull, isNull } from "./CommonUtils";

export function findElementsByClassName(
  className: string,
  dom?: any
): HTMLCollectionOf<Element> | undefined {
  dom = isNull(dom) ? document : dom;
  return dom!.getElementsByClassName(className);
}

export function findElementsByClassNameFirst(
  className: string,
  dom?: any
): Element | undefined {
  let element: Element | undefined = undefined;
  const elements = findElementsByClassName(className, dom);

  if (isNotNull(elements) && elements!.length > 0) {
    element = elements![0];
  }

  return element;
}

export function findElementById(id: string, dom?: any): Element | undefined {
  dom = isNull(dom) ? document : dom;
  return dom!.getElementById(id);
}

export function hasClassName(element: Element, className: string): boolean {
  return element.classList.contains(className);
}

export function addClassName(element: Element, className: string): void {
  element.classList.add(className);
}

export function removeClassName(element: Element, className: string): void {
  element.classList.remove(className);
}

export function createDiv(): HTMLElement {
  const element = document.createElement(TagName.DIV);
  return element;
}

export function createIFrame(): HTMLElement {
  const element = document.createElement(TagName.IFRAME);
  return element;
}
