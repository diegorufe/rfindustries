import { getAppContext, ModuleLoader } from "rfindustriescore";
import { KeyComponents } from "../constants/KeyComponents";


export class TestModule implements ModuleLoader {
    loadI18n(): void {

    }
    loadLazyComponents(): void {
        const context = getAppContext();

        context.lazyComponents[KeyComponents.TEST] = async () => {
            return import("../components/test/TestComponent.vue");
        };
    }

}