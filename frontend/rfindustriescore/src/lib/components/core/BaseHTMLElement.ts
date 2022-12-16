export abstract class BaseHTMLElement extends HTMLElement {
  constructor() {
    super();
  }

  abstract renderHtml(): void;

  abstract renderCss(): void;

  connectedCallback() {
    this.renderCss();
    this.renderHtml();
  }
}
