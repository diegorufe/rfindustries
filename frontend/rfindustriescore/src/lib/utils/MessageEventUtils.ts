import { Tab } from "../beans/core/Tab";
import { EventMessage } from "../beans/dom/EventMessage";
import { EventType } from "../constants/dom/EventType";
import { isNotNull } from "./CommonUtils";
import { getAppContext } from "./ContextUtils";
import { addTab, changeTab, clearTabs, removeTab } from "./TabUtils";

export function addMessageEventListener() {
  window.addEventListener(
    "message",
    (event) => {
      const context = getAppContext();

      // https://developer.mozilla.org/en-US/docs/Web/API/Window/postMessage
      if (isNotNull(event.data) && !context.frameles) {
        const eventMessage: EventMessage<any> = event.data;

        if (isNotNull(eventMessage) && isNotNull(eventMessage.type)) {
          event.preventDefault();

          switch (eventMessage.type) {
            case EventType.ADD_TAB:
              const addTabData: Tab = eventMessage.data;
              addTab(addTabData.key, addTabData.title);
              break;
            case EventType.CHANGE_TAB:
              const changeTabData: Tab = eventMessage.data;
              changeTab(changeTabData.id);
              break;
            case EventType.CLOSE_TAB:
              const closeTabData: Tab = eventMessage.data;
              removeTab(closeTabData.id);
              break;

            case EventType.CLOSE_ALL_TABS:
              clearTabs();
              break;
          }
        }
      } else {
        return;
      }
    },
    false
  );
}

export function addTabEvent(key: string, title: string) {
  const tab = new Tab("", key, title);
  const eventMessage: EventMessage<Tab> = new EventMessage(
    EventType.ADD_TAB,
    tab
  );
  window.postMessage(eventMessage);
}

export function closeTabEvent(id: string) {
  const tab = new Tab(id, "", "");
  const eventMessage: EventMessage<Tab> = new EventMessage(
    EventType.CLOSE_TAB,
    tab
  );
  window.postMessage(eventMessage);
}

export function changeTabEvent(id: string) {
  const tab = new Tab(id, "", "");
  const eventMessage: EventMessage<Tab> = new EventMessage(
    EventType.CHANGE_TAB,
    tab
  );
  window.postMessage(eventMessage);
}

export function closeAllTabsEvent() {
  const eventMessage: EventMessage<Tab> = new EventMessage(
    EventType.CLOSE_ALL_TABS
  );
  window.postMessage(eventMessage);
}
