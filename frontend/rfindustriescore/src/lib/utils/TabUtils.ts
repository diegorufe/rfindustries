import { Tab } from "../beans/core/Tab";
import { isNotNull } from "./CommonUtils";
import { getAppContext } from "./ContextUtils";
import {
  addClassName,
  createDiv,
  createIFrame,
  findElementById,
  findElementsByClassNameFirst,
  hasClassName,
  removeClassName,
} from "./DomUtils";
import { uniqueId } from "./StringUtils";

export function clearTabs() {
  const tabViewComponentHeaders = findElementById("TabViewComponentHeaders");
  const tabViewComponentBody = findElementById("TabViewComponentBodys");
  tabViewComponentHeaders!.innerHTML = "";
  tabViewComponentBody!.innerHTML = "";
  getAppContext().tabs = [];
}

export function addTab(key: string, title: string) {
  const tab = new Tab(uniqueId(), key, title);

  const tabViewComponentHeaders = findElementById("TabViewComponentHeaders");
  const tabViewComponentBodys = findElementById("TabViewComponentBodys");

  // header
  const header = createDiv();
  header.id = tab.id + "Header";
  addClassName(header, "TabViewComponentHeader");
  header.innerText = tab.title;
  tabViewComponentHeaders?.appendChild(header);

  // body
  const body = createDiv();
  body.id = tab.id + "Body";
  addClassName(body, "TabViewComponentBody");
  tabViewComponentBodys?.appendChild(body);

  const iframe = createIFrame();
  addClassName(iframe, "IFrameBody");

  // TODO get path aplication
  const pathApp = `/?key=${tab.key}&tab=${tab.id}`;
  iframe.setAttribute("src", pathApp);

  body.appendChild(iframe);

  getAppContext().tabs.push(tab);
  changeTab(tab.id);
}

export function removeTab(id: string) {
  const context = getAppContext();
  let activeTab: number = 0;
  let removeTab: number = 0;

  for (let tabIndex = 0; tabIndex < context.tabs.length; tabIndex++) {
    if (context.tabs[tabIndex].id === id) {
      removeTab = tabIndex;
      const tabViewHeaderComponent = findElementById(
        context.tabs[tabIndex].id + "Header"
      );
      if (
        hasClassName(tabViewHeaderComponent!, "TabViewComponentHeaderActive")
      ) {
        activeTab = tabIndex;
      }
      break;
    }
  }

  const tab = context.tabs[removeTab];
  const tabViewHeaderComponent = findElementById(tab.id + "Header");
  const tabViewBodyComponent = findElementById(tab.id + "Body");

  tabViewHeaderComponent?.remove();
  tabViewBodyComponent?.remove();

  context.tabs.splice(removeTab, 1);

  if (activeTab == removeTab && context.tabs.length > 0) {
    changeTab(context.tabs[activeTab--].id);
  }
}

export function changeTab(id: string) {
  const context = getAppContext();
  let activeTab = findElementsByClassNameFirst("TabViewComponentHeaderActive");

  if (isNotNull(activeTab)) {
    activeTab = findElementById(activeTab!.id);
    removeClassName(activeTab!, "TabViewComponentHeaderActive");
  }

  activeTab = findElementsByClassNameFirst("TabViewComponentBodyActive");

  if (isNotNull(activeTab)) {
    activeTab = findElementById(activeTab!.id);
    removeClassName(activeTab!, "TabViewComponentBodyActive");
  }

  let changeTab: number = 0;

  for (let tabIndex = 0; tabIndex < context.tabs.length; tabIndex++) {
    if (context.tabs[tabIndex].id === id) {
      changeTab = tabIndex;
      break;
    }
  }

  const tab = context.tabs[changeTab];
  const tabViewHeaderComponent = findElementById(tab.id + "Header");
  const tabViewBodyComponent = findElementById(tab.id + "Body");

  addClassName(tabViewHeaderComponent!, "TabViewComponentHeaderActive");
  addClassName(tabViewBodyComponent!, "TabViewComponentBodyActive");
}
