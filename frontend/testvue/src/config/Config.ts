import { loadAppContext } from "rfindustriescore";
import { TestModule } from "./TestModule";

export function config() {
    // Load App context with modules
    loadAppContext([
        new TestModule()
    ]);
}