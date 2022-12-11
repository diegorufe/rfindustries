interface Reactivity {
  setReactiveData(_target: any, _data: any): void;
  initReactivityObject<T>(target: T): T;
}

export type { Reactivity };
